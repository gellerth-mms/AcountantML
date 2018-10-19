package com.mediasaturn.fom.application.http;

import com.google.cloud.vision.v1.*;
import net.rationalminds.LocalDateModel;
import net.rationalminds.Parser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/test")
public final class ReservationController {


    @RequestMapping(
            method = RequestMethod.POST
    )
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void reserve(@RequestBody String payload) throws Exception {
        detectDocumentTextGcs(payload, System.out);
    }

    private static void detectDocumentTextGcs(String uri, PrintStream out) throws Exception {
        List<AnnotateImageRequest> requests = new ArrayList<>();

        ImageSource imgSource = ImageSource.newBuilder().setImageUri(uri).build();
        Image img = Image.newBuilder().setSource(imgSource).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.DOCUMENT_TEXT_DETECTION).build();
        AnnotateImageRequest request =
                AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();
            client.close();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    out.printf("Error: %s\n", res.getError().getMessage());
                    return;
                }
                // For full list of available annotations, see http://g.co/cloud/vision/docs
                TextAnnotation annotation = res.getFullTextAnnotation();
                for (Page page : annotation.getPagesList()) {
                    String pageText = "";
                    for (Block block : page.getBlocksList()) {
                        String blockText = "";
                        /*
                        block.getParagraphsList().sort(
                                Comparator.comparingInt(p -> p.getBoundingBox().getVerticesList().stream().mapToInt(Vertex::getY).sorted().boxed().collect(Collectors.toList()).get(0))
                        );
                        //(p1, p2) -> p1.getBoundingBox().getVerticesList().stream().mapToInt(Vertex::getY).sorted().boxed().collect(Collectors.toList()).get(0) -
                        //                                p2.getBoundingBox().getVerticesList().stream().mapToInt(Vertex::getY).sorted().boxed().collect(Collectors.toList()).get(0)
                      //  block.getParagraphsList().get(0).getBoundingBox().getVerticesList().get(0).getY()
                        List<List<Paragraph>> lines = new ArrayList<>();
                        List<Paragraph> line = new ArrayList<>();
                        Integer threshold = 10;
                        */
                        for (Paragraph para : block.getParagraphsList()) {
                            String paraText = "";
                            for (Word word : para.getWordsList()) {
                                String wordText = "";
                                for (Symbol symbol : word.getSymbolsList()) {
                                    wordText = wordText + symbol.getText();
                                }
                             //   out.format("Word text: %s \n", wordText);
                                paraText = String.format("%s %s", paraText, wordText);
                                if(extractDate(paraText)!=null){
                                    LocalDateModel date =extractDate(paraText);                                };
                            }
                            // Output Example using Paragraph:
                            out.println("\nParagraph Text :   " + paraText);
                            blockText = blockText + paraText;
                        }
                        pageText = pageText + blockText;
                        //  out.println("\n-----------------------");
                        //  out.println("Block Text :   " + blockText);
                    }
                }
                out.println("\n------------------------------------------------------------------------");
            }
        }
    }

    private static LocalDateModel extractDate(String paraText) {
        String st = paraText;
        String stt = st.replaceAll("\\s+","");
        Parser parser=new Parser();
        List<LocalDateModel> dates=parser.parse(stt);

        if(dates.size()>0){String date = dates.get(0).getOriginalText();
            return dates.get(0);
        }
        else return null;
    }
}

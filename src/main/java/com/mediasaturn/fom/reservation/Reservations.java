package com.mediasaturn.fom.reservation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder(
        {
                "checkCapacity",
                "checkInventory",
                "enterpriseCode",
                "optimizationType",
                "organizationCode",
                "reservationParameters",
                "promiseLines"
        }
)
public class Reservations {

    private String checkCapacity;
    private String checkInventory;
    private String enterpriseCode;
    private String optimizationType;
    private String organizationCode;
    private ReservationParameters reservationParameters;
    private PromiseLines promiseLines;

    public String getCheckCapacity() {
        return checkCapacity;
    }

    public void setCheckCapacity(String checkCapacity) {
        this.checkCapacity = checkCapacity;
    }

    public String getCheckInventory() {
        return checkInventory;
    }

    public void setCheckInventory(String checkInventory) {
        this.checkInventory = checkInventory;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getOptimizationType() {
        return optimizationType;
    }

    public void setOptimizationType(String optimizationType) {
        this.optimizationType = optimizationType;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public ReservationParameters getReservationParameters() {
        return reservationParameters;
    }

    public void setReservationParameters(ReservationParameters reservationParameters) {
        this.reservationParameters = reservationParameters;
    }

    public PromiseLines getPromiseLines() {
        return promiseLines;
    }

    public void setPromiseLines(PromiseLines promiseLines) {
        this.promiseLines = promiseLines;
    }

    public static class PromiseLines {
        private List<PromiseLine> promiseLine = null;

        public List<PromiseLine> getPromiseLine() {
            return promiseLine;
        }

        public void setPromiseLine(List<PromiseLine> promiseLine) {
            this.promiseLine = promiseLine;
        }
    }

    @JsonPropertyOrder(
            {
                    "isProcurementAllowed",
                    "useUnplannedInventory",
                    "deliveryMethod",
                    "fulfillmentType",
                    "itemId",
                    "levelOfService",
                    "lineId",
                    "requiredQty",
                    "shipNode",
                    "unitOfMeasure",
                    "reservationParameters",
                    "shipToAddress"
            }
    )
    public static class PromiseLine {

        private String isProcurementAllowed;
        private String useUnplannedInventory;
        private String deliveryMethod;
        private String fulfillmentType;
        private String itemId;
        private String levelOfService;
        private String lineId;
        private String requiredQty;
        private String shipNode = "";
        private String unitOfMeasure;
        private PromiseLineReservationParameters reservationParameters;
        private ShipToAddress shipToAddress;

        public String getIsProcurementAllowed() {
            return isProcurementAllowed;
        }

        public void setIsProcurementAllowed(String isProcurementAllowed) {
            this.isProcurementAllowed = isProcurementAllowed;
        }

        public String getUseUnplannedInventory() {
            return useUnplannedInventory;
        }

        public void setUseUnplannedInventory(String useUnplannedInventory) {
            this.useUnplannedInventory = useUnplannedInventory;
        }

        public String getDeliveryMethod() {
            return deliveryMethod;
        }

        public void setDeliveryMethod(String deliveryMethod) {
            this.deliveryMethod = deliveryMethod;
        }

        public String getFulfillmentType() {
            return fulfillmentType;
        }

        public void setFulfillmentType(String fulfillmentType) {
            this.fulfillmentType = fulfillmentType;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public String getLevelOfService() {
            return levelOfService;
        }

        public void setLevelOfService(String levelOfService) {
            this.levelOfService = levelOfService;
        }

        public String getLineId() {
            return lineId;
        }

        public void setLineId(String lineId) {
            this.lineId = lineId;
        }

        public String getRequiredQty() {
            return requiredQty;
        }

        public void setRequiredQty(String requiredQty) {
            this.requiredQty = requiredQty;
        }

        public String getShipNode() {
            return shipNode;
        }

        public void setShipNode(String shipNode) {
            this.shipNode = shipNode;
        }

        public String getUnitOfMeasure() {
            return unitOfMeasure;
        }

        public void setUnitOfMeasure(String unitOfMeasure) {
            this.unitOfMeasure = unitOfMeasure;
        }

        public PromiseLineReservationParameters getReservationParameters() {
            return reservationParameters;
        }

        public void setReservationParameters(PromiseLineReservationParameters reservationParameters) {
            this.reservationParameters = reservationParameters;
        }

        public ShipToAddress getShipToAddress() {
            return shipToAddress;
        }

        public void setShipToAddress(ShipToAddress shipToAddress) {
            this.shipToAddress = shipToAddress;
        }

    }

    @JsonPropertyOrder(
            {
                    "allowPartialReservation",
                    "reservationId",
                    "expirationDate"
            }
    )
    public static class ReservationParameters {

        private String allowPartialReservation;
        private String reservationId;
        private String expirationDate;

        public String getAllowPartialReservation() {
            return allowPartialReservation;
        }

        public void setAllowPartialReservation(String allowPartialReservation) {
            this.allowPartialReservation = allowPartialReservation;
        }

        public String getReservationId() {
            return reservationId;
        }

        public void setReservationId(String reservationId) {
            this.reservationId = reservationId;
        }

        public String getExpirationDate() {
            return expirationDate;
        }

        public void setExpirationDate(String expirationDate) {
            this.expirationDate = expirationDate;
        }
    }

    @JsonPropertyOrder(
            {
                    "reservationId"
            }
    )
    public static class PromiseLineReservationParameters {

        private String reservationId;

        public String getReservationId() {
            return reservationId;
        }

        public void setReservationId(String reservationId) {
            this.reservationId = reservationId;
        }

    }

    @JsonPropertyOrder(
            {
                    "addressLine1",
                    "addressLine2",
                    "addressLine3",
                    "addressLine4",
                    "addressLine5",
                    "addressLine6",
                    "alternateEmailId",
                    "beeper",
                    "city",
                    "company",
                    "country",
                    "dayFaxNo",
                    "dayPhone",
                    "department",
                    "emailId",
                    "eveningFaxNo",
                    "eveningPhone",
                    "firstName",
                    "isCommercialAddress",
                    "jobTitle",
                    "lastName",
                    "middleName",
                    "mobilePhone",
                    "otherPhone",
                    "personId",
                    "state",
                    "suffix",
                    "taxGeoCode",
                    "title",
                    "zipCode"
            }
    )
    public static class ShipToAddress {

        private String addressLine1;
        private String addressLine2;
        private String addressLine3;
        private String addressLine4;
        private String addressLine5;
        private String addressLine6;
        private String alternateEmailId;
        private String beeper;
        private String city;
        private String company;
        private String country;
        private String dayFaxNo;
        private String dayPhone;
        private String department;
        private String emailId;
        private String eveningFaxNo;
        private String eveningPhone;
        private String firstName;
        private String isCommercialAddress;
        private String jobTitle;
        private String lastName;
        private String middleName;
        private String mobilePhone;
        private String otherPhone;
        private String personId;
        private String state;
        private String suffix;
        private String taxGeoCode;
        private String title;
        private String zipCode;

        public String getAddressLine1() {
            return addressLine1;
        }

        public void setAddressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
        }

        public String getAddressLine2() {
            return addressLine2;
        }

        public void setAddressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
        }

        public String getAddressLine3() {
            return addressLine3;
        }

        public void setAddressLine3(String addressLine3) {
            this.addressLine3 = addressLine3;
        }

        public String getAddressLine4() {
            return addressLine4;
        }

        public void setAddressLine4(String addressLine4) {
            this.addressLine4 = addressLine4;
        }

        public String getAddressLine5() {
            return addressLine5;
        }

        public void setAddressLine5(String addressLine5) {
            this.addressLine5 = addressLine5;
        }

        public String getAddressLine6() {
            return addressLine6;
        }

        public void setAddressLine6(String addressLine6) {
            this.addressLine6 = addressLine6;
        }

        public String getAlternateEmailId() {
            return alternateEmailId;
        }

        public void setAlternateEmailId(String alternateEmailId) {
            this.alternateEmailId = alternateEmailId;
        }

        public String getBeeper() {
            return beeper;
        }

        public void setBeeper(String beeper) {
            this.beeper = beeper;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getDayFaxNo() {
            return dayFaxNo;
        }

        public void setDayFaxNo(String dayFaxNo) {
            this.dayFaxNo = dayFaxNo;
        }

        public String getDayPhone() {
            return dayPhone;
        }

        public void setDayPhone(String dayPhone) {
            this.dayPhone = dayPhone;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getEmailId() {
            return emailId;
        }

        public void setEmailId(String emailId) {
            this.emailId = emailId;
        }

        public String getEveningFaxNo() {
            return eveningFaxNo;
        }

        public void setEveningFaxNo(String eveningFaxNo) {
            this.eveningFaxNo = eveningFaxNo;
        }

        public String getEveningPhone() {
            return eveningPhone;
        }

        public void setEveningPhone(String eveningPhone) {
            this.eveningPhone = eveningPhone;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getIsCommercialAddress() {
            return isCommercialAddress;
        }

        public void setIsCommercialAddress(String isCommercialAddress) {
            this.isCommercialAddress = isCommercialAddress;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public void setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
        }

        public String getOtherPhone() {
            return otherPhone;
        }

        public void setOtherPhone(String otherPhone) {
            this.otherPhone = otherPhone;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getSuffix() {
            return suffix;
        }

        public void setSuffix(String suffix) {
            this.suffix = suffix;
        }

        public String getTaxGeoCode() {
            return taxGeoCode;
        }

        public void setTaxGeoCode(String taxGeoCode) {
            this.taxGeoCode = taxGeoCode;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

    }

}
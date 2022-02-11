package models;

import enums.ContactsLeadSource;
import enums.ContactsSalutation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contacts {
    private String phone;
    private String mobile;
    private ContactsSalutation salutation;
    private String firstName;
    private String lastName;
    private String accountName;
    private String email;
    private String title;
    private String reportsTo;
    private String mailingStreet;
    private String otherStreet;
    private String mailingCity;
    private String mailingStateProvince;
    private String otherCity;
    private String otherStateProvince;
    private String mailingZipPostalCode;
    private String mailingCountry;
    private String otherZipPostalCode;
    private String otherCountry;
    private String fax;
    private String department;
    private String homePhone;
    private String otherPhone;
    private String asstPhone;
    private String assistant;
    private ContactsLeadSource leadSource;
    private String birthdate;
    private String description;

}
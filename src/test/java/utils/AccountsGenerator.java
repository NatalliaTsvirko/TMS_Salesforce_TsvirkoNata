package utils;

import com.github.javafaker.Faker;
import enums.Industry;
import enums.AccountType;
import models.Account;


public class AccountsGenerator {

    public Account getAccountWithAllData() {
        Faker faker = new Faker();
        faker.company().name();
        Account account = Account.builder()
                .accountName(faker.name().firstName())
                .phone("+3453455435435")
                .parentAccount("")
                .website("")
                .type(AccountType.CUSTOMER)
                .industry(Industry.UTILITIES)
                .employees("885")
                .billingStreet("A")
                .shippingStreet("k")
                .billingCity("City")
                .shippingCity("ShipCity")
                .billingStateProvince("3365")
                .shippingStateProvince("33256")
                .billingZipPostalCode("33254")
                .shippingZipPostalCode("55487")
                .billingCountry("Country")
                .shippingCountry("SCountry")
                .description("Hello")
                .build();
        return account;
    }

}

package utils;

import com.github.javafaker.Faker;
import models.Account;


public class AccountsGenerator {

    public Account get() {
        Faker faker = new Faker();
        faker.company().name();
        Account account = Account.builder()
                .accountName(faker.company().name())
                .phone("+3453455435435")
                .parentAccount("i")
                .build();
        return account;

    }

    public Account get(String industry) {
        Faker faker = new Faker();
        faker.company().name();
        Account testAccount = Account.builder()
                .accountName(faker.company().name())
                .build();
        return testAccount;

    }
}

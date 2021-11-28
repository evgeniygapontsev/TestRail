package models;

import com.github.javafaker.Faker;

public class CaseInfoFactory {
    static Faker faker;

    public static CaseInfo get() {
        faker = new Faker();

        return new CaseInfo(faker.name().title(),"Test Cases", "Test Case (Text)", "Automated",
                "Medium", "", "", "None",
                faker.programmingLanguage().name(), faker.phoneNumber().cellPhone(), faker.phoneNumber().phoneNumber());
    }
}

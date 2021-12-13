package models;

import com.github.javafaker.Faker;

public class CaseInfoFactory {
    static Faker faker;

    public static CaseInfo get() {
        faker = new Faker();

        return new CaseInfo(faker.book().title(),"Test Cases", "Test Case (Text)", "Automated",
                "Medium", faker.numerify("12 minutes"), "TR-2", "None",
                faker.programmingLanguage().name(), faker.book().title(), faker.book().author());
    }
}

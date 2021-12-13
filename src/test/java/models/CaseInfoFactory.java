package models;

import com.github.javafaker.Faker;

public class CaseInfoFactory {
    static Faker faker;

    public static CaseInfo get() {
        faker = new Faker();

        return new CaseInfo(faker.name().title(),"Test Cases", "Test Case (Text)", "Automated",
                "Medium", faker.numerify("12 minutes"), "TR-2", "None",
                faker.programmingLanguage().name(), faker.book().title(), faker.book().author());
    }

    public static CaseInfo getAgain() {
        faker = new Faker();

        return new CaseInfo(faker.name().nameWithMiddle(), "Test Cases", "Test Case (Text)", "Automated",
                "High", faker.numerify("15 minutes"), "TR-4", "None",
                faker.beer().name(), faker.ancient().god(), faker.animal().name());
    }
}

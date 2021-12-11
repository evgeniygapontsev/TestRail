package models;

import com.github.javafaker.Faker;

public class ProjectFactory {
    static Faker faker;

    public static Project get() {
        faker = new Faker();
        return Project.builder()
                .name(faker.book().title())
                .announcement(faker.address().fullAddress())
                .showAnnouncement(faker.random().nextBoolean())
                .suiteMode(faker.random().nextInt(1, 3))
                .build();
    }
}

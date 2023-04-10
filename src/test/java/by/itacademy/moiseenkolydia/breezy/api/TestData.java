package by.itacademy.moiseenkolydia.breezy.api;

import com.github.javafaker.Faker;

public class TestData {
    static Faker faker = new Faker();
    public static final String BASE_URL = "https://breezy.by";
    public static final String LOGIN_URL = "https://breezy.by/profile/login";
    public static final String SEARCH_URL = "https://breezy.by/search";
    public static final String VALID_EMAIL = "99camomile99@gmail.com";
    public static final String VALID_PASSWORD = "Qwerty!1";
    public static final String RANDOM_EMAIL = faker.internet().emailAddress();
    public static final String RANDOM_PASSWORD = faker.internet().password(6, 14);
    public static final String TEXT_SEARCH = "наушники";
}

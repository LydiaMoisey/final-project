package by.itacademy.moiseenkolydia.breezy.ui.domain;

import com.github.javafaker.Faker;

public class User {
    static Faker faker = new Faker();
    private String email;
    private String password;
    public static final String VALID_EMAIL = "99camomile99@gmail.com";
    public static final String VALID_PASSWORD = "Qwerty!1";
    public static final String RANDOM_EMAIL = faker.internet().emailAddress();
    public static final String RANDOM_PASSWORD = faker.internet().password(6, 14);

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

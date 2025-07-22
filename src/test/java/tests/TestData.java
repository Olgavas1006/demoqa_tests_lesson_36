package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
   public static final Faker faker = new Faker(new Locale("en"));
   public static String firstName = faker.name().firstName();
   public static String lastName = faker.name().lastName();
   public static String userEmail = faker.internet().emailAddress();
   public static String gender = faker.options().option("Male", "Female", "Other");
   public static String userNumber = faker.phoneNumber().subscriberNumber(10);
   public static String day = String.format("%02d", faker.number().numberBetween(1, 30));
   public static String month = faker.options().option(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
   public static String year = String.valueOf(faker.number().numberBetween(1900, 2100));

   public static String subject = faker.options().option("Math", "Biology", "Chemistry", "Physics");
   public static String hobby = faker.options().option("Sports", "Reading", "Music");
   public static String pictureName = faker.options().option("cat.jpg");
   public static String currentAddress = faker.address().fullAddress();
   public static String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
   public static String city = getRandomCity(state);


    private static String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalArgumentException("Unknown state: " + state);
        };

    }

}
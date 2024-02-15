package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataGenerator {
    private Faker generator;
    public String firstName;
    public String lastName;
    public String fullName;
    public String phoneNumber;
    public String email;
    public String password;
    public String vatNumber;
    public String streetAdress;
    public String zipCode;
    public String city;
    public String creditCardNumber;
    public String validUntil;
    public String cvv;

    public DataGenerator(){
        this.generator = new Faker(new Locale("en-GB"));
        this.firstName = generator.name().firstName();
        this.lastName = generator.name().lastName();
        this.fullName = firstName + " " + lastName;
        this.phoneNumber = generator.number().digits(9);
        this.email = firstName.toLowerCase()
                + generator.pokemon().name().toLowerCase()
                + "@mailsac.com";
        this.password = generator
                .name()
                .lastName()
                +"@"
                +generator.number().digits(5);
        this.vatNumber = generator.number().digits(9);
        this.streetAdress = generator.name().lastName()
                +" Street, " + generator.number().digits(3);
        this.zipCode = generator.number().digits(4)
                +"-"
                +generator.number().digits(3);
        this.city = generator.address().cityName();
        this.creditCardNumber = generator.business().creditCardNumber();
        this.cvv = generator.number().digits(3);
    }
}

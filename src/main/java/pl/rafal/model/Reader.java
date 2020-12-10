package pl.rafal.model;

import java.util.Objects;

public class Reader {

    private String firstName;
    private String lastName;
    private final String cardNumber;

    public Reader(String firstName, String lastName, String cardNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(getCardNumber(), reader.getCardNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardNumber());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}

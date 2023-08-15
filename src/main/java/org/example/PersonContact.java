package org.example;

public class PersonContact extends Contact {
    private String name;
    private String surname;
    private String phoneNumber;
    private String gender;

    public PersonContact(String name, String surname, String phoneNumber, String gender) {
        super(phoneNumber);
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = EMPTY_NUMBER;
        }
    }

    @Override
    public String print() {
        return "Name: " + getName() + "\n" +
                "Surname: " + getSurname() + "\n" +
                "Gender: " + getGender() + "\n" +
                "Number: " + getPhoneNumber() + "\n" +
                "Time created: " + getCreationDate() + "\n" +
                "Time last edit: " + getLastEditDate();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

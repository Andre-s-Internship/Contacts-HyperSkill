package org.example;

public class PersonContact extends Contact {
    private String name;
    private String surname;
    private String phoneNumber;
    private String gender;
    private String birthdate;

    public PersonContact(String name, String surname, String phoneNumber, String gender, String birthdate) {
        super(phoneNumber);
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthdate = birthdate;
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
        } else this.phoneNumber = "[no number]";
    }
    @Override
    public String print() {
        return "Name: "            + getName() + "\n" +
                "Surname: "        + getSurname() + "\n" +
                "Birth date: "     + getBirthdate() + "\n" +
                "Gender: "         + getGender() + "\n" +
                "Number: "         + getPhoneNumber() + "\n" +
                "Time created: "   + getCreationDate() + "\n" +
                "Time last edit: " + getLastEditDate();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}

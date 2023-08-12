package org.example;

public class OrganizationContact extends Contact {
    private final String name;
    private String address;

    public OrganizationContact(String phoneNumber, String name, String address) {
        super(phoneNumber);
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrgName() {
        return name;
    }

    @Override
    public String print() {
        return "Organization name: " + getName() + "\n" +
                "Address: " + getAddress() + "\n" +
                "Number: " + getPhoneNumber() + "\n" +
                "Time created: " + getCreationDate() + "\n" +
                "Time last edit: " + getLastEditDate();
    }
}

package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

    public static final String EDIT_PERSON_FIELD = "Select a field (name, surname, gender, number):";
    public static final String EDIT_ORGANIZATION_FIELD = "Select a field (address, number):";

    private static final List<Contact> contactList = new ArrayList<>();

    public static int count() {
        return contactList.size();
    }

    static void addPerson(Scanner scanner) {
        System.out.print("Enter the name:");
        String name = scanner.next();
        System.out.print("Enter the surname:");
        String surname = scanner.next();
        System.out.print("Enter the gender (M, F):");
        String gender = scanner.next();
        if (!checkGender(gender)) {
            System.out.println("Bad gender!");
            gender = "[no data]";
        }
        System.out.println("Enter the number:");
        scanner.nextLine();
        String phoneNumber = scanner.nextLine();
        contactList.add(new PersonContact(name, surname, phoneNumber, gender));
        System.out.println("The record added.");
    }

    static void addOrganization(Scanner scanner) {
        System.out.print("Enter the organization name:");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter the address:");
        String address = scanner.nextLine();
        System.out.println("Enter the number:");
        String phoneNumber = scanner.nextLine();
        contactList.add(new OrganizationContact(phoneNumber, name, address));
        System.out.println("The record added.");
    }

    public static void list() {
        listContacts(contactList);
    }


    public static void removeContact(int index) {
        if (contactList.remove(index - 1) != null) {
            System.out.println("The record removed!");
        }
    }

    public static void edit(Scanner scanner, int index) {
        Contact contact = contactList.get(index);
        if (contact instanceof PersonContact) {
            editPerson(scanner, (PersonContact) contact);
        } else {
            editOrganization(scanner, (OrganizationContact) contact);
        }
    }

    static void editPerson(Scanner scanner, PersonContact contact) {
        System.out.println(EDIT_PERSON_FIELD);
        String input = scanner.nextLine();
        switch (input) {
            case "name" -> {
                System.out.println("Enter name:");
                String newName = scanner.nextLine();
                contact.setName(newName);
                System.out.println("The record updated!");
                contact.setLastEditDate(LocalDateTime.now());
            }
            case "surname" -> {
                System.out.println("Enter surname:");
                String newSurname = scanner.next();
                contact.setSurname(newSurname);
                System.out.println("The record updated!");
                contact.setLastEditDate(LocalDateTime.now());
            }
            case "gender" -> {
                System.out.println("Enter gender:");
                String newGender = scanner.next();
                contact.setGender(newGender);
                System.out.println("The record updated!");
                contact.setLastEditDate(LocalDateTime.now());
            }
            case "number" -> {
                scanner.nextLine();
                System.out.println("Enter number:");
                String newNumber = scanner.nextLine();
                contact.setPhoneNumber(newNumber);
                System.out.println("The record updated!");
                contact.setLastEditDate(LocalDateTime.now());
            }
        }
    }

    static void editOrganization(Scanner scanner, OrganizationContact contact) {
        System.out.println(EDIT_ORGANIZATION_FIELD);
        String input = scanner.next();
        switch (input) {
            case "address" -> {
                System.out.println("Enter address:");
                scanner.nextLine();
                String newAddress = scanner.nextLine();
                contact.setAddress(newAddress);
                System.out.println("The record updated!");
            }
            case "number" -> {
                scanner.nextLine();
                System.out.println("Enter number:");
                String newNumber = scanner.nextLine();
                contact.setPhoneNumber(newNumber);
                System.out.println("The record updated!");
            }
        }
    }

    static void getInfo(int index) {
        Contact contact = contactList.get(index);
        System.out.println(contact.print());
    }

    public static boolean checkGender(String gender) {
        return gender.equals("M") || gender.equals("F");
    }

    public static List<Contact> searchQuery(String substring) {
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact instanceof PersonContact) {
                if (containsQuery(((PersonContact) contact).getName(), substring) ||
                        (containsQuery(((PersonContact) contact).getSurname(), substring) ||
                                (containsQuery(contact.getPhoneNumber(), substring)))) {
                    result.add(contact);
                }
            } else if (contact instanceof OrganizationContact) {
                if (containsQuery(((OrganizationContact) contact).getName(), substring) ||
                        containsQuery(contact.getPhoneNumber(), substring)) {
                    result.add(contact);
                }
            }
        }
        return result;
    }

    public static boolean containsQuery(String base, String substring) {
        return base.toLowerCase().contains(substring.toLowerCase());
    }

    public static void listSearchedQuery(List<Contact> searchQuery) {
        listContacts(searchQuery);
    }

    private static void listContacts(List<Contact> searchQuery) {
        int count = 1;
        for (Contact contact : searchQuery) {
            if (contact instanceof PersonContact) {
                System.out.println(count + ". " + ((PersonContact) contact).getName() + " "
                        + ((PersonContact) contact).getSurname() + ", " + contact.getPhoneNumber());
            } else if (contact instanceof OrganizationContact) {
                System.out.println(count + ". " + ((OrganizationContact) contact).getName());
            }
            count++;
        }
    }
}

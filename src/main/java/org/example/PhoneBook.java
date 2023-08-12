package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

    private static final List<Contact> contactList = new ArrayList<>();

    public static void addContact(Contact contact) {
        contactList.add(contact);
        System.out.println("The record added.");
    }

    public static void list() {
        listing(contactList);
    }


    public static void removeContact(int index) {
        if (contactList.remove(index - 1) != null) {
            System.out.println("The record removed!");
        }
    }

    public static int count() {
        return contactList.size();
    }


    public static void edit(Scanner scanner, int index) {
        Contact contact = contactList.get(index);
        if (contact instanceof PersonContact) {
            editPerson(scanner, (PersonContact) contact);
        } else editOrganization(scanner, (Organization) contact);
    }
    public static void editPerson(Scanner scanner, PersonContact contact) {
        System.out.println("Select a field (name, surname, birth, gender number):");
        String input = scanner.next();
        switch (input) {
            case "name" -> {
                System.out.println("Enter name:");
                String newName = scanner.next();
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
            case "birth" -> {
                System.out.println("Enter birth:");
                String newBirthdate = scanner.next();
                contact.setBirthdate(newBirthdate);
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


    public static void editOrganization(Scanner scanner, Organization contact) {
        System.out.println("Select a field (address, number):");
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


    static PersonContact addPerson(Scanner scanner) {
        System.out.print("Enter the name:");
        String name = scanner.next();
        System.out.print("Enter the surname:");
        String surname = scanner.next();
        System.out.print("Enter the birth date:");
        String birthdate = scanner.nextLine();
        if (!checkBirthday(birthdate)) {
            System.out.println("Bad birth date!");
            birthdate = "[no data]";
        }
        System.out.print("Enter the gender (M, F):");
        String gender = scanner.nextLine();
        if (!checkGender(gender)) {
            System.out.println("Bad gender!");
            gender = "[no data]";
        }
        System.out.println("Enter the number:");
        scanner.nextLine();
        String phoneNumber = scanner.nextLine();
        return new PersonContact(name, surname, phoneNumber, gender, birthdate);
    }

    static Organization addOrganization(Scanner scanner) {
        System.out.print("Enter the organization name:");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter the address:");
        String address = scanner.nextLine();
        System.out.println("Enter the number:");
        //scanner.nextLine();
        String phoneNumber = scanner.nextLine();
        return new Organization(phoneNumber, name, address);
    }

    static void getInfo(int index) {
        Contact contact = contactList.get(index);
        System.out.println(contact.print());
    }

    private static boolean checkGender(String gender) {
        return gender.equals("M") || gender.equals("F");
    }

    private static boolean checkBirthday(String birthdate) {
        return false;
    }


    public static List<Contact> searchQuery(String substring) {
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact instanceof PersonContact) {
                if (contains(((PersonContact) contact).getName(),substring) ||
                        (contains(((PersonContact) contact).getSurname(),substring) ||
                                (contains(contact.getPhoneNumber(),substring))))  {
                    result.add(contact);
                }
            } else if (contact instanceof Organization) {
                if (contains(((Organization) contact).getName(), substring) ||
                        contains(contact.getPhoneNumber(), substring)) {
                    result.add(contact);
                }
            }
        }
        return result;
    }

    public static void listQuery(List<Contact> searchQuery) {
        listing(searchQuery);
    }

    private static void listing(List<Contact> searchQuery) {
        int count = 1;
        for (Contact contact : searchQuery) {
            if (contact instanceof PersonContact) {
                System.out.println(count + ". " + ((PersonContact) contact).getName() + " "
                        + ((PersonContact) contact).getSurname() + ", " + contact.getPhoneNumber());
            } else if (contact instanceof Organization){
                System.out.println(count + ". " + ((Organization) contact).getOrgName());
            }
            count++;
        }
    }

    private static boolean contains(String base, String substring) {
        return base.toLowerCase().contains(substring.toLowerCase());
    }


}

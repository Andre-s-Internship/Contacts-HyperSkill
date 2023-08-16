package org.example;

import java.util.List;
import java.util.Scanner;

import static org.example.PhoneBook.*;

public class Contacts {

    public static final String MENU_ACTIONS = "[menu] Enter action (add, list, search, count, exit):";
    public static final String LIST_MENU_ACTIONS = "[list] Enter action ([number], back):";
    public static final String SEARCH_MENU_ACTIONS = "[search] Enter action ([number], back, again):";
    public static final String RECORD_MENU_ACTIONS = "[record] Enter action (edit, delete, menu):";
    private static final String ACTION_ADD = "add";
    private static final String ACTION_SEARCH = "search";
    private static final String ACTION_LIST = "list";
    private static final String ACTION_COUNT = "count";
    private static final String ACTION_EXIT = "exit";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        System.out.print(MENU_ACTIONS);
        String input = scanner.next();
        switch (input) {
            case ACTION_ADD: {
                addContact();
                System.out.println();
                menu();
            }
            case ACTION_LIST: {
                listMenu();
                System.out.println();
            }
            case ACTION_SEARCH: {
                searchMenu();
                searchContacts();
                System.out.println();
            }
            case ACTION_COUNT: {
                count();
                System.out.println();
                menu();
            }
            case ACTION_EXIT: {
                System.exit(0);
            }
        }
    }

    static void listMenu() {
        list();
        System.out.println();
        System.out.print(LIST_MENU_ACTIONS);
        String input = scanner.next();
        if (input.equals("back")) {
            menu();
            return;
        }
        try {
            int index = Integer.parseInt(input);
            getInfo(index - 1);
            System.out.println();
            recordMenu(index);
        } catch (Exception e) {
            menu();
        }
    }

    static void searchMenu() {
        searchContacts();
        System.out.println(SEARCH_MENU_ACTIONS);
        String input = scanner.next();
        switch (input) {
            case "back": {
                System.out.println();
                menu();
            }
            case "again": {
                System.out.println();
                searchMenu();
            }
        }
        try {
            int index = Integer.parseInt(input);
            getInfo(index - 1);
            recordMenu(index);
        } catch (Exception e) {
            searchMenu();
        }
    }

    static void recordMenu(int index) {
        System.out.print(RECORD_MENU_ACTIONS);
        String input = scanner.next();
        switch (input) {
            case "edit": {
                editContact(index);
                System.out.println();
                recordMenu(index);
            }
            case "delete": {
                removeContact(index);
                System.out.println();
                menu();
            }
            case "menu": {
                menu();
            }
        }
    }

    static void addContact() {
        System.out.println("Enter the type (person, organization):");
        String isPerson = scanner.next();
        if (isPerson.equals("person")) {
            PhoneBook.addPerson(scanner);
        } else {
            PhoneBook.addOrganization(scanner);
        }
    }

    static void editContact(int index) {
        if (index > PhoneBook.count()) return;
        edit(scanner, index - 1);
    }

    static void searchContacts() {
        System.out.println("Enter search query:");
        List<Contact> searchedQuery = searchQuery(scanner.next());
        System.out.println("Found " + searchedQuery.size() + " results:");
        listSearchedQuery(searchedQuery);
    }

    static void removeContact(int index) {
        PhoneBook.removeContact(index);
    }

    static void count() {
        scanner.nextLine();
        System.out.println("The Phone Book has " + PhoneBook.count() + " records.");
    }
}

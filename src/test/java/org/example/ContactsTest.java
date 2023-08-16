package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ContactsTest {

    @Test
    @DisplayName("Test for add, count")
    void test1() {
        String input = "person\nname\nPersonName\nPersonSurname\nM\n1234";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Contacts.addContact();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Contacts.count();
        assertEquals("The Phone Book has 1 records.\n", outputStream.toString());
    }

    @Test
    @DisplayName("Test for add, count")
    void test2() {
        String input = "person\nname\nPersonName\nPersonSurname\nM\n1234\norganization\norgName\naddress\n1234";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Contacts.addContact();
        Contacts.addContact();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Contacts.count();
        assertEquals("The Phone Book has 2 records.\n", outputStream.toString());
    }

    @Test
    @DisplayName("Test for search contacts")
    void test3() {
        String input = "person\nPersonName\nPersonSurname\nM\n1234\norganization\norgName\naddress\n1234\nname";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Contacts.addContact();
        Contacts.addContact();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Contacts.searchContacts();
        assertTrue(outputStream.toString().contains("Found 2 results:"));
        assertTrue(outputStream.toString().contains("1. PersonName PersonSurname"));
        assertTrue(outputStream.toString().contains("2. orgName"));
    }


    @Test
    @DisplayName("Test for remove")
    void test4() {
        String input = "person\nname\nPersonName\nPersonSurname\nM\n1234";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Contacts.addContact();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Contacts.count();
        assertTrue(outputStream.toString().contains("The Phone Book has 1 records."));
        Contacts.removeContact(1);
        assertTrue(outputStream.toString().contains("The record removed!"));

    }

    @Test
    @DisplayName("Test for getInfo")
    void test5() {
        String input = "person\nPersonName\nPersonSurname\nM\n1234\nname\nnewName";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Contacts.addContact();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Contacts.editContact(1);
        System.out.println(outputStream);
        assertTrue(outputStream.toString().contains("The record updated!"));
        PhoneBook.getInfo(0);
        assertTrue(outputStream.toString().contains("Name: newName"));

    }

}
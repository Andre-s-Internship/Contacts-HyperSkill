package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @Test
    @DisplayName("Test for add person")
    void test1() {
        String input = "name\nsurname\nM\n1234";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        PhoneBook.addPerson(sc);
        String outputStreamString = outputStream.toString();
        assertTrue(outputStreamString.contains("The record added."));
        assertTrue(PhoneBook.count() != 0);
    }

    @Test
    @DisplayName("Test for add person")
    void test2() {
        String input = "name\nsurname\nHello\n1234";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        PhoneBook.addPerson(sc);
        String outputStreamString = outputStream.toString();
        assertTrue(outputStreamString.contains("The record added."));
        assertTrue(outputStreamString.contains("Bad gender!"));
        assertTrue(PhoneBook.count() != 0);
    }

    @Test
    @DisplayName("Test for add org")
    void test3() {
        String input = "\nname\naddress\n1234";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        PhoneBook.addOrganization(sc);
        String outputStreamString = outputStream.toString();
        assertTrue(outputStreamString.contains("The record added."));
        assertTrue(PhoneBook.count() != 0);
    }

    @Test
    @DisplayName("Test for list")
    void test4() {
        String input = "\norg\naddress\n1234\nname\nsurname\nM\n1234";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        PhoneBook.addOrganization(sc);
        PhoneBook.addPerson(sc);
        PhoneBook.list();
        String outputStreamString = outputStream.toString();
        assertTrue(outputStreamString.contains("The record added."));
        assertTrue(outputStreamString.contains("1. org"));
        assertTrue(outputStreamString.contains("2. name surname"));
        assertTrue(PhoneBook.count() != 0);
    }

    @Test
    @DisplayName("Test for remove")
    void test5() {
        String input = "\norg\naddress\n1234\nname\nsurname\nM\n1234";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        PhoneBook.addOrganization(sc);
        PhoneBook.addPerson(sc);
        PhoneBook.removeContact(1);
        PhoneBook.list();
        String outputStreamString = outputStream.toString();
        assertTrue(outputStreamString.contains("The record added."));
        assertTrue(outputStreamString.contains("The record removed!"));
        assertFalse(outputStreamString.contains("1. org"));
        assertTrue(outputStreamString.contains("1. name surname"));
        assertTrue(PhoneBook.count() != 0);
    }

    @Test
    @DisplayName("Test edit (person)")
    void test6() {
        String input = "name\nsurname\nM\n1234\nname\nJava";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        PhoneBook.addPerson(sc);
        PhoneBook.edit(sc, 0);
        PhoneBook.list();
        String outputStreamString = outputStream.toString();
        assertTrue(outputStreamString.contains("The record added."));
        assertTrue(outputStreamString.contains("The record updated!"));
        assertTrue(outputStreamString.contains("1. Java surname"));
        assertTrue(PhoneBook.count() != 0);
    }

    @Test
    @DisplayName("Test edit (person)")
    void test7() {
        String input = "name\nsurname\nM\n1234\nsurname\nJava";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        PhoneBook.addPerson(sc);
        PhoneBook.edit(sc, 0);
        PhoneBook.list();
        String outputStreamString = outputStream.toString();
        assertTrue(outputStreamString.contains("The record added."));
        assertTrue(outputStreamString.contains("The record updated!"));
        assertTrue(outputStreamString.contains("1. name Java"));
        assertTrue(PhoneBook.count() != 0);
    }

    @Test
    @DisplayName("Test edit (person)")
    void test8() {
        String input = "name\nsurname\nM\n1234\nnumber\n12";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        PhoneBook.addPerson(sc);
        PhoneBook.edit(sc, 0);
        PhoneBook.list();
        PhoneBook.getInfo(0);
        String outputStreamString = outputStream.toString();
        assertTrue(outputStreamString.contains("The record added."));
        assertTrue(outputStreamString.contains("The record updated!"));
        assertTrue(outputStreamString.contains("Number: 12"));
        assertTrue(PhoneBook.count() != 0);
    }

    @Test
    @DisplayName("Test edit (person)")
    void test9() {
        String input = "name\nsurname\nM\n1234\ngender\nM";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        PhoneBook.addPerson(sc);
        PhoneBook.edit(sc, 0);
        PhoneBook.list();
        PhoneBook.getInfo(0);
        String outputStreamString = outputStream.toString();
        assertTrue(outputStreamString.contains("The record added."));
        assertTrue(outputStreamString.contains("The record updated!"));
        assertTrue(outputStreamString.contains("Gender: M"));
        assertTrue(PhoneBook.count() != 0);
    }
    @Test
    @DisplayName("Test edit (org)")
    void test10() {
        String input = "\nOrgName\nAddress\n1234\naddress\nNewAddress";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        PhoneBook.addOrganization(sc);
        PhoneBook.edit(sc, 0);
        PhoneBook.list();
        PhoneBook.getInfo(0);
        String outputStreamString = outputStream.toString();
        assertTrue(outputStreamString.contains("The record added."));
        assertTrue(outputStreamString.contains("The record updated!"));
        assertTrue(outputStreamString.contains("Address: NewAddress"));
        assertTrue(PhoneBook.count() != 0);
    }
    @Test
    @DisplayName("Test edit (org)")
    void test11() {
        String input = "\nOrgName\nAddress\n1234\nnumber\nNewNumber";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        PhoneBook.addOrganization(sc);
        PhoneBook.edit(sc, 0);
        PhoneBook.list();
        PhoneBook.getInfo(0);
        String outputStreamString = outputStream.toString();
        assertTrue(outputStreamString.contains("The record added."));
        assertTrue(outputStreamString.contains("The record updated!"));
        assertTrue(outputStreamString.contains("Number: NewNumber"));
        assertTrue(PhoneBook.count() != 0);
    }

    @Test
    @DisplayName("Test for checkGender")
    void test12() {
        assertTrue(PhoneBook.checkGender("M"));
        assertTrue(PhoneBook.checkGender("F"));
        assertFalse(PhoneBook.checkGender(""));
        assertFalse(PhoneBook.checkGender("Hello"));
    }
    @Test
    @DisplayName("Test for containsQuery")
    void test13() {
        assertTrue(PhoneBook.containsQuery("Hello", "Hel"));
        assertTrue(PhoneBook.containsQuery("Java", "av"));
        assertTrue(PhoneBook.containsQuery("Python", "py"));
        assertFalse(PhoneBook.containsQuery("JavaScript", "JS"));
    }
    @Test
    @DisplayName("Test for searchQuery")
    void test14() {
        String input = "\nOrgName\nOrgAddress\n1234\nPersonName\nPersonSurname\nM\n1234\nnewPersonName\nnewPersonSurname\nM\n123";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PhoneBook.addOrganization(sc);
        PhoneBook.addPerson(sc);
        PhoneBook.addPerson(sc);
        System.setOut(new PrintStream(outputStream));
        PhoneBook.listSearchedQuery(PhoneBook.searchQuery("name"));
        assertTrue(outputStream.toString().contains("1. OrgName"));
        assertTrue(outputStream.toString().contains("2. PersonName"));
        assertTrue(outputStream.toString().contains("3. newPersonName"));

    }
    @Test
    @DisplayName("Test for searchQuery")
    void test15() {
        String input = "\nOrgName\nOrgAddress\n1234\nPersonName\nPersonSurname\nM\n1234\nnewPersonName\nnewPersonSurname\nM\n123";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PhoneBook.addOrganization(sc);
        PhoneBook.addPerson(sc);
        PhoneBook.addPerson(sc);
        System.setOut(new PrintStream(outputStream));
        PhoneBook.listSearchedQuery(PhoneBook.searchQuery("suRnAme"));
        assertTrue(outputStream.toString().contains("1. PersonName PersonSurname"));
        assertTrue(outputStream.toString().contains("2. newPersonName newPersonSurname"));

    }

    @Test
    @DisplayName("Test for searchQuery")
    void test16() {
        String input = "\nOrgName\nOrgAddress\n1234\nPersonName\nPersonSurname\nM\n1234\nnewPersonName\nnewPersonSurname\nM\n123";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PhoneBook.addOrganization(sc);
        PhoneBook.addPerson(sc);
        PhoneBook.addPerson(sc);
        System.setOut(new PrintStream(outputStream));
        PhoneBook.listSearchedQuery(PhoneBook.searchQuery("12"));
        assertTrue(outputStream.toString().contains("1. OrgName"));
        assertTrue(outputStream.toString().contains("2. PersonName PersonSurname"));
        assertTrue(outputStream.toString().contains("3. newPersonName newPersonSurname"));

    }

    @Test
    @DisplayName("Test for searchQuery")
    void test17() {
        String input = "\nOrgName\nOrgAddress\n1234\nPersonName\nPersonSurname\nM\n1234\nnewPersonName\nnewPersonSurname\nM\n123";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PhoneBook.addOrganization(sc);
        PhoneBook.addPerson(sc);
        PhoneBook.addPerson(sc);
        System.setOut(new PrintStream(outputStream));
        PhoneBook.listSearchedQuery(PhoneBook.searchQuery("1234"));
        assertTrue(outputStream.toString().contains("1. OrgName"));
        assertTrue(outputStream.toString().contains("2. PersonName PersonSurname"));

    }
    @Test
    @DisplayName("Test for searchQuery")
    void test18() {
        String input = "\nOrgName\nOrgAddress\n1234\nPersonName\nPersonSurname\nM\n1234\nnewPersonName\nnewPersonSurname\nM\n123";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PhoneBook.addOrganization(sc);
        PhoneBook.addPerson(sc);
        PhoneBook.addPerson(sc);
        System.setOut(new PrintStream(outputStream));
        PhoneBook.listSearchedQuery(PhoneBook.searchQuery("12345"));
        assertTrue(outputStream.toString().isEmpty());

    }
    @Test
    @DisplayName("Test for searchQuery")
    void test19() {
        String input = "\nOrgName\nOrgAddress\n1234\nPersonName\nPersonSurname\nM\n1234\nnewPersonName\nnewPersonSurname\nM\n123";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PhoneBook.addOrganization(sc);
        PhoneBook.addPerson(sc);
        PhoneBook.addPerson(sc);
        System.setOut(new PrintStream(outputStream));
        PhoneBook.listSearchedQuery(PhoneBook.searchQuery("Java"));
        assertTrue(outputStream.toString().isEmpty());

    }

}
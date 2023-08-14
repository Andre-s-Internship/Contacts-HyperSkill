package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonContactTest {

    @Test
    @DisplayName("Test for getters")
    void test1() {
        PersonContact personContact = new PersonContact("name", "surname", "phone", "M");
        assertEquals("name", personContact.getName());
        assertEquals("surname", personContact.getSurname());
        assertEquals("phone", personContact.getPhoneNumber());
        assertEquals("M", personContact.getGender());
    }

    @Test
    @DisplayName("Test for setters")
    void test2() {
        PersonContact personContact = new PersonContact("name", "surname", "12345", "M");
        assertEquals("name", personContact.getName());
        assertEquals("surname", personContact.getSurname());
        assertEquals("12345", personContact.getPhoneNumber());
        assertEquals("M", personContact.getGender());
        personContact.setName("name1");
        personContact.setSurname("surname1");
        personContact.setPhoneNumber("123");
        personContact.setGender("F");
        assertEquals("name1", personContact.getName());
        assertEquals("surname1", personContact.getSurname());
        assertEquals("123", personContact.getPhoneNumber());
        assertEquals("F", personContact.getGender());
    }

    @Test
    @DisplayName("Test for set phone number")
    void test3() {
        PersonContact personContact = new PersonContact("name", "surname", "12345", "M");
        personContact.setPhoneNumber("+(Hello) -(World)");
        assertEquals("[no number]", personContact.getPhoneNumber());
    }

    @Test
    @DisplayName("Test for print")
    void test4() {
        PersonContact personContact = new PersonContact("name", "surname", "12345", "M");
        String toString = """
                Name: name
                Surname: surname
                Gender: M
                Number: 12345
                """;
        assertTrue(personContact.print().contains(toString));
    }

}
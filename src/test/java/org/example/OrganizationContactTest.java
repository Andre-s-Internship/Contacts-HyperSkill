package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationContactTest {

    @Test
    @DisplayName("Test for getters")
    void test1() {
        OrganizationContact organizationContact = new OrganizationContact("phone", "name", "address");
        assertEquals("name", organizationContact.getName());
        assertEquals("phone", organizationContact.getPhoneNumber());
        assertEquals("address", organizationContact.getAddress());
    }

    @Test
    @DisplayName("Test for set address")
    void test2() {
        OrganizationContact organizationContact = new OrganizationContact("phone", "name", "address");
        assertEquals("name", organizationContact.getName());
        assertEquals("phone", organizationContact.getPhoneNumber());
        assertEquals("address", organizationContact.getAddress());
        organizationContact.setAddress("Address2");
        assertEquals("Address2", organizationContact.getAddress());
    }

    @Test
    @DisplayName("Test for print")
    void test3() {
        OrganizationContact organizationContact = new OrganizationContact("phone", "name", "address");
        String toString = """
                Organization name: name
                Address: address
                Number: phone
                """;
        assertTrue(organizationContact.print().contains(toString));
    }

}
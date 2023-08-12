package org.example;


import java.time.LocalDateTime;
public abstract class Contact {
    private String phoneNumber;
    private final LocalDateTime creationDate;
    private LocalDateTime lastEditDate;

    public Contact(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        creationDate = LocalDateTime.now();
        lastEditDate = creationDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else this.phoneNumber = "[no number]";
    }
    boolean isValidPhoneNumber(String phoneNumber) {
        String pattern =   "^\\+?(?:\\([a-zA-Z0-9]{2,}\\)|[a-zA-Z0-9]+)?(?:[-\\s]?|[a-zA-Z0-9]{2,}){0,8}$";
        String pattern1 =  "^\\+?(?:[a-zA-Z0-9]+)?(?:[-\\s]?\\([a-zA-Z0-9]{2,}\\)|[a-zA-Z0-9]{2,}){0,8}$";

        if (phoneNumber.matches(pattern) || phoneNumber.matches(pattern1)) {
            return true;
        } else {
            System.out.println("Wrong number format!");
            return false;
        }
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public LocalDateTime getLastEditDate() {
        return lastEditDate;
    }
    public void setLastEditDate(LocalDateTime date) {
        lastEditDate = date;
    }

    public abstract String print();
}

package org.example;


import java.time.LocalDateTime;

public abstract class Contact {

    public static final String EMPTYNUMBER = "[no number]";
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
        } else {
            this.phoneNumber = EMPTYNUMBER;
        }
    }
//    Rules of the regex below
//    1. The phone number should be split into groups using a space or dash. One group is also possible.
//    2. Before the first group, there may or may not be a plus symbol.
//    3. The first group or the second group can be wrapped in parentheses, but there should be no more than one group
//          that is wrapped in parentheses. There may also be no groups wrapped in parentheses.
//    4. A group can contain numbers, uppercase, and lowercase English letters. A group should be at least 2 symbols in
//          length. But the first group may be only one symbol in length.
    boolean isValidPhoneNumber(String phoneNumber) {
        String pattern = "^\\+?(?:\\([a-zA-Z0-9]{2,}\\)|[a-zA-Z0-9]+)?(?:[-\\s]?|[a-zA-Z0-9]{2,}){0,8}$";
        String pattern1 = "^\\+?(?:[a-zA-Z0-9]+)?(?:[-\\s]?\\([a-zA-Z0-9]{2,}\\)|[a-zA-Z0-9]{2,}){0,8}$";
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

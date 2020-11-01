package ru.stqa.pft.addressbook;

public class ContactData {
    private final String name;
    private final String surname;
    private final String mobilePhone;
    private final String email;

    public ContactData(String name, String surname, String mobilePhone, String email) {
        this.name = name;
        this.surname = surname;
        this.mobilePhone = mobilePhone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }
}

package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private final String name;
    private final String surname;
    private final String mobilePhone;
    private final String email;

    public ContactData(int id, String name, String surname, String mobilePhone, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mobilePhone = mobilePhone;
        this.email = email;
    }

    public ContactData(String name, String surname, String mobilePhone, String email) {
        this.id = Integer.MAX_VALUE;
        this.name = name;
        this.surname = surname;
        this.mobilePhone = mobilePhone;
        this.email = email;
    }


    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

}

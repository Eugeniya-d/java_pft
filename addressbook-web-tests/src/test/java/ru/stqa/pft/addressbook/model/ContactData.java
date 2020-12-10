package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "addressbook")
public class ContactData {
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name ="firstname")
    private  String name;
    @Expose
    @Column(name = "lastname")
    private  String surname;
    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private  String mobilePhone;
    @Expose
    @Column(name = "email")
    @Type(type = "text")
    private  String email;
    @Column(name = "email2")
    @Type(type = "text")
    private  String email2;
    @Column(name = "email3")
    @Type(type = "text")
    private  String email3;
    @Column(name = "home")
    @Type(type = "text")
    private String homePhone;
    @Column(name = "work")
    @Type(type = "text")
    private String workPhone;
    @Column(name = "address")
    @Type(type = "text")
    private String address;
    @Transient
    private String allPhones;
    @Transient
    private String allMails;



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

    public String getEmail2() {
        return email2;
        }


    public String getEmail3() {
        return email3;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getAddress() {
        return address;
    }
    public String getAllPhones() {
        return allPhones;
    }

    public String getAllMails() {
        return allMails;
    }


    public ContactData withId(int id) {
        this.id = id;
        return this;
    }
    public ContactData withName(String name) {
        this.name = name;
        return this;
    }

    public ContactData withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }
    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }


    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return null;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }


    public ContactData withAllMails(String allMails) {
        this.allMails = allMails;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(mobilePhone, that.mobilePhone) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, mobilePhone, email);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

}

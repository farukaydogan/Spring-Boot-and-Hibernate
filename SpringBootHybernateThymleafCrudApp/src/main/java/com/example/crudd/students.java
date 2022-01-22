package com.example.crudd;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "person")
@Controller

public class students {


    @Id

    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )


   private Integer id;
    @Column(
           nullable = false,unique = true,length = 99
    )

    private String name;

    @Column(
            nullable = false

    )
    private String email;
    @Column(
            nullable = false,
            insertable = false, updatable = false
    )

     private String phonenumber;

    @Column(
            nullable = false,name = "phonenumber",length = 255
    )
    private String address;
    @Column(
            nullable = false ,name = "address"
    )
    private String postalcode;
    @Column(
            nullable = false,name = "postalcode"
    )
    private String notes;
    @Column(
            nullable = false,name = "notes"
    )
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}


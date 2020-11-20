package com.carparts.wholesaler.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "personal_datas")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_personal_data")
    private int idPersonalData;

    @Column(name = "First_name", length = 30)
    private String firstName;

    @Column(name = "Last_name", length = 30)
    private String last_Name;

    @Column(name = "Phone_number", length = 12)
    private String phoneNumber;

    @Column(name = "Street", length = 50)
    private String street;

    @Column(name = "House_number", length = 3)
    private int houseNumber;

    @Column(name = "Apartment_number", length = 3)
    private int apartmentNumber;

    @Column(name = "PostCode", length = 6)
    private String postCode;

    @Column(name = "City", length = 50)
    private String city;

    @Column(name = "Country", length = 20)
    private String country;

    @OneToOne(mappedBy = "personalData")
    @JsonBackReference(value = "employee-data")
    private Employee employee;

    @OneToOne(mappedBy = "personalData")
    @JsonBackReference(value = "user-data")
    private Client client;

}

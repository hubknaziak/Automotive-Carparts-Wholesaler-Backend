package com.carparts.wholesaler.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "clients")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_client")
    private int idClient;

    @OneToOne
    @MapsId
    @JoinColumn(name = "Id_client")
    @JsonBackReference(value = "client-account")
    private Account account;

    @Column(name = "Type", length = 20)
    private String type;

    @Column(name = "NIP", length = 10)
    private long nip;

    @Column(name = "Company_name", length = 100)
    private String companyName;

//    @Column(name = "Status", length = 20)
//    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_code", referencedColumnName = "id_discount")
    private DiscountCode discountCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Personal_data", referencedColumnName = "Id_personal_data")
    @JsonManagedReference(value = "user-data")
    private PersonalData personalData;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "client-payments")
    //@JoinColumn(name = "Make_id")
    private List<Payment> payments;
}

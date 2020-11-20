package com.carparts.wholesaler.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "accounts")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_account")
    private int idAccount;

    @Column(name = "email", length = 20, nullable = false)
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Employee employee;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "client-account")
    @PrimaryKeyJoinColumn
    private Client client;


}

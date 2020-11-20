package com.carparts.wholesaler.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "detail_payments")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail_payment")
    private int idDetailPayment;

    @Column(name = "cost")
    private double cost;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    //@OneToOne(cascade = CascadeType.ALL)
    @OneToOne
    @JoinColumn(name = "specimen_part", referencedColumnName = "Id_specimen_part")
    //@JsonBackReference
    @JsonManagedReference
    private SpecimenPart specimenPart;

    @ManyToOne(optional = false)
    @JoinColumn(name = "payment_id", nullable = false)
    @JsonBackReference
    private Payment payment;
}

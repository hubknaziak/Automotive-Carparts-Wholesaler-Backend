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
@Table(name = "discount_codes")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscountCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_discount")
    private int idDiscount;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "value")
    private double value;

    @OneToOne(mappedBy = "discountCode")
    @JsonBackReference
    private Payment payment;

    @OneToOne(mappedBy = "discountCode")
    @JsonBackReference
    private Client client;
}

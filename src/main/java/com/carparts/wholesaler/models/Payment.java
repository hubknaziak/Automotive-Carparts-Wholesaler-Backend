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
@Table(name = "payments")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Payment")
    private int idPayment;

    @Column(name = "total_cost")
    private double totalCost;

    @Column(name = "status")
    private String status;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_status")
    private String paymentStatus;

    @OneToOne
    @JoinColumn(name = "discount_id", referencedColumnName = "id_discount")
    @JsonManagedReference
    private DiscountCode discountCode;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    @JsonManagedReference
    //@JoinColumn(name = "Make_id")
    private List<DetailPayment> detailPayments;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client", nullable = false)
    @JsonBackReference(value = "client-payments")
    private Client client;

}

package com.carparts.wholesaler.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Getter
@Setter
@Table(name = "specimen_parts")
@JsonIgnoreProperties(ignoreUnknown=true)
public class SpecimenPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_specimen_part")
    private int idSpecimenPart;

    @Column(name = "Name", length = 100)
    private String name;

    @Column(name = "OE", length = 50, nullable = false, unique = true)
    private String oe;

    @Column(name = "Producer", length = 50)
    private String producer;

    @Column(name = "Producer_code", length = 10, nullable = false, unique = true)
    private String producerCode;

    @Column(name = "Net_Price", length = 10)
    private double netPrice;

    @Column(name = "Gross_Price", length = 10)
    private double grossPrice;

    @Column(name = "Quantity", length = 10)
    private int quantity;

    @Column(name = "Informations")
    private String informations;

//    @Lob //mapping objects of large size
//    @Column(name = "Part_Image", length = Integer.MAX_VALUE)
//    private byte[] partImage;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Id_part", nullable = false)
    @JsonBackReference
    private Part part;

    //@OneToOne(mappedBy = "specimenPart", cascade = CascadeType.ALL)
    @OneToOne(mappedBy = "specimenPart")
    //@JsonManagedReference
    @JsonBackReference
    private DetailPayment detailPayment;

}

package com.carparts.wholesaler.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "engines")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Engine implements Serializable {

    public Engine(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_engine")
    private int idEngine;

    @Column(name = "Name", length = 50)
    private String name;

    @Column(name = "Code")
    private String code;

    @Column(name = "Fuel", length = 20)
    private String fuel;

    @Column(name = "Years_of_production", length = 50)
    private String yearsOfProduction;

    @Column(name = "Capacity")
    private double capacity;

    @Column(name = "Power")
    private double power;

    @Column(name = "Torque")
    private double torque;

//    @Column(name = "Make")
//    private int make;
//
//    @Column(name = "Model")
//    private int model;
//
    @Column(name = "Generation")
    private int generation;

    @ManyToMany(mappedBy = "engines")
    @JsonBackReference
    List<CarModel> carModels;

    @ManyToMany(mappedBy = "engines", cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "Engine_part",
//            joinColumns = @JoinColumn(name = "engine_id"),
//            inverseJoinColumns = @JoinColumn(name = "part_id")
//    )
    //@JsonManagedReference
    @JsonBackReference
    List<Part> parts;

}

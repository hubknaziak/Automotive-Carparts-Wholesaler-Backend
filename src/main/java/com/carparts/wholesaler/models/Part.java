package com.carparts.wholesaler.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "parts")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Part implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_part")
    private int idPart;

    @Column(name = "Name", length = 50)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "part_type_id", nullable = false)
    @JsonBackReference
    private PartType partType;

    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(
            name = "Car_model_part",
            joinColumns = @JoinColumn(name = "part_id"),
            inverseJoinColumns = @JoinColumn(name = "car_model_id")
    )
    @JsonManagedReference
    List<CarModel> carModels;

    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(
            name = "Engine_part",
            joinColumns = @JoinColumn(name = "part_id"),
            inverseJoinColumns = @JoinColumn(name = "engine_id")
    )
    //@JsonBackReference
    @JsonManagedReference
    List<Engine> engines;

    @OneToMany(mappedBy = "part", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<SpecimenPart> specimenParts = new ArrayList<>();

}

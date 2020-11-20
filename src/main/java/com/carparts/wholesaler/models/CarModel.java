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
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "car_models")
@JsonIgnoreProperties(ignoreUnknown=true)
public class CarModel implements Serializable {

    public CarModel(){

    }

    @Id
    @Column(name = "Id_model")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idModel;

    @Column(name = "Name", length = 20, nullable = false, unique = false)
    private String name;

    @Column(name = "Body", length = 20, nullable = false, unique = false)
    private String body;

//    @Column(name = "Make", nullable = false)
//    private int make;

//    @Column(name = "Generation", length = 20, nullable = false)
//    private String generationName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "make_id", nullable = false)
    @JsonBackReference
    private CarMake carMake;

    @OneToMany(mappedBy = "carModel", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Generation> generations = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "Car_model_engine",
            joinColumns = @JoinColumn(name = "car_model_id"),
            inverseJoinColumns = @JoinColumn(name = "engine_id")
    )
    @JsonManagedReference
    List<Engine> engines;

    @ManyToMany(mappedBy = "carModels", cascade = CascadeType.ALL)

    @JsonBackReference
    List<Part> parts;

}

package com.carparts.wholesaler.models;

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
@Table(name = "car_makes")
@JsonIgnoreProperties(ignoreUnknown=true)
public class CarMake implements Serializable {

    public CarMake(){
    }

    @Id
    @Column(name = "Id_make")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMake;

    @Column(name = "Name", length = 20, nullable = false, unique = false)
    private String name;

    @Column(name = "Country", length = 20, nullable = false, unique = false)
    private String country;

    @OneToMany(mappedBy = "carMake", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CarModel> carModels;
}

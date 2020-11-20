package com.carparts.wholesaler.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "part_types")
@JsonIgnoreProperties(ignoreUnknown=true)
public class PartType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_part_type")
    private int idPartType;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "partType", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Part> parts = new ArrayList<>();
}

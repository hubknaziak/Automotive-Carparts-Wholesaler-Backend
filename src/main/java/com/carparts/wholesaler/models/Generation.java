package com.carparts.wholesaler.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.SpringVersion;

import javax.persistence.*;
import java.util.Date;
//import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "generations")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Generation {

    public Generation(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_generation")
    private int idGeneration;

    @Column(name = "Begin_date", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date beginDate;

    @Column(name = "End_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    @Column(name = "Name", nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "model_id", nullable = false)
    @JsonBackReference
    private CarModel carModel;
}

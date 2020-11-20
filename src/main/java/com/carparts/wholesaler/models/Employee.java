package com.carparts.wholesaler.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "employees")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_employee")
    private int idEmployee;

    @OneToOne
    @MapsId
    @JoinColumn(name = "Id_employee")
    private Account account;

    @Column(name = "Employment_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date employmentDate;

//    @Column(name = "Status", length = 20)
//    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Personal_data", referencedColumnName = "Id_personal_data")
    @JsonManagedReference(value = "employee-data")
    private PersonalData personalData;

}

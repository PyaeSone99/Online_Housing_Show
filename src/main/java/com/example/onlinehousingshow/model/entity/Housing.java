package com.example.onlinehousingshow.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "housings")
@Data
public class Housing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,name = "housing_name")
    private String housingName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false,name = "number_of_floors")
    private int numberOfFloors;
    @Column(nullable = false,name = "number_of_master_room")
    private int numberOfMasterRoom;
    @Column(nullable = false,name = "number_of_single_room")
    private int numberOfSingleRoom;
    @Column(nullable = false)
    private int amount;

    @ManyToOne()
    @JoinColumn(name = "owner_id",nullable = false)
    private Owner owner;

    @Column(nullable = false,name = "created_date")
    private LocalDate createdDate;
    @Column(nullable = false,name = "updated_date")
    private LocalDate updatedDate;


}

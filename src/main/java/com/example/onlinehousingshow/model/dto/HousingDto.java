package com.example.onlinehousingshow.model.dto;

import com.example.onlinehousingshow.model.entity.Housing;
import com.example.onlinehousingshow.model.entity.Owner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HousingDto {
    private int id;
    private String housingName;
    private String address;
    private int numberOfFloors;
    private int numberOfMasterRoom;
    private int numberOfSingleRoom;
    private int amount;
    private String owner;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    public static HousingDto housingData(Housing housing){
        return new HousingDto(housing.getId(),housing.getHousingName(),housing.getAddress(),housing.getNumberOfFloors(),
                housing.getNumberOfMasterRoom(),housing.getNumberOfSingleRoom(),housing.getAmount(),housing.getOwner().getOwnerUserName(),
                housing.getCreatedDate(),housing.getUpdatedDate());
    }
}






























package com.example.onlinehousingshow.model.dto.form;

import com.example.onlinehousingshow.model.entity.Owner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HousingForm {
    private String housingName;
    private String address;
    private int numberOfFloors;
    private int numberOfMasterRoom;
    private int numberOfSingleRoom;
    private int amount;
    private int owner;
}

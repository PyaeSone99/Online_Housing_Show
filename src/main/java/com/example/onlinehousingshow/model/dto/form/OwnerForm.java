package com.example.onlinehousingshow.model.dto.form;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OwnerForm {
    private String ownerUserName;
    private String ownerName;
    private String ownerEmail;
    private String password;

    public OwnerForm(String ownerUserName, String ownerName, String ownerEmail, String password) {
        this.ownerUserName = ownerUserName;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.password = password;
    }
}

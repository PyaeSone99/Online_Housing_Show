package com.example.onlinehousingshow.api;

import com.example.onlinehousingshow.model.dto.OwnerDto;
import com.example.onlinehousingshow.model.dto.form.OwnerForm;
import com.example.onlinehousingshow.model.services.OwnerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("owner")
public class OwnerApi {

    @Autowired
    private OwnerServices services;

    @PostMapping(path = "/register",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public OwnerDto register(@RequestParam("ownerUserName") String ownerUserName,
                           @RequestParam("ownerName") String ownerName,
                           @RequestParam("ownerEmail") String ownerEmail,
                           @RequestParam("password") String password) {
        OwnerForm ownerform = new OwnerForm();
        ownerform.setOwnerUserName(ownerUserName);
        ownerform.setOwnerName(ownerName);
        ownerform.setOwnerEmail(ownerEmail);
        ownerform.setPassword(password);
        return services.save(ownerform);
    }

    @PostMapping(path = "/authenticate",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public OwnerDto authenticate(@RequestParam("ownerUserName")String ownerUserName,
                                 @RequestParam("password")String password){
        return services.authenticate(ownerUserName,password);
    }

}




















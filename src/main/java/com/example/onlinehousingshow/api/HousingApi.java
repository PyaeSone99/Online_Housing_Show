package com.example.onlinehousingshow.api;

import com.example.onlinehousingshow.model.dto.HousingDto;
import com.example.onlinehousingshow.model.dto.form.HousingForm;
import com.example.onlinehousingshow.model.entity.Housing;
import com.example.onlinehousingshow.model.services.HousingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("housing")
public class HousingApi {

    @Autowired
    private HousingServices services;

    @Value("${myapp.secretKey}")
    private String SECRET_KEY;

//    Creating Housing With LoggedIn Owner Api
    @PostMapping
    public HousingDto create(@RequestBody @Validated HousingForm form, BindingResult result,@RequestHeader HttpHeaders headers){
        if (result.hasErrors()){
            throw  new EntityNotFoundException();
        }
        return services.save(form,headers,SECRET_KEY);
    }

//    Updating Housing Data with LoggedIn Owner Api
    @PatchMapping("{id}")
    public HousingDto update(@PathVariable int id, @RequestBody @Validated HousingForm form, BindingResult result,@RequestHeader HttpHeaders headers){
        if (result.hasErrors()){
            throw new EntityNotFoundException();
        }
        return services.update(id,form,headers,SECRET_KEY);
    }

//    Finding Housing Data With LoggedIn Owner Api
    @GetMapping("/findLoggedInUser")
    public List<HousingDto> findByOwnerUserName(@RequestHeader HttpHeaders headers,
                                                @RequestParam Optional<String> housingName,
                                                @RequestParam("numberOfFloors") Optional<Integer> floors,
                                                @RequestParam Optional<Integer> masterRoom,
                                                @RequestParam Optional<Integer> singleRoom,
                                                @RequestParam Optional<Integer> amount,
                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> createdDate,
                                                @RequestParam(required = false,defaultValue = "0")int current,
                                                @RequestParam(required = false,defaultValue = "2")int size){
        return services.findByOwnerUserName(headers,SECRET_KEY,housingName,floors,masterRoom,singleRoom,amount,createdDate,current,size);
    }

//    Finding All Housing Data (Public Api)
    @GetMapping("/allData")
    public List<HousingDto> findAll(@RequestParam Optional<String> housingName,
                                    @RequestParam("numberOfFloors") Optional<Integer> floors,
                                    @RequestParam Optional<Integer> masterRoom,
                                    @RequestParam Optional<Integer> singleRoom,
                                    @RequestParam Optional<Integer> amount,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> createdDate,
                                    @RequestParam(required = false,defaultValue = "0")int current,
                                    @RequestParam(required = false,defaultValue = "2")int size){
        return services.findAllHousingData(housingName,floors,masterRoom,singleRoom,amount,createdDate,current,size);
    }
}






//    with housingName, floors, masterRoom, singleRoom, amount or postedDate (createdDate)

























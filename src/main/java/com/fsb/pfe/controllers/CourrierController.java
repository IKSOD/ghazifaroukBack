package com.fsb.pfe.controllers;
import com.fsb.pfe.dto.CourrierrecuDto;
import com.fsb.pfe.services.CourrierrecuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/courrierRecu")
@CrossOrigin(value = "*")
public class CourrierController {



    @Autowired
    private CourrierrecuService courrierrecuService ;



    @PostMapping("/add")
    public CourrierrecuDto addCourrier(@RequestBody CourrierrecuDto courrierrecuDto)
    {
      return this.courrierrecuService.addCourrierrecu(courrierrecuDto);
    }


    @GetMapping(value = "/getAll")
    public List<CourrierrecuDto>  getAllCouriers()
    {
        return this.courrierrecuService.getAllCourrierRecu();
    }

    @DeleteMapping(value="/deleteOne/{id}")
    public void  deleteOneIfExist(@PathVariable("id") Integer id)
    {
        this.courrierrecuService.deleteCrourrierRecu(id);
    }

}

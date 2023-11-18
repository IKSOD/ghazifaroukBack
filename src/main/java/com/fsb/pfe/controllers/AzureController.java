package com.fsb.pfe.controllers;


import com.azure.core.exception.AzureException;
import com.fsb.pfe.dto.AzureModel;
import com.fsb.pfe.services.AzureStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("azure")
public class AzureController {

     @Autowired
     private AzureStorageService azureStorageService ;


     @RequestMapping("addFileToAzure")
    public ResponseEntity<String> addFileToAzure(@RequestBody AzureModel azureModel) throws AzureException
     {
         if(azureModel ==  null)
         {
             return new ResponseEntity<>(azureModel.getAzureFile(),HttpStatus.ALREADY_REPORTED);
         }
      this.azureStorageService.addFile(azureModel.getFilePath(),  null);
         return new ResponseEntity<>(azureModel.getAzureFile(), HttpStatus.ACCEPTED);
     }


}

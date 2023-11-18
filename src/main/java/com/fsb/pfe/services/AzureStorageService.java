package com.fsb.pfe.services;

import com.azure.core.exception.AzureException;
import com.azure.core.util.BinaryData;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.fsb.pfe.dto.AzureModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;


@Component
public class AzureStorageService {

    public BlobContainerClient blobClient ;

    @Value("${azure.containername}")
    private String containerName ;

    @Value("${azure.url}")
    private String azureUrl ;

    @Value("${azure.token}")
    private String azureToken;

    public AzureStorageService()
    {
        blobClient = this.blobContainerClient() ;}

     private BlobContainerClient blobContainerClient ()
     {
         return  new BlobContainerClientBuilder().containerName("first").endpoint("https://firstedition.blob.core.windows.net/first").sasToken("https://firstedition.blob.core.windows.net/first?sp=racwdl&st=2023-11-18T15:16:13Z&se=2024-07-17T23:16:13Z&sv=2022-11-02&sr=c&sig=sja75lIrVW3SieDy%2BTags9C004KsGYNn7ereQsnMX58%3D").buildClient();


     }

     public void addFile(String filePath , byte[] fileBytes){
       BlobClient blobClient = this.blobClient.getBlobClient(filePath);
         ByteArrayInputStream byteArrayInputStream =  new ByteArrayInputStream(fileBytes);
       if(blobClient.exists()) {
           throw new AzureException("file already exist");
       }

       blobClient.upload(byteArrayInputStream);
     }


}

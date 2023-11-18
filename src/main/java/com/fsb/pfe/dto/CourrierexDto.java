package com.fsb.pfe.dto;


import com.fsb.pfe.entities.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CourrierexDto {

    private List<User> users ;
    private Integer refUser;
    private String docaccompa;
    private String destinataire;
    private String sujet;
    private LocalDate datelivraison;
    private Integer numCourrier;
    private String azureFilePath ;

}

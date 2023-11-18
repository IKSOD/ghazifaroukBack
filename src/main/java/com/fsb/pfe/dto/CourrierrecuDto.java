package com.fsb.pfe.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CourrierrecuDto {
    public  Long  idCourrier;
    private String numInscri;
    private LocalDate datepub;
    private String subject;
    private String docaccompa;
    private String expediteur;
    private String destinataire;
    private String remarque;
    private String filePath;
    private byte [] fileBytes;
}

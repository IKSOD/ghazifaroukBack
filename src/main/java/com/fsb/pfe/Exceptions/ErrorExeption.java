package com.fsb.pfe.Exceptions;


import lombok.Data;

@Data
public class ErrorExeption {
    private String description ;
    private String status;
    private String message ;

}

package com.fsb.pfe.serviceInterface;

import com.fsb.pfe.dto.CourrierrecuDto;
import com.fsb.pfe.entities.Courrierrecu;
import com.fsb.pfe.entities.User;

import java.util.List;

public interface ICourrierrecuService {
    List<CourrierrecuDto> getAllCourrierRecu();

    Courrierrecu getCourrierRecu(Integer idCourrierRecu);

    Courrierrecu addCourrierRecu(Courrierrecu cr);

    Courrierrecu updateCourrierRecu(Courrierrecu cr);

    void deleteCrourrierRecu(Integer idCourrierRecu);

    void assignCourrierRecuToUser(Integer idUser, Integer idCourrierRecu);

     CourrierrecuDto addCourrierrecu(CourrierrecuDto c);
}

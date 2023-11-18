package com.fsb.pfe.services;

import com.fsb.pfe.dto.CourrierrecuDto;
import com.fsb.pfe.entities.Courrierrecu;
import com.fsb.pfe.entities.User;
import com.fsb.pfe.repository.CourrierrecuRepository;
import com.fsb.pfe.repository.UserRepository;
import com.fsb.pfe.serviceInterface.ICourrierrecuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CourrierrecuService implements ICourrierrecuService {

    @Autowired
    CourrierrecuRepository cr;
    @Autowired
    UserRepository ur;

    @Autowired
    private AzureStorageService azureStorageService;

    @Override
    public List<CourrierrecuDto> getAllCourrierRecu() {

        return cr.findAll().stream().map(this::fromModel).collect(Collectors.toList());
    }

    @Override
    public CourrierrecuDto addCourrierrecu(CourrierrecuDto c) {
        Courrierrecu courrierrecu = this.fromDto(c);
        if(c.getFilePath() != null && c.getFileBytes()!= null)
        {
            this.azureStorageService.addFile(c.getFilePath() , c.getFileBytes());
        }
        return this.fromModel(cr.save(courrierrecu));
    }
    @Override
    public Courrierrecu getCourrierRecu(Integer idCourrierRecu) {
        return cr.findById(idCourrierRecu).orElse(null);
    }

    @Override
    public Courrierrecu addCourrierRecu(Courrierrecu c) {
        return cr.save(c);
    }

    @Override
    public Courrierrecu updateCourrierRecu(Courrierrecu c) {
        return cr.save(c);
    }

    @Override
    public void deleteCrourrierRecu(Integer idCourrierRecu) {
        if(checkIfExist(idCourrierRecu) != null)
        cr.deleteById(idCourrierRecu);
    }

    @Override
    public void assignCourrierRecuToUser(Integer idUser, Integer idCourrierRecu) {
        User u = ur.findById(idUser).orElse(null);
        Courrierrecu courRecu = cr.findById(idCourrierRecu).orElse(null);
        courRecu.getUsers().add(u);
        u.getCourrierrecus().add(courRecu);
        cr.save(courRecu);
    }

    public  Courrierrecu checkIfExist(Integer id)
    {
        return cr.findById(id).orElse(null);

    }


    private static Courrierrecu fromDto(CourrierrecuDto courrierrecuDto){

        if(courrierrecuDto ==null)
            return null;


        Courrierrecu courrierrecu  = new Courrierrecu();
        courrierrecu.setNuminscri(courrierrecuDto.getNumInscri());
        courrierrecu.setDestinataire(courrierrecuDto.getDestinataire());
        courrierrecu.setExpediteur(courrierrecuDto.getExpediteur());
        courrierrecu.setRemarque(courrierrecuDto.getRemarque());
        courrierrecu.setDatepub(courrierrecuDto.getDatepub());
        courrierrecu.setDocaccompa(courrierrecuDto.getDocaccompa());
        courrierrecu.setSujet(courrierrecuDto.getSubject());
        courrierrecu.setFilePath(courrierrecuDto.getFilePath());

        return courrierrecu ;
    }

    private  CourrierrecuDto fromModel(Courrierrecu courrierrecuDto){

        if(courrierrecuDto ==null)
            return null;


        CourrierrecuDto courrierrecu  = new CourrierrecuDto();
        courrierrecu.setNumInscri(courrierrecuDto.getNuminscri());
        courrierrecu.setDestinataire(courrierrecuDto.getDestinataire());
        courrierrecu.setExpediteur(courrierrecuDto.getExpediteur());
        courrierrecu.setRemarque(courrierrecuDto.getRemarque());
        courrierrecu.setDatepub(courrierrecuDto.getDatepub());
        courrierrecu.setDocaccompa(courrierrecuDto.getDocaccompa());
        courrierrecu.setSubject(courrierrecuDto.getSujet());
        courrierrecu.setFilePath(courrierrecuDto.getFilePath());

        return courrierrecu ;
    }
}

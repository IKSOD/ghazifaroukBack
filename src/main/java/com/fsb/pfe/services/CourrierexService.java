package com.fsb.pfe.services;

import com.fsb.pfe.entities.Courrierex;
import com.fsb.pfe.repository.CourrierexRepository;
import com.fsb.pfe.serviceInterface.ICourrierexService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourrierexService implements ICourrierexService {

    @Autowired
    CourrierexRepository ce;

    @Override
    public List<Courrierex> getAllCourrierExp() {
        return ce.findAll();
    }

    @Override
    public Courrierex getCourrierExp(int idCourrierExp) {
        return ce.findById(idCourrierExp).orElse(null);
    }

    @Override
    public Courrierex addCourrierExp(Courrierex c) {
        return ce.save(c);
    }

    @Override
    public Courrierex updateCourrierExp(Courrierex c) {
        return ce.save(c);
    }

    @Override
    public void deleteCourrierExp(int idCourrierExp) {
        ce.deleteById(idCourrierExp);
    }
}

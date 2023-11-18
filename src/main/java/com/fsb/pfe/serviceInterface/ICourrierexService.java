package com.fsb.pfe.serviceInterface;

import com.fsb.pfe.entities.Courrierex;

import java.util.List;

public interface ICourrierexService {
    List<Courrierex> getAllCourrierExp();
    Courrierex getCourrierExp(int idCourrierExp);
    Courrierex addCourrierExp(Courrierex cr);
    Courrierex updateCourrierExp(Courrierex cr);
    void deleteCourrierExp(int idCourrierExp);
}

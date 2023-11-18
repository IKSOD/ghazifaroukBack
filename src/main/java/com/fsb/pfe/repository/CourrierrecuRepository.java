package com.fsb.pfe.repository;

import com.fsb.pfe.entities.Courrierrecu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CourrierrecuRepository extends JpaRepository<Courrierrecu, Integer>, JpaSpecificationExecutor<Courrierrecu> {

}
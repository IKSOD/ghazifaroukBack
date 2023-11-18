package com.fsb.pfe.repository;

import com.fsb.pfe.entities.Courrierex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CourrierexRepository extends JpaRepository<Courrierex, Integer>, JpaSpecificationExecutor<Courrierex> {

}
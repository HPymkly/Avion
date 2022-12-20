package com.main.demo.demande.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.demo.demande.model.DetailDemande;

public interface DetailDemandeRepository extends JpaRepository<DetailDemande, Integer> {

    @Query(value = "select r.* from vrequest_details r", nativeQuery = true)
    public List<DetailDemande> findNonPostule();
}

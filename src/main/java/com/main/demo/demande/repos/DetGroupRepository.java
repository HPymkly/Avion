package com.main.demo.demande.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.demo.demande.model.DetGroupDemande;

public interface DetGroupRepository extends JpaRepository<DetGroupDemande, Integer> {
    
}

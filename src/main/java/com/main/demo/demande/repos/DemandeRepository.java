package com.main.demo.demande.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.demo.demande.model.Demande;

public interface DemandeRepository extends JpaRepository<Demande, Integer> {

}

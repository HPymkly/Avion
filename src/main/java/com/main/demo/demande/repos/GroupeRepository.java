package com.main.demo.demande.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.demo.demande.model.GroupDemande;

public interface GroupeRepository extends JpaRepository<GroupDemande, Integer> {

}

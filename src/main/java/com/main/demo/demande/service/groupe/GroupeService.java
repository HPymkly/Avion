package com.main.demo.demande.service.groupe;

import java.util.List;

import com.main.demo.demande.model.GroupDemande;

public interface GroupeService {
    public List<GroupDemande> getAll();

    public void grouper(List<Integer> ids);
}

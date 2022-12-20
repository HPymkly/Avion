package com.main.demo.demande.service.demande;

import java.util.List;

import com.main.demo.demande.model.Demande;
import com.main.demo.generic.service.ObjectBddSaved;

public interface DemandeService {
    public Demande save(Demande d) throws ObjectBddSaved;

    public Demande save(Demande d, boolean shouldCheck) throws ObjectBddSaved;

    public Demande[] toArray(List<Demande> liste);

    public Demande[] getAll();
}

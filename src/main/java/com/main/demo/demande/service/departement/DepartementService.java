package com.main.demo.demande.service.departement;

import java.util.List;

import com.main.demo.demande.model.Departement;

public interface DepartementService {
    public Departement save(Departement d);

    public void save(List<Departement> d);

    public void save(List<Departement> d, boolean shouldCheck);

    public Departement[] getAll();

    public Departement getById(int id);

    public Departement getById(Departement d);

    public Departement[] toArray(List<Departement> liste);
}

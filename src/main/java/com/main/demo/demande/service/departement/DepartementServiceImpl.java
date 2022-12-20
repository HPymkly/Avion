package com.main.demo.demande.service.departement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.main.demo.demande.model.Departement;
import com.main.demo.demande.repos.DepartementRepository;
import com.main.demo.generic.service.GenericService;
import com.main.demo.generic.service.ObjectBddSaved;
import com.main.demo.model.tool.MyTool;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Service
@Qualifier("departService")
@EqualsAndHashCode(callSuper = true)
public class DepartementServiceImpl extends GenericService implements DepartementService {

    @Autowired
    DepartementRepository dRepository;

    public Departement save(Departement d) {
        try {
            this.verif(d);
            return this.getDRepository().save(d);
        } catch (ObjectBddSaved e) {
            return d;
        }
    }

    public Departement[] getAll() {
        return this.toArray(this.getDRepository().findAll());
    }

    public Departement[] toArray(List<Departement> liste) {
        return MyTool.toArray(liste, Departement.class);
    }

    public Departement getById(int id) {
        return this.getDRepository().findById(id).get();
    }

    public Departement getById(Departement d) {
        return this.getById(d.getId());
    }

    public void save(List<Departement> d) {
        this.save(d, true);
    }

    public void save(List<Departement> d, boolean shouldCheck) {
        if (shouldCheck) {
            this.verif(d);
        }
        this.getDRepository().saveAll(d);
    }

}

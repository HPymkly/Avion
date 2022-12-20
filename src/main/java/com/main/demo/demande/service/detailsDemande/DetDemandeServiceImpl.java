package com.main.demo.demande.service.detailsDemande;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.main.demo.demande.model.DetailDemande;
import com.main.demo.demande.repos.DetailDemandeRepository;
import com.main.demo.generic.service.GenericService;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Service
@Qualifier("detDemandeServ")
@EqualsAndHashCode(callSuper = true)
public class DetDemandeServiceImpl extends GenericService implements DetDemandeService {

    @Autowired
    DetailDemandeRepository ddRepository;

    public void save(List<DetailDemande> d) {
        this.save(d, true);
    }

    public void save(List<DetailDemande> d, boolean shouldCheck) {
        if (shouldCheck) {
            this.verif(d);
        }
        this.getDdRepository().saveAll(d);
    }

    public List<DetailDemande> getNonPostule() {
        return this.getDdRepository().findNonPostule();
    }

    public List<DetailDemande> getIn(List<Integer> liste) {
        return this.getDdRepository().findAllById(liste);
    }

    

}

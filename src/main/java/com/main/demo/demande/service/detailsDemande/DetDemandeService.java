package com.main.demo.demande.service.detailsDemande;

import java.util.List;

import com.main.demo.demande.model.DetailDemande;
import com.main.demo.generic.service.GenericServiceInt;

public interface DetDemandeService extends GenericServiceInt {
    public void save(List<DetailDemande> d, boolean shouldCheck);

    public void save(List<DetailDemande> d);

    public List<DetailDemande> getNonPostule();

    public List<DetailDemande> getIn(List<Integer> liste);
}

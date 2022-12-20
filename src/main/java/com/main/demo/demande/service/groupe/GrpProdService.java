package com.main.demo.demande.service.groupe;

import java.util.List;

import com.main.demo.demande.model.GroupDemande;
import com.main.demo.demande.model.GroupeProduit;

public interface GrpProdService {
    public List<GroupeProduit> getBy(GroupDemande grp);
}

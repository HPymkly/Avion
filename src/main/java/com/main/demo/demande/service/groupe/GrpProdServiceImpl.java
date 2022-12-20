package com.main.demo.demande.service.groupe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.main.demo.demande.model.GroupDemande;
import com.main.demo.demande.model.GroupeProduit;

import lombok.Data;

@Data
@Service
@Qualifier("gpService")
public class GrpProdServiceImpl implements GrpProdService {

    public List<GroupeProduit> getBy(GroupDemande grp) {
        return null;
    }

}

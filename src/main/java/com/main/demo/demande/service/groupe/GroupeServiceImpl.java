package com.main.demo.demande.service.groupe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.main.demo.demande.model.DetGroupDemande;
import com.main.demo.demande.model.DetailDemande;
import com.main.demo.demande.model.GroupDemande;
import com.main.demo.demande.repos.DetGroupRepository;
import com.main.demo.demande.repos.GroupeRepository;
import com.main.demo.demande.service.detailsDemande.DetDemandeService;
import com.main.demo.generic.service.GenericService;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Service
@Qualifier("gService")
public class GroupeServiceImpl extends GenericService implements GroupeService {

    @Autowired
    DetDemandeService ddService;

    @Autowired
    GroupeRepository gRepository;

    @Autowired
    DetGroupRepository dGRepository;

    public List<GroupDemande> getAll() {
        return this.getGRepository().findAll();
    }

    public void grouper(List<Integer> ids) {
        GroupDemande grp = new GroupDemande();
        List<DetailDemande> ans = null;
        if (ids != null) {
            ans = this.getDdService().getIn(ids);
        } else {
            ans = this.getDdService().getNonPostule();
        }
        List<DetGroupDemande> det = new ArrayList<DetGroupDemande>();
        for (int i = 0; i < ans.size(); i++) {
            det.add(new DetGroupDemande(ans.get(i), grp));
        }
        grp.setDemandeDetails(det);
        this.getGRepository().save(grp);
        this.getDGRepository().saveAll(grp.getDemandeDetails());
    }

}

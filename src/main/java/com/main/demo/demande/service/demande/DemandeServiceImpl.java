package com.main.demo.demande.service.demande;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.main.demo.demande.model.Demande;
import com.main.demo.demande.repos.DemandeRepository;
import com.main.demo.demande.service.departement.DepartementService;
import com.main.demo.demande.service.detailsDemande.DetDemandeService;
import com.main.demo.generic.model.ObjectBdd;
import com.main.demo.generic.service.GenericService;
import com.main.demo.generic.service.ObjectBddSaved;
import com.main.demo.model.tool.MyTool;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Service
@Qualifier("demandeService")
@EqualsAndHashCode(callSuper = true)
public class DemandeServiceImpl extends GenericService implements DemandeService {
    @Autowired
    DemandeRepository dRepository;

    @Autowired
    @Qualifier("departService")
    DepartementService dpService;

    @Autowired
    @Qualifier("detDemandeServ")
    DetDemandeService ddService;

    public Demande save(Demande d) throws ObjectBddSaved {
        return this.save(d, true);
    }

    public Demande[] toArray(List<Demande> liste) {
        return MyTool.toArray(liste, Demande.class);
    }

    public Demande[] getAll() {
        return this.toArray(this.getDRepository().findAll());
    }

    @Override
    public void verif(ObjectBdd obj) throws ObjectBddSaved {
        super.verif(obj);
        this.getDdService().verif(((Demande) obj).getDetailDemandes());
    }

    public Demande save(Demande d, boolean shouldCheck) throws ObjectBddSaved {
        if (shouldCheck) {
            try {
                this.verif(d);
            } catch (ObjectBddSaved e) {
                throw new ObjectBddSaved(
                        "Cannot be saved because this object is already in the database. Set the Id to null.");
            }
        }
        d = this.getDRepository().save(d);
        this.getDdService().save(d.getDetailDemandes(), !shouldCheck);
        return d;
    }

}

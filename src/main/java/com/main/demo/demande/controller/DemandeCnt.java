package com.main.demo.demande.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.gson.Gson;
import com.main.demo.demande.model.Demande;
import com.main.demo.demande.model.DemandeModel;
import com.main.demo.demande.model.DetailDemande;
import com.main.demo.demande.model.GroupDemande;
import com.main.demo.demande.model.GroupeProduit;
import com.main.demo.demande.model.Status;
import com.main.demo.demande.service.demande.DemandeService;
import com.main.demo.demande.service.departement.DepartementService;
import com.main.demo.demande.service.detailsDemande.DetDemandeService;
import com.main.demo.demande.service.groupe.GroupeService;
import com.main.demo.demande.service.groupe.GrpProdService;
import com.main.demo.demande.service.produit.ProduitService;
import com.main.demo.generic.controller.GenericController;
import com.main.demo.generic.convension.Logic;
import com.main.demo.model.tool.MyTool;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@RestController
public class DemandeCnt extends GenericController {

    @Autowired
    @Qualifier("demandeService")
    DemandeService dmService;

    @Autowired
    @Qualifier("departService")
    DepartementService dpService;

    @Autowired
    @Qualifier("detDemandeServ")
    DetDemandeService ddService;

    @Autowired
    @Qualifier("prService1")
    ProduitService prService;

    @Autowired
    @Qualifier("gService")
    GroupeService gService;

    @Autowired
    @Qualifier("gpService")
    GrpProdService gpService;

    @Autowired
    Gson gson;

    @GetMapping("/demande/details/nonpostule")
    public String detNonPostule() {
        List<DetailDemande> ans = this.getDdService().getNonPostule();
        return this.getMessage(ans);
    }

    @GetMapping("/demande/grouper/{id}")
    public String getByGroup(@PathVariable String id) {
        GroupDemande grp = new GroupDemande();
        grp.setId(Integer.parseInt(id));
        List<GroupeProduit> ans = this.getGpService().getBy(grp);
        return this.getMessage(ans);
    }

    @GetMapping("/demande/grouper")
    public String getGroupe() {
        List<GroupDemande> ans = this.getGService().getAll();
        return this.getMessage(ans);
    }

    @PostMapping("/demande/grouper")
    public String grouperDetails(@RequestBody Map<String, List<String>> details) {
        List<Integer> ans = MyTool.toInt(details.get("iddetails"));
        try {
            this.getGService().grouper(ans);
        } catch (Exception e) {
            e.printStackTrace();
            return this.onError(e);
        }
        return Logic.Yes.getSignal();
    }

    /**
     * Aza adino fa methode Get ito
     * 
     * @return :
     *         {"departements":[
     *         {
     *         "name":"value",
     *         "id":value
     *         }
     *         ],
     *         "produits":[
     *         {
     *         "value":"value",
     *         "id":value
     *         }
     *         ]}
     */
    @GetMapping("/demande")
    public String formRequest() {
        DemandeModel d = new DemandeModel();
        d.setDepartements(this.getDpService().getAll());
        d.setProduits(this.getPrService().getAll());
        return this.getGson().toJson(d);
    }

    /**
     * Tyh ndray method POST
     * 
     * @param d :
     *          {"dept":{"id" : idvalue},
     *          "detailDemandes": [
     *          {
     *          "produit" : {"id" : idValue},
     *          "quantite" : qttValue,
     *          "qualite" : qltValue,
     *          "designation" : value
     *          }
     *          ]}
     * @return :
     *         Miandry kely ny Gestion d'erreur
     */
    @PostMapping("/demande")
    public String addRequest(@RequestBody Demande d) {
        d.loadDetails(d);
        d.setState(Status.Postule);
        this.getDmService().save(d);
        return Logic.Yes.getSignal();
    }
}

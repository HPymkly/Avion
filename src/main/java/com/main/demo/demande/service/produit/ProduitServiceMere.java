package com.main.demo.demande.service.produit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.main.demo.demande.model.Produit;
import com.main.demo.demande.repos.ProduitRepository;
import com.main.demo.model.tool.MyTool;

import lombok.Data;

@Data
public abstract class ProduitServiceMere implements ProduitService {
    @Autowired(required = true)
    ProduitRepository prRepository;

    public Produit[] toArray(List<Produit> liste) {
        return MyTool.toArray(liste, Produit.class);
    }

    public Produit save(Produit p) {
        return this.prRepository.save(p);
    }

    public Produit[] getAll() {
        return this.toArray(this.prRepository.findAll());
    }

    public Produit[] getByName(Produit p) {
        List<Produit> ans = this.prRepository.findByValueContains(p.getValue());
        return this.toArray(ans);
    }

    public Produit[] getByTheOtherMeth(Produit p) {
        List<Produit> ans = this.prRepository.findByName(p.getValue());
        return this.toArray(ans);
    }

    public abstract String sayValue(Produit p);
}

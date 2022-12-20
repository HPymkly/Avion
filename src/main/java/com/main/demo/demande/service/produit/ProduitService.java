package com.main.demo.demande.service.produit;

import com.main.demo.demande.model.Produit;

public interface ProduitService {
    public String sayValue(Produit p);

    Produit save(Produit p);

    Produit[] getAll();

    Produit[] getByName(Produit p);

    Produit[] getByTheOtherMeth(Produit p);
}

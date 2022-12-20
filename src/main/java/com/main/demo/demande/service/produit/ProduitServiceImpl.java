package com.main.demo.demande.service.produit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.main.demo.demande.model.Produit;

@Service
@Qualifier("prService1")
public class ProduitServiceImpl extends ProduitServiceMere {

    @Override
    public String sayValue(Produit p) {
        String message = "The product value is %s";
        message = String.format(message, p.getValue());
        return message;
    }

}

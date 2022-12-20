package com.main.demo.demande.service.produit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.main.demo.demande.model.Produit;

@Service
@Qualifier("prService2")
public class ProduitServiceImpl1 extends ProduitServiceMere {

    @Override
    public String sayValue(Produit p) {
        String message = "The Ids match are : %s ";
        String ans = "";
        Produit[] liste = this.toArray(this.getPrRepository().findByValueContains(ans));
        for (int i = 0; i < liste.length; i++) {
            ans += (i != 0 ? "," : "") + liste[i].getId();
        }
        return String.format(message, ans);
    }
}

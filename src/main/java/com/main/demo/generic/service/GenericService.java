package com.main.demo.generic.service;

import java.util.List;

import com.main.demo.generic.model.ObjectBdd;

public class GenericService implements GenericServiceInt {
    public void verif(ObjectBdd obj) throws ObjectBddSaved {
        if (obj.getId() != null) {
            throw new ObjectBddSaved();
        }
    }

    public void verif(List<?> liste) {
        for (int i = 0; i < liste.size(); i++) {
            try {
                ObjectBdd obj = (ObjectBdd) liste.get(i);
                this.verif(obj);
            } catch (ObjectBddSaved e) {
                liste.remove(i);
                i--;
            }
        }
    }
}

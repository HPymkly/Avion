package com.main.demo.generic.service;

import java.util.List;

import com.main.demo.generic.model.ObjectBdd;

public interface GenericServiceInt {
    public void verif(ObjectBdd obj) throws ObjectBddSaved;

    public void verif(List<?> liste);
}

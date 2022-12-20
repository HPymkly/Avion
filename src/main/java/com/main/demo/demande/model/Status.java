package com.main.demo.demande.model;


public enum Status {
    Postule(1), Proformat(2), MoinsDisant(3), BCEnvoie(4), Livraison(5), LivreTermine(6), Dispatch(7);

    int id;

    private Status(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

}

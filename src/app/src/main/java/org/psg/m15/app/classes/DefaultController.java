package org.psg.m15.app.classes;

import javax.persistence.EntityManagerFactory;

public abstract class DefaultController {

    private EntityManagerFactory emf;

    public EntityManagerFactory getEmf () {
        return emf;
    }

    public void setEmf (EntityManagerFactory emf) {
        this.emf = emf;
    }
}

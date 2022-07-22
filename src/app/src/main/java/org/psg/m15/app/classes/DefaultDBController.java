package org.psg.m15.app.classes;

import org.psg.m15.app.interfaces.IInicia;
import org.psg.m15.app.model.Usuari;

public abstract class DefaultDBController extends DefaultController implements IInicia {

    private Usuari usuari;

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }
}

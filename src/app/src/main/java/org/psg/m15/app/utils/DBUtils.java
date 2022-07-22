package org.psg.m15.app.utils;

import org.psg.m15.app.classes.Constants;
import org.psg.m15.app.classes.UsuariHelper;
import org.psg.m15.app.enums.LoginStates;
import org.psg.m15.app.model.Usuari;

import javax.persistence.EntityManagerFactory;

public class DBUtils {

    private EntityManagerFactory emf;

    public DBUtils(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     *
     * @param usuari usuari amb el que es vol entrar a l'aplicacio
     * @param password contrasenya amb la cual es vol entrar a l'aplicacio
     * @return LoginStates per sabes si l'usuari entra, ha fallat o ha sigut bloquejat
     *
     * Funcio que s'encarrega de comprovar a la base de dades si el usuari i contrasenya introduits existeixen, el usuari es correcte pero la contrasenya no
     * o s'arriba al numero maxim d'intents i es bloqueja al usuari.
     */
    public LoginStates checkPassword(String usuari, String password) {
        LoginStates loginStates = null;
        UsuariHelper helper = new UsuariHelper(this.emf, Usuari.class);
        Usuari u = helper.getUsuariByUsername(usuari);

        if (u != null) {
            if (u.getUsername().equals(usuari) && password.equals(u.getPasswd()) && !u.isBloquejat()) {
                loginStates = LoginStates.GRANTED;
            } else {
                if (u.getIntents() < Constants.MAX_INTENTS - 1 && !u.isBloquejat()) {
                    loginStates = LoginStates.FAILED;
                    u.setIntents(u.getIntents() + 1);
                } else if (u.getIntents() >= Constants.MAX_INTENTS - 1){
                    u.setBloquejat(true);
                    u.setIntents(u.getIntents() + 1);
                    loginStates = LoginStates.LOCKED;
                }
                helper.update(u);
            }
            return loginStates;
        } else {
            loginStates = LoginStates.NOEXIST;
        }

        return loginStates;
    }
}
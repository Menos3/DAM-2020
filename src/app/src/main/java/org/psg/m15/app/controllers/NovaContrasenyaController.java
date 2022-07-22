package org.psg.m15.app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import org.psg.m15.app.classes.DAOHelper;
import org.psg.m15.app.classes.DefaultDBController;
import org.psg.m15.app.classes.EncryptHelper;
import org.psg.m15.app.model.Usuari;

public class NovaContrasenyaController extends DefaultDBController {

    @FXML
    PasswordField pfNovaContrasenya;

    private DAOHelper<Usuari> helper;

    @Override
    public void inicia() {
        helper = new DAOHelper<>(getEmf(), Usuari.class);
    }

    @FXML
    public void btGuardarContrasenyaOnAction(ActionEvent event) {

        try{
            EncryptHelper eh = new EncryptHelper();
            getUsuari().setPasswd(eh.AESEncrypt(pfNovaContrasenya.getText()));
            helper.update(getUsuari());
            ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

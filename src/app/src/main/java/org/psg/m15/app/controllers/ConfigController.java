package org.psg.m15.app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.psg.m15.app.classes.AppConfigSingleton;
import org.psg.m15.app.classes.Constants;
import org.psg.m15.app.classes.DAOHelper;
import org.psg.m15.app.classes.DefaultDBController;
import org.psg.m15.app.model.Config;
import org.psg.m15.app.utils.Utilitats;

import java.util.List;

public class ConfigController extends DefaultDBController {

    @FXML
    TextField tfNumIntents;

    @FXML
    TextField tfCaractersContrasenya;

    @FXML
    TextField tfAssumpteCorreu;

    @FXML
    TextArea taCosCorreu;

    @FXML
    Button btGuardarConfig;

    private boolean update = true;
    DAOHelper<Config> helper;
    private Config config;

    /**
     * Metode que s'utilitza per carregar la connexio a la base de dades, consultar el registre de configuracio i carregar-lo
     * Si no hi ha cap registre en la base de dades, el formulari passa a mode d'alta per omplir els camps i guardar-los
     */
    public void inicia () {
        helper = new DAOHelper<>(this.getEmf(), Config.class);
        List<Config> llista = helper.getAll();

        if (llista != null && !llista.isEmpty()) {
            config = llista.get(0);
            tfNumIntents.setText(String.valueOf(config.getIntents()));
            tfCaractersContrasenya.setText((String.valueOf(config.getMaxPassword())));
            tfAssumpteCorreu.setText(config.getAssumpteMail());
            taCosCorreu.setText(config.getCosMail());
      } else {
            update = false;
        }
    }

    /**
     * @param event Parametre refernciat a fer clic en el boto
     *
     * Metode que s'encarrega de fer el INSERT o el UPDATE a la base de dades (depenent si hi ha un registre existent o no)
     * Els camps buits es gestionen amb una alerta avisant que certs camps no poden estar buits
     */

    @FXML
    public void btGuardarConfigOnAction(ActionEvent event) {
        if(tfNumIntents.getLength() == 0 || tfCaractersContrasenya.getLength() == 0 || tfAssumpteCorreu.getLength() == 0 || taCosCorreu.getLength() == 0 ) {
            Utilitats.AlertaGeneralWarning(Constants.TITOL_CONFIGURACIO,Constants.CAPCALERA_ALERTA_CAMPS_BUITS, Constants.MISSATGE_ALERTA_CAMPS_BUITS);

        }else {

            if (update){
                config.setIntents(Integer.parseInt(tfNumIntents.getText()));
                config.setMaxPassword(Integer.parseInt(tfCaractersContrasenya.getText()));
                config.setAssumpteMail(tfAssumpteCorreu.getText());
                config.setCosMail(taCosCorreu.getText());
                helper.update(config);

            } else {
                Config c= new Config();
                c.setIntents(Integer.parseInt(tfNumIntents.getText()));
                c.setMaxPassword(Integer.parseInt(tfCaractersContrasenya.getText()));
                c.setAssumpteMail(tfAssumpteCorreu.getText());
                c.setCosMail(taCosCorreu.getText());
                try{
                    helper.insert(c);
                }catch (Exception e){
                    e.printStackTrace();
                }

                AppConfigSingleton.getInstancia().setIntents(Integer.parseInt(tfNumIntents.getText()));
                AppConfigSingleton.getInstancia().setMaxPassword(Integer.parseInt(tfCaractersContrasenya.getText()));
                AppConfigSingleton.getInstancia().setAssumpteMail(tfAssumpteCorreu.getText());
                AppConfigSingleton.getInstancia().setCosMail(taCosCorreu.getText());

                update = true;
            }
            ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
        }
    }

}

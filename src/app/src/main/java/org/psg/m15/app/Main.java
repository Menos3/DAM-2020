package org.psg.m15.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.commons.configuration.ConfigurationException;
import org.psg.m15.app.classes.AppPropertiesHelper;
import org.psg.m15.app.classes.CryptoException;
import org.psg.m15.app.classes.PropertiesHelperException;
import org.psg.m15.app.controllers.LoginController;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    private EntityManagerFactory emf;

    /**
     *
     * @throws Exception Llança un error amb missatge en cas de que no es pogués iniciar la connexió
     *
     *  Aquesta funció s'encarrega d'iniciar la connexió a la BBDD (MariaDB en aquest cas).
     */
    @Override
    public void init() throws Exception {
        super.init();
        emf = Persistence.createEntityManagerFactory("mariaDB",
                getProperties());
    }

    /**
     *
     * @throws Exception Llança un error amb missatge en cas de que no es pogués iniciar la connexió
     *
     *  Aquesta funció s'encarrega de tancar la connexió creada amb la BBDD.
     */
    public Map getProperties() throws CryptoException, IOException, PropertiesHelperException, ConfigurationException {
        Map result = new HashMap();
        // Read the properties from a file instead of hard-coding it here.
        // Or pass the password in from the command-line.
        try {
            String passwd = getDecryptedPropsFilePassword("app.properties", "password","enc");
            result.put("javax.persistence.jdbc.password", passwd);
        } catch (PropertiesHelperException e) {
            System.err.println("Error en el procés d'encriptació");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return result;
    }
    private static String getDecryptedPropsFilePassword(String fitxer, String clauAEncriptar,String clauTestEncriptacio) throws PropertiesHelperException, ConfigurationException {
        AppPropertiesHelper helper = new AppPropertiesHelper(fitxer, clauAEncriptar, clauTestEncriptacio);
        return helper.getDecryptedUserPassword();
    }
    @Override
    public void stop() throws Exception {
        if(emf != null && emf.isOpen()) {
            emf.close();
        }

        super.stop();
    }


    /**
     *
     * @param stage Es un objecte que s'encarrega de carregar el formulari amb uns paràmetres prefedinits.
     * @throws Exception Llança un error amb missatge en cas de que no es pogués iniciar la connexió
     *
     * Aquesta funció s'encarrega de obrir una connexió a la BBDD un cop s'ha iniciat.
     */

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/login.fxml"));
        Parent root = null;

        try {
            root = loader.load();
            LoginController controller = loader.getController();
            controller.setEmf (emf);
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.DECORATED);;
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            Platform.exit();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

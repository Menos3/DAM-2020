package org.psg.m15.app.testFX;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import org.psg.m15.app.Main;
import org.psg.m15.app.controllers.LoginController;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@DisplayName("Test: Login Test GUI")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTestFX extends ApplicationTest {

    @Start
    public void start(Stage stage) throws IOException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("mariaDB");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/login.fxml"));
        Parent root = null;

        try {
            root = loader.load();
            LoginController controller = loader.getController();
            controller.setEmf(emf);
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.DECORATED);
            //stage.setMaximized(true);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            Platform.exit();
        }
    }

    @Order(1)
    @DisplayName("Test d'usuaris")
    @ParameterizedTest
    @CsvSource({"bgates, pass", "pnorton, pass", "emusk, pass"})
    void  introdueix_dades_correctament(ArgumentsAccessor argumentsAccessor) {

        String usuari = argumentsAccessor.getString(0);
        String password = argumentsAccessor.getString(1);

        clickOn("#tfUsuari");
        write(usuari);

        clickOn("#tfPassword");
        write(password);

        clickOn("#btSignIn");
        FxAssert.verifyThat("#lbErrors", LabeledMatchers.hasText("Accés garantit !!!"));
    }
}

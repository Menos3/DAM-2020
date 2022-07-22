package org.psg.m15.app.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.psg.m15.app.enums.LoginStates;
import org.psg.m15.app.utils.DBUtils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LoginSteps {
    private LoginStates result;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariaDB");
    private static DBUtils dbUtils;

    @Given("^Donat l avaluador de login$")
    public void donatLAvaluadorDeLogin() {
        dbUtils = new DBUtils(emf);
    }

    @When("^Quan l usuari introdueix les dades correctament (.+) (.+)$")
    public void quanLUsuariIntrodueixLesDadesCorrectamentUsuariPassword(String usuari, String passwd) {
        result = dbUtils.checkPassword(usuari, passwd);
    }

    @Then("^L usuari accedeix al sistema$")
    public void lUsuariAccedeixAlSistema() {
        LoginStates expected = LoginStates.GRANTED;
        Assertions.assertEquals(expected, result, "accessUtils.check_password() falla");
    }

    @When("^Quan l usuari introdueix les dades malament (.+) (.+)$")
    public void quanLUsuariIntrodueixLesDadesMalament(String usuari, String passwd) {
        result = dbUtils.checkPassword(usuari, passwd);
    }

    @Then("^L usuari no accedeix al sistema$")
    public void lUsuariNoAccedeixAlSistema() {
        LoginStates expected = LoginStates.FAILED;
        Assertions.assertEquals(expected, result, "accesUtils.check_password() falla");
    }

    //TODO: SMA El cucumber esta por comprovar
    @When("^Quan l usuari introdueix les dades malament (.+) (.+)$")
    public void quanLUsuariIntrodueixLesDadesMalamentIEsBloquejaElCompte(String usuari, String passwd) {
        result = dbUtils.checkPassword(usuari, passwd);
    }

    @Then("Compte bloquejat")
    public void compteBloquejat(int numIntents) {
        if (numIntents >= 3) {
            LoginStates expected = LoginStates.LOCKED;
            Assertions.assertEquals(expected, result, "accesUtils.check_password() falla");
        }
    }
}

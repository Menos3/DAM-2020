package org.psg.m15.app.classes;

public class AppConfigSingleton {

    private static AppConfigSingleton instancia;
    private Integer maxPassword;
    private int intents;
    private String assumpteMail;
    private String CosMail;

    /**
     * @return la instancia creada
     * <p>
     * Metode per crear instancies de la classe AppConfigSingleton
     * Si la instancia a crear es diferent de null, es crea una nova instancia de la classe AppConfigSingleton
     */
    public static AppConfigSingleton getInstancia() {
        if (instancia == null)
            instancia = new AppConfigSingleton();
        return instancia;
    }
    private AppConfigSingleton() {

    }

    public Integer getMaxPassword() {
        return maxPassword;
    }

    public void setMaxPassword(Integer maxPassword) {
        this.maxPassword = maxPassword;
    }

    public int getIntents() {
        return intents;
    }

    public void setIntents(int intents) {
        this.intents = intents;
    }

    public String getAssumpteMail() {
        return assumpteMail;
    }

    public void setAssumpteMail(String assumpteMail) {
        this.assumpteMail = assumpteMail;
    }

    public String getCosMail() {
        return CosMail;
    }

    public void setCosMail(String cosMail) {
        CosMail = cosMail;
    }

    @Override
    public String toString() {
        return "AppConfigSingleton{" +
                "maxPassword='" + maxPassword + '\'' +
                ", intents='" + intents + '\'' +
                ", assumpteMail='" + assumpteMail + '\'' +
                ", CosMail='" + CosMail + '\'' +
                '}';
    }
}
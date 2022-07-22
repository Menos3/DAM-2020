package org.psg.m15.app.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import static org.psg.m15.app.classes.Constants.BTN_DACORD;

public class Utilitats {

    /**
     *
     * @param TitolAlerta  Titol de la alerta
     * @param Capcalera  Capcalera de la alerta
     * @param Missatge  El error del que s'esta avisant
     *
     * Metode per generar alertes de tipus WARNING
     * Es reben els tres missatges per omplir la finestra de la alerta i es mostra al usuari
     *
     */

    public static void AlertaGeneralWarning(String TitolAlerta, String Capcalera, String Missatge) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(TitolAlerta);
        alert.setHeaderText(Capcalera);
        alert.setContentText(Missatge);
        alert.getDialogPane().setPrefSize(400, 300);
        ButtonType btDacord = new ButtonType(BTN_DACORD);
        alert.getButtonTypes().setAll(btDacord);
        alert.showAndWait();
    }
    /**
     * retorna la ip del ordenador
     * @return
     */
    public String GevIP(){
        String ip="";
        try(final DatagramSocket socket = new DatagramSocket()){
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            ip = socket.getLocalAddress().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return ip;
    }

}

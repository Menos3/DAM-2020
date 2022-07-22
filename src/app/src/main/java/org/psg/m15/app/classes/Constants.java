package org.psg.m15.app.classes;

public class Constants {

    public static final int MAX_INTENTS = 3;

    //Constants dels butons
    public static final String BTN_DACORD = "D'acord";
    public static final String BTN_SI = "Si";
    public static final String BTN_NO = "No";

    //Constants correu
    public static final String ASSUMPTE_CORREU_BLOQUEIG = "Bloqueig de compte";
    public static final String COS_CORREU_BLOQUEIG = "La seva conta ha sigut bloquejada per excedir el numero maxim d'intents. "+
            "Contacti amb el administrador del sistema per desbloquejat el seu compte";
    public static final String COS_CORREU_BLOQUEIG_ADMIN = "La seva conta ha siguit bloquejada per un administrador. Contacti amb el seu administrador" +
            "de sistema per desbloquejarla";
    public static final String ASSUMPTE_CORREU_CONTRASENYA = "Contrasenya canviada";
    public static final String COS_CORREU_CONTRASENYA = "La seva contrasenya ha sigut canviada. La contrasenya nova es: ";

    //Constants Alerta Camps Buits
    public static final String CAPCALERA_ALERTA_CAMPS_BUITS = "Camp Buit";
    public static final String MISSATGE_ALERTA_CAMPS_BUITS = "Els camps no poden estar buits. Introdueix un caracter com a minim";

    //Constants Alertas Salir de la app
    public static final String TITOL_ALERTA_SORTIR = "Sortir";
    public static final String CAPCALERA_ALERTA_SORTIR = "Esteu sortint de la aplicacio";
    public static final String MISSATGE_ALERTA_SORTIR = "Esteu segurs que voleu sortir de la aplicacio?";

    //Constants Alertas Login
    public static final String TITOL_ALERTA_LOGIN = "Login";
    public static final String CAPCALERA_ALERTA_DADES_INCORRECTES = "Acces incorrecte";
    public static final String CAPCALERA_ALERTA_BLOQUEIG = "Bloqueig";
    public static final String MISSATGE_ALERTA_BLOQUEIG = "El seu usuari es troba bloquejat, per favor contacti amb l'administrador del sistema, perquè siguin restablerts els drets d'accés.";
    public static final String MISSATGE_ALERTA_NONEXISTING = "L'usuari o la contrasenya son incorrectes";

    //Constants Alertas Canvi Contrasenya
    public static final String TITOL_CANVI_CONTRASENYA = "Canvi de Contrasenya";
    public static final String CAPCALERA_ALERTA_LONGITUD = "Longitud maxima";
    public static final String CAPCALERA_ALERTA_CONTRASENYES_DIFERENTS = "Contrasenyes diferents";
    public static final String MISSATGE_CONTRASENYES_DIFERENTS = "La contrasenya nova i la confirmacio no coincideixen";
    public static final String MISSATGE_CONTRASENYES_NO_COINCIDEIXEN="Les contrasenyes no coincideixen";

    //Constants Alertas Personalitzacio Usuari
    public static final String TITOL_PERSONALITZACIO_USUARI = "Personalitzacio d'usuari";
    public static final String CAPCALERA_ERROR_TELEFON = "Telefon incorrecte ";
    public static final String CAPCALERA_CORREU_INCORRECTE = "Format de correu incorrecte";
    public static final String MISSATGE_NUMERO_TELEFON_INCORRECTE = "La allargada del numero  ha de ser 9 no  ";
    public static final String MISSATGE_CORREU_INCORRECTE ="El correu  no es correcte ";

    //Constants Alertes Configuració
    public static final String TITOL_CONFIGURACIO = "Configuracio del Sistema";

    //Constants Administracio d'Usuaris
    public static final int DOUBLE_CLICK = 2;
    public static final String TITOL_ADMINSTRACIO_USUARIS = "Administracio d'Usuaris";
    public static final String CONFIRMAR_ACCIO = "Eliminar Usuari";
    public static final String SEGUR_QUE_VOLS_ELIMINAR = "Segur que vols eliminar al usuari: ";


    //Constants Administracio de Dispositius
    public static final String MSG_TITOL_ALTA_DISPOSITIUS = "ALTA DISPOSITIUS" ;
    public static final String MSG_TITOL_MODIFICA_DISPOSITIUS = "MODIFICA DISPOSITIUS" ;

}

package segundoobligatoriop2;

import segundoobligatoriop2.interfaz.InterfazRegistro;
import segundoobligatoriop2.auxiliar.*;

public class Sistema {

    public static void main(String[] args) {
        InterfazRegistro v = new InterfazRegistro();
        v.setVisible(true);
        Mercado m = new Mercado();
    }

}

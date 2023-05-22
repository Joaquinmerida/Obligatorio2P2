package segundoobligatoriop2.auxiliar;

import java.util.*;

public class Mercado {

    private ArrayList<Mayorista> listaMayoristas;
    private ArrayList<Puesto> listaPuestos;

    public Mercado() {
        listaMayoristas = new ArrayList<>();
        listaPuestos = new ArrayList<>();
    }

    public ArrayList<Mayorista> getListaMayoristas() {
        return listaMayoristas;
    }

    public ArrayList<Puesto> getListaPuestos() {
        return listaPuestos;
    }

    public void agregarMayorista(Mayorista unMayorista) {
        this.getListaMayoristas().add(unMayorista);
    }

    public void agregarPuesto(Puesto unPuesto) {
        this.getListaPuestos().add(unPuesto);
    }

}

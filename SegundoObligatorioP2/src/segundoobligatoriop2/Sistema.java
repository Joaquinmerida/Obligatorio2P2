package segundoobligatoriop2;

import java.util.ArrayList;
import segundoobligatoriop2.interfaz.*;
import segundoobligatoriop2.auxiliar.*;

public class Sistema {

    private static ArrayList<Mayorista> listaMayoristas;
    private static ArrayList<Puesto> listaPuestos;

    public static void main(String[] args) {
        Interfaz v = new Interfaz();
        v.setVisible(true);
        listaMayoristas = new ArrayList<>();
        listaPuestos = new ArrayList<>();
    }

    public static ArrayList<Mayorista> getListaMayoristas() {
        return listaMayoristas;
    }

    public ArrayList<Puesto> getListaPuestos() {
        return listaPuestos;
    }

    public static void agregarMayorista(String nombre, String rut, String direccion /*FALTA AGREGAR LA LISTA DE ITEMS QUE VENDE*/) {
        Mayorista unMayorista = new Mayorista(rut,nombre,direccion);
        Sistema.getListaMayoristas().add(unMayorista);
        System.out.println("se agrega mayorista");
        for (Mayorista mayorista : listaMayoristas) {
            System.out.println(mayorista.getNombre());
        }
    }

    public void agregarPuesto(Puesto unPuesto) {
        this.getListaPuestos().add(unPuesto);
    }

  

    public static void altaItem(String nombre, String descripcion, String tipo, String formaVenta, String imagen) {

        System.out.println("se agrega");

    }

}

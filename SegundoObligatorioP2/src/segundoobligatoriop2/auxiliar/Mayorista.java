package segundoobligatoriop2.auxiliar;

import java.util.*;

public class Mayorista {

    private String rut;
    private String nombre;
    private String direccion;
    private ArrayList<Item> listaItems;

    public Mayorista(String rut, String nombre, String direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaItems = new ArrayList<Item>();
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Item> getListaItems() {
        return listaItems;
    }

    public void agregarItem(Item unItem) {
        this.listaItems.add(unItem);
    }

    public boolean itemUnico(String nombre) {
        for (Item item : this.getListaItems()) {
            if (item.getNombre().equals(nombre)) {
                System.out.println("Ya existe un item con ese nombre.");
                return false;
            }
        }
        System.out.println("no esiste");
        return true;
    }

}

package segundoobligatoriop2.auxiliar;

import java.util.*;

public class Mayorista {

    private int rut;
    private String nombre;
    private String direccion;
    private ArrayList<Item> listaItems;

    public Mayorista(int rut, String nombre, String direccion,ArrayList<Item> listaItems) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaItems = listaItems;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
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
                return false;
            }
        }
        return true;
    }


    
}

package segundoobligatoriop2.auxiliar;

import java.util.*;

public class Mayorista {

    private String rut;
    private String nombre;
    private String direccion;
    private ArrayList<Item> listaItems;

    // falta la lista de productos que es array
    public Mayorista(String rut, String nombre, String direccion, ArrayList listaItems) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaItems = listaItems;
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
        this.getListaItems().add(unItem);
    }

}

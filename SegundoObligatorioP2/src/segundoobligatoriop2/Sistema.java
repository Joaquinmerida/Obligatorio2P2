package segundoobligatoriop2;

import java.util.ArrayList;
import segundoobligatoriop2.interfaz.*;
import segundoobligatoriop2.auxiliar.*;

public class Sistema {

    private static ArrayList<Mayorista> listaMayoristas;
    private static ArrayList<Puesto> listaPuesto;
    private static ArrayList<Dueno> listaDuenos;

    public static void main(String[] args) {
        listaMayoristas = new ArrayList<>();
        listaDuenos = new ArrayList<>();
        listaPuesto= new ArrayList<>();
        Interfaz v = new Interfaz();
        v.setVisible(true);

    }

    public static ArrayList<Mayorista> getListaMayoristas() {
        return listaMayoristas;
    }

    public static ArrayList<Dueno> getListaDuenos() {
         return listaDuenos;
    }

    public  static ArrayList<Puesto> getListaPuesto() {
        return listaPuesto;
    }
    
    public static void agregarMayorista(String nombre, String rut, String direccion) {
        if (mayoristaUnico(rut)) {
            System.out.println("ya existe ese mayorista");
        } else {
            Mayorista unMayorista = new Mayorista(rut, nombre, direccion);
            Sistema.getListaMayoristas().add(unMayorista);
            System.out.println("se agrega mayorista");
        }
        for (Mayorista mayorista : listaMayoristas) {
            System.out.println(mayorista.getNombre());
        }
    }
    
    public static void agregarPuesto(String identificacion,String dueno, String ubicacion, int empleados){
        if(identificacionUnico(identificacion)){
            System.out.println("Ya existe un puesto con esa identificacion");
        }else{
            Puesto unpuesto = new Puesto(identificacion, dueno, ubicacion, empleados);
            Sistema.getListaPuesto().add(unpuesto);
        }
    
    }
    
    public static void agregarDueno(String nombre, int edad, int experiencia){
        if(nombreDueñoUnico(nombre)){
            System.out.println("ya existe ese nombre");
        }else{
            Dueno unDueño = new Dueno(nombre, edad, experiencia);
            Sistema.getListaDuenos().add(unDueño);
            System.out.println("se agrego Dueño");
        }
        for(Dueno unDueño : listaDuenos){
            System.out.println(unDueño.getNombre());
        }
    
    
    }

    public static Boolean mayoristaUnico(String rut) {
        Boolean existe = false;
        for (Mayorista mayorista : listaMayoristas) {
            if (mayorista.getRut().contains(rut)) {
                existe = true;
                System.out.println("ya hay un mayorista con ese rut");
            }
        }
        return existe;
    }
    
    public static Boolean identificacionUnico(String identificacion){
        Boolean existe= false;
        for(Puesto puesto:listaPuesto){
            if(puesto.getIdentificacion().equalsIgnoreCase(identificacion)){
                existe=true;
                System.out.println("Ya hay un puesto con esa identificacion");
            
            }
        }
     return existe;
    }
    
    public static Boolean nombreDueñoUnico(String nombre){
        Boolean existe= false;
        for(Dueno Dueños:listaDuenos){
            if(Dueños.getNombre().contains(nombre)){
                existe=true;
                System.out.println("Ya hay un Dueño con ese nombre");
            }
        }
        return existe;
    }

    public static void agregarItemAMayorista(String nombreMayorista, String nombre, String descripcion, String tipo, String formaVenta, String imagen) {
        
        
        Item unItem= new Item(nombre,descripcion,tipo,formaVenta,imagen);

        for (int i = 0; i < Sistema.getListaMayoristas().size(); i++) {
            if (Sistema.getListaMayoristas().get(i).getNombre().equals(nombreMayorista)) {
                        if(Sistema.getListaMayoristas().get(i).itemUnico(nombre)){
                                       Sistema.getListaMayoristas().get(i).getListaItems().add(unItem);
                                       System.out.println("item agregado");
                        }else{
                            System.out.println("ese item ya existe en este mayorista");
                        }
            }
        }

    }

    public void agregarPuesto(Puesto unPuesto) {
        this.getListaPuesto().add(unPuesto);
    }

    public static void altaItem(String nombre, String descripcion, String tipo, String formaVenta, String imagen) {

        System.out.println("se agrega");

    }

}

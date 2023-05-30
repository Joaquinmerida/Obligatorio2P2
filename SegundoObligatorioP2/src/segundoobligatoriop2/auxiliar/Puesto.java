package segundoobligatoriop2.auxiliar;

import java.util.ArrayList;

public class Puesto {

    private String identificacion;
    private Object dueño;
    private String ubicacion;
    private int cantidadEmpleados;
    private ArrayList<Puesto> puesto; 
    private ArrayList stock;

    public Puesto(String identificacion, Object dueño, String ubicacion, int cantidadEmpleados) {
        this.identificacion = identificacion;
        this.dueño = dueño;
        this.ubicacion = ubicacion;
        this.cantidadEmpleados = cantidadEmpleados;
        this.stock = new ArrayList<Item>();
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Object getDueño() {
        return dueño;
    }

    public void setDueño(Object dueño) {
        this.dueño = dueño;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void setCantidadEmpleados(int cantidadEmpleados) {
        this.cantidadEmpleados = cantidadEmpleados;
    }

    public Object getStock() {
        return stock;
    }

    public void setStock(ArrayList stock) {
        this.stock = stock;
    }

}


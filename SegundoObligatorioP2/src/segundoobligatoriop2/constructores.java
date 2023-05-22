
import java.util.*;

public class Item {
    private String nombre;
    private String descripcion;
    private String tipo;
    private String formaVenta;
    private String imagen;

    public Item(String nombre, String descripcion, String tipo, String formaVenta, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.formaVenta = formaVenta;
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFormaVenta(String formaVenta) {
        this.formaVenta = formaVenta;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFormaVenta() {
        return formaVenta;
    }

    public String getImagen() {
        return imagen;
    }

}

public class Dueño {
    private String nombre;
    private int edad;
    private int añosExperiencia;

    public Dueño(String nombre, int Edad, int añosExperiencia) {
        this.nombre = nombre;
        this.edad = edad;
        this.añosExperiencia = añosExperiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }
}

public class Puesto {
    private String identificacion;
    private Object dueño;
    private String ubicacion;
    private int cantidadEmpleados;
    private Object stock;

    public Puesto(String identificacion, Object dueño, String ubicacion, int cantidadEmpleados, array stock) {
        this.identificacion = identificacion;
        this.dueño = dueño;
        this.ubicacion = ubicacion;
        this.cantidadEmpleados = cantidadEmpleados;
        this.stock = stock;
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

    public void setStock(Object stock) {
        this.stock = stock;
    }

}

public class Mayorista {
    private String rut;
    private String nombre;
    private String direccion;

    // falta la lista de productos que es array
    public Mayorista(String rut, String nombre, String direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
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

}
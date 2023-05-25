package segundoobligatoriop2.auxiliar;

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
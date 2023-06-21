package segundoobligatoriop2.auxiliar;

/*
      ---------------------------------------------------------
    |                    Sistema desarrollado por                               |
  |    Joaquin Merida 253076 y Juan Manuel Mera  273527 |
 ---------------------------------------------------------
*/                           

public class Item {

    private String nombre;
    private String descripcion;
    private String tipo;
    private String formaVenta;
    private String imagen;
    private double cantidad;

    public Item(String nombre, String descripcion, String tipo, String formaVenta, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.formaVenta = formaVenta;
        this.imagen = imagen;
        this.cantidad=0;
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
    
    public void setCantidad(double cantidad){
    this.cantidad = cantidad;
    }
    
    public void sumarCantidad(double cantidad) {
    this.cantidad += cantidad;
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
    
    public double getCantidad(){
    return cantidad;
    }

}

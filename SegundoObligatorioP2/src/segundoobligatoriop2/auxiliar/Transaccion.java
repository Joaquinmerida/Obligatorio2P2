package segundoobligatoriop2.auxiliar;

/*
      ---------------------------------------------------------
    |                    Sistema desarrollado por                               |
  |    Joaquin Merida 253076 y Juan Manuel Mera  273527 |
 ---------------------------------------------------------
*/                           
public class Transaccion {

    private int numeroTransaccion;
    private String vendedor;
    private String comprador;
    private Item itemVenta;
    private int precio;
    private double cantidad;

    public Transaccion(int numeroTransaccion, String vendedor, String comprador, Item itemsVenta, int precio, double cantidad) {
        this.numeroTransaccion = numeroTransaccion;
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.itemVenta = itemsVenta;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getNumeroTransaccion(){
    return numeroTransaccion;
    }
    
    public String getVendedor() {
        return vendedor;
    }

    public String getComprador() {
        return comprador;
    }

    public int getPrecio() {
        return precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public Item getItemVenta() {
        return itemVenta;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public void setComprador(String comprador) {
        this.vendedor = comprador;
    }

    public void setItem(Item unItem) {
        this.itemVenta = unItem;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

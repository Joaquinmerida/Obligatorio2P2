/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segundoobligatoriop2.auxiliar;

import java.util.ArrayList;

public class Transaccion {

    private String rutVendedor;
    private String comprador;
    private Item itemVenta;
    private int precio;
    private int cantidad;

    public Transaccion(String rutVendedor, String comprador, Item itemsVenta, int precio, int cantidad) {
        this.rutVendedor = rutVendedor;
        this.comprador = comprador;
        this.itemVenta = itemsVenta;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getRutVendedor() {
        return rutVendedor;
    }

    public String getComprador() {
        return comprador;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Item getItemsVenta() {
        return itemVenta;
    }

    public void setVendedor(String vendedor) {
        this.rutVendedor = vendedor;
    }

    public void setComprador(String comprador) {
        this.rutVendedor = comprador;
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

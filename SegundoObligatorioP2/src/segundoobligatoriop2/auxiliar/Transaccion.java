/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segundoobligatoriop2.auxiliar;

import java.util.ArrayList;

public class Transaccion {

    private String vendedor;
    private String comprador;
    private ArrayList<Item> itemsVenta;
    private int precio;
    private int cantidad;

    public Transaccion(String vendedor, String comprador, ArrayList itemsVenta, int precio, int cantidad) {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.itemsVenta = itemsVenta;
        this.precio = precio;
        this.cantidad = cantidad;
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

    public int getCantidad() {
        return cantidad;
    }

    public ArrayList<Item> getItemsVenta() {
        return itemsVenta;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public void setComprador(String comprador) {
        this.vendedor = comprador;
    }

    public void agregarItem(Item unItem) {
        this.getItemsVenta().add(unItem);
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

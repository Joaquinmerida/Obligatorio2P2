/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segundoobligatoriop2.auxiliar;

import java.util.ArrayList;

class Transaccion {

    private String vendedor;
    private String comprador;
    private ArrayList<Item> itemsVenta;

    public Transaccion(String vendedor, String comprador, ArrayList itemsVenta) {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.itemsVenta = itemsVenta;
    }

    public String getVendedor() {
        return vendedor;
    }

    public String getComprador() {
        return comprador;
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

}

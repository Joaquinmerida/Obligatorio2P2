package segundoobligatoriop2.auxiliar;

/*
      ---------------------------------------------------------
    |                    Sistema desarrollado por                               |
  |    Joaquin Merida 253076 y Juan Manuel Mera  273527 |
 ---------------------------------------------------------
*/                           
import java.util.ArrayList;
import java.util.Comparator;

public class Puesto {
    private String identificacion;
    private Dueno dueno;
    private String ubicacion;
    private int cantidadEmpleados;
    private ArrayList<Item> stock;

    public Puesto(String identificacion, Dueno dueno, String ubicacion, int cantidadEmpleados) {
        this.identificacion = identificacion;
        this.dueno = dueno;
        this.ubicacion = ubicacion;
        this.cantidadEmpleados = cantidadEmpleados;
        this.stock = new ArrayList<>();
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueño) {
        this.dueno = dueño;
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

    public ArrayList<Item> getStock() {
        return stock;
    }

    public void añadirItem(Item unItem) {
        this.stock.add(unItem);
    }

    public void setStock(ArrayList<Item> stock) {
        this.stock.clear();
        this.stock.addAll(stock); 
    }

    public void ordenarStock() {
        stock.sort(new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                boolean esFruta1 = item1.getTipo().equals("Fruta");
                boolean esFruta2 = item2.getTipo().equals("Fruta");
                if (esFruta1 == esFruta2) {
                    return item1.getNombre().compareTo(item2.getNombre());
                }
                if (esFruta1) {
                    return -1;
                }
                return 1;
            }

        });
    }
}


package segundoobligatoriop2.auxiliar;

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

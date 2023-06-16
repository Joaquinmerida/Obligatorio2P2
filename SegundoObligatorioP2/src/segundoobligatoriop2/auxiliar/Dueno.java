package segundoobligatoriop2.auxiliar;


public class Dueno {

    private String nombre;
    private int edad;
    private int aExperiencia;

    public Dueno(String nombre, int edad, int aExperiencia) {
        this.nombre = nombre;
        this.edad = edad;
        this.aExperiencia = aExperiencia;
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

    public int getAExperiencia() {
        return aExperiencia;
    }

    public void setAExperiencia(int aExperiencia) {
        this.aExperiencia = aExperiencia;
    }
    
}

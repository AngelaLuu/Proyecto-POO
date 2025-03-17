// Asesor.java
public class Asesor {
    private String nombre;
    private int ventasRealizadas;

    public Asesor(String nombre) {
        this.nombre = nombre;
        this.ventasRealizadas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void realizarVenta() {
        ventasRealizadas++;
    }
}
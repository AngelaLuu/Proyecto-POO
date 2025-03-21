public class Asesor {
    private String nombre;
    private int ventasRealizadas;

    // Constructor vacío (para el CRUD)
    public Asesor() {}

    // Constructor con nombre
    public Asesor(String nombre) {
        setNombre(nombre);
        this.ventasRealizadas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del asesor no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public int getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void realizarVenta() {
        ventasRealizadas++;
    }

    // Método para mostrar información del asesor
    @Override
    public String toString() {
        return "Asesor: " + nombre + " | Ventas realizadas: " + ventasRealizadas;
    }
}

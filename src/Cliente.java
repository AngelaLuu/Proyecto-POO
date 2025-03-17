// Cliente.java
public class Cliente {
    private String nombre;
    private String telefono;
    private String vehiculoActual;
    private Vehiculo vehiculoDeseado;

    public Cliente(String nombre, String telefono, String vehiculoActual) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.vehiculoActual = vehiculoActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getVehiculoActual() {
        return vehiculoActual;
    }

    public void setVehiculoActual(String vehiculoActual) {
        this.vehiculoActual = vehiculoActual;
    }

    public Vehiculo getVehiculoDeseado() {
        return vehiculoDeseado;
    }

    public void setVehiculoDeseado(Vehiculo vehiculoDeseado) {
        this.vehiculoDeseado = vehiculoDeseado;
    }
}
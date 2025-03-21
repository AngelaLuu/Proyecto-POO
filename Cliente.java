public class Cliente {
    private String nombre;
    private String telefono;
    private String vehiculoActual;
    private Vehiculo vehiculoDeseado;

    // Constructor vacío (para el CRUD)
    public Cliente() {}

    // Constructor con todos los atributos
    public Cliente(String nombre, String telefono, String vehiculoActual) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.vehiculoActual = vehiculoActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío.");
        }
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

    // Método para mostrar información del cliente
    @Override
    public String toString() {
        return "Cliente: " + nombre + " | Teléfono: " + telefono +
               " | Vehículo Actual: " + vehiculoActual +
               (vehiculoDeseado != null ? " | Vehículo Deseado: " + vehiculoDeseado.getModelo() : "");
    }
}

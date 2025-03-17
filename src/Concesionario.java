// Concesionario.java
import java.util.ArrayList;
import java.util.List;

public class Concesionario {
    private List<Vehiculo> vehiculos; // Lista de vehículos disponibles
    private List<Asesor> asesores; // Lista de asesores de ventas

    // Constructor que inicializa las listas
    public Concesionario() {
        vehiculos = new ArrayList<>();
        asesores = new ArrayList<>();
    }

    // Método para agregar un vehículo a la lista
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    // Método para agregar un asesor a la lista
    public void agregarAsesor(Asesor asesor) {
        asesores.add(asesor);
    }

    // Método para obtener la lista de vehículos
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    // Método para obtener la lista de asesores
    public List<Asesor> getAsesores() {
        return asesores;
    }

    // Método para mostrar todos los vehículos disponibles
    public void mostrarVehiculos() {
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.mostrarDetalles());
        }
    }

    // Setter para la lista de vehículos (opcional)
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    // Setter para la lista de asesores (opcional)
    public void setAsesores(List<Asesor> asesores) {
        this.asesores = asesores;
    }
}
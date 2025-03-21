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
        if (vehiculo != null) {
            vehiculos.add(vehiculo);
        } else {
            System.out.println("No se puede agregar un vehículo nulo.");
        }
    }

    // Método para agregar un asesor a la lista
    public void agregarAsesor(Asesor asesor) {
        if (asesor != null) {
            asesores.add(asesor);
        } else {
            System.out.println("No se puede agregar un asesor nulo.");
        }
    }

    // Método para obtener la lista de vehículos
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    // Método para obtener la lista de asesores
    public List<Asesor> getAsesores() {
        return asesores;
    }

    // Método para eliminar un vehículo por modelo
    public boolean eliminarVehiculo(String modelo) {
        return vehiculos.removeIf(v -> v.getModelo().equalsIgnoreCase(modelo));
    }

    // Método para eliminar un asesor por nombre
    public boolean eliminarAsesor(String nombre) {
        return asesores.removeIf(a -> a.getNombre().equalsIgnoreCase(nombre));
    }

    // Método para buscar un vehículo por modelo
    public Vehiculo buscarVehiculo(String modelo) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getModelo().equalsIgnoreCase(modelo)) {
                return vehiculo;
            }
        }
        return null;
    }

    // Método para buscar un asesor por nombre
    public Asesor buscarAsesor(String nombre) {
        for (Asesor asesor : asesores) {
            if (asesor.getNombre().equalsIgnoreCase(nombre)) {
                return asesor;
            }
        }
        return null;
    }

    // Método para mostrar todos los vehículos disponibles
    public void mostrarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos disponibles.");
        } else {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo.mostrarDetalles());
            }
        }
    }

    // Método para mostrar todos los asesores disponibles
    public void mostrarAsesores() {
        if (asesores.isEmpty()) {
            System.out.println("No hay asesores registrados.");
        } else {
            for (Asesor asesor : asesores) {
                System.out.println(asesor);
            }
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

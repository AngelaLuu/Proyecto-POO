import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Concesionario concesionario = new Concesionario();

        // Agregar asesores al concesionario
        System.out.print("Ingrese el número de asesores: ");
        int numAsesores = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        for (int i = 0; i < numAsesores; i++) {
            System.out.print("Ingrese el nombre del asesor " + (i + 1) + ": ");
            String nombreAsesor = scanner.nextLine();
            Asesor asesor = new Asesor(nombreAsesor);
            concesionario.agregarAsesor(asesor);
        }

        // Agregar vehículos al concesionario
        System.out.print("Ingrese el número de vehículos: ");
        int numVehiculos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        for (int i = 0; i < numVehiculos; i++) {
            System.out.print("Ingrese el tipo de vehículo (1: Automóvil, 2: Camioneta): ");
            int tipoVehiculo = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("Ingrese la marca: ");
            String marca = scanner.nextLine();
            System.out.print("Ingrese el modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Ingrese el precio: ");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer

            if (tipoVehiculo == 1) {
                System.out.print("Ingrese el número de puertas: ");
                int puertas = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                concesionario.agregarVehiculo(new Automovil(marca, modelo, precio, puertas));
            } else if (tipoVehiculo == 2) {
                System.out.print("¿Tiene tracción 4x4? (1: Sí, 2: No): ");
                int traccionInput = scanner.nextInt();
                boolean traccion4x4 = (traccionInput == 1);
                scanner.nextLine(); // Limpiar el buffer
                concesionario.agregarVehiculo(new Camioneta(marca, modelo, precio, traccion4x4));
            } else {
                System.out.println("Tipo de vehículo no válido.");
            }
        }

        // Mostrar vehículos disponibles
        System.out.println("\nVehículos disponibles:");
        List<Vehiculo> vehiculos = concesionario.getVehiculos();
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo());
        }

        // Crear un cliente
        System.out.print("\nIngrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese el teléfono del cliente: ");
        String telefonoCliente = scanner.nextLine();
        System.out.print("Ingrese el vehículo actual del cliente: ");
        String vehiculoActual = scanner.nextLine();

        Cliente cliente = new Cliente(nombreCliente, telefonoCliente, vehiculoActual);

        // Seleccionar vehículo deseado por nombre
        System.out.print("Seleccione el modelo de vehículo deseado: ");
        String modeloDeseado = scanner.nextLine().trim(); // Eliminar espacios en blanco al inicio y al final
        Vehiculo vehiculoDeseado = null;

        for (Vehiculo vehiculo : vehiculos) {
            String identificadorVehiculo = vehiculo.getMarca().trim() + " " + vehiculo.getModelo().trim();
            if (identificadorVehiculo.equalsIgnoreCase(modeloDeseado.trim())) {
                vehiculoDeseado = vehiculo;
                break;
            }
        }

        if (vehiculoDeseado == null) {
            System.out.println("Vehículo no encontrado.");
            return;
        }

        cliente.setVehiculoDeseado(vehiculoDeseado);

        // Mostrar asesores disponibles antes de la selección
        System.out.println("\nAsesores disponibles:");
        for (Asesor asesor : concesionario.getAsesores()) {
            System.out.println("- " + asesor.getNombre());
        }

        // Seleccionar asesor por nombre
        System.out.print("Seleccione el asesor que atenderá al cliente: ");
        String nombreAsesorSeleccionado = scanner.nextLine();
        Asesor asesorSeleccionado = null;

        for (Asesor asesor : concesionario.getAsesores()) {
            if (asesor.getNombre().equalsIgnoreCase(nombreAsesorSeleccionado)) {
                asesorSeleccionado = asesor;
                break;
            }
        }

        if (asesorSeleccionado == null) {
            System.out.println("Asesor no encontrado.");
            return;
        }

        asesorSeleccionado.realizarVenta();

        // Generar factura
        Factura factura = new Factura(cliente, vehiculoDeseado);
        factura.mostrarFactura();

        scanner.close();
    }
}

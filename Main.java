import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Concesionario concesionario = new Concesionario();

        while (true) {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Comprar un vehículo");
            System.out.println("2. Acceder a CRUD (Administradores)");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    iniciarCompra(concesionario, scanner);
                    break;
                case 2:
                    if (verificarCredenciales(scanner)) {
                        menuCRUD(concesionario, scanner);
                    } else {
                        System.out.println("Acceso denegado.");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static boolean verificarCredenciales(Scanner scanner) {
        System.out.print("Ingrese usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String contraseña = scanner.nextLine();
        return Administrador.validarAcceso(usuario, contraseña);
    }

    private static void iniciarCompra(Concesionario concesionario, Scanner scanner) {
        System.out.println("\n--- Compra de Vehículo ---");

        // Agregar asesores al concesionario
        System.out.print("Ingrese el número de asesores: ");
        int numAsesores = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numAsesores; i++) {
            System.out.print("Ingrese el nombre del asesor " + (i + 1) + ": ");
            String nombreAsesor = scanner.nextLine();
            concesionario.agregarAsesor(new Asesor(nombreAsesor));
        }

        // Agregar vehículos
        System.out.print("Ingrese el número de vehículos: ");
        int numVehiculos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numVehiculos; i++) {
            System.out.print("Ingrese el tipo de vehículo (1: Automóvil, 2: Camioneta): ");
            int tipoVehiculo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ingrese la marca: ");
            String marca = scanner.nextLine();
            System.out.print("Ingrese el modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Ingrese el precio: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();

            if (tipoVehiculo == 1) {
                System.out.print("Ingrese el número de puertas: ");
                int puertas = scanner.nextInt();
                scanner.nextLine();
                concesionario.agregarVehiculo(new Automovil(marca, modelo, precio, puertas));
            } else if (tipoVehiculo == 2) {
                System.out.print("¿Tiene tracción 4x4? (1: Sí, 2: No): ");
                boolean traccion4x4 = scanner.nextInt() == 1;
                scanner.nextLine();
                concesionario.agregarVehiculo(new Camioneta(marca, modelo, precio, traccion4x4));
            } else {
                System.out.println("Tipo de vehículo no válido.");
            }
        }

        // Mostrar vehículos disponibles
        System.out.println("\nVehículos disponibles:");
        for (Vehiculo vehiculo : concesionario.getVehiculos()) {
            System.out.println(vehiculo.mostrarDetalles());
        }

        // Crear cliente
        System.out.print("\nIngrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese el teléfono del cliente: ");
        String telefonoCliente = scanner.nextLine();
        System.out.print("Ingrese el vehículo actual del cliente: ");
        String vehiculoActual = scanner.nextLine();
        Cliente cliente = new Cliente(nombreCliente, telefonoCliente, vehiculoActual);

        // Seleccionar vehículo deseado
        System.out.print("Seleccione el modelo de vehículo deseado: ");
        String modeloDeseado = scanner.nextLine().trim();
        Vehiculo vehiculoDeseado = null;

        for (Vehiculo vehiculo : concesionario.getVehiculos()) {
            if ((vehiculo.getMarca() + " " + vehiculo.getModelo()).equalsIgnoreCase(modeloDeseado)) {
                vehiculoDeseado = vehiculo;
                break;
            }
        }

        if (vehiculoDeseado == null) {
            System.out.println("Vehículo no encontrado.");
            return;
        }

        cliente.setVehiculoDeseado(vehiculoDeseado);

        // Mostrar asesores disponibles
        System.out.println("\nAsesores disponibles:");
        for (Asesor asesor : concesionario.getAsesores()) {
            System.out.println("- " + asesor.getNombre());
        }

        // Seleccionar asesor
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
    }

    private static void menuCRUD(Concesionario concesionario, Scanner scanner) {
        while (true) {
            System.out.println("\n=== Menú CRUD ===");
            System.out.println("1. Agregar vehículo");
            System.out.println("2. Eliminar vehículo");
            System.out.println("3. Mostrar vehículos");
            System.out.println("4. Salir del CRUD");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Tipo de vehículo (1: Automóvil, 2: Camioneta): ");
                    int tipoVehiculo = scanner.nextInt();
                    scanner.nextLine();

                    Vehiculo nuevoVehiculo;
                    if (tipoVehiculo == 1) {
                        System.out.print("Ingrese número de puertas: ");
                        int puertas = scanner.nextInt();
                        scanner.nextLine();
                        nuevoVehiculo = new Automovil(marca, modelo, precio, puertas);
                    } else {
                        System.out.print("¿Tiene tracción 4x4? (1: Sí, 2: No): ");
                        boolean traccion4x4 = scanner.nextInt() == 1;
                        scanner.nextLine();
                        nuevoVehiculo = new Camioneta(marca, modelo, precio, traccion4x4);
                    }

                    concesionario.agregarVehiculo(nuevoVehiculo);
                    System.out.println("Vehículo agregado correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese modelo del vehículo a eliminar: ");
                    String modeloEliminar = scanner.nextLine();
                    List<Vehiculo> vehiculos = concesionario.getVehiculos();
                    Vehiculo vehiculoEliminar = null;

                    for (Vehiculo v : vehiculos) {
                        if (v.getModelo().equalsIgnoreCase(modeloEliminar)) {
                            vehiculoEliminar = v;
                            break;
                        }
                    }

                    if (vehiculoEliminar != null) {
                        vehiculos.remove(vehiculoEliminar);
                        System.out.println("Vehículo eliminado correctamente.");
                    } else {
                        System.out.println("Vehículo no encontrado.");
                    }
                    break;

                case 3:
                    concesionario.mostrarVehiculos();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
            }

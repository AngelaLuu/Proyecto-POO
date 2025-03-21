import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Concesionario concesionario = new Concesionario();
        boolean ejecutando = true;

        while (ejecutando) {
            System.out.println("\n====== MENÚ PRINCIPAL ======");
            System.out.println("1. Comprar un Vehículo");
            System.out.println("2. CRUD (Administración)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    flujoCompra(scanner, concesionario);
                    break;
                case 2:
                    menuCRUD(scanner, concesionario);
                    break;
                case 0:
                    ejecutando = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
        scanner.close();
    }

    public static void flujoCompra(Scanner scanner, Concesionario concesionario) {
        // Aquí va el flujo de compra original
        System.out.println("\nIniciando proceso de compra...");
        // (Lógica de agregar asesores, vehículos, cliente y generar factura)
    }

    public static void menuCRUD(Scanner scanner, Concesionario concesionario) {
        boolean crudActivo = true;

        while (crudActivo) {
            System.out.println("\n====== CRUD (Administración) ======");
            System.out.println("1. CRUD Vehículos");
            System.out.println("2. CRUD Asesores");
            System.out.println("3. CRUD Clientes");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    crudVehiculos(scanner, concesionario);
                    break;
                case 2:
                    crudAsesores(scanner, concesionario);
                    break;
                case 3:
                    crudClientes(scanner, concesionario);
                    break;
                case 0:
                    crudActivo = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void crudVehiculos(Scanner scanner, Concesionario concesionario) {
        boolean activo = true;
        while (activo) {
            System.out.println("\n====== CRUD VEHÍCULOS ======");
            System.out.println("1. Agregar Vehículo");
            System.out.println("2. Listar Vehículos");
            System.out.println("3. Actualizar Vehículo");
            System.out.println("4. Eliminar Vehículo");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese el modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese el precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar buffer

                    concesionario.agregarVehiculo(new Vehiculo(marca, modelo, precio));
                    System.out.println("Vehículo agregado.");
                    break;
                case 2:
                    System.out.println("\nVehículos disponibles:");
                    for (Vehiculo v : concesionario.getVehiculos()) {
                        System.out.println("- " + v.getMarca() + " " + v.getModelo() + " - $" + v.getPrecio());
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el modelo del vehículo a actualizar: ");
                    String modeloActualizar = scanner.nextLine();
                    Vehiculo vehiculoActualizar = concesionario.buscarVehiculo(modeloActualizar);
                    if (vehiculoActualizar != null) {
                        System.out.print("Nuevo precio: ");
                        double nuevoPrecio = scanner.nextDouble();
                        scanner.nextLine();
                        vehiculoActualizar.setPrecio(nuevoPrecio);
                        System.out.println("Vehículo actualizado.");
                    } else {
                        System.out.println("Vehículo no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el modelo del vehículo a eliminar: ");
                    String modeloEliminar = scanner.nextLine();
                    concesionario.eliminarVehiculo(modeloEliminar);
                    System.out.println("Vehículo eliminado.");
                    break;
                case 0:
                    activo = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void crudAsesores(Scanner scanner, Concesionario concesionario) {
        System.out.println("\nCRUD de asesores en construcción...");
    }

    public static void crudClientes(Scanner scanner, Concesionario concesionario) {
        System.out.println("\nCRUD de clientes en construcción...");
    }
}

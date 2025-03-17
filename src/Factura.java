// Factura.java
public class Factura {
    private Cliente cliente;
    private Vehiculo vehiculo;
    private double total;

    public Factura(Cliente cliente, Vehiculo vehiculo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.total = vehiculo.getPrecio();
    }

    public Cliente getCliente() { 
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        this.total = vehiculo.getPrecio(); // Actualiza el total si se cambia el vehículo
    }

    public double getTotal() {
        return total;
    }

    public void mostrarFactura() {
        System.out.println("Factura:");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Vehículo: " + vehiculo.mostrarDetalles());
        System.out.println("Total: " + total);
    }
}

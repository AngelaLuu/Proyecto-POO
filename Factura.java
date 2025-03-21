public class Factura {
    private Cliente cliente;
    private Vehiculo vehiculo;
    private double total;

    // Constructor
    public Factura(Cliente cliente, Vehiculo vehiculo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        calcularTotal();
    }

    // Getters y setters
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
        calcularTotal(); // Recalcula el total al cambiar el vehículo
    }

    public double getTotal() {
        return total;
    }

    // Método para calcular el total (útil si se agregan descuentos/impuestos)
    private void calcularTotal() {
        this.total = vehiculo.getPrecio();
    }

    // Método para mostrar la factura en consola
    public void mostrarFactura() {
        System.out.println("\n======= FACTURA =======");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Teléfono: " + cliente.getTelefono());
        System.out.println("Vehículo: " + vehiculo.mostrarDetalles());
        System.out.println("Total a pagar: $" + String.format("%.2f", total));
    }

    // Método toString() para impresión directa
    @Override
    public String toString() {
        return "Factura\nCliente: " + cliente.getNombre() +
               "\nVehículo: " + vehiculo.mostrarDetalles() +
               "\nTotal: $" + String.format("%.2f", total);
    }
}

// Camioneta.java
public class Camioneta extends Vehiculo {
    private boolean traccion4x4;

    public Camioneta(String marca, String modelo, double precio, boolean traccion4x4) {
        super(marca, modelo, precio);
        this.traccion4x4 = traccion4x4;
    }

    public boolean isTraccion4x4() {
        return traccion4x4;
    }

    public void setTraccion4x4(boolean traccion4x4) {
        this.traccion4x4 = traccion4x4;
    }

    @Override
    public String mostrarDetalles() {
        return "Camioneta: " + getMarca() + " " + getModelo() + ", Precio: " + getPrecio() + ", 4x4: " + (traccion4x4 ? "Sí" : "No");
    }
}
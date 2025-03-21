public class Automovil extends Vehiculo {
    private int puertas;

    // Constructor vacío (para CRUD)
    public Automovil() {}

    // Constructor con parámetros
    public Automovil(String marca, String modelo, double precio, int puertas) {
        super(marca, modelo, precio);
        setPuertas(puertas); // Usamos el setter para validar
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        if (puertas <= 0) {
            throw new IllegalArgumentException("El número de puertas debe ser mayor a 0.");
        }
        this.puertas = puertas;
    }

    @Override
    public String mostrarDetalles() {
        return "Automóvil: " + getMarca() + " " + getModelo() + ", Precio: $" + getPrecio() + ", Puertas: " + puertas;
    }

    @Override
    public String toString() {
        return mostrarDetalles();
    }
}

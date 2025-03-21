public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private double precio;

    // Constructor
    public Vehiculo(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        setPrecio(precio); // Se usa el setter para validar el precio
    }

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            System.out.println("El precio no puede ser negativo. Se mantiene el valor anterior.");
        }
    }

    // Método abstracto para mostrar detalles específicos de cada vehículo
    public abstract String mostrarDetalles();

    // Método toString() para facilitar la impresión del objeto
    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Precio: $" + String.format("%.2f", precio);
    }
}

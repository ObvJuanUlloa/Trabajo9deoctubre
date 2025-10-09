public class LibroImpreso extends Libro {
    private double peso;
    private int numeroEjemplares;
    public void registrar(String titulo, String autor, double precio, double peso, int numeroEjemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.peso = peso;
        this.numeroEjemplares = numeroEjemplares;
        this.cantidadEjemplares = numeroEjemplares;
    }
    @Override
    public void mostrarLibro() {
        super.mostrarLibro();
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Número de ejemplares: " + numeroEjemplares);
    }
    public void prestar(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor que 0.");
        } else if (cantidad > cantidadEjemplares) {
            System.out.println("No hay suficientes ejemplares disponibles.");
        } else {
            cantidadEjemplares -= cantidad;
            System.out.println("Se han prestado " + cantidad + " ejemplares.");
        }
    }
    public void devolver(int cantidad) {
        if (cantidad > 2) {
            System.out.println("No se pueden devolver más de 2 libros a la vez.");
        } else {
            cantidadEjemplares += cantidad;
            System.out.println("Se han devuelto " + cantidad + " ejemplares.");
        }
    }
}
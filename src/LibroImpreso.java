public class LibroImpreso extends Libro {
    double peso;
    public LibroImpreso(String codigo, String titulo, String autor, double precio, int cantidad, double peso) {
        super(codigo, titulo, autor, precio, cantidad);
        this.peso = peso;
    }
    public void mostrarLibro() {
        super.mostrarLibro();
        System.out.println("Peso: " + peso + " gr");
    }
    public void prestar() {
        if (cantidad <= 0) {
            System.out.println("No hay ejemplares disponibles para préstamo.");
        } else {
            cantidad--;
            System.out.println("Libro prestado correctamente.");
        }
    }
    public void devolver() {
        if (cantidad >= 2) {
            System.out.println("No se pueden devolver más de 2 libros.");
        } else {
            cantidad++;
            System.out.println("Libro devuelto correctamente.");
        }
    }
}

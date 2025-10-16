public class LibroDigital extends Libro {
    double tamano;
    boolean disponible;
    public LibroDigital(String codigo, String titulo, String autor, double precio, int cantidad, double tamano, boolean disponible) {
        super(codigo, titulo, autor, precio, cantidad);
        this.tamano = tamano;
        this.disponible = disponible;
    }
    public void mostrarLibro() {
        super.mostrarLibro();
        System.out.println("Tamaño del archivo: " + tamano + " MB");
        System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
    }
    public void prestar() {
        if (!disponible) {
            System.out.println("El libro no está disponible para préstamo.");
        } else if (cantidad <= 0) {
            System.out.println("No hay copias disponibles para préstamo.");
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

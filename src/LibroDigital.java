public class LibroDigital extends Libro {
    private double tamanoMB;
    private boolean disponible;
    public void registrar(String titulo, String autor, double precio, double tamanoMB, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.tamanoMB = tamanoMB;
        this.disponible = disponible;
        this.cantidadEjemplares = 1000000;
    }
    @Override
    public void mostrarLibro() {
        super.mostrarLibro();
        System.out.println("Tamaño (MB): " + tamanoMB);
        System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
    }
    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println("Libro digital prestado correctamente.");
        } else {
            System.out.println(" No se puede prestar, el libro no está disponible.");
        }
    }
    public void devolver() {
        if (!disponible) {
            disponible = true;
            System.out.println("Libro digital devuelto correctamente.");
        } else {
            System.out.println("No se puede devolver, el libro ya estaba disponible.");
        }
    }
}

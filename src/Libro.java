public class Libro {
    String codigo;
    String titulo;
    String autor;
    double precio;
    int cantidad;
    public Libro(String codigo, String titulo, String autor, double precio, int cantidad) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public void mostrarLibro() {
        System.out.println("Código: " + codigo);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad disponible: " + cantidad);
    }
}
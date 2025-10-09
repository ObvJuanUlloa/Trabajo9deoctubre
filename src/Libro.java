public class Libro {
    protected String titulo;
    protected String autor;
    protected double precio;
    protected int cantidadEjemplares;
    public void mostrarLibro() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad de ejemplares: " + cantidadEjemplares);
    }
}

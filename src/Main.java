import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Libro> libros = new ArrayList<>();
        int opcion = 0;
        int contadorDigital = 1;
        int contadorImpreso = 1;
        while (opcion != 4) {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar todos los libros");
            System.out.println("3. Buscar libro");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            if (opcion == 1) {
                System.out.println("1. Libro impreso");
                System.out.println("2. Libro digital");
                System.out.print("Seleccione tipo de libro: ");
                int tipo = sc.nextInt();
                sc.nextLine();
                System.out.print("Título: ");
                String titulo = sc.nextLine();
                System.out.print("Autor: ");
                String autor = sc.nextLine();
                System.out.print("Precio: ");
                double precio = sc.nextDouble();
                while (precio < 0) {
                    System.out.println("No se aceptan valores que sean negativos.");
                    precio = sc.nextDouble();
                }
                System.out.print("Cantidad disponible: ");
                int cantidad = sc.nextInt();
                while (cantidad < 0) {
                    System.out.println("No se aceptan valores que sean negativos.");
                    cantidad = sc.nextInt();
                }
                if (tipo == 1) {
                    String codigo = "LF" + contadorImpreso;
                    contadorImpreso++;
                    System.out.print("Peso del libro (gr): ");
                    double peso = sc.nextDouble();
                    while (peso < 0) {
                        System.out.println("No se aceptan valores negativos.");
                        peso = sc.nextDouble();
                    }
                    libros.add(new LibroImpreso(codigo, titulo, autor, precio, cantidad, peso));
                    System.out.println("Libro impreso agregado con código " + codigo);
                } else if (tipo == 2) {
                    String codigo = "LD" + contadorDigital;
                    contadorDigital++;
                    System.out.print("Tamaño del archivo (MB): ");
                    double tamano = sc.nextDouble();
                    System.out.print("¿Está disponible? (true/false): ");
                    boolean disponible = sc.nextBoolean();
                    libros.add(new LibroDigital(codigo, titulo, autor, precio, cantidad, tamano, disponible));
                    System.out.println("Libro digital agregado con código " + codigo);
                }
            } else if (opcion == 2) {
                if (libros.isEmpty()) {
                    System.out.println("No hay libros registrados.");
                } else {
                    for (Libro libro : libros) {
                        libro.mostrarLibro();
                        System.out.println("");
                    }
                }
            } else if (opcion == 3) {
                System.out.println("1. Buscar por código");
                System.out.println("2. Buscar por título");
                System.out.print("Elija una opción: ");
                int tipoBusqueda = sc.nextInt();
                sc.nextLine();
                System.out.print("Ingrese el valor a buscar: ");
                String valor = sc.nextLine();
                boolean encontrado = false;
                for (Libro libro : libros) {
                    if ((tipoBusqueda == 1 && libro.codigo.equals(valor)) ||
                            (tipoBusqueda == 2 && libro.titulo.equals(valor))) {
                        libro.mostrarLibro();
                        encontrado = true;
                        System.out.println("\n1. Prestar libro");
                        System.out.println("2. Devolver libro");
                        System.out.println("3. Volver");
                        System.out.print("Elija una opción: ");
                        int accion = sc.nextInt();
                        if (accion == 1) {
                            if (libro instanceof LibroDigital)
                                ((LibroDigital) libro).prestar();
                            else
                                ((LibroImpreso) libro).prestar();
                        } else if (accion == 2) {
                            if (libro instanceof LibroDigital)
                                ((LibroDigital) libro).devolver();
                            else
                                ((LibroImpreso) libro).devolver();
                        }
                    }
                }
                if (!encontrado) {
                    System.out.println("Libro no encontrado.");
                }
            }
        }
        System.out.println("Programa finalizado.");
        sc.close();
    }
}
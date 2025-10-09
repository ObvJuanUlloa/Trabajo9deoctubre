import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibroDigital digital = new LibroDigital();
        LibroImpreso impreso = new LibroImpreso();
        boolean hayDigital = false;
        boolean hayImpreso = false;
        int opcion;
        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Registrar libro digital");
            System.out.println("2. Registrar libro impreso");
            System.out.println("3. Mostrar libros");
            System.out.println("4. Buscar libro por título");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String tituloD = sc.nextLine();
                    System.out.print("Autor: ");
                    String autorD = sc.nextLine();
                    System.out.print("Precio: ");
                    double precioD = sc.nextDouble();
                    System.out.print("Tamaño (MB): ");
                    double tamano = sc.nextDouble();
                    System.out.print("¿Disponible? (true/false): ");
                    boolean disp = sc.nextBoolean();
                    digital.registrar(tituloD, autorD, precioD, tamano, disp);
                    hayDigital = true;
                    System.out.println("Libro digital registrado.");
                    break;
                case 2:
                    System.out.print("Título: ");
                    String tituloI = sc.nextLine();
                    System.out.print("Autor: ");
                    String autorI = sc.nextLine();
                    System.out.print("Precio: ");
                    double precioI = sc.nextDouble();
                    System.out.print("Peso (gr): ");
                    double peso = sc.nextDouble();
                    System.out.print("Número de ejemplares: ");
                    int ejemplares = sc.nextInt();
                    impreso.registrar(tituloI, autorI, precioI, peso, ejemplares);
                    hayImpreso = true;
                    System.out.println("Libro impreso registrado.");
                    break;
                case 3:
                    System.out.println("\n LISTADO DE LIBROS ");
                    if (hayDigital) {
                        System.out.println("\n Libro digital:");
                        digital.mostrarLibro();
                    }
                    if (hayImpreso) {
                        System.out.println("\nLibro impreso:");
                        impreso.mostrarLibro();
                    }
                    if (!hayDigital && !hayImpreso) {
                        System.out.println("No hay libros registrados.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el título del libro a buscar: ");
                    String buscar = sc.nextLine();
                    boolean encontrado = false;
                    if (hayDigital && digital.titulo.equalsIgnoreCase(buscar)) {
                        encontrado = true;
                        System.out.println("\nLibro digital encontrado:");
                        digital.mostrarLibro();
                        int subop;
                        do {
                            System.out.println("\n---SUBMENU DIGITAL ---");
                            System.out.println("1. Prestar");
                            System.out.println("2. Devolver");
                            System.out.println("3. Volver al menú principal");
                            System.out.print("Elija una opción: ");
                            subop = sc.nextInt();
                            if (subop == 1) digital.prestar();
                            else if (subop == 2) digital.devolver();
                        } while (subop != 3);
                    }
                    if (hayImpreso && impreso.titulo.equalsIgnoreCase(buscar)) {
                        encontrado = true;
                        System.out.println("\nLibro impreso encontrado:");
                        impreso.mostrarLibro();
                        int subop;
                        do {
                            System.out.println("\nSUBMENÚ IMPRESO ");
                            System.out.println("1. Prestar");
                            System.out.println("2. Devolver");
                            System.out.println("3. Volver al menú principal");
                            System.out.print("Elija una opción: ");
                            subop = sc.nextInt();
                            if (subop == 1) {
                                System.out.print("Cantidad a prestar: ");
                                int cant = sc.nextInt();
                                impreso.prestar(cant);
                            } else if (subop == 2) {
                                System.out.print("Cantidad a devolver: ");
                                int cant = sc.nextInt();
                                impreso.devolver(cant);
                            }
                        } while (subop != 3);
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró ningún libro con ese título.");
                    }
                    break;
                case 5:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 5);
        sc.close();
    }
}

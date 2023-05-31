package biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase ejecutable del ejercicio 2
 *
 * @author pablo villaseñor
 */
public class BibliotecaApp {

    public static void main(String[] args) throws InterruptedException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String lectura;

        ArrayList<Publicacion> listaPubli = new ArrayList<Publicacion>();
        final int AnioPublicacion = 2018;
        Libro l1 = new Libro(5, 123, "Harry Potter", 2007);
        Libro l2 = new Libro(7, 456, "Los juegos del Hambre", 2016);
        Libro l3 = new Libro(1, 789, "Percy Jackson", 2016);
        Revista r1 = new Revista(987, "El pais", 2023, 02);
        Revista r2 = new Revista(654, "El ABC", 2021, 04);
        Revista r3 = new Revista(321, "El Diario", 2015, 03);

        listaPubli.add(l3);
        listaPubli.add(l1);
        listaPubli.add(l2);
        listaPubli.add(r1);
        listaPubli.add(r3);
        listaPubli.add(r2);

        

        //Mostramos la informacion de toda la lista
        for (int i = 0; i < listaPubli.size(); i++) {
            System.out.println("***********************");
            if (listaPubli.get(i) instanceof Libro) {
                System.out.println("    LIBRO ");
                System.out.println(listaPubli.get(i).toString());
            } else {
                System.out.println("    REVISTA ");
                System.out.println(listaPubli.get(i).toString());
            }

            System.out.println("***********************");
            System.out.println("");
            Thread.sleep(2000);

        }

        //Esto se podria hacer con el setPrestado, pero usamos la interface Prestable para aprender  
        System.out.println("Vamos a prestar el libro 1...");
        l1.prestar();
        System.out.println("");
        Thread.sleep(2000);
        /*Como ordenar un ArrayList, usando el metodo sort de la clase collections (recuerda que previamente tienes que implementar la
        interfaz Comparable con el metodo compareTo en la clase Publicacion
         */
        Collections.sort(listaPubli);
        System.out.println("¿Cuál es la publicación mas antigua?");

        System.out.println("***********************");
        if (listaPubli.get(0) instanceof Libro) {
            System.out.println("    LIBRO ");
            System.out.println(listaPubli.get(0).toString());
        } else {
            System.out.println("    REVISTA ");
            System.out.println(listaPubli.get(0).toString());
        }
        System.out.println("***********************");
        System.out.println("");
        System.out.print("¿Cuántos libros se han prestado? ");
        System.out.println(cuentaPrestado(listaPubli));
        System.out.print("¿Cuantos ejemplares de libros hay en total? ");
        System.out.println(cuentaNumEjemplaresLibros(listaPubli));
        System.out.print("¿Cuantos ejemplares totales hay? ");
        System.out.println(cuentaEjemplaresTotales(listaPubli));
        System.out.print("¿Cuántas publicaciones son anteriores a 2018? ");
        System.out.println(publicacionesAnterioresA(listaPubli, AnioPublicacion));
    }

    /**
     * Calcula el numero de libros que se han prestado
     *
     * @param listaPubli
     * @return devolvera el numero de libros prestados
     */
    private static int cuentaPrestado(ArrayList<Publicacion> listaPubli) {
        int contadorPrestado = 0;

        //Hacemos un casting para que la lista tenga el metodo de estaPrestado de la clase Libro
        for (int i = 0; i < listaPubli.size(); i++) {
            if (listaPubli.get(i) instanceof Libro) {
                Libro lib = (Libro) listaPubli.get(i);
                if (lib.estaPrestado()) {
                    contadorPrestado++;
                }
            }
        }
        return contadorPrestado;
    }

    /**
     * Muestra que cuantas publicaciones anteriores al año 2018 hay
     * @param listaPubli
     * @param anio
     * @return 
     */
    private static int publicacionesAnterioresA(ArrayList<Publicacion> listaPubli, int anio) {
        int contadorPublicaciones = 0;
        for (int i = 0; i < listaPubli.size(); i++) {
            if (listaPubli.get(i).getAnioPublicacion() < anio) {
                contadorPublicaciones++;
            }
        }
        return contadorPublicaciones++;
    }

    
    public static int cuentaNumEjemplaresLibros(ArrayList<Publicacion> listaPubli) {
        int sumaEjemplares = 0;
        for (int i = 0; i < listaPubli.size(); i++) {
            if (listaPubli.get(i) instanceof Libro) {
                Libro lib = (Libro) listaPubli.get(i);
                sumaEjemplares += lib.getnEjemplares();
            }

        }
        return sumaEjemplares;
    }
    
    public static int cuentaEjemplaresTotales(ArrayList<Publicacion> listaPubli) {
        int sumaEjemplares = 0;
        for (int i = 0; i < listaPubli.size(); i++) {
            if (listaPubli.get(i) instanceof Libro lib) {
                sumaEjemplares += lib.getnEjemplares();
            }
            if (listaPubli.get(i) instanceof Revista lib) {
                sumaEjemplares += lib.getNEJEMPLARES();
            }

        }
        return sumaEjemplares;
    }
}

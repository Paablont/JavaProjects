
package biblioteca;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase ejecutable Proyectos
 * @author pablo
 */
public class ProyectosApp {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Publicacion> listaPubli = new ArrayList<Publicacion>();
        
        Proyecto p1 = new Proyecto("AF", 123, "Mundo Empresarial", 2020);
        Proyecto p2 = new Proyecto("DAM", 456, "Mundo Multiplataforma", 2013);
        Proyecto p3 = new Proyecto("DAW", 789, "Mundo Web", 2005);
        Libro l1 = new Libro(20, 852, "El hobbit", 2023);
        
        listaPubli.add(p1);
        listaPubli.add(p2);
        listaPubli.add(p3);
        listaPubli.add(l1);
        
        System.out.println("Vamos a prestar 2 proyectos y el libros...");
        l1.prestar();
        p1.prestar();
        p3.prestar();
        System.out.print("¿Cuántos proyectos y libros totales se han prestado? ");
        System.out.println(cuentaPrestado(listaPubli));
        System.out.println("Vamos a ordenar el arrayList y mostraremos la informacion de cada elemento");
        Collections.sort(listaPubli);
        System.out.println("");
        for (int i = 0; i < listaPubli.size(); i++) {
            System.out.println("***********************");
            if (listaPubli.get(i) instanceof Libro) {
                System.out.println("    LIBRO ");
                System.out.println(listaPubli.get(i).toString());
            } else {
                System.out.println("    PROYECTO ");
                System.out.println(listaPubli.get(i).toString());
            }
            System.out.println("***********************");
            System.out.println("");
            Thread.sleep(2000);

        }
        System.out.println("");
        System.out.print("¿Cuantos ejemplares de proyecto hay en total? ");
        System.out.println(cuentaEjemplaresProyecto(listaPubli));
        System.out.print("¿Cuantos ejemplares totales hay? ");
        System.out.println(cuentaEjemplaresTotales(listaPubli));
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
            if (listaPubli.get(i) instanceof Proyecto) {
                Proyecto pro = (Proyecto) listaPubli.get(i);
                if (pro.estaPrestado()) {
                    contadorPrestado++;
                }
            }
        }
        return contadorPrestado;
    }
    
    public static int cuentaEjemplaresTotales(ArrayList<Publicacion> listaPubli) {
        int sumaEjemplares = 0;
        for (int i = 0; i < listaPubli.size(); i++) {
            if (listaPubli.get(i) instanceof Libro) {
                Libro lib = (Libro) listaPubli.get(i);
                sumaEjemplares += lib.getnEjemplares();
            }
            if (listaPubli.get(i) instanceof Proyecto) {
                Proyecto proy = (Proyecto) listaPubli.get(i);
                sumaEjemplares += proy.getNEJEMPLARES();
            }

        }
        return sumaEjemplares;
    }
    
    public static int cuentaEjemplaresProyecto(ArrayList<Publicacion> listaPubli) {
        int sumaEjemplares = 0;
        for (int i = 0; i < listaPubli.size(); i++) {
            
            if (listaPubli.get(i) instanceof Proyecto) {
                Proyecto proy = (Proyecto) listaPubli.get(i);
                sumaEjemplares += proy.getNEJEMPLARES();
            }

        }
        return sumaEjemplares;
    }
    
}

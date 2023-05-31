package clases;

import clases.Metodos;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * Clase hija que tiene las propiedadees y funciones de un ser mitolgico japones
 *
 * @author Pablo Villaseñor Ruiz [pvillasenorr01@educastillalamancha.es]
 * @version 1.0
 */
public class JaponesPVR extends SerMitologico implements Serializable {

    //Atributos
    private Transformaciones transformacion;

    
    //Constructores
    public JaponesPVR(Transformaciones transformacion, int fuerza, String nombre, RegionGeografica region, String nombreUsuario) {
        super(fuerza, nombre, region, nombreUsuario);
        this.transformacion = transformacion;
    }

    public JaponesPVR() {
    }
    

    //Getters & Setters
    public Transformaciones getTransformacion() {
        return transformacion;
    }

    public void setTransformacion(Transformaciones transformacion) {
        this.transformacion = transformacion;
    }

    /**
     * Metodo que permite cambiar de forma del ser mitolgico japones
     *
     * @param lista
     * @param nombreJapones
     * @return Devuelve la lista con la nueva transformacion modificada
     * @throws java.io.IOException
     */
    public LinkedList<Object> cambiarTransformacion(LinkedList<Object> lista, String nombreJapones) throws IOException {
        Metodos metodos = new Metodos();
        Transformaciones transformacionNueva;
        transformacionNueva = metodos.pedirTransformacion();
        for (int i = 0; i < lista.size(); i++) {
            if (((JaponesPVR) lista.get(i)).getNombre().equals(nombreJapones)) {
                if (((JaponesPVR) lista.get(i)).getTransformacion().equals(transformacionNueva)) {
                    System.out.println("No puedes transformarte en " + transformacionNueva + " porque ya eres un " + transformacion);
                } else {
                    ((JaponesPVR) lista.get(i)).setTransformacion(transformacionNueva);
                    System.out.println("Transformacion completada: de " + transformacion + " a " + transformacionNueva);
                }
            }

        }
        return lista;
    }

    /**
     * Metodo para borrar la criatura
     * lista
     *
     * @param lista
     * @param nombreCriatura
     */
    public void borrarCriatura(LinkedList<Object> lista, String nombreCriatura) {

        for (int i = 0; i < lista.size(); i++) {
            if (((JaponesPVR) lista.get(i)).getNombre().equals(nombreCriatura)) {

                lista.remove(i);

            }
        }
        System.out.println("La criatura " + nombreCriatura + " se ha borrado correctamente");
    }

    /**
     * Metodo que determina cual es el patron de ritual de invocacion
     *
     * @return
     */
    @Override
    public String establecerPatron() {
        String ritual = "[a-zA-Z]{3,}[0-9]@";
        return ritual;
    }

    /**
     * Metodo toString
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + "\nTransformacion: " + transformacion
                + "\nPertenece a: " + nombreUsuario
                +"\n";
    }

}

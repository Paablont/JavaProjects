package clases;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Clase padre que tiene las propiedades y funciones de un Ser Mitologico
 *
 * @author Pablo Villaseñor Ruiz [pvillasenorr01@educastillalamancha.es]
 * @version 1.0
 */
public abstract class SerMitologico implements RitualValidable, Serializable {

    //Atributos
    protected int fuerza;
    protected String nombre;
    protected RegionGeografica region;
    public static int contadorMitologia;
    protected String nombreUsuario;

    //Constructores
    public SerMitologico(int fuerza, String nombre, RegionGeografica region, String nombreUsuario) {
        this.fuerza = fuerza;
        this.nombre = nombre;
        this.region = region;
        this.nombreUsuario = nombreUsuario;
        contadorMitologia++;
    }

    public SerMitologico() {
    }

    
    //Getters&Setters
    public int getFuerza() {
        return fuerza;
    }

    public String getNombre() {
        return nombre;
    }

    public int getContadorMitologia() {
        return contadorMitologia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Metodo abstracto donde cada hija determina el patron del ritual de
     * invocacion
     *
     * @return
     */
    public abstract String establecerPatron();

    /**
     * Metodo que valida si el ritual introducido es igual al establecido en
     * cada clase hija. Proviene de la clase Interface RitualValidable
     *
     * @param patron
     * @param ritual
     * @return
     */
    @Override
    public boolean validarRitual(String patron, String ritual) {
        boolean valido = false;
        if (Pattern.matches(patron, ritual)) {
            valido = true;
        }
        return valido;
    }

    @Override
    public String toString() {
        return "****** CARACTERISTICAS DE " + nombre + " ******"
                + "\nRegion: " + region
                + "\nFuerza: " + fuerza;

    }

}

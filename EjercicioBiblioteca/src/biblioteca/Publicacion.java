package biblioteca;

import java.util.Calendar;

/**
 * Clase padre Publicacion que hereda atribuos y metodos a Libro y Revista
 *
 * @author pablo
 */
public class Publicacion implements Comparable<Publicacion> {

    protected int codigo;
    protected String titulo;
    protected int anioPublicacion;

    public Publicacion(int codigo, String titulo, int anioPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
    }

    public Publicacion() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + "\nTitulo: " + titulo + "\nAño de publicación: " + anioPublicacion;
    }

    /**
     * Metodo para comparar si 2 objetos tienen el mismo codigo Si devuelve true
     * lo tienen y debera avisar Si devuelve false no lo tienen
     *
     * @param obj
     * @return
     */
    public boolean iguales(Object obj) {
        boolean iguales = false;
        Publicacion publiComparar;
        publiComparar = (Publicacion) obj;
        if (this.codigo == publiComparar.codigo) {
            iguales = true;
        }
        return iguales;
    }

    /**
     * Metodo para calcular la antigüedad que tiene una publicacion usando la
     * clase Calendar
     *
     * @param anio
     * @return
     */
    public int antiguedad(int anio) {
        int antiguedad;
        antiguedad = anio - Calendar.YEAR;
        return antiguedad;
    }

    /**
     * Comparamos el año de publicacion de 2 libros
     *
     * @param publicacionComparar
     * @return
     */
    @Override
    public int compareTo(Publicacion publicacionComparar) {

        int este = this.getAnioPublicacion();
        int otro = publicacionComparar.getAnioPublicacion();
        int res = 0;
        if (este < otro) {
//Si el que pasamos tiene el lado mayor,
//el resultado será menor que 0
            res = -1;
        } else {
//sino, con el que se invoca al método será mayor
            res = 1;
        }
        /* si no es ni mayor ni menor es porque son
iguales, entonces res tendrá valor 0 porque
no lo habrá cambiado desde la inicialización*/
        return res;
    }

    public boolean equals(Object obj) {
        boolean igual=false;
        if (obj==null || !(obj instanceof Publicacion)) {
            igual=false;
            
        }
        Publicacion publiEquals = (Publicacion) obj;
        if (this.codigo == publiEquals.getCodigo()) {
            igual=true;
            
        }
        return igual;
}
    

}

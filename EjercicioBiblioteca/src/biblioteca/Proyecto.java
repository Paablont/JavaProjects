
package biblioteca;

/**
 * Clase no ejecutable Proyecto. Contiene información de todos los proyectos de segundo curso de los CF Grado superior
 * @author pablo
 */
public class Proyecto extends Publicacion implements Prestable,Comparable<Publicacion>{
    private String titulacion;
    private boolean prestado=false;
    private final int NEJEMPLARES=1;
    public final static int TITU_AF=0;
    public final static int TITU_DAW=1;
    public final static int TITU_DAM=2;
    public final static int TITU_AUTO=3;
   
    public final static String titulaciones[] = {
                                "Administración y Finanzas",
                                "Desarrollo de Aplicaciones Web",
                                "Desarrollo de Aplicaciones Multiplataforma",
                                "Automoción"
    };

    /**
     * Constructor con los atributos de la clase padre y los de la hija
     * @param titulacion
     * @param codigo
     * @param titulo
     * @param anioPublicacion 
     */
    public Proyecto(String titulacion, int codigo, String titulo, int anioPublicacion) {
        super(codigo, titulo, anioPublicacion);
        this.titulacion = titulacion;
    }

    /**
     * Constructor vacio
     */
    public Proyecto() {
    }

    /**
     * Getters&Setters
     * @return 
     */
    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public int getNEJEMPLARES() {
        return NEJEMPLARES;
    }
    

    public boolean getPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
    
    
    /**
     * Metodo ToString que devuelve la cadena de valores de un Proyecto
     * @return 
     */
   @Override
    public String toString() {
        return super.toString()+ "\nTitulacion: "+titulacion + "\n¿Esta prestado? " + prestado ;
    }
    
    /**
     * Metodo compareTo que compara los proyectos segun el codigo
     *
     * @param publicacionComparar
     * @return
     */
    @Override
    public int compareTo(Publicacion publicacionComparar) {

        int este = this.getCodigo();
        int otro = publicacionComparar.getCodigo();
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

    /**
     * Metodo que establece si se ha prestado un proyecto
     */
    @Override
    public void prestar() {
        this.setPrestado(true);
    }

    /**
     * Metodo que establece si se ha devuelto un proyecto
     */
    @Override
    public void devolver() {
        this.setPrestado(false);
    }

    /**
     * Metodo que devuelve como esta el proyecto(prestado o devuelto)
     * @return 
     */
    @Override
    public boolean estaPrestado() {
            return this.getPrestado();
        }
}

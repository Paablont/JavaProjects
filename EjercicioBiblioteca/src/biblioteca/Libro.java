
package biblioteca;

/**
 * Clase hija del padre Publicacion
 * @author pablo
 */
public class Libro extends Publicacion implements Prestable{
    private int nEjemplares;
    private boolean prestado=false;
    private int ejemplares=0;

    public Libro(int nEjemplares, int codigo, String titulo, int anioPublicacion) {
        super(codigo, titulo, anioPublicacion);
        this.nEjemplares = nEjemplares;
        ejemplares++;
    }

    public Libro() {
    }

    public int getnEjemplares() {
        return nEjemplares;
    }

    public boolean getPrestado() {
        return prestado;
    }
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nEjemplares: " + nEjemplares + "\n¿Esta prestado? " + prestado ;
    }
    
    

    /**
     * En este metodo se establece
     */
    @Override
    public void prestar() {
        this.setPrestado(true);
    }

    @Override
    public void devolver() {
        this.setPrestado(false);
    }

    @Override
    public boolean estaPrestado() {
            return this.getPrestado();
        }

    
    
    
    
}

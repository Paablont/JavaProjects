package biblioteca;

/**
 * Clase hija del padre Publicacion
 * @author pablo
 */
public class Revista extends Publicacion{
    private final int NEJEMPLARES=2;
    private int nRevista;

    public Revista(int codigo, String titulo, int anioPublicacion, int numeroRevista) {
        super(codigo, titulo, anioPublicacion);
      this.nRevista = numeroRevista;
    }

    public Revista() {
    }

    public int getNEJEMPLARES() {
        return NEJEMPLARES;
    }

    public int getnRevista() {
        return nRevista;
    }

    public void setnRevista(int nRevista) {
        this.nRevista = nRevista;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNúmero de revista: " + nRevista;
    }

    
    
}

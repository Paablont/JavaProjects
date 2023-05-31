package biblioteca;

/**
 * Definir el interface Prestable dentro del mismo proyecto, con los métodos
prestar, devolver y estaPrestado. Éste último método devolverá un
boolean.
 * @author b03-01t
 */
public interface Prestable {
    public void prestar();
    public void devolver();
    public boolean estaPrestado();
}

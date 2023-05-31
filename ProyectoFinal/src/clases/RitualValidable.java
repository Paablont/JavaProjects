package clases;

/**
 * Clase interface que tiene el metodo abstracto que valida si el ritual esta bien o mal
 * 
 * @author Pablo Villaseñor Ruiz [pvillasenorr01@educastillalamancha.es]
 * @version 1.0
 */
public interface RitualValidable {
    public abstract boolean validarRitual(String patron, String ritual);
}

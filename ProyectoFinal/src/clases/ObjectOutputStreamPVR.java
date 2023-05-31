
package clases;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Clase que modifica la clase base ObjectOutputStream
 * 
 * @author Pablo Villaseñor Ruiz [pvillasenorr01@educastillalamancha.es]
 * @version 1.0
 */
public class ObjectOutputStreamPVR extends ObjectOutputStream {
    
    /**
     * Sobreescribe el metodo de la clase ObjectOutputStream
     * para evitar que la cabecera de los metadatos del fichero se
     * duplique cada vez que añadimos un objeto al fichero
     * @throws IOException 
     */
    @Override
    protected void writeStreamHeader() throws IOException {
        //no se hace nada
    }
    
    //constructores
    public ObjectOutputStreamPVR () throws IOException {
        super ();
    }
    
    public ObjectOutputStreamPVR (OutputStream out) throws IOException {
        super (out);
    }
}

package clases;

import clases.UsuariosPVR;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

/**
 * Clase que permite leer objetos en ficheros
 *
 * @author Pablo Villaseñor Ruiz [pvillasenorr01@educastillalamancha.es]
 * @version 1.0
 */
public class LectorPVR {

    File fichLector;

    //Constructores    
    public LectorPVR() {
    }

    public LectorPVR(File fichLector) {
        this.fichLector = fichLector;
    }

    // get & set
    public File getFichLector() {
        return fichLector;
    }

    public void setFichLector(File fichLector) {
        this.fichLector = fichLector;
    }

    /**
     * Método que recorre un fichero y lista todas los objetos segun de que
     * clase sean almacenados en el fichero
     *
     * @return nº de objetos leídas si se ha podido leer; -1 si no ha podido
     * leer
     */
    public int verContenidoPVR() {
        ObjectInputStream ois = null;
        int valorDevuelto = 0;
        Object p;
        
            try {
                ois = new ObjectInputStream(new FileInputStream(fichLector));
                p = ois.readObject();

                while (p != null) {
                    if (p instanceof UsuariosPVR) {
                        valorDevuelto++;
                        System.out.println("*********** USUARIO " + (valorDevuelto) + " ****************************");
                        System.out.println(p.toString());
                        System.out.println("**********************************************************************");
                        System.out.println("");
                        p = (UsuariosPVR) ois.readObject();
                    }
              if (p instanceof JaponesPVR) {
                  valorDevuelto++;
                  System.out.println("*********** SER MITOLOGICO " + (valorDevuelto) + " *********************");
                  System.out.println(p.toString());
                  System.out.println("**********************************************************************");
                  System.out.println("");

                  p = (JaponesPVR) ois.readObject();
                }
                }
            } catch (EOFException eofe) {
                System.out.println("********************************************************************");
                System.out.println("SE HAN LISTADO TODOS LOS DATOS. EN TOTAL: " + valorDevuelto + " OBJETOS");
                System.out.println("********************************************************************");
            } catch (IOException ioe) {
                System.out.println("***********El fichero esta vacio " + ioe.getMessage());
                valorDevuelto = -1;
            } catch (ClassNotFoundException cnfe) {
                System.out.print("***********No se ha encontrado la clase a la que deberia pertenecer el objeto " + cnfe.getMessage());
                valorDevuelto = -1;
            } catch (Exception e) {
                System.out.print("***********Fallo en la lectura  " + e.getMessage());
                valorDevuelto = -1;
            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        System.out.println("\t***********Fallo en el cierre de lectura " + e.getMessage());
                    }
                }
            }
            return valorDevuelto;
       
        
    }
    
    /**
     * Método que lee de un fichero todos los objetos y busca el que coincida
     * que se pasa por parámetro
     *
     * @param nombreObjeto del objeto a buscar(por nombre de este)
     * @return el objeto si se ha encontrado; null si no se ha encontrado
     */
    public Object buscaPVR(String nombreObjeto) {
        Object p = null;
        boolean encontrado = false;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichLector));
            p = ois.readObject();
            while (p != null && !encontrado) {
                //Busca por nombre de usuario
                if (p instanceof UsuariosPVR usuariosPVR) {
                    if ((usuariosPVR.getNombre().equals(nombreObjeto))) {
                        encontrado = true;
                    } else {
                        p = (UsuariosPVR) ois.readObject();
                    }                    
                }

                if (p instanceof JaponesPVR) {

                    if (((JaponesPVR) p).getNombre().equals(nombreObjeto)) {
                        encontrado = true;
                    } else {
                        p = (JaponesPVR) ois.readObject();
                    }
                }
            }//Fin del while 
            if (!encontrado) {
                p = null;
            }
        } catch (EOFException eofe) {
            p = null;
        } catch (IOException ioe) {
            System.out.println("Fallo de E/S " + ioe.getMessage());
            p = null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Fallo al leer los datos: " + ex.getMessage());
            p = null;
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ioe) {
                System.out.println("Fallo al cerrar la lectura de datos mientras se buscaba " + ioe.getMessage());
            }
        }//Fin del  try
        return p;
    }//Fin de busca

    /**
     * Método que lee de un fichero todos los objetos y los almacena en una
     * lista dinámica
     *
     * @return LinkedList con todo el contenido del fichero
     */
    public LinkedList<Object> leerPVR() {
        LinkedList<Object> listaObjetos = new LinkedList<>();
        Object p;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichLector));
            //Mientras haya objetos en el fichero se ejecuta el while
            //Cuando salte la excepcion de EOF sale del bucle
            p = ois.readObject();
           
            while (p != null) {
                if (p instanceof UsuariosPVR) {
                    listaObjetos.add(p);
                    p = (UsuariosPVR) ois.readObject();
                }

              if (p instanceof JaponesPVR) {
                  listaObjetos.add(p);
                  p = (JaponesPVR) ois.readObject();
                }
            }//Fin del while 
        } catch (EOFException eofe) {
            System.out.println("");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("La clase no se ha encontrada: " + cnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("Fallo de E/S: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Fallo al recorrer el fichero: " + e.getMessage());
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }//Fin try
        return listaObjetos;
    }//Fin de lee*/
}

package clases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Clase que contiene algunos metodos genericos como escribir, limpiar pantalla
 * pedir valores, etc
 *
 * @author Pablo Villase�or Ruiz [pvillasenorr01@educastillalamancha.es]
 * @version 1.0
 */
public class Metodos {

    //Constructor
    public Metodos() {
    }

    /**
     * Metodo para limpiar la pantalla
     *
     * @throws AWTException
     * @throws InterruptedException
     */
    public void limpiarPantallaEnter() throws AWTException, InterruptedException, IOException {
        Robot robot = new Robot();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Presiona Enter para continuar...");
        br.readLine();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_L);
        Thread.sleep(1000);

    }

    /**
     * Metodo para limpiar la pantalla
     *
     * @throws AWTException
     * @throws InterruptedException
     * @throws java.io.IOException
     */
    public void limpiarPantalla() throws AWTException, InterruptedException, IOException {
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_L);
        Thread.sleep(1000);
    }

    /**
     * Metodo para pedir nombre de usuario
     *
     * @return
     * @throws IOException
     */
    public String pedirNombreUsuario(int opcion) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String nombre;

        do {
            switch (opcion) {
                case 0:
                    System.out.print("Escribe tu nombre de usuario: ");
                    break;
                case 1:
                    System.out.print("Escribe el nombre para el nuevo usuario: ");
                    break;

            }
            nombre = teclado.readLine().toLowerCase();
        } while (nombre.isBlank());

        return nombre;
    }

    /**
     * Metodo para pedir contrase�a del usuario
     *
     * @param opcion 0 imprimira con mensaje generico,1 con mensaje de "nueva
     * contrase�a". Para Para cuando el usuario quiere cambiarla
     * @return
     * @throws IOException
     */
    public String pedirContrasenia(int opcion) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String contrasenia;
        do {
            switch (opcion) {
                case 0:
                    System.out.print("Escribe tu contrase�a: ");
                    break;
                case 1:
                    System.out.print("Escribe tu nueva contrase�a: ");
                    break;
                default:
                    System.out.print("Escribe la contrase�a para el nuevo usuario: ");
                    break;
            }
            contrasenia = teclado.readLine().toLowerCase();
        } while (contrasenia.isBlank());

        return contrasenia;
    }

    /**
     * Metodo que pide la cantidad de seres japoneses que queremos crear
     * 
     * @return devuelve la cantidad de seres que queremos crear
     * @throws IOException
     */
    public int pedirCantidadSeres() throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String cantidadString = "";
        int cantidad;
        do {
            do {
                try {

                    System.out.println("�Cuantos seres japoneses quieres crear?");
                    cantidadString = teclado.readLine();

                } catch (NumberFormatException e) {
                    System.out.println("Debes ingresar un numero!");
                }
            } while (cantidadString.isBlank());
            cantidad = Integer.parseInt(cantidadString);
        } while (cantidad < 1);
        return cantidad;
    }

    /**
     * Metodo para pedir el nombre de la criatura. Segun el parametro que le pases
     * imprime un mensaje u otro
     *
     * @param opcion
     * @return devuelve un String con el nombre de la criatura
     * @throws IOException
     */
    public String pedirNombreJapones(int opcion) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String nombre;
        do {
            switch (opcion) {
                case 0:
                    
                    System.out.print("Indica el nombre de la criatura que deseas crear: ");
                    break;
                case 1:
                    System.out.print("Escribe el nombre de la criatura que deseas borrar: ");
                    break;
                default:
                    System.out.print("Escribe el nombre de la criatura que deseas modificar: ");
                    break;
            }
            nombre = teclado.readLine().toLowerCase().trim();
        } while (nombre.isBlank());
        return nombre;
    }

    /**
     * Metodo para pedir la fuerza de la criatura
     *
     * @return
     * @throws IOException
     */
    public int pedirFuerzaJapones() throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int fuerza;
        String fuerzaString = "";
        do {
            try {
                System.out.print("Indica la fuerza(1 - 10): ");
                fuerzaString = teclado.readLine();
                fuerza = Integer.parseInt(fuerzaString);
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un n�mero!");
                fuerza=-1;
            }
            
        } while ((fuerza < 1 || fuerza > 10));
        return fuerza;
    }

    /**
     * Metodo que pide que tipo de transformacion es nuestro objeto Japones
     * inicial (Despu�s podremos cambiarlo con el m�todo de
     * cambiarTransformacion)
     *
     * @return
     * @throws java.io.IOException
     */
    public Transformaciones pedirTransformacion() throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        String transformarse = "";

        //Array de valores del enumerado, para asignarlo despues a la opcion 
        Transformaciones[] valoresEnumerado = Transformaciones.values();
        Transformaciones transfor;

        System.out.println(" ***** TIPOS DE FORMAS *****");
        System.out.println("1. KITSUNE (Zorro)");
        System.out.println("2. HEBI (Serpiente)");
        System.out.println("3. BAKENEKO (Gato)");
        System.out.println("4. KAPPA (Tortuga)");
        System.out.println("5. TATSU (Dragon)");
        System.out.println("6. ONI (Demonio)");
        System.out.println("7. NINGEN (Humano)");
        System.out.println("");

        do {
            try {
                System.out.println("�A que forma te quieres transformar?");
                transformarse = teclado.readLine();
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un n�mero!");
                opcion=-1;
            }
            opcion = Integer.parseInt(transformarse);
        } while (opcion < 1 || opcion > 7);

        transfor = valoresEnumerado[opcion - 1];

        return transfor;
    }

    public String pedirRitual() throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String ritual;
        do {
            System.out.println("Escribe el ritual japones (Minimo 3 letras(mayusculas o minusculas), seguido de un numero y un @ al final del ritual)");
            ritual = teclado.readLine();
        } while (ritual.isBlank());

        return ritual;
    }

    /**
     * Metodo para pedir todos los valores de la criatura japonesa y agregarla a
     * una lista
     *
     * @param numeroSeres
     * @param usuario
     * @return
     * @throws IOException
     * @throws AWTException
     * @throws InterruptedException
     */
    public LinkedList<Object> pedirValoresJapones(int numeroSeres, UsuariosPVR usuario) throws IOException, AWTException, InterruptedException {
        Metodos metodos = new Metodos();
        LinkedList<Object> listaJaponeses;
        listaJaponeses = new LinkedList<>();
        int fuerza, opcionMensajeNombreJapones = 0;
        String nombre;
        Transformaciones transformacion;
        JaponesPVR japones;
        RegionGeografica region = RegionGeografica.ASIA;
        for (int i = 1; i < numeroSeres + 1; i++) {
            System.out.println("Datos para la criatura " + i);
            nombre = metodos.pedirNombreJapones(opcionMensajeNombreJapones);
            fuerza = metodos.pedirFuerzaJapones();
            transformacion = metodos.pedirTransformacion();
            japones = new JaponesPVR(transformacion, fuerza, nombre, region, usuario.getNombre());

            japones.setTransformacion(transformacion);

            japones.setFuerza(fuerza);

            japones.setNombre(nombre);
            japones.setNombreUsuario(usuario.getNombre());

            listaJaponeses.add(japones);

            System.out.println(nombre + " se ha agregado correctamente");
            System.out.println("");
        }

        return listaJaponeses;
    }
    
    /**
     * Recorre la lista japonesa y comprueba si el animal pertenece al usuario.
     * Si pertenece podra modificar su forma animal
     * @param listaJapo
     * @param nombreUsuario
     * @return true si pertenece al usuario, false si no
     */
    public boolean pertenece(LinkedList<Object> listaJapo,String nombreUsuario){
        boolean pertenece=false;        
        for (int i = 0; i < listaJapo.size(); i++) {
            if (((JaponesPVR) listaJapo.get(i)).getNombreUsuario().equals(nombreUsuario)) {
                pertenece=true;  
                break;
            }
        }
        
        return pertenece;
    }

}

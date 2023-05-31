package clases;


import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Clase ejecutable que pone en funcionamiento todo el programa
 *
 * @author Pablo Villaseñor Ruiz [pvillasenorr01@educastillalamancha.es]
 * @version 1.0
 */
public class GestorJaponesApp {

    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        //Teclado
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String tecladoString;

        //Variables generales
        int opcionMenu, contadorIntentos, numeroSeres;
        int opcionMensajeContraseña; //0 mensaje normal,1 mensaje nueva contraseña
        int opcionMensajeNombreJapones; //0 nombre nueva criatra,1 nombre borrar criatura, 2 nombre cambiar de forma
        boolean salirAplicacion = false, salirMenuInicio, salirMenuJapones, contraValida = false, ritualValido = false;
        String nombreUsuario, contraseniaUsuario, nuevaContrasenia, nuevaForma, patronRitual, ritual, nombreJapones;

        //Objetos de clases
        Metodos metodos = new Metodos();
        EscritorPVR escritorUsuarios;
        EscritorPVR escritorJaponeses;
        LectorPVR lectorUsuarios;
        LectorPVR lectorJaponeses;
        UsuariosPVR usuario = new UsuariosPVR();
        JaponesPVR japones;
        LinkedList<Object> listaUsuario;

        LinkedList<Object> listaJaponeses = null;

        //Nombre de los ficheros (contienen la ruta donde se guardan)
        String rutaFicheros = "ficheros/";
        String nombreFichUsuarios = "";
        String nombreFichJaponeses = "";

        do {
            System.out.println("Escribe un nombre para el archivo donde se guardaran los usuarios(la extensión no hace falta): ");
            nombreFichUsuarios = teclado.readLine();
        } while (nombreFichUsuarios.isBlank());
        nombreFichUsuarios = rutaFicheros.concat(nombreFichUsuarios.concat(".txt"));

        do {
            System.out.println("Escribe un nombre para el archivo donde se guardaran los elementos japoneses(la extensión no hace falta): ");
            nombreFichJaponeses = teclado.readLine();
        } while (nombreFichJaponeses.isBlank());
        nombreFichJaponeses = rutaFicheros.concat(nombreFichJaponeses.concat(".txt"));

        System.out.println("Entrando a la aplicacion. Por favor espere...");
        metodos.limpiarPantalla();

        //Inicializacion de objetos
        File usuarios = new File(nombreFichUsuarios);
        File japoneses = new File(nombreFichJaponeses);
        escritorUsuarios = new EscritorPVR(usuarios);
        escritorJaponeses = new EscritorPVR(japoneses);
        lectorUsuarios = new LectorPVR(usuarios);
        lectorJaponeses = new LectorPVR(japoneses);

        /*Generamos algunos usuarios, pero antes
         comprobamos si existe el fichero*/
        if (!usuarios.exists()) {

            listaUsuario = new LinkedList<>();
            usuario = new UsuariosPVR("admin", "admin123");
            listaUsuario.add(usuario);
            usuario = new UsuariosPVR("pablo", "pablito");
            listaUsuario.add(usuario);
            escritorUsuarios.escribirPVR(listaUsuario);
            listaUsuario.clear();

        }
        
        
        if (japoneses.exists()) {
            listaJaponeses = new LinkedList<>();
            escritorJaponeses.escribirPVR(listaJaponeses);
        }

        while (!salirAplicacion) {
            salirMenuInicio = false;
            salirMenuJapones = false;

            while (!salirMenuInicio) {

                /*Para abrir la aplicacion en modo desarrollador, descomentar lineas 
                104,386-389*/
                System.out.println("*********** MENU PRINCIPAL ***************");
                System.out.println("1. Iniciar sesión");
                System.out.println("2. Registrarse");
                System.out.println("3. Cerrar aplicación");
//              System.out.println("4. (MODO DESARROLLADOR)Ver contenido del fichero usuarios"); 
                System.out.println("*********** ************* ***************");
                System.out.print("Elige una opcion... ");
                tecladoString = teclado.readLine();

                try { //Excepcion para controlar que se ingresa un valor numerico para menu

                    opcionMenu = Integer.parseInt(tecladoString);

                    switch (opcionMenu) {

                        case 1://Iniciar sesion
                            metodos.limpiarPantalla();
                            contadorIntentos = 3;

                            nombreUsuario = metodos.pedirNombreUsuario(0);

                            /*Buscamos ese nombre de usuario, si lo encuentra pasa a pedir la contraseña
                        si no lo encuentra preguntara si queremos registrarlo*/
                            usuario = (UsuariosPVR) lectorUsuarios.buscaPVR(nombreUsuario);

                            if (usuario != null) {
                                System.out.println("Usuario correcto.");
                                System.out.println("Tienes " + contadorIntentos + " intentos");
                                while (contadorIntentos > 0) {
                                    opcionMensajeContraseña = 0;
                                    contraseniaUsuario = metodos.pedirContrasenia(opcionMensajeContraseña);
                                    
                                    //Buscamos la contraseña del usuario
                                    listaUsuario = lectorUsuarios.leerPVR();
                                    contraValida = usuario.validarContrasenia(listaUsuario, nombreUsuario, contraseniaUsuario);
                                    listaUsuario.clear();
                                    if (contraValida) {

                                        System.out.println("Usuario y contraseña correctos");
                                        salirMenuInicio = true;
                                        contadorIntentos = 0;
                                        metodos.limpiarPantallaEnter();
                                        
                                        //Menu de inicio del usuario
                                        while (!salirMenuJapones) {

                                            System.out.println("*********** USUARIO: " + usuario.getNombre() + " ***************");
                                            System.out.println("1. Cambiar mi contraseña");
                                            System.out.println("2. Creacion de criaturas japonesas");
                                            System.out.println("3. Mostrar bestiario de las criaturas japonesas");
                                            System.out.println("4. Cambiar de forma");
                                            System.out.println("5. Borrar criatura");
                                            System.out.println("6. Cerrar sesión");
                                            System.out.println("7. Cerrar aplicación");
                                            System.out.println("*********** ************* ***************");
                                            System.out.print("Elige una opcion... ");
                                            tecladoString = teclado.readLine();

                                            try { //Excepcion para controlar que se ingresa un valor numerico para menu

                                                opcionMenu = Integer.parseInt(tecladoString);

                                                switch (opcionMenu) {

                                                    case 1://Cambiar de contraseña el usuarioo
                                                        listaUsuario = lectorUsuarios.leerPVR();
                                                        System.out.println("Tu contraseña actual es: " + usuario.getContrasenia());
                                                        opcionMensajeContraseña = 1;
                                                        nuevaContrasenia = metodos.pedirContrasenia(opcionMensajeContraseña);
                                                        listaUsuario = usuario.cambiarContrasenia(listaUsuario, nombreUsuario, contraseniaUsuario, nuevaContrasenia);
                                                        escritorUsuarios.escribirPVR(listaUsuario);
                                                        listaUsuario.clear();
                                                        metodos.limpiarPantallaEnter();
                                                        break;
                                                        
                                                    case 2://Crea nuevas criaturas y las añade a la lista

                                                        //Primero pregunta la cantidad de criaturas
                                                        numeroSeres = metodos.pedirCantidadSeres();
                                                        metodos.limpiarPantalla();
                                                        //Pide valores por cada criatura creada
                                                        listaJaponeses = metodos.pedirValoresJapones(numeroSeres, usuario);
                                                        System.out.println("");
                                                        //Escribe la lista en el fichero de japoneses
                                                        escritorJaponeses.escribirPVR(listaJaponeses);
                                                        metodos.limpiarPantallaEnter();
                                                        break;
                                                        
                                                    case 3://Muestra la lista de TODAS las criaturas creadas
                                                        metodos.limpiarPantalla();
                                                        if (listaJaponeses == null || !japoneses.exists()) {
                                                            System.out.println("***************************************************");
                                                            System.out.println("*** El bestiario de seres japoneses esta vacio! ***");
                                                            System.out.println("***************************************************");

                                                        } else {
                                                            lectorJaponeses.verContenidoPVR();
                                                        }

                                                        metodos.limpiarPantallaEnter();
                                                        break;

                                                    case 4://Permite cambiar de forma a la criatura que queramos (mientras que sea nuestra)
                                                        metodos.limpiarPantalla();
                                                        if (listaJaponeses == null || !japoneses.exists()) {
                                                            System.out.println("***************************************************");
                                                            System.out.println("*** El bestiario de seres japoneses esta vacio! ***");
                                                            System.out.println("***************************************************");

                                                        } else {

                                                            listaJaponeses = lectorJaponeses.leerPVR();

                                                            System.out.println("Cada criatura japonesa tiene la habilidad de cambiar de forma"
                                                                    + "\nrealizando previamente un ritual.Si el ritual es correcto, la criatura se transformará"
                                                                    + "\ncorrectamente, adoptando una de las siguientes formas animales");
                                                            System.out.println("");
                                                            lectorJaponeses.verContenidoPVR();
                                                            System.out.println("");
                                                            System.out.println("RECUERDA: SOLO PUEDES MODIFICAR CRIATURAS QUE TE PERTENEZCAN");
                                                            opcionMensajeNombreJapones = 2;
                                                            nombreJapones = metodos.pedirNombreJapones(opcionMensajeNombreJapones);
                                                            japones = (JaponesPVR) lectorJaponeses.buscaPVR(nombreJapones);
                                                            if (japones != null) {
                                                                //Comprueba que es nuestra, si no no deja modificarla
                                                                if (metodos.pertenece(listaJaponeses, nombreUsuario)) {

                                                                    System.out.println("Vas a transformar a " + japones.getNombre());
                                                                    System.out.println("");
                                                                    patronRitual = japones.establecerPatron();
                                                                    ritual = metodos.pedirRitual();
                                                                    ritualValido = japones.validarRitual(patronRitual, ritual);

                                                                    if (ritualValido) {
                                                                        System.out.println("Ritual valido, empieza tu transformacion: ");
                                                                        japones.cambiarTransformacion(listaJaponeses, nombreJapones);
                                                                        japoneses.delete();
                                                                        escritorJaponeses.escribirPVR(listaJaponeses);

                                                                    } else {
                                                                        System.out.println("El ritual no es valido, por lo que tu criatura japonesa no tiene permitido cambiar su forma animal");
                                                                        metodos.limpiarPantallaEnter();
                                                                    }
                                                                } else {
                                                                    System.out.println("Esta criatura no te pertenece");
                                                                }

                                                            } else {
                                                                System.out.println("No se ha encontrado esa criatura en el bestiario");
                                                                Thread.sleep(1000);

                                                            }

                                                        }
                                                        metodos.limpiarPantallaEnter();
                                                        break;

                                                    case 5: //Borrar criatura del bestiario
                                                        metodos.limpiarPantalla();

                                                        if (listaJaponeses == null || !japoneses.exists()) {
                                                            System.out.println("***************************************************");
                                                            System.out.println("*** El bestiario de seres japoneses esta vacio! ***");
                                                            System.out.println("***************************************************");

                                                        } else {
                                                            lectorJaponeses.verContenidoPVR();
                                                            System.out.println("");
                                                            System.out.println("RECUERDA: SOLO PUEDES BORRAR CRIATURAS QUE TE PERTENEZCAN");

                                                            System.out.println("");
                                                            opcionMensajeNombreJapones = 1;
                                                            nombreJapones = metodos.pedirNombreJapones(opcionMensajeNombreJapones);
                                                            japones = (JaponesPVR) lectorJaponeses.buscaPVR(nombreJapones);
                                                            if (japones != null) {
                                                                //Comprueba que es nuestra, si no no deja borrarla
                                                                if (metodos.pertenece(listaJaponeses, nombreUsuario)) {
                                                                    listaJaponeses = lectorJaponeses.leerPVR();
                                                                    japones.borrarCriatura(listaJaponeses, nombreJapones);
                                                                    japoneses.delete();
                                                                    escritorJaponeses.escribirPVR(listaJaponeses);
                                                                } else {
                                                                    System.out.println("Esta criatura no te pertenece");
                                                                }
                                                            } else {
                                                                System.out.println("No se ha encontrado a " + nombreJapones + " en el bestiario");
                                                            }
                                                        }

                                                        metodos.limpiarPantallaEnter();

                                                        break;
                                                    case 6://Cierra la sesion y vuelve al menu principal
                                                        System.out.println("Cerrando sesión....");
                                                        System.out.println("");
                                                        salirMenuJapones = true;
                                                        metodos.limpiarPantalla();
                                                        break;
                                                        
                                                    case 7://Cierra la aplicación
                                                        System.out.println("Gracias por usar la aplicación Japonesa!!!");
                                                        System.out.println("");
                                                        salirMenuJapones = true;
                                                        salirAplicacion = true;
                                                        salirMenuInicio = true;
                                                        break;
                                                        
                                                    default:
                                                        System.out.println("Opción invalida");
                                                        Thread.sleep(1000);
                                                        metodos.limpiarPantalla();
                                                        
                                                }//FIN SWITCH OPCION MENU JAPONES

                                                //Esta excepcion captura que en la entrada de opciones del menu no sea un
                                                //caracter alfabetico
                                            } catch (NumberFormatException e) {
                                                System.out.println("Debes ingresar un numero!");
                                                Thread.sleep(1000);
                                                metodos.limpiarPantalla();
                                            }
                                        }//FIN SALIR WHILE MENU JAPONES

                                    } else {
                                        contadorIntentos--;
                                        if (contadorIntentos != 0) {
                                            System.out.println("Contraseña incorrecta");
                                            System.out.println("Te quedan " + contadorIntentos + " intentos");
                                        } else {
                                            System.out.println("Se han acabado los intentos de inicio de sesion con el usuario " + nombreUsuario
                                                    + "\nPor procesos de seguridad se procederá a borrar el usuario de la aplicación asi como "
                                                    + "\nlas criaturas japonesas que tenga");
                                            System.out.println("");
                                            listaUsuario = lectorUsuarios.leerPVR();
                                            listaJaponeses = lectorJaponeses.leerPVR();
                                            usuarios.delete();
                                            japoneses.delete();
                                            usuario.borrarUsuario(listaUsuario, nombreUsuario, listaJaponeses);

                                            System.out.println("");

                                            escritorUsuarios.escribirPVR(listaUsuario);
                                            escritorJaponeses.escribirPVR(listaJaponeses);
                                            metodos.limpiarPantallaEnter();
                                        }

                                    }

                                }//FIN WHILE CONTADOR INTENTOS

                            } else {

                                do {
                                    System.out.println("No se ha encontrado al usuario " + nombreUsuario);
                                    System.out.print("¿Deseas registrarte?(S para si, N para no) ");
                                    tecladoString = teclado.readLine().toUpperCase();
                                } while (!tecladoString.equals("S") && !tecladoString.equals("N"));

                                if (tecladoString.equals("S")) {
                                    usuario = new UsuariosPVR();
                                    usuario = usuario.registrarse(lectorUsuarios);
                                    escritorUsuarios.escribirPVR(usuario);
                                    metodos.limpiarPantallaEnter();
                                } else {
                                    metodos.limpiarPantalla();
                                }
                            }

                            break;

                        case 2: //Registrar nuevo usuario
                            usuario = new UsuariosPVR();
                            usuario = usuario.registrarse(lectorUsuarios);
                            escritorUsuarios.escribirPVR(usuario);

                            metodos.limpiarPantallaEnter();
                            break;

                        case 3: //Salir de la aplicacion
                            System.out.println("Gracias por usar la aplicación Japonesa!!!");
                            salirMenuInicio = true;
                            salirMenuJapones = true;
                            salirAplicacion = true;
                            break;
                            
                            
//                        case 4: //DESCOMENTAR PARA VER LA LISTA DE TODOS LOS USUARIOS ACTUALES
//                            lectorUsuarios.verContenidoPVR();
//                            metodos.limpiarPantallaEnter();
//                            break;
                            
                        default:
                            System.out.println("Opción invalida");
                            Thread.sleep(1000);
                            metodos.limpiarPantalla();
                            
                    }//FIN SWITCH MENU PRINCIPAL

                } catch (NumberFormatException e) {
                    System.out.println("Debes ingresar un numero!");
                    Thread.sleep(1000);
                    metodos.limpiarPantalla();
                }
            }//FIN WHILE SALIR MENU PRINCIPAL

        }//fIN WHILE SALIR DE LA APLICACION

    }//FIN MAIN

}

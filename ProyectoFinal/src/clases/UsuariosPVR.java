package clases;

import java.io.IOException;
import java.io.Serializable;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Clase Usuarios
 *
 * @author Pablo Villaseñor Ruiz [pvillasenorr01@educastillalamancha.es]
 * @version 1.0
 */
public class UsuariosPVR implements Serializable {

    //Atributos
    private String nombre, contrasenia;

    
    //Constructores
    public UsuariosPVR(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public UsuariosPVR() {
    }

    
    //Getters&Setters
    public String getNombre() {
        return nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + "\nContraseña: " + contrasenia;
    }

    /**
     * Metodo para registrarse en la aplicacion.Comprueba si ya existe,
     * Si no existe lo añade al fichero
     *
     * @param lector
     * @return objeto UsuarioPVR para poder añadirlo al fichero
     * @throws IOException
     */
    public UsuariosPVR registrarse(LectorPVR lector) throws IOException {
        UsuariosPVR usuario;
        Metodos metodos = new Metodos();
        String nombreUsuario, contraseniaUser;
        nombreUsuario = metodos.pedirNombreUsuario(1);

        usuario = (UsuariosPVR) lector.buscaPVR(nombreUsuario);

        if (usuario != null) {
            System.out.println("Este usuario ya se encuentra registrado");

        } else {
            contraseniaUser = metodos.pedirContrasenia(3);
            System.out.println("Usuario registrado correctamente");
            usuario = new UsuariosPVR(nombreUsuario, contraseniaUser);

        }

        return usuario;
    }

    /**
     * Metodo para borrar usuarios.Cuando encuentra el usuario, lo borra de la
     * lista y tambien si tiene alguna criatura la borra
     *
     * @param listaUser
     * @param nombreUsuario
     * @param listaJapo
     */
    public void borrarUsuario(LinkedList<Object> listaUser, String nombreUsuario, LinkedList<Object> listaJapo) {
        ListIterator<Object> iterator = listaJapo.listIterator();
        for (int i = 0; i < listaUser.size(); i++) {
            if (((UsuariosPVR) listaUser.get(i)).getNombre().equals(nombreUsuario)) {
                listaUser.remove(i);
                if (listaJapo != null) {
                    while (iterator.hasNext()) {
                        Object japones = iterator.next();
                        if (((JaponesPVR) japones).getNombreUsuario().equals(nombreUsuario)) {
                            iterator.remove();
                            System.out.println("Se ha eliminado a " + ((JaponesPVR) japones).getNombre());
                        }
                    }

                }

            } else {
                System.out.println("El usuario no tenia criaturas");
            }

        }
        System.out.println("El usuario se ha borrado correctamente");
    }

    /**
     * Metodo que recorre la lista de usuarios segun su nombre y cambia la
     * contrraseña asociada a este usuario
     *
     * @param lista
     * @param nombreUsuario
     * @param contrasenia
     * @param nuevaContrasenia
     * @return Devuelve la lista de usuarios con la contraseña cambiada
     * @throws java.io.IOException
     */
    public LinkedList<Object> cambiarContrasenia(LinkedList<Object> lista, String nombreUsuario, String contrasenia, String nuevaContrasenia) throws IOException {
        //pide la nueva contraseña

        for (int i = 0; i < lista.size(); i++) {
            if (((UsuariosPVR) lista.get(i)).getNombre().equals(nombreUsuario)) {
                if (((UsuariosPVR) lista.get(i)).getContrasenia().equals(contrasenia)) {
                    ((UsuariosPVR) lista.get(i)).setContrasenia(nuevaContrasenia);
                    System.out.println("Tu nueva contraseña es: " + ((UsuariosPVR) lista.get(i)).getContrasenia());
                }
            }
        }

        return lista;
    }

    /**
     * Metodo que valida la contraseña del usuario para acceder a la aplicacion
     *
     * @param lista
     * @param nombreUsuario
     * @param contrasenia
     * @return true si valida false si no
     */
    public boolean validarContrasenia(LinkedList<Object> lista, String nombreUsuario, String contrasenia) {
        boolean valida = false;
        for (int i = 0; i < lista.size(); i++) {
            if (((UsuariosPVR) lista.get(i)).getNombre().equals(nombreUsuario)) {
                if (((UsuariosPVR) lista.get(i)).getContrasenia().equals(contrasenia)) {
                    valida = true;
                }
            }
        }

        return valida;
    }

}

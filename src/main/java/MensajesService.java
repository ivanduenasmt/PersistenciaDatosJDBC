import java.util.Scanner;

/**
 * Es básicamente la clase intermedia, creada paraaccesar a la clase Dao
 * y desde allí unirlo a la clase subsecuente. es el puente de intercomunicación. */
public class MensajesService {

    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Nombre del autor del mensaje");
        String nombre = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensajes(mensaje);
        registro.setAutorMensaje(nombre);

        MensajesDataAccessObject.crearMensajeDb(registro);
    }

    public static void leerMensajes(){
        MensajesDataAccessObject.leerMensajes();

    }

    public static void borrarMensaje(){

    }

    public static void actualizarMensaje(){

    }
}

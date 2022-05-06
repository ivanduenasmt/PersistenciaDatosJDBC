import java.sql.Connection;
import java.util.Scanner;

public class Inicio {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int opcion=0;

        do {
            System.out.println("---------------");
            System.out.println("Aplicación de mensajes");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensajes");
            System.out.println("3. Editar mensaje");
            System.out.println("4. Eliminar mensaje");
            System.out.println("5. Salir");
            opcion = sc.nextInt();

            switch(opcion){
                case 1:
                    MensajesService.crearMensajeDb();
                    break;
                case 2:
                    MensajesService.leerMensajes();
                    break;
                case 3:
                    MensajesService.borrarMensajeDb();
                    break;
                case 4:
                    MensajesService.actualizarMensajeDb();
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }while(opcion != 5);


        /*Conexion conexion = new Conexion();

        try(Connection cnx = conexion.getConnection()) {

        }catch(Exception e){
            System.out.println(e);

        }*/

    }
}

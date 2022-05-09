import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase creada ásicamente para generar los metodos y mi conexión con mi db*/
public class MensajesDataAccessObject {

    /**
     * Descripción: Método creado para crear mensaje. Se inicia instancia la clase conexión, luego try and catch para conectar o no contectar y mostrar la
     * excepción, despues la clase prepared statatement me proporciona métodos para trabajar*/
    public static void crearMensajeDb(Mensajes mensajes){
        Conexion dbConnect = new Conexion();
        try(Connection conexion = dbConnect.getConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajesApp.mensajes(mensajes,autorMensaje) VALUES (?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1,mensajes.getMensajes());
                ps.setString(2,mensajes.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado correctamente");
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void leerMensajes(){
        Conexion dbConnect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try(Connection conexion = dbConnect.getConnection()) {
            String query = "SELECT * FROM mensajesApp.mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println("Id: "+rs.getInt("idmensajes"));
                System.out.println("Mensaje: "+rs.getString("mensajes"));
                System.out.println("autor: "+rs.getString("autorMensaje"));
                System.out.println("fecha: "+rs.getString("fechaMensaje"));
                System.out.println("___________________");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void borrarMensajeDb(Integer idMensaje){

    }

    public static void actualizarMensajeDb(Mensajes mensajes){

    }
}

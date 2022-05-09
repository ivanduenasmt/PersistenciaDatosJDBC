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
                String query = "INSERT INTO mensajesApp.mensajes(mensaje,autorMensaje) VALUES (?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1,mensajes.getMensaje());
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
                System.out.println("Id: "+rs.getInt("idMensaje"));
                System.out.println("Mensaje: "+rs.getString("mensaje"));
                System.out.println("autor: "+rs.getString("autorMensaje"));
                System.out.println("fecha: "+rs.getString("fechaMensaje"));
                System.out.println("___________________");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void borrarMensajeDb(Integer idMensaje){
        Conexion dbConnect = new Conexion();

        try (Connection conexion = dbConnect.getConnection()){
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM mensajesApp.mensajes WHERE idMensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, idMensaje);
                ps.executeUpdate();
                System.out.println("El mensaje ha sido borrado");
            }catch(SQLException e){
                System.out.println(e);
                System.out.println("No se pudo borrar el mensaje");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void actualizarMensajeDb(Mensajes mensajes){
        Conexion dbConnect = new Conexion();
            try (Connection conexion = dbConnect.getConnection()){
            PreparedStatement ps = null;
                try {
                    String query = "UPDATE mensajesApp.mensajes SET mensaje = ? WHERE idMensaje = ?";
                    ps = conexion.prepareStatement(query);
                    ps.setString(1,mensajes.getMensaje());
                    ps.setInt(2,mensajes.getIdMensaje());
                    ps.executeUpdate();
                    System.out.println("El mensaje se actualizó correctamente");
                }catch(SQLException ex){
                    System.out.println(ex);
                    System.out.println("No se pudo actualizar el mensaje");
                }
            }catch(SQLException e){
                System.out.println(e);
            }
        }
    }


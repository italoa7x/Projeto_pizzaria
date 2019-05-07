package ConnectionFactory;

import java.sql.*;

/**
 *
 * @author Italo
 */
public class ConexaoDB {

    private final String USUARIO = "root";
    private final String SENHA = "root";
    private final String URL = "jdbc:mysql://localhost:3306/pp";
    private final String DRIVE = "com.mysql.jdbc.Driver";

    public Connection conectar() {
        try {
            Class.forName(DRIVE);
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("erro ao conectar. " + ex.getMessage());
        }
    }

    public void desconectar(Connection con, PreparedStatement pst) {
        try {
            if (con != null && pst != null) {
                con.close();
                pst.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException("erro ao fechar conexão. " + e.getMessage());
        }
    }

    public void desconectar(Connection con, PreparedStatement pst, ResultSet rs) {
        desconectar(con, pst);
        try {
            if (rs != null) {
                rs.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException("erro ao fechar conexão. " + e.getMessage());
        }
    }

    private ConexaoDB() {

    }

    private static volatile ConexaoDB objConexao;

    public static ConexaoDB instancia() {
        if (objConexao == null) {
            synchronized (ConexaoDB.class) {
                objConexao = new ConexaoDB();
            }
        }
        return objConexao;
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe que faz a conexão com o banco de dados via mysql.
 * **/
public class Conexao {

    private static String url = "jdbc:mysql://localhost:3306/coma_bem";
    private static String user = "developer";
    private static String password = "123456";

    /**
     * Método que retorna a conexão com o banco de dados.
     * **/
    public static Connection getConnection() throws SQLException {
        Connection c = DriverManager.getConnection(url, user, password);
        return c;
    }

    /**
     * Método que fecha a conexão com o banco de dados após as consultas e alterações do mesmo.
     * **/
    public static Connection closeConnetion() throws SQLException {
        Connection c = getConnection();
        c.close();
        return c;
    }
}

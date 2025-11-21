import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    public Connection recuperaConexao() {
        try {
            // Cria o arquivo 'banco_tarefas.db' na pasta do projeto
            return DriverManager.getConnection("jdbc:sqlite:banco_tarefas.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {
    private Connection conexao;

    public TarefaDAO() {
        this.conexao = new ConexaoFactory().recuperaConexao();
        this.criaTabela(); // Garante que a tabela existe ao iniciar
    }

    // Cria a tabela se ela não existir
    private void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS tarefas (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "descricao TEXT)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void salvar(Tarefa tarefa) {
        String sql = "INSERT INTO tarefas (descricao) VALUES (?)";
        try {
            // PreparedStatement evita ataques de SQL Injection
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, tarefa.getDescricao());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Tarefa> listar() {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM tarefas";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                tarefas.add(new Tarefa(id, descricao));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tarefas;
    }
    
    public void deletar(int id) {
        String sql = "DELETE FROM tarefas WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
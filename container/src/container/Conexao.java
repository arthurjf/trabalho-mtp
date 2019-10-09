package container;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {

    // string URL padrão
    // endereço: localhost
    // base de dados: mtp
    private String url = "jdbc:postgresql://localhost/mtp";

    // usuário do postgres
    private String usuario = "postgres";

    // senha do postgres
    private String senha = "fls2802";

    // variável que guarda a conexão
    private Connection conn;

    /**
     * Método construtor.
     *
     * Toda vez que instanciar essa classe, a conexão é automaticamente feita
     */
    public Conexao() {
        conectar();
    }

    /**
     * Método para conexão com o banco de dados.
     *
     * Carrega o driver e cria a conexão com o BD.
     */
    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        Properties props = new Properties();
        props.setProperty("user", this.usuario);
        props.setProperty("password", this.senha);

        try {
            this.conn = DriverManager.getConnection(this.url, props);
        } catch (SQLException e) {
            e.getMessage();
        }

    }

    /**
     * Método que retorna a conexão feita com o BD
     *
     * @return um objeto Connection que é a conexão feita com o BD
     */
    public Connection getConnection() {
        return this.conn;
    }

    /**
     * Método que cria a tabela pessoa para este exemplo.
     *
     * Normalmente, a criação de tabelas NÃO é feita pela aplicação.
     */
    public void criarTabela() {
        try {
            PreparedStatement st = this.conn.prepareStatement("CREATE TABLE pessoa (id serial primary key, nome text)");
            st.execute();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que insere uma pessoa no banco de dados
     *
     * Por enquanto, a pessoa está fixa!
     */
    public void inserircadastro(String email, String senha, String nome, String cidade) throws SQLException {
        PreparedStatement st = this.conn.prepareStatement("INSERT INTO pessoa (email,senha,nome,cidade) VALUES (?,?,?,?)");
        st.setString(1, email);
        st.setString(2, senha);
        st.setString(3, nome);
        st.setString(4, cidade);
        st.executeUpdate();
        st.close();
    }

    /**
     * Método que atualiza todos os nomes do banco de dados
     *
     * E se for necessário alterar para uma pessoa só? O que muda?
     */
    public void atualizar(String nome, String cidade, String senha, Integer id) {
        try {
            PreparedStatement st = this.conn.prepareStatement("UPDATE pessoa SET (nome,cidade,senha) = (?,?,?) WHERE id = ?;");
            st.setString(1, nome);
            st.setString(2, cidade);
            st.setString(3, senha);
            st.setInt(4, id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que exclui uma determinada pessoa do banco de dados
     *
     * Está sempre excluindo a mesma pessoa! A que tem ID = 1!
     */
    public void excluir() {
        try {
            PreparedStatement st = this.conn.prepareStatement("DELETE FROM pessoa WHERE id = ?");
            st.setInt(1, 1);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario login(String email, String senha) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT id, nome, email, senha, cidade FROM pessoa WHERE email = ? AND senha = ?;");

            ps.setString(1, email);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setNome(rs.getString(2));
                usuario.setEmail(rs.getString(3));
                usuario.setSenha(rs.getString(4));
                usuario.setCidade(rs.getString(5));
                return usuario;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}

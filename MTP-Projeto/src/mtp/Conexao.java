package mtp;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Conexao {

    // string URL padrão
    // endereço: localhost
    // base de dados: mtp
    private String url = "jdbc:postgresql://localhost/mtp";

    // usuário do postgres
    private String usuario = "postgres";

    // senha do postgres
    private String senha = "ifg";

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

    /* Método que retorna o usuário da pessoa do banco de dados */
    public Usuario login(String email, String senha) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM pessoa WHERE email = ? AND senha = ?;");
            ps.setString(1, email);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario novoUsuario = new Usuario();
                novoUsuario.setId(rs.getInt(1));
                novoUsuario.setNome(rs.getString(2));
                novoUsuario.setEmail(rs.getString(3));
                novoUsuario.setSenha(rs.getString(4));
                novoUsuario.setCidade(rs.getString(5));
                novoUsuario.setFoto(rs.getBytes(6));
                return novoUsuario;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /* Método que retorna uma ArrayList de posts */
 /*
    public ArrayList<Post> buscarPosts(Usuario novoUsuario) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM pessoa AS pa JOIN post AS po on pa.id = po.id_pessoa ORDER BY po.id DESC FETCH FIRST 10 ROWS ONLY;");
            ResultSet rs = ps.executeQuery();
            ArrayList<Post> newPost = new ArrayList<Post>();
            while (rs.next()) {
                Post tempPost = new Post();
                tempPost.setTexto(rs.getString(8));
                tempPost.setData(rs.getString(10));
                tempPost.setNome(rs.getString(2));
                newPost.add(tempPost);
            }
            return newPost;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }*/
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

    private byte[] pegarImagemPessoa(int idUsuario) {
        try {
            PreparedStatement st = this.conn.prepareStatement("SELECT foto FROM pessoa WHERE id = ?");
            st.setInt(1, idUsuario);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                byte[] binario = rs.getBytes(1);
                InputStream is = new ByteArrayInputStream(binario);
                BufferedImage imag = ImageIO.read(is);
                ImageIcon icon = new ImageIcon(imag);
                return rs.getBytes(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Método que insere uma pessoa no banco de dados
     *
     * Por enquanto, a pessoa está fixa!
     */
    public void inserir() {
        try {
            PreparedStatement st = this.conn.prepareStatement("INSERT INTO pessoa (nome) VALUES (?)");
            st.setString(1, "Thiago");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* Método que insere uma pessoa no banco de dados */
    public void inserirPessoa(String nome, String senha, String cidadeEstado, String email, File imagem) throws SQLException, FileNotFoundException {
        PreparedStatement ps;
        if (imagem == null) {
            ps = this.conn.prepareStatement("INSERT INTO pessoa (nome, email, senha, cidade_estado) values (?, ?, ?, ?);");
        } else {
            FileInputStream fis = new FileInputStream(imagem);
            ps = this.conn.prepareStatement("INSERT INTO pessoa (nome, email, senha, cidade_estado, foto) values (?, ?, ?, ?, ?);");
            ps.setBinaryStream(5, fis, (int) imagem.length());
        }
        ps.setString(1, nome);
        ps.setString(2, email);
        ps.setString(3, senha);
        ps.setString(4, cidadeEstado);
        ps.executeUpdate();
        ps.close();
    }

    /**
     * Método que atualiza todos os nomes do banco de dados
     *
     * E se for necessário alterar para uma pessoa só? O que muda?
     */
    public void atualizar() {
        try {
            PreparedStatement st = this.conn.prepareStatement("UPDATE pessoa SET nome = ?");
            st.setString(1, "Thiago 2");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* Método que cadastra o post criado pelo usuário no banco de dados */
    public void cadastrarPost(String texto, int idPessoa) throws SQLException {
        PreparedStatement st = this.conn.prepareStatement("INSERT INTO post (id_pessoa, texto, data) VALUES (?, ?, now())");
        st.setInt(1, idPessoa);
        st.setString(2, texto);
        st.executeUpdate();
        st.close();
    }

    /* Método que atualiza a pessoa no banco de dados */
    public Usuario atualizarPessoa(String nome, String senha, String cidadeEstado, File imagem, Usuario novoUsuario) throws FileNotFoundException {
        try {
            PreparedStatement st;
            if (imagem == null) {
                st = this.conn.prepareStatement("UPDATE pessoa SET nome = ?, senha = ?, cidade_estado = ? WHERE id = ?");

            } else {
                st = this.conn.prepareStatement("UPDATE pessoa SET nome = ?, senha = ?, cidade_estado = ?, foto = ? WHERE id = ?");
                try {
                    FileInputStream fis = new FileInputStream(imagem);
                    st.setBinaryStream(4, fis, (int) imagem.length());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            st.setString(1, nome);
            st.setString(2, senha);
            st.setString(3, cidadeEstado);
            st.setInt(5, novoUsuario.getId());
            st.executeUpdate();
            st.close();
            Usuario newUser = new Usuario();
            newUser.setNome(nome);
            newUser.setSenha(senha);
            newUser.setCidade(cidadeEstado);
            newUser.setId(novoUsuario.getId());
            newUser.setEmail(novoUsuario.getEmail());
            if (imagem != null) {
                newUser.setFoto(pegarImagemPessoa(newUser.getId()));
            }
            return newUser;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return novoUsuario;
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

}

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
import java.util.GregorianCalendar;
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
    public ArrayList<PostClass> buscarPosts(Usuario novoUsuario) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT pa.nome, po.data, po.texto, po.imagem FROM pessoa AS pa JOIN post AS po on pa.id = po.pessoa_id ORDER BY po.data DESC LIMIT(3);");
            ResultSet rs = ps.executeQuery();
            ArrayList<PostClass> newPost = new ArrayList<PostClass>();
            while (rs.next()) {
                PostClass tempPost = new PostClass();
                tempPost.setTexto(rs.getString(3));
                tempPost.setData(rs.getTimestamp(2));
                tempPost.setNome(rs.getString(1));
                tempPost.setImagem(rs.getBytes(4));
                newPost.add(tempPost);
            }
            return newPost;
        } catch (Exception e) {
            e.getMessage();
            return null;
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

    /* Método que cadastra o post criado pelo usuário no banco de dados */
    public void cadastrarPost(String texto, int idPessoa, File arquivo) throws SQLException, FileNotFoundException {
        PreparedStatement st;
        if (arquivo == null) {
            st = this.conn.prepareStatement("INSERT INTO post (pessoa_id, texto, data) VALUES (?, ?, now())");
        }
        else{
            FileInputStream fis = new FileInputStream(arquivo);
            st = this.conn.prepareStatement("INSERT INTO post (pessoa_id, texto, data, imagem) VALUES (?, ?, now(), ?)");
            st.setBinaryStream(3,fis,(int) arquivo.length());
        }
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

}

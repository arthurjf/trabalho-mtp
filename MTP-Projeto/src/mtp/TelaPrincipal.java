package mtp;

import java.awt.Color;
import java.util.ArrayList;

public class TelaPrincipal extends javax.swing.JFrame {

    private Usuario usuario;

    public TelaPrincipal(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        setLocationRelativeTo(null);
        if (this.usuario.getFoto() != null) {
            TelaCadastro.setTempFotoIcon(this.usuario.getFoto(), jLabel1, 100, 100);
        }
        Conexao conexao = new Conexao();
        conexao.conectar();
        int quantidadePosts = conexao.pegarQuantidadePosts(this.usuario.getId());
        int quantidadePaginas = pegarQuantidadePosts(quantidadePosts);
        labelPagina.setText(paginaAtual + "/" + quantidadePaginas);
        ArrayList<PostClass> posts = conexao.buscarPosts(this.usuario, 0);
        for (int i = 0; i < posts.size(); i++) {
            jPanel3.add(new Post(posts.get(i), this.usuario.getId()));
        }
        jNome.setText("Olá, " + this.usuario.getNome());
        setTitle("Perfil de " + this.usuario.getNome());
    }

    int paginaAtual = 1;

    private void moverPagina(int value) {

    }

    private int pegarQuantidadePosts(int quantidade) {
        float temp = (float) quantidade / 3;
        int novaQuantidade = (int) temp;
        if (temp > (int) temp) {
            novaQuantidade++;
        }
        return novaQuantidade;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jAlterarCadastro = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buttonCriarPost = new javax.swing.JButton();
        jNome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonVoltar = new javax.swing.JButton();
        buttonAvancar = new javax.swing.JButton();
        labelPagina = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jAlterarCadastro.setBackground(new java.awt.Color(0, 0, 255));
        jAlterarCadastro.setForeground(new java.awt.Color(255, 255, 255));
        jAlterarCadastro.setText("Alterar Cadastro");
        jAlterarCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jAlterarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlterarCadastroActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Sair");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mtp/imagens/user_icon100.png"))); // NOI18N

        buttonCriarPost.setBackground(new java.awt.Color(0, 0, 255));
        buttonCriarPost.setForeground(new java.awt.Color(255, 255, 255));
        buttonCriarPost.setText("Criar Post");
        buttonCriarPost.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonCriarPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCriarPostActionPerformed(evt);
            }
        });

        jNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jNome.setText("Olá, %user%");

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(jPanel3);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mtp/imagens/64673 (1).png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Buscar");

        buttonVoltar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonVoltar.setText("<");

        buttonAvancar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonAvancar.setText(">");

        labelPagina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPagina.setText("1/2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(buttonCriarPost)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jAlterarCadastro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jNome)
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(36, 36, 36))))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAvancar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(buttonCriarPost))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jAlterarCadastro))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAvancar)
                    .addComponent(labelPagina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonVoltar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new TelaInicial().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jAlterarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlterarCadastroActionPerformed
        new TelaCadastro(this.usuario).setVisible(true);
        dispose();
    }//GEN-LAST:event_jAlterarCadastroActionPerformed

    private void buttonCriarPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCriarPostActionPerformed
        new NovoPost(this.usuario).setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonCriarPostActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAvancar;
    private javax.swing.JButton buttonCriarPost;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JButton jAlterarCadastro;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jNome;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelPagina;
    // End of variables declaration//GEN-END:variables
}

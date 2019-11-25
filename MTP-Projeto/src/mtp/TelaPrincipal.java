package mtp;

import java.awt.Color;
import java.util.ArrayList;

public class TelaPrincipal extends javax.swing.JFrame {

    private Usuario usuario;

    public TelaPrincipal(Usuario usuario) {
        initComponents();
        MyUtil.setarCorDaJanela(this, new Color(245, 245, 245));
        this.usuario = usuario;
        setTitle("Perfil de " + this.usuario.getNome());
        jNome.setText("Olá, " + this.usuario.getNome());
        setLocationRelativeTo(null);
        if (this.usuario.getFoto() != null) {
            MyUtil.setarImagem(this.usuario.getFoto(), jLabel1, 100, 100);
        }
        buscarPosts();
    }

    /* Método que busca e constrói os posts */
    private void buscarPosts() {
        Conexao conexao = new Conexao();
        conexao.conectar();
        ArrayList<PostClass> posts = conexao.buscarPosts(this.usuario);
        for (int i = 0; i < posts.size(); i++) {
            jPanel3.add(new PanelPost(posts.get(i), this.usuario.getId()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonAlterarCadastro = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buttonCriarPost = new javax.swing.JButton();
        jNome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonAlterarCadastro.setBackground(new java.awt.Color(0, 0, 255));
        buttonAlterarCadastro.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        buttonAlterarCadastro.setForeground(new java.awt.Color(255, 255, 255));
        buttonAlterarCadastro.setText("Alterar Cadastro");
        buttonAlterarCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAlterarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterarCadastroActionPerformed(evt);
            }
        });

        buttonSair.setBackground(new java.awt.Color(0, 0, 255));
        buttonSair.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        buttonSair.setForeground(new java.awt.Color(255, 255, 255));
        buttonSair.setText("Sair");
        buttonSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mtp/imagens/user_icon100.png"))); // NOI18N

        buttonCriarPost.setBackground(new java.awt.Color(0, 0, 255));
        buttonCriarPost.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        buttonCriarPost.setForeground(new java.awt.Color(255, 255, 255));
        buttonCriarPost.setText("Criar Post");
        buttonCriarPost.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonCriarPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCriarPostActionPerformed(evt);
            }
        });

        jNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jNome.setText("Olá, ");

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(jPanel3);

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
                                .addComponent(buttonAlterarCadastro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                                .addComponent(buttonSair)
                                .addGap(23, 23, 23))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jNome)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
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
                            .addComponent(buttonSair)
                            .addComponent(buttonAlterarCadastro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
        new TelaInicial().setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonSairActionPerformed

    private void buttonAlterarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAlterarCadastroActionPerformed
        new TelaCadastro(this.usuario).setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonAlterarCadastroActionPerformed

    private void buttonCriarPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCriarPostActionPerformed
        new NovoPost(this.usuario).setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonCriarPostActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAlterarCadastro;
    private javax.swing.JButton buttonCriarPost;
    private javax.swing.JButton buttonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jNome;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

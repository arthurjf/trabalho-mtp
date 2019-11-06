/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtp;

import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author filip
 */
public class Post extends javax.swing.JPanel {

    /**
     * Creates new form Post
     */
    public Post(PostClass novoPost, int setPessoaId) {
        this.pessoaId = setPessoaId;
        initComponents();
        this.novoPost = novoPost;
        SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        jNome.setText(this.novoPost.getNome());
        jData.setText(sp.format(this.novoPost.getData()));
        jTexto.setText(this.novoPost.getTexto());
        labelLikes.setText(Integer.toString(this.novoPost.getLikes()));
        if (this.novoPost.getImagem() != null) {
            jFoto.setIcon(new ImageIcon(this.novoPost.getImagem()));
        }

    }
    private int pessoaId;

    private PostClass novoPost;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jNome = new javax.swing.JLabel();
        jData = new javax.swing.JLabel();
        jTexto = new javax.swing.JLabel();
        jFoto = new javax.swing.JLabel();
        labelLikes = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jNome.setText("jLabel1");

        jData.setText("jLabel2");

        jTexto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jTexto.setText("jLabel4");
        jTexto.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        labelLikes.setText("likes");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mtp/imagens/qw.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jNome)
                        .addGap(182, 182, 182)
                        .addComponent(jData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(labelLikes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 102, Short.MAX_VALUE))
                    .addComponent(jFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jNome)
                                .addComponent(jData))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelLikes)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFoto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Conexao conexao = new Conexao();
        conexao.conectar();
        conexao.cadastrarLike(this.novoPost, pessoaId);
        JOptionPane.showMessageDialog(null, pessoaId);
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jData;
    private javax.swing.JLabel jFoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jNome;
    private javax.swing.JLabel jTexto;
    private javax.swing.JLabel labelLikes;
    // End of variables declaration//GEN-END:variables
}

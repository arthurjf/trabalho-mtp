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

/**
 *
 * @author filip
 */
public class Post extends javax.swing.JPanel {

    /**
     * Creates new form Post
     */
    public Post(PostClass novoPost) {
        initComponents();
        this.novoPost = novoPost;
        SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        jNome.setText(this.novoPost.getNome());
        jData.setText(sp.format(this.novoPost.getData()));
        jTexto.setText(this.novoPost.getTexto());
        jFoto.setIcon(new ImageIcon(this.novoPost.getImagem()));
    }
    private PostClass novoPost ;
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jNome = new javax.swing.JLabel();
        jData = new javax.swing.JLabel();
        jTexto = new javax.swing.JLabel();
        jFoto = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jNome.setText("jLabel1");

        jData.setText("jLabel2");

        jTexto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jTexto.setText("jLabel4");
        jTexto.setVerticalAlignment(javax.swing.SwingConstants.TOP);

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
                        .addGap(0, 211, Short.MAX_VALUE))
                    .addComponent(jFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNome)
                    .addComponent(jData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFoto)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jData;
    private javax.swing.JLabel jFoto;
    private javax.swing.JLabel jNome;
    private javax.swing.JLabel jTexto;
    // End of variables declaration//GEN-END:variables
}

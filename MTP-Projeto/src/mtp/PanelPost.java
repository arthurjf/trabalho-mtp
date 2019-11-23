package mtp;

import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;

public class PanelPost extends javax.swing.JPanel {

    public PanelPost(PostClass novoPost, int idPessoa) {
        this.idPessoa = idPessoa;
        initComponents();
        this.novoPost = novoPost;
        jNome.setText(this.novoPost.getNome());
        SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        jData.setText("• postou em: " +  sp.format(this.novoPost.getData()));
        jTexto.setText(this.novoPost.getTexto());
        atualizarLikeText();
        if (this.novoPost.getImagem() != null) {
            ImageIcon icon = new ImageIcon(this.novoPost.getImagem());
            Image img = icon.getImage();
            float aspectRatio = (float) icon.getIconWidth() / icon.getIconHeight();
            int novaAltura = (int) ((float) aspectRatio * 300);
            Image newimg = img.getScaledInstance(novaAltura, 300, Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            jFoto.setIcon(newIcon);
        }
    }

    private void atualizarLikeText() {
        labelLikes.setText(Integer.toString(this.novoPost.getLikes()));
    }

    private int idPessoa;

    private PostClass novoPost;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jNome = new javax.swing.JLabel();
        jData = new javax.swing.JLabel();
        jFoto = new javax.swing.JLabel();
        labelLikes = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTexto = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();

        jNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jNome.setText("jLabel1");

        jData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jData.setForeground(new java.awt.Color(130, 130, 130));
        jData.setText("jLabel2");

        jFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        labelLikes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelLikes.setText("likes");
        labelLikes.setToolTipText("Clique aqui para ver quem curtiu este post");
        labelLikes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelLikes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLikesMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mtp/imagens/qw.png"))); // NOI18N
        jLabel1.setToolTipText("Clique aqui para curtir este post");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTexto.setEditable(false);
        jTexto.setColumns(20);
        jTexto.setLineWrap(true);
        jTexto.setRows(5);
        jTexto.setToolTipText("");
        jTexto.setMaximumSize(new java.awt.Dimension(164, 94));
        jScrollPane1.setViewportView(jTexto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                        .addComponent(labelLikes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addComponent(jScrollPane1))
                .addGap(12, 12, 12))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jNome, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jData, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelLikes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFoto)
                .addGap(35, 35, 35)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            conexao.cadastrarLikes(novoPost.getId(), idPessoa);
            this.novoPost.setLikes(this.novoPost.getLikes() + 1);
            atualizarLikeText();
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void labelLikesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLikesMouseClicked
        new TelaLikes(this.novoPost).setVisible(true);
    }//GEN-LAST:event_labelLikesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jData;
    private javax.swing.JLabel jFoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTexto;
    private javax.swing.JLabel labelLikes;
    // End of variables declaration//GEN-END:variables
}

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
        labelNome.setText(this.novoPost.getNome());
        SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        labelData.setText("• postou em: " + sp.format(this.novoPost.getData()));
        labelTexto.setText(this.novoPost.getTexto());
        atualizarLikeText();
        if (this.novoPost.getImagem() != null) {
            MyUtil.redimensionarImagem(this.novoPost.getImagem(), labelFoto, 300);
        }
    }

    /* Método que atualiza o texto da quantidade de likes */
    private void atualizarLikeText() {
        labelLikes.setText(Integer.toString(this.novoPost.getLikes()));
    }

    private int idPessoa;

    private PostClass novoPost;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNome = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
        labelFoto = new javax.swing.JLabel();
        labelLikes = new javax.swing.JLabel();
        labelIcone = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        labelTexto = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();

        setMaximumSize(new java.awt.Dimension(643, 32767));

        labelNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNome.setText("jLabel1");

        labelData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelData.setForeground(new java.awt.Color(130, 130, 130));
        labelData.setText("jLabel2");

        labelFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        labelLikes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelLikes.setText("likes");
        labelLikes.setToolTipText("Clique aqui para ver quem curtiu este post");
        labelLikes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelLikes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLikesMouseClicked(evt);
            }
        });

        labelIcone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mtp/imagens/qw.png"))); // NOI18N
        labelIcone.setToolTipText("Clique aqui para curtir este post");
        labelIcone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelIcone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelIconeMouseClicked(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        labelTexto.setEditable(false);
        labelTexto.setColumns(20);
        labelTexto.setLineWrap(true);
        labelTexto.setRows(5);
        labelTexto.setToolTipText("");
        labelTexto.setMaximumSize(new java.awt.Dimension(164, 94));
        labelTexto.setPreferredSize(null);
        jScrollPane1.setViewportView(labelTexto);

        jSeparator1.setForeground(new java.awt.Color(121, 121, 121));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(labelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                        .addComponent(labelLikes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelData, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelLikes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelFoto)
                .addGap(35, 35, 35)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void labelIconeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconeMouseClicked
        Conexao conexao = new Conexao();
        conexao.conectar();
        try {
            conexao.cadastrarLikes(novoPost.getId(), idPessoa);
            this.novoPost.setLikes(this.novoPost.getLikes() + 1);
            atualizarLikeText();
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_labelIconeMouseClicked

    private void labelLikesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLikesMouseClicked
        new TelaLikes(this.novoPost).setVisible(true);
    }//GEN-LAST:event_labelLikesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelFoto;
    private javax.swing.JLabel labelIcone;
    private javax.swing.JLabel labelLikes;
    private javax.swing.JLabel labelNome;
    private javax.swing.JTextArea labelTexto;
    // End of variables declaration//GEN-END:variables
}

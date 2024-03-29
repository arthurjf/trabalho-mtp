package mtp;

import java.awt.Color;
import java.text.SimpleDateFormat;

public class PanelLikes extends javax.swing.JPanel {

    public PanelLikes(PostClass pessoa) {
        initComponents();
        setBackground(Color.white);
        labelNome.setText(pessoa.getNome());
        SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        labelData.setText("Curtiu o post em: " + sp.format(pessoa.getData()));
        if (pessoa.getImagem() != null) {
            MyUtil.setarImagem(pessoa.getImagem(), labelFoto, 139, 139);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelFoto = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setText("jLabel2");

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(519, 165));

        labelFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mtp/imagens/user_icon.png"))); // NOI18N

        labelNome.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        labelNome.setText("Nome");

        labelData.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        labelData.setForeground(new java.awt.Color(91, 91, 91));
        labelData.setText("Curtiu o post em: 00/00/0000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelFoto)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNome)
                    .addComponent(labelData))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelFoto)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelNome)
                        .addGap(18, 18, 18)
                        .addComponent(labelData)
                        .addGap(57, 57, 57))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelFoto;
    private javax.swing.JLabel labelNome;
    // End of variables declaration//GEN-END:variables
}

package mtp;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyUtil {

    /* Método que muda a cor de uma janela */
    public static void setarCorDaJanela(JFrame janela, Color cor) {
        janela.getContentPane().setBackground(cor);
    }

    /* Método que seta uma imagem em uma label */
    public static void setarImagem(byte[] foto, JLabel labelDaFoto, int Largura, int Altura) {
        ImageIcon icon = new ImageIcon(foto);
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(Largura, Altura, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);
        labelDaFoto.setIcon(newIcon);
    }

    /* Método que seta e redimensiona uma imagem em uma label */
    public static void redimensionarImagem(byte[] foto, JLabel labelDaFoto, int novaLargura) {
        ImageIcon icon = new ImageIcon(foto);
        Image img = icon.getImage();
        float aspectRatio = (float) icon.getIconWidth() / icon.getIconHeight();
        int novaAltura = (int) ((float) aspectRatio * novaLargura);
        Image newimg = img.getScaledInstance(novaAltura, novaLargura, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);
        labelDaFoto.setIcon(newIcon);
    }

    /* Método que filtra um arquivo, verificando se é extensão de imagem */
    public static void filtrarArquivoParaImagem(File novoArquivo) throws Exception {
        if (novoArquivo.getName().toLowerCase().endsWith(".png") || novoArquivo.getName().toLowerCase().endsWith(".jpg") || novoArquivo.getName().toLowerCase().endsWith(".bmp")) {
            return;
        } else {
            throw new Exception();
        }
    }

}

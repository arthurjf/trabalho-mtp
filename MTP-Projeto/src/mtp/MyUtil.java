package mtp;

import java.awt.Color;
import java.io.File;
import javax.swing.JFrame;

public class MyUtil {

    public static void setarCorDaJanela(JFrame janela, Color cor) {
        janela.getContentPane().setBackground(cor);
    }

    public static void filtrarArquivoParaImagem(File novoArquivo) throws Exception {
        if (novoArquivo.getName().toLowerCase().endsWith(".png") || novoArquivo.getName().toLowerCase().endsWith(".jpg") || novoArquivo.getName().toLowerCase().endsWith(".bmp")) {
            return;
        } else {
            throw new Exception();
        }
    }

}

package mtp;

import java.io.File;

public class MyUtil {

    public static void filtrarArquivoParaImagem(File novoArquivo) throws Exception {
        if (novoArquivo.getName().toLowerCase().endsWith(".png") || novoArquivo.getName().toLowerCase().endsWith(".jpg") || novoArquivo.getName().toLowerCase().endsWith(".bmp")) {
            return;
        } else {
            throw new Exception();
        }
    }

}

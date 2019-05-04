package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class documentUtil {

    public static File Ecrire(String name, byte[] contents) throws IOException {
        File file = new File(RepRacineFile(), name);

        OutputStream out = new FileOutputStream(file);
        out.write(contents);
        out.close();

        return file;
    }

    public static List<File> Liste() {
        File dir =RepRacineFile();

        return Arrays.asList(dir.listFiles());
    }

    public static java.io.File RepRacineFile() {
        File dir = new File(RepertoirRacine(), "document");

        if (!dir.exists()) {
            dir.mkdirs();
        }

        return dir;
    }
    
    public static File RepertoirRacine() {
        // Estamos utilizando um diretório dentro da pasta temporária. 
        // No seu projeto, imagino que queira mudar isso para algo como:
        // File dir = new File(System.getProperty("user.home"), "algaworks");
        File dir = new File(System.getProperty("java.io.tmpdir"), "algaworks");

        if (!dir.exists()) {
            dir.mkdirs();
        }

        return dir;
    }
}
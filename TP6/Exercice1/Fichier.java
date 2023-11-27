package Exercice1;

import java.io.File;
import java.io.IOException;

public class Fichier {
    private String path;

    public Fichier(String path){
        this.path = path;
    }

    public String typeFile(File f){
        if (f.isFile()) {
            return "<FICH>";
        }
        return "<DIR>";
    }

    public String modeAcces(File f){
        String access = "";
        if (f.canRead()) {
            access += "r";
        }
        else {
            access += "-";
        }
        if (f.canWrite()) {
            access += "w";
        }
        else {
            access += "-";
        }
        if (f.isHidden()){
            access += "h";
        }
        else {
            access += "-";
        }
        return access;
    }

    public void getFilesList() throws IOException {
        File f = new File(this.path);
        for (File file : f.listFiles()) {
            System.out.println(file.getAbsolutePath() + " " + typeFile(f) + " " + modeAcces(file));
        }
    }
}

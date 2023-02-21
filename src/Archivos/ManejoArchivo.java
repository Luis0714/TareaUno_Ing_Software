package Archivos;

import java.io.File;
import java.util.ArrayList;

public class ManejoArchivo {
    private String ruta;

    public ManejoArchivo(String ruta){
        this.ruta = ruta;
    }

    /**
     * Obtiene los archivos de la carpeta
     * @return archivos
     */
    public ArrayList<File> obtenerArchivos() throws NullPointerException{
        File folder = new File(this.ruta);

        if(!folder.exists()){
            throw new NullPointerException("No se encuentra la carpeta indicada");
        }

        File[] archivosEncontrados = folder.listFiles();
        ArrayList<File> archivos = new ArrayList<>();

        for (File file : archivosEncontrados) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                archivos.add(file);
            }
        }
        if (archivos.size() == 0){
            throw new NullPointerException("No se encontraron archivos de texto en la carpeta");
        }
        return  archivos;
    }
}

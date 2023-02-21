package Logica;

import Archivos.ManejoArchivo;
import Entidades.ArchivoResumen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LogicaArchivo {
    private String ruta;
    private ManejoArchivo manejoArchivo;

    public LogicaArchivo(String ruta) {
        this.ruta = ruta;
        this.manejoArchivo = new ManejoArchivo(this.ruta);
    }

    public int obtenerCantiadadTotalVecesPalabraEnArchivos(String palabraBuscar){
        ArrayList<ArchivoResumen> resumenArchivos = this.ObtenerResumenArchivos(palabraBuscar);
        int catidad = 0;

        for (ArchivoResumen resumenArchivo: resumenArchivos) {
            System.out.println(resumenArchivo);
            catidad += resumenArchivo.getCatidad();
        }
       return catidad;
    }

    public ArrayList<ArchivoResumen> ObtenerResumenArchivos(String palabraBuscar){
        ArrayList<ArchivoResumen> resumenArchivos = new ArrayList<>();
        try {
            ArrayList<File> archivos = this.manejoArchivo.obtenerArchivos();
            
            for (File archivo : archivos) {

                    String textoArchivo = this.leerArchivo(archivo);
                    textoArchivo = textoArchivo.toUpperCase();
                    palabraBuscar = palabraBuscar.toUpperCase();

                    int cantidad = this.obtenerCantiadadVecesPalabraEnArchivo(textoArchivo, palabraBuscar);
                    resumenArchivos.add(new ArchivoResumen(archivo.getName(),cantidad));

                }
        }catch (NullPointerException | IOException exception){
            System.out.println(exception.getMessage());
        }
        return resumenArchivos;
    }

   private int obtenerCantiadadVecesPalabraEnArchivo(String textoArchivo,String palabraBuscar){
       StringTokenizer token = new StringTokenizer(textoArchivo);
       int catidad = 0;
       while(token.hasMoreTokens()) {
           if(token.nextElement().equals(palabraBuscar)) {
               catidad++;
           }
       }
       return catidad;
   }
   private String leerArchivo(File archivo) throws  IOException{
       String texto = "";
       try (FileReader fileReader = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
               texto += line;
               line = bufferedReader.readLine();
           }

       } catch (IOException e) {
          throw  new IOException("Error al leer archivo");
       }
       return texto;
   }


}

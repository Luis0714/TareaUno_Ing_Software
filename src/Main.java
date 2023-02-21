import Logica.LogicaArchivo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese la ruta: ");
        String ruta = lector.nextLine();
        System.out.print("Ingrese la palabra a buscar: ");
        String palabra = lector.nextLine();

        LogicaArchivo logicaArchivo = new LogicaArchivo(ruta);
        int cantidad = logicaArchivo.obtenerCantiadadTotalVecesPalabraEnArchivos(palabra);
        System.out.println("Cantidad: "+cantidad);
    }
}
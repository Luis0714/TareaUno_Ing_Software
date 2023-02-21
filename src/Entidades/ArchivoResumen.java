package Entidades;

public class ArchivoResumen {
    private String nombre;
    private int catidad;

    public ArchivoResumen(String nombre, int catidad) {
        this.nombre = nombre;
        this.catidad = catidad;
    }

    public int getCatidad() {
        return catidad;
    }

    @Override
    public String toString() {
        return "Archivo{" +
                "nombre='" + nombre + '\'' +
                ", catidad=" + catidad +
                '}';
    }
}

import java.util.ArrayList;

public class Tienda {

    ArrayList<Videojuego> stock = new ArrayList<>();

    // Método que tedevuelva todos los videojuegos a partir de una fecha de lanzamiento.

    public ArrayList<Videojuego> juegosLanzamiento(Fecha fecha){
        ArrayList<Videojuego> lanzamiento = new ArrayList<>();
        for (Videojuego v: stock){
            if (v.lanzamiento.after(fecha) || v.lanzamiento.equals(fecha)){
                lanzamiento.add(v);
            }
        }
        return lanzamiento;
    }

    public void agregar(Videojuego v){
        stock.add(v);
    }
}

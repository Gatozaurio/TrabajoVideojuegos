import java.util.ArrayList;

public class Director {

    String nombre;
    public ArrayList<Videojuego> games = new ArrayList<>();

    public Director(String nombre) {
        this.nombre = nombre;
    }


    public void agregar(Videojuego v){
        games.add(v);
    }
}

import java.util.ArrayList;

public class Consola {

    String nombre;
    ArrayList<Videojuego> juegosCompatibles = new ArrayList<>();

    // Método que te indique si una consola tiene videojuegos del mismo género del videojuego devuelto.
    public boolean tieneGenero(Videojuego game){
        for (Videojuego v: juegosCompatibles){
            if (v.genero.equals(game.genero) && !v.nombre.equals(game.nombre)){
                return true;
            }
        }
        return false;
    }

    public boolean diversidad(){
        int count = 0;
        ArrayList<Videojuego> categorias = new ArrayList<>();
        Videojuego aux;
        for (int i = 0; i < juegosCompatibles.size(); i++){
            for (int a = 0; a < juegosCompatibles.size();a++){
            if (!juegosCompatibles.get(i).genero.equals(juegosCompatibles.get(a).genero) && !categorias.contains(juegosCompatibles.get(a))){
             count++;
             categorias.add(juegosCompatibles.get(a));
            }
        }
        }
        if (count>=10){
            return true;
        }
        else{
           return false;
            }
    }

    // Método que devuelve otro juego del mismo director, sino, devuelve null
    public Videojuego buscarJuego(Videojuego game) {
        for (Videojuego v: juegosCompatibles){
            if (v.director.equals(game.director) && !v.nombre.equals(game.nombre)){
                return v;
            }
        }
        return null;
    }

    // Método que devuelva los videojuegos con un título entre 5 y 10 caracteres.
    public ArrayList<Videojuego> shortNames(){
        ArrayList<Videojuego> juegosEntre5Y10 = new ArrayList<>();
        for (Videojuego v: juegosCompatibles){
            if (v.nombre.length()>=5 && v.nombre.length()<=10){
                juegosEntre5Y10.add(v);
            }
        }
        if (juegosEntre5Y10.isEmpty()){
            return null;
        }
        return juegosEntre5Y10;

    }

    public Consola(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(Videojuego v){
        juegosCompatibles.add(v);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
public class Videojuego {

    String nombre;
    String genero;
    Director director;
    Fecha lanzamiento;

    public Videojuego(String nombre,String genero, Director director, Fecha lanzamiento) {
        this.nombre = nombre;
        this.genero = genero;
        this.director = director;
        this.lanzamiento = lanzamiento;
    }

    // Método que si le indicas un género y un creador a un videojuego te indique si es o no de ese género y si pertenece a ese director
    public void esGeneroYDirector(String gen, Director dic){
        if (genero.equals(gen) && director.equals(dic)){
            System.out.println("Es del mismo genero y del mismo director");
        }
        if (!genero.equals(gen) && director.equals(dic)){
            System.out.println("No es del mismo genero, pero si es del mismo director");
        }
        if (genero.equals(gen) && !director.equals(dic)){
            System.out.println("Es del mismo genero, pero no es del mismo director");
        }
        if (!genero.equals(gen) && !director.equals(dic)){
            System.out.println("No es ni del mismo genero, ni del mismo director");
        }
    }

    // Método que compara si dos videojuegos son iguales.

    public boolean comparar(Videojuego v){
        if (this.equals(v)) return true;
        return false;
    }

    public long getTiempoLanzamiento(Fecha fechaActual){
        long actual = fechaActual.getTimeInMillis()/1000;
        long lanzamiento = getLanzamiento().getTimeInMillis()/1000;
        return (((actual-lanzamiento)/3600)/8760);
    }


    public Fecha getLanzamiento() {
        return lanzamiento;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

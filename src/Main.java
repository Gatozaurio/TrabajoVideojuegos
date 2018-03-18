public class Main {
    public static void main(String[] args) {
        Director d1 = new Director("Pepe");
        Director d2 = new Director("Cabesa");
        Fecha f1 = new Fecha(17,4,2018);
        Fecha f2 = new Fecha(18,4,2018);
        Videojuego v1 = new Videojuego("CSGOOO","FPS", d2,f2);
        Videojuego v2 = new Videojuego("Gambisimaaaaa","GambaForce", d1, f2);
        Videojuego v3 = new Videojuego("TF2","FPS", d1,f2);
        Videojuego v4 = new Videojuego("Gambisimaaaaa 2","GambaForce", d1, f2);
        Consola c1 = new Consola("PepeGameX");
        c1.agregar(v1);
        c1.agregar(v2);
        c1.agregar(v3);
        c1.agregar(v4);
        c1.tieneGenero(v1);
        c1.shortNames();
    }
}

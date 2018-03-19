import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TieneGeneroTest {

    static Consola consolaConJuego;
    static Consola consolaSinJuego;
    static Consola consolaConMismoJuego;
    static Videojuego juegoAComparar;
    static int contador = 0;

    @BeforeAll
    static void prepararTestAll(){
        Director d1 = new Director ("Pepe");
        Fecha f1 = new Fecha();

        consolaConJuego = new Consola("Consola con juego del mismo género");
        consolaSinJuego = new Consola("Consola sin juego del mismo género");
        consolaConMismoJuego = new Consola("Consola con el mismo juego que el introducido");
        juegoAComparar = new Videojuego("Juego a comparar", "Rol", d1, f1);
        Videojuego videojuegoMismoGenero = new Videojuego("Juego2", "Rol", d1, f1);
        Videojuego videojuegoDistintoGenero = new Videojuego("Juego3", "RTS", d1, f1);

        consolaConJuego.agregar(videojuegoMismoGenero);
        consolaConJuego.agregar(videojuegoDistintoGenero);
        consolaSinJuego.agregar(videojuegoDistintoGenero);
        consolaConMismoJuego.agregar(juegoAComparar);
    }

    @BeforeEach
    void imprimirObjetos (){
        System.out.println("Elementos a probar:\n"
                + consolaConJuego + "\n"
                + consolaSinJuego + "\n"
                + consolaConMismoJuego + "\n"
                + juegoAComparar + "\n");
    }

    @AfterEach
    void contador (){
        System.out.println( "Pruebas realizadas: " + ++contador + "\n");
    }

    @AfterAll
    static void  hacerNull (){
        consolaConJuego = null;
        consolaSinJuego = null;
        consolaConMismoJuego = null;
        juegoAComparar = null;
    }

    /**
     * Se comprueba el resultado de consultar una consola con un videojuego del mismo género
     */
    @DisplayName("Test1: La consola tiene un juego del mismo género")
    @Test
    public void consolaTieneGenero (){
        assertTrue(consolaConJuego.tieneGenero(juegoAComparar));
    }

    /**
     * Se comprueba el resultado de consultar una consola con un videojuego de distinto género
     */
    @DisplayName("Test2: La consola no tiene un juego del mismo género")
    @Test
    public void consolaNoTieneGenero (){
        assertFalse(consolaSinJuego.tieneGenero(juegoAComparar));
    }

    /**
     * Se comprueba el resultado de consultar una consola con el mismo videojuego
     */
    @DisplayName("Test3: La consola tiene el mismo juego")
    @Test
    public void mismoJuego (){
        assertFalse(consolaConMismoJuego.tieneGenero(juegoAComparar));
    }


}
import org.junit.jupiter.api.*;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNull;

class BuscarJuegoTest {

    static Consola consolaConJuego;
    static Consola consolaSinJuego;
    static Consola consolaConMismoJuego;
    static Videojuego juegoAComparar;
    static Videojuego juegoNull;
    static int contador = 0;


    @BeforeAll
    static void prepararTestAll(){
        Director mismoDirector = new Director ("Pepe");
        Director distintoDirector = new Director ("Manolete");
        Fecha f1 = new Fecha();

        consolaConJuego = new Consola("Consola con juego del mismo director");
        consolaSinJuego = new Consola("Consola sin juego del mismo director");
        consolaConMismoJuego = new Consola("Consola con el mismo juego que el introducido");
        juegoAComparar = new Videojuego("Juego a comparar", "Rol", mismoDirector, f1);
        juegoNull = null;

        Videojuego videojuegoMismoDirector = new Videojuego("Juego2", "RTS", mismoDirector, f1);
        Videojuego videojuegoDistintoDirector = new Videojuego("Juego3", "Rol", distintoDirector, f1);

        consolaConJuego.agregar(videojuegoMismoDirector);
        consolaConJuego.agregar(videojuegoDistintoDirector);
        consolaSinJuego.agregar(videojuegoDistintoDirector);
        consolaConMismoJuego.agregar(juegoAComparar);
    }

    @BeforeEach
     void imprimirObjetos (){
        System.out.println("Elementos a probar:\n"
                + consolaConJuego + "\n"
                + consolaSinJuego + "\n"
                + juegoAComparar + "\n"
                + juegoNull + "\n");
    }

    @AfterEach
    void contador (){
        System.out.println( "Pruebas realizadas: " + ++contador + "\n");
    }

    @AfterAll
    static void  hacerNull (){
        consolaConJuego = null;
        consolaSinJuego = null;
        juegoAComparar = null;
        juegoNull = null;
    }

    /**
     * Se comprueba el resultado de consultar una consola con un videojuego del mismo director
     */
    @DisplayName("Test1: La consola tiene un videojuego del mismo director")
    @Test
    public void consolaTieneVideojuego (){
        assertNotNull(consolaConJuego.buscarJuego(juegoAComparar));
    }

    /**
     * Se comprueba el resultado de consultar una consola con un videojuego de distinto director
     */
    @DisplayName("Test2: La consola no tiene un videojuego del mismo director")
    @Test
    public void consolaNoTieneVideojuego (){
        assertNull(consolaSinJuego.buscarJuego(juegoAComparar));
    }

    /**
     * Se comprueba el resultado de consultar una consola con el mismo videojuego
     */
    @DisplayName("Test3: La consola tiene el mismo juego")
    @Test
    public void mismoJuego (){
        assertNull(consolaConMismoJuego.buscarJuego(juegoAComparar));
    }

}



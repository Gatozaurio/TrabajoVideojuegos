import org.junit.jupiter.api.*;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

class TieneGeneroTest {

    static Consola consolaConJuego;
    static Consola consolaSinJuego;
    static Consola consolaConMismoJuego;
    static Videojuego juegoAComparar;
    static Videojuego juegoNull;
    static int contador = 0;

    @BeforeAll
    static void prepararTestAll(){
        Director d1 = new Director ("Pepe");
        Fecha f1 = new Fecha();

        consolaConJuego = new Consola("Consola con juego del mismo género");
        consolaSinJuego = new Consola("Consola sin juego del mismo género");
        consolaConMismoJuego = new Consola("Consola con el mismo juego que el introducido");
        juegoAComparar = new Videojuego("Juego a comparar", "Rol", d1, f1);
        juegoNull = null;

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
        consolaConMismoJuego = null;
        juegoAComparar = null;
        juegoNull = null;
    }

    @DisplayName("Test1: La consola tiene un juego del mismo género")
    @Test
    public void consolaTieneGenero (){
        assertTrue(consolaConJuego.tieneGenero(juegoAComparar));
    }

    @DisplayName("Test2: La consola no tiene un juego del mismo género")
    @Test
    public void consolaNoTieneGenero (){
        assertFalse(consolaSinJuego.tieneGenero(juegoAComparar));
    }

    @DisplayName("Test3: La consola tiene el mismo juego")
    @Test
    public void mismoJuego (){
        assertFalse(consolaConMismoJuego.tieneGenero(juegoAComparar));
    }

    // No furula
    @DisplayName("Test4: Juego null introducido")
    @Test
    public void VideojuegoNullIntroducido (){
        assertNull(consolaConJuego.buscarJuego(juegoNull));
    }
}
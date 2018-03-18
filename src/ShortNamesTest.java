import org.junit.jupiter.api.*;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNull;

class ShortNamesTest {
    static Consola consola4caracteres;
    static Consola consola5caracteres;
    static Consola consola10caracteres;
    static Consola consola11caracteres;
    static Consola consolaVacia;
    static Consola consolaConJuegoNull;
    static Videojuego videojuego4caracteres;
    static Videojuego videojuego5caracteres;
    static Videojuego videojuego10caracteres;
    static Videojuego videojuego11caracteres;
    static Videojuego videojuegoNull;
    static int contador = 0;


    @BeforeAll
    static void prepararTestAll(){
        Director d1 = new Director ("Pepe");
        Fecha f1 = new Fecha();

        consola4caracteres = new Consola("Consola con un juego de 4 caracteres");
        consola5caracteres = new Consola("Consola con un juego de 5 caracteres");
        consola10caracteres = new Consola("Consola con un juego de 10 caracteres");
        consola11caracteres = new Consola("Consola con un juego de 11 caracteres");
        consolaVacia = new Consola("Consola sin juegos");
        consolaConJuegoNull = new Consola("Consola con un juego null");

        videojuego4caracteres = new Videojuego("1234", "Rol", d1, f1);
        videojuego5caracteres = new Videojuego("12345", "Rol", d1, f1);
        videojuego10caracteres = new Videojuego("1234567890", "Rol", d1, f1);
        videojuego11caracteres = new Videojuego("12345678901", "Rol", d1, f1);
        videojuegoNull = null;

        consola4caracteres.agregar(videojuego4caracteres);
        consola5caracteres.agregar(videojuego5caracteres);
        consola10caracteres.agregar(videojuego10caracteres);
        consola11caracteres.agregar(videojuego11caracteres);
    }

    @BeforeEach
    void imprimirObjetos (){
        System.out.println("Elementos a probar:\n"
                + consola4caracteres + "\n"
                + consola5caracteres + "\n"
                + consola10caracteres + "\n"
                + consola11caracteres + "\n"
                + videojuego4caracteres + "\n"
                + videojuego5caracteres + "\n"
                + videojuego10caracteres + "\n"
                + videojuego11caracteres + "\n");
    }

    @AfterEach
    void contador (){
        System.out.println( "Pruebas realizadas: " + ++contador + "\n");
    }

    @AfterAll
    static void  hacerNull (){
        consola4caracteres = null;
        consola5caracteres = null;
        consola10caracteres = null;
        consola11caracteres = null;
        consolaVacia = null;
        videojuego4caracteres = null;
        videojuego5caracteres = null;
        videojuego10caracteres = null;
        videojuego11caracteres = null;
    }

    @DisplayName("Test1: La consola tiene un videojuego de 4 caracteres")
    @Test
    public void videojuego4caracteres (){
        assertNull(consola4caracteres.shortNames());
    }

    @DisplayName("Test2: La consola tiene un videojuego de 5 caracteres")
    @Test
    public void videojuego5caracteres (){
        assertNotNull(consola5caracteres.shortNames());
    }

    @DisplayName("Test3: La consola tiene un videojuego de 10 caracteres")
    @Test
    public void videojuego10caracteres (){
        assertNotNull(consola10caracteres.shortNames());
    }

    @DisplayName("Test4: La consola tiene un videojuego de 11 caracteres")
    @Test
    public void videojuego11caracteres (){
        assertNull(consola11caracteres.shortNames());
    }

    @DisplayName("Test5: Consola sin juegos")
    @Test
    public void consolaVacia (){
        assertNull(consolaVacia.shortNames());
    }

    @DisplayName("Test6: Consola con juego null")
    @Test
    public void videojuegoNull (){
        assertNull(consolaConJuegoNull.shortNames());
    }
}
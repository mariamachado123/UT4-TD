import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestABB{
    private static TArbolBB<Integer> arbol;
    @BeforeEach
    public void setUp(){
        arbol = new TArbolBB<>();
        arbol.insertar(1, 1);
        arbol.insertar(2, 2);
        arbol.insertar(3, 3);
        arbol.insertar(4, 4);
        arbol.insertar(5, 5);

    }
    @Test
    public void testMenorClave(){
        assertEquals(1,arbol.menorClaveABB());
        System.out.println( "MENOR CLAVE: " + arbol.menorClaveABB());
    }

    @Test
    public void testMaxClave(){
        assertEquals(5,arbol.maxClaveABB());
        System.out.println( "MAX CLAVE: " + arbol.maxClaveABB());
    }

    @Test
    public void testClaveAnterior(){
        assertEquals(3,arbol.claveAnteriorABB(new TElementoABB(4)));
        System.out.println( "CLAVE ANTERIOR: " + arbol.claveAnteriorABB(new TElementoABB(5)));
    }
    @Test
    public void testContNiveles(){
        TArbolBB<Integer> arbol2 = new TArbolBB<>();
        arbol2.insertar(4, 4);
        arbol2.insertar(2, 2);
        arbol2.insertar(1, 1);
        arbol2.insertar(5, 5);
        arbol2.insertar(6, 6);
        arbol2.insertar(7, 7);
        int cantNivel2=arbol2.contNivelesABB(2);
        assertEquals(2,cantNivel2);
        System.out.println( "NIVEL 2: " + cantNivel2);
    }
    @Test
    public void testCantHojas(){
        assertEquals(1,arbol.cantHojasABB());
    }
    @Test
    public void testVerificarABB(){
        TArbolBB<Integer> arbol2 = new TArbolBB<>();
        arbol2.insertar(4, 4);
        arbol2.insertar(2, 2);
        arbol2.insertar(1, 1);
        arbol2.insertar(5, 5);
        arbol2.insertar(6, 6);
        arbol2.insertar(7, 7);
        assertTrue(arbol2.verificarABB());
        System.out.println( "VERIFICAR ABB: " + arbol2.verificarABB());
    }

}

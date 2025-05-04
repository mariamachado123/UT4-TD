import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestMetodos {
    private static TArbolBB arbol;
    @BeforeEach
    public void setUp(){
        arbol = new TArbolBB();
        arbol.insertar(new TElementoABB(4));
        arbol.insertar(new TElementoABB(2));
        arbol.insertar(new TElementoABB(1));
        arbol.insertar(new TElementoABB(5));
        arbol.insertar(new TElementoABB(6));
        arbol.insertar(new TElementoABB(7));
    }

    @Test
    public void testCantHojas(){
        assertEquals(2,arbol.cantHojas());
    }

    @Test
    public void testNivel(){
        assertEquals(3,arbol.Nivel(6));
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ABB<String> arbol = new ABB<>();

        arbol.insertar(10, "Raíz");
        arbol.insertar(5, "Izquierda");
        arbol.insertar(15, "Derecha");
        arbol.insertar(3, "Nieto izquierdo");
        arbol.insertar(7, "Nieto derecho");
        arbol.hojas();
        arbol.sumaDeClavesDelArbol();
        System.out.println("Nodos en nivel 1: " + arbol.cantNodos(null, 1, 0));



    }
    }

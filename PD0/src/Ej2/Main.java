package Ej2;

import Ej1.TArbolABB;
import Ej1.TElementoABB;

public class Main {
    public static void main(String[] args) {
        ConstructorArbolPrefijo constructor = new ConstructorArbolPrefijo();
        String[] expresion2 = ConstructorArbolPrefijo.convertirExpresion("+ 1 * 2 - 3 4");
        probarExpresion(constructor, expresion2); // Result -1

        String[] expresion3 = ConstructorArbolPrefijo.convertirExpresion("/ * + 1 2 - 3 4 5");
        probarExpresion(constructor, expresion3); // Result 0
    }

    private static void probarExpresion(ConstructorArbolPrefijo constructor,
                                        String[] expresion,
                                        String... variables) {
        System.out.println("Probando expresión: " + String.join(" ", expresion));

        TElementoABB raiz = constructor.construirArbol(expresion);
        if (raiz == null) {
            System.out.println("No se pudo construir el árbol");
            return;
        }

        TArbolABB arbol = new TArbolABB();
        arbol.setRaiz(raiz);
        arbol.imprimir();

        if (variables.length > 0) {
            for (int i = 0; i < variables.length; i += 2) {
                String var = variables[i];
                int valor = Integer.parseInt(variables[i+1]);
                System.out.println("Sustituyendo " + var + " = " + valor);
                arbol.sustituirVariable(var, valor);
            }
        }

        int resultado = arbol.evaluar();
        System.out.println("Resultado: " + resultado);
    }
}
package Ej1;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {

        TElementoABB x = new TElementoABB("x");
        TElementoABB tres = new TElementoABB(3);
        TElementoABB cinco = new TElementoABB(5);
        TElementoABB y = new TElementoABB("y");

        TElementoABB multiplicacion = new TElementoABB("*");
        multiplicacion.setIzquierda(x);
        multiplicacion.setDerecha(tres);

        TElementoABB division = new TElementoABB("/");
        division.setIzquierda(cinco);
        division.setDerecha(y);

        TElementoABB suma = new TElementoABB("+");
        suma.setIzquierda(multiplicacion);
        suma.setDerecha(division);

        TArbolABB arbol = new TArbolABB();
        arbol.setRaiz(suma);


        arbol.sustituirVariable("x", 4);
        arbol.sustituirVariable("y", 2);


        int resultado = arbol.evaluar();
        System.out.println("El resultado es: " + resultado);


    }
}

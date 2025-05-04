package Ej1;

public class TArbolABB {
    private TElementoABB raiz;

    public TArbolABB() {
        raiz = null;
    }

    public void setRaiz(TElementoABB raiz) {
        this.raiz = raiz;
    }

    public void sustituirVariable(String variable, int valor) {
        if (raiz != null) {
            raiz.sustituirVariable(variable, valor);
        } else {
            System.err.println("Advertencia: No se puede sustituir en árbol vacío");
        }
    }

    public int evaluar() {
        if (raiz == null) {
            System.err.println("Error: Árbol vacío");
            return 0;
        }
        return raiz.evaluar();
    }

    public void imprimir() {
        if (raiz != null) {
            System.out.println("Estructura del árbol:");
            raiz.imprimir(0);
        } else {
            System.out.println("Árbol vacío");
        }
    }
}
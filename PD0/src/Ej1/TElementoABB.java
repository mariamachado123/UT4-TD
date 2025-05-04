package Ej1;

public class TElementoABB {
    private Object valor;
    private TElementoABB izquierda;
    private TElementoABB derecha;

    public TElementoABB(Object dato) {
        this.valor = dato;
        this.izquierda = null;
        this.derecha = null;
    }

    public Object getValor() {
        return valor;
    }

    public void setIzquierda(TElementoABB izquierda) {
        this.izquierda = izquierda;
    }

    public void setDerecha(TElementoABB derecha) {
        this.derecha = derecha;
    }

    public boolean esHoja() {
        return izquierda == null && derecha == null;
    }

    public void sustituirVariable(String variable, int valor) {
        if (esHoja()) {
            if (this.valor instanceof String && this.valor.equals(variable)) {
                this.valor = valor;
            }
        } else {
            if (izquierda != null) {
                izquierda.sustituirVariable(variable, valor);
            }
            if (derecha != null) {
                derecha.sustituirVariable(variable, valor);
            }
        }
    }

    public int evaluar() {
        if (esHoja()) {
            if (valor instanceof Integer) {
                return (Integer) valor;
            } else {
                return 0;
            }
        } else {
            if (!(valor instanceof String)) {

                return 0;
            }

            String operador = (String) valor;

            if (this.izquierda == null || derecha == null) {

                return 0;
            }

            int izquierda = this.izquierda.evaluar();
            int der = derecha.evaluar();

            switch (operador) {
                case "+": return izquierda + der;
                case "-": return izquierda - der;
                case "*": return izquierda * der;
                case "/":
                    if (der == 0) {
                        return 0;
                    }
                    return izquierda / der;
                default:

                    return 0;
            }
        }
    }

    public void imprimir(int nivel) {
        String espacios = "  ".repeat(nivel);
        System.out.println(espacios + valor);

        if (izquierda != null) {

            izquierda.imprimir(nivel + 1);
        }
        if (derecha != null) {

            derecha.imprimir(nivel + 1);
        }
    }
}
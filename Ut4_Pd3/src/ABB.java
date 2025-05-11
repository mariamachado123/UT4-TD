public class ABB<T> implements IABB<T>{
    protected Nodo<T> raiz;
    public ABB() {
        raiz = null;
    }

    @Override
    public boolean insertar(Comparable etiqueta, T dato) {
        if (raiz == null) {
            raiz = new Nodo<>(etiqueta, dato);
            return true;
        }
        return insertarRec(raiz, etiqueta, dato);
    }

    private boolean insertarRec(Nodo<T> actual, Comparable etiqueta, T dato) {
        int comparacion = etiqueta.compareTo(actual.getEtiqueta());

        if (comparacion < 0) {
            if (actual.getIzquierda() == null) {
                actual.setIzquierda(new Nodo<>(etiqueta, dato));
                return true;
            } else {
                return insertarRec(actual.getIzquierda(), etiqueta, dato);
            }
        } else if (comparacion > 0) {
            if (actual.getDerecha() == null) {
                actual.setDerecha(new Nodo<>(etiqueta, dato));
                return true;
            } else {
                return insertarRec(actual.getDerecha(), etiqueta, dato);
            }
        }
        return false;
    }

    @Override
    public boolean esVacio() {
        return raiz==null;
    }
    @Override
    public int hojas() {
        if (raiz == null) {
            return 0;
        }
        return raiz.hojasAux();
    }
    @Override
    public int sumaDeClavesDelArbol() {
        if (esVacio()) {
            return 0;
        }
        return raiz.sumaDeClavesDelArbol();
    }
    @Override
    public int cantNodos(Nodo<T> nodo, int nivelObj, int nivelActual){
        if(esVacio()){
            return 0;
        }
        return raiz.cantNodos(raiz,1,0);
    }
}

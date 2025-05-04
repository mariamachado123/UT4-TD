class ArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public ArbolBB() {
        raiz = null;
    }

    /**
     * @param unElemento
     * @return
     */
    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @SuppressWarnings("unchecked")
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    /**
     * @return recorrida en inorden del arbol, null en caso de ser vacío
     */
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }

    /**
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
    /**
     * @return
     */
    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    @Override
    public Lista<T> inorden() {
        Lista <T> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new Lista<T>();
            raiz.inOrden(listaInorden);
        }
        return listaInorden;

    }

    @Override
    public int obtenerAltura() {
        if(raiz==null){
            return -1;
        }
        return raiz.obtenerAltura();

    }

    @Override
    public int obtenerTamanio() {
        if (esVacio()){
            return 0;
        }
        return this.raiz.obtenerTamanio();
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        int nivelActual = 0;
        TElementoAB<T> actual = this.raiz;

        while (actual != null) {
            int comparacion = unaEtiqueta.compareTo(actual.getEtiqueta());
            if (comparacion == 0) {
                return nivelActual;
            }

            if (comparacion < 0) {
                actual = actual.getHijoIzq();
                nivelActual++;
            }
            else {
                actual = actual.getHijoDer();
                nivelActual++;
            }
        }

        return -1; /* Nodo no encontrado */
    }
    @Override
    public int obtenerCantidadHojas() {
        if(raiz==null){
            return 0;
        }
        return raiz.obtenerCantidadHojas();
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }


}

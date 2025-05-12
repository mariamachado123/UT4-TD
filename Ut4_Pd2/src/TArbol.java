public class TArbol<T> implements IArbolBB<T> {
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    private TElementoAB<T> raiz;

    public TArbol() {
        raiz = null;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (raiz == null) {
            raiz = unElemento;
            return true;
        }
        return raiz.insertar(unElemento);
    }


    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (raiz == null) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public String preOrden() {
        if (raiz == null) {
            return "";
        } else {
            return raiz.preOrden();
        }
    }

    @Override
    public String inOrden() {
        if (raiz == null) {
            return "";
        } else {
            return raiz.inOrden();
        }
    }

    @Override
    public String postOrden() {
        if (raiz == null) {
            return "";
        } else {
            return raiz.postOrden();
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz != null) {
            raiz = raiz.eliminar(unaEtiqueta);
        }
    }
    public String PreOrdenEtiqueta(Comparable etiquetaBuscada, int nivelInicio) {
        TElementoAB<T> nodo = buscar(etiquetaBuscada);
        if (nodo != null) {
            String resultado = nodo.PreOrdenDesdeClave(etiquetaBuscada, nivelInicio);
            return !resultado.isEmpty() ? resultado : "Clave encontrada pero error al generar recorrido";
        }
        return "";
    }

}

public class TArbol<T> implements IArbolBB<T>{
    private TElementoAB<T> raiz;
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";
    public TArbol() {
        this.raiz = null;
    }
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {

        if (unElemento == null || unElemento.getEtiqueta()==null) {
            System.out.println("No se puede insertar");
            return false;
        }
        if (raiz == null) {
            raiz = unElemento;
            System.out.println("RAIZ INSERTADO: " + unElemento.getEtiqueta().toString());
            return true;
        }

        else {
            raiz.insertar(unElemento);
            System.out.println("Insertando " +unElemento.getEtiqueta().toString() + " en el árbol...");
            return true;
        }
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (raiz == null) {
            return null;
        }
        else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public String preOrden() {
        if (raiz == null) {
            return "";
        }
        else {
            return raiz.preOrden();
        }
    }

    @Override
    public String inOrden() {
        if (raiz == null) {
            return "";
        }
        else {
            return raiz.inOrden();
        }
    }

    @Override
    public String postOrden() {
        if (raiz == null) {
            return "";
        }
        else {
            return raiz.postOrden();
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz == null) {
            return;
        }
        if (raiz.buscar(unaEtiqueta) == null) {
            return;
        }
        else {
            raiz.eliminar(unaEtiqueta);
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

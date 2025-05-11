
public class Nodo<T> implements INodo<T> {
    private T dato;
    private Nodo<T> izquierda;
    private Nodo<T> derecha;
    private Comparable etiqueta;

    public Nodo(Comparable unaEtiqueta, T unDato) {
        etiqueta = unaEtiqueta;
        dato = unDato;
    }
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public Nodo<T> getIzquierda() {
        return izquierda;
    }

    @Override
    public Nodo<T> getDerecha() {
        return derecha;
    }

    @Override
    public void setDerecha(Nodo<T> nodo) {
        derecha = nodo;
    }


    @Override
    public void setIzquierda(Nodo<T> siguiente) {
        izquierda = siguiente;

    }

    @Override
    public boolean insertar(Nodo<T> nodo) {
        if (nodo.getEtiqueta().compareTo(this.etiqueta) < 0) {
            if (izquierda == null) {
                izquierda = nodo;
                System.out.println("NODO INSERTADO:" + nodo.dato);
                return true;

            }
            else{
                izquierda.insertar(nodo);
            }
        }
        if(nodo.getEtiqueta().compareTo(this.etiqueta)>0){
            if (derecha == null) {
                derecha = nodo;
                System.out.println("NODO INSERTADO:" +  nodo.dato);
                return true;
            }
            else{
                derecha.insertar(nodo);
            }
        }
        return false;
    }
    public int hojasAux() {
        int cantidad = 0;
        if (this.getIzquierda() == null && this.getDerecha() == null) {
            cantidad = 1;
        }
        else {
            if (this.getIzquierda() != null) {
                cantidad += this.getIzquierda().hojasAux();
            }
            if (this.getDerecha() != null) {
                cantidad += this.getDerecha().hojasAux();
            }
        }
        return cantidad;
    }
}




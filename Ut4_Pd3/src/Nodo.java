
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
        System.out.println("Cantidad total de hojas: " + cantidad);
        return cantidad;
    }
    @Override
    public int sumaDeClavesDelArbol(){
        int suma= (int) this.etiqueta;
        if (this.getIzquierda() != null) {
            suma += this.getIzquierda().sumaDeClavesDelArbol();
        }
        if (this.getDerecha() != null) {
            suma += this.getDerecha().sumaDeClavesDelArbol();
        }
        System.out.println("Suma de claves: " + suma);
        return suma;
    }
    @Override
    public int cantNodos(Nodo<T> nodo, int nivelObj, int nivelActual) {
        if (nodo == null) {
            return 0;
        }
        if (nivelActual == nivelObj) {
            return 1;
        }
        return cantNodos(nodo.izquierda, nivelObj, nivelActual + 1)+
        cantNodos(nodo.derecha, nivelObj, nivelActual + 1);

    }

}




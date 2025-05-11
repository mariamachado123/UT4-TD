public interface INodo<T>{
    T getDato();
    INodo<T> getDerecha();
    Nodo<T> getIzquierda();

    void setDerecha(Nodo<T> nodo);
    void setIzquierda(Nodo<T> nodo);
    public int sumaDeClavesDelArbol();
    public int cantNodos(Nodo<T> nodo, int nivelObj, int nivelActual);
}

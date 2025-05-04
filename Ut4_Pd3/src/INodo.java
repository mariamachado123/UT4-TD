public interface INodo<T>{
    T getDato();
    INodo<T> getDerecha();
    Nodo<T> getIzquierda();

    void setDerecha(Nodo<T> nodo);
    void setIzquierda(Nodo<T> nodo);
    public boolean insertar(Nodo<T> nodo);
}

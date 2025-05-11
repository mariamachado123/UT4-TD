public interface IABB<T> {
    public boolean insertar(Comparable etiqueta, T dato);
    public boolean esVacio();
    int hojas();
    int sumaDeClavesDelArbol();
    int cantNodos(Nodo<T> nodo, int nivelObj, int nivelActual);
}

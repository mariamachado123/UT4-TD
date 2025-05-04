public interface IABB<T> {
    public boolean insertar(Comparable etiqueta, T unDato);
    public boolean esVacio();
    int hojas();
}

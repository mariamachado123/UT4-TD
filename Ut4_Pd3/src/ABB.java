public class ABB<T> implements IABB<T>{
    protected Nodo<T> raiz;
    public ABB() {
        raiz = null;
    }
    @Override
    public boolean insertar(Comparable etiqueta, T unDato) {
        Nodo<T> elemento=new Nodo<>(etiqueta,unDato);
        if(esVacio()){
            raiz=elemento;
            return true;
        }
        else{
            return raiz.insertar(elemento);
        }
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
}

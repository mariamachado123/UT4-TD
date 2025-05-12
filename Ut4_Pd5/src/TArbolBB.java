public class TArbolBB<T extends Comparable<T>> {
    private TElementoABB<T> raiz;
    private int contadorInserciones;

    public T menorClaveABB(){
        if (this.raiz == null) {
            return null;
        } else {
            return this.raiz.menorClave();
        }
    }
    public T maxClaveABB(){
        if (this.raiz == null) {
            return null;
        }
        else {
            return this.raiz.maxClave();
        }
    }
    public T claveAnteriorABB(TElementoABB<T> clave){
        if (this.raiz == null) {
            return null;
        }
        else {
            return this.raiz.claveAnterior(clave);
        }
    }
    public int contNivelesABB(int nivel){
        if(this.raiz == null){
            return 0;
        }
        else{
            return raiz.cantNodos(raiz,nivel,0);
        }
    }
    public int cantHojasABB(){
        if(raiz == null){
            return 0;
        }
        return raiz.cantHojas(raiz,0);
    }
    public boolean verificarABB(){
        if(this.raiz == null){
            return true;
        }
        else{
            return raiz.verificarABB(null,null);
        }
    }
    public boolean esVacio() {
        return raiz == null;
    }
    public boolean insertar(Comparable etiqueta, T dato) {
        if (raiz == null) {
            raiz = new TElementoABB<>(dato);
            return true;
        }
        return insertarRec(raiz, etiqueta, dato);
    }

    private boolean insertarRec(TElementoABB<T> actual, Comparable etiqueta, T dato) {
        int comparacion = etiqueta.compareTo(actual.getClave());

        if (comparacion < 0) {
            if (actual.getHijoIzq() == null) {
                actual.setHijoIzq(new TElementoABB<>(dato));
                return true;
            } else {
                return insertarRec(actual.getHijoIzq(), etiqueta, dato);
            }
        } else if (comparacion > 0) {
            if (actual.getHijoDer() == null) {
                actual.setHijoDer(new TElementoABB<>(dato));
                return true;
            } else {
                return insertarRec(actual.getHijoDer(), etiqueta, dato);
            }
        }
        return false;

    }

}

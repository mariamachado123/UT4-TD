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
    public boolean insertar(TElementoABB<T> unElemento) {
        if (esVacio()) {
            raiz = ((TElementoABB<T>) unElemento);
            contadorInserciones++;
            System.out.println("Elemento insertado. Contador de inserciones: " + contadorInserciones);
            return true;
        } else {
            boolean resultado = raiz.insertar((TElementoABB<T>) unElemento);
            if (resultado) {
                contadorInserciones++;
                System.out.println("Elemento insertado. Contador de inserciones: " + contadorInserciones);
            }
            return resultado;
        }
    }

}

public class TElementoABB<T extends Comparable<T>> {
    private T clave;
    private TElementoABB<T> hijoIzq;
    private TElementoABB<T> hijoDer;
    public TElementoABB(T clave){
        this.clave=clave;
        this.hijoIzq=null;
        this.hijoDer=null;
    }
    public T getClave(){
        return this.clave;
    }
    public void setClave(T clave){
        this.clave=clave;
    }
    public void setHijoIzq(TElementoABB<T> hijoIzq){
        this.hijoIzq=hijoIzq;
    }
    public void setHijoDer(TElementoABB<T> hijoDer){
        this.hijoDer=hijoDer;
    }
    public TElementoABB<T> getHijoIzq(){
        return this.hijoIzq;
    }
    public TElementoABB<T> getHijoDer(){
        return this.hijoDer;
    }
    public TElementoABB<T>setHijoIzq(){return this.hijoIzq;}
    public TElementoABB<T>setHijoDer(){return this.hijoDer;}
    public boolean compararClaves(T otraClave) {
        return this.clave.compareTo(otraClave) < 0;
    }
    public T menorClave(){
        if(this.clave == null){
            return null;
        }
        TElementoABB<T> nodoActual=this;
        while(nodoActual.hijoIzq!=null){
            nodoActual=nodoActual.hijoIzq;
        }
        return nodoActual.clave;
    }
    public T maxClave(){
        if(this.clave == null){
            return null;
        }
        TElementoABB<T> nodoActual=this;
        while(nodoActual.hijoDer!=null){
            nodoActual=nodoActual.hijoDer;
        }
        return nodoActual.clave;
    }
    public T claveAnterior(TElementoABB<T> elemento) {
        if (elemento == null || elemento.getClave() == null) {
            return null;

        }
        if (this.clave
                == null) {
            return null;
        }
        TElementoABB<T> nodoActual = this;
        TElementoABB<T> anterior = null;
        while (nodoActual != null) {
            if (elemento.getClave().compareTo(nodoActual.getClave()) < 0) {
                nodoActual = nodoActual.hijoIzq;
            } else if (elemento.getClave().compareTo(nodoActual.getClave()) > 0) {
                anterior = nodoActual;
                nodoActual = nodoActual.hijoDer;
            } else {
                if (nodoActual.hijoIzq != null) {
                    anterior = nodoActual.hijoIzq;
                    while (anterior.hijoDer != null) {
                        anterior = anterior.hijoDer;
                    }
                }
                break;

            }
        }
        return anterior!=null?anterior.getClave():null;
    }
    public int cantNodos(TElementoABB<T> nodo, int nivelObj, int nivelActual) {
        if (nodo==null){
            return 0;
        }
        if (nivelActual==nivelObj){
            return 1;
        }

        int nivelIzq=cantNodos(nodo.hijoIzq,nivelObj, nivelActual +1);
        int nivelDer=cantNodos(nodo.hijoDer,nivelObj, nivelActual +1);
        return nivelIzq+nivelDer;
    }
    public int cantHojas(TElementoABB<T> nodo, int nivel){
        if (nodo==null) {
            return 0;
        }
        if (nodo.hijoIzq==null && nodo.hijoDer==null){
            System.out.println("HOJA: " + nodo.clave+ ", NIVEL: " + nivel);
            return 1;
        }
        int nivelIzq=cantHojas(nodo.hijoIzq, nivel+1);
        int nivelDer=cantHojas(nodo.hijoDer, nivel+1);
        return nivelIzq+nivelDer;
    }
    public String toString(){
        return this.clave.toString();
    }

    public boolean verificarABB(T minimo, T maximo){
        if(this==null){
            return true;
        }
        if(minimo!=null && clave.compareTo(minimo)<=0 || maximo!=null && clave.compareTo(maximo)>0){
            return false;
        }
        boolean izqOk=true;
        boolean derOk=true;
        if(hijoIzq!=null){
            izqOk=hijoIzq.verificarABB(minimo,clave);
        }
        if(hijoDer!=null){
            derOk=hijoDer.verificarABB(clave,maximo);
        }
        return izqOk && derOk;
    }

}

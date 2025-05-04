
public class TElementoABB<T extends Comparable<T>> {
    private T elemento;
    private TElementoABB<T>  izquierdo;
    private TElementoABB<T>  derecho;
    public TElementoABB(T elemento){
        this.elemento = elemento;
        this.izquierdo = null;
        this.derecho = null;
    }
    public T getElemento(){
        return this.elemento;
    }
    public void setElemento(T elemento){
        this.elemento = elemento;
    }
    public TElementoABB<T> getIzquierdo(){
        return izquierdo;
    }
    public void setIzquierdo(TElementoABB<T> izquierdo){
        this.izquierdo = izquierdo;
    }
    public TElementoABB<T> getDerecho(){
        return derecho;
    }
    public void setDerecho(TElementoABB<T> derecho){
        this.derecho = derecho;
    }
    public boolean esVacio(){
        return izquierdo == null && derecho == null;
    }

    public boolean insertar(TElementoABB<T> unElemento) {
        if (unElemento.getElemento().compareTo(elemento) < 0) {
            if (izquierdo != null) {
                return getIzquierdo().insertar(unElemento);
            } else {
                izquierdo = unElemento;
                return true;
            }
        } else if (unElemento.getElemento().compareTo(elemento) > 0) {
            if (derecho != null) {
                return getDerecho().insertar(unElemento);
            } else {
                derecho = unElemento;
                return true;
            }
        } else {
            return false;
        }
    }
    public int cantidadHojas() {
        if (esVacio()) {
            return 0;
        } else {
            int hojasIzq = (izquierdo != null && !izquierdo.esVacio()) ? izquierdo.cantidadHojas() : 0; //Si izquierdo distinto de null y no es vacio, entonces hace la recursion, sino devuelve 0
            int hojasDer = (derecho != null && !derecho.esVacio()) ? derecho.cantidadHojas() : 0;

            if ((izquierdo == null || izquierdo.esVacio()) && (derecho == null || derecho.esVacio())) {
                return 1;
            }

            return hojasIzq + hojasDer;
        }
    }

    public int encontrarNivel(int clave){
        if(esVacio()){
            return 0;
        }
        if(elemento.compareTo((T) Integer.valueOf(clave)) == 0){
            return 1;
        }
        int nivelIzq=(izquierdo!=null)?izquierdo.encontrarNivel(clave):0; //Si izquierdo distinto de null y no es vacio, entonces hace la recursion, sino devuelve 0
        int nivelDer=(derecho!=null)?derecho.encontrarNivel(clave):0;
        if(nivelIzq>0){
            return nivelIzq+1;
        }
        if(nivelDer>0){
            return nivelDer+1;
        }
        return 0;
    }
    public T menorClave(){
        if(this.elemento == null){
            return null;
        }
        TElementoABB<T> nodoActual=this;
        while(nodoActual.izquierdo!=null){
            nodoActual=nodoActual.izquierdo;
        }
        return nodoActual.elemento;
    }
    public T maxClave(){
        if(this.elemento == null){
            return null;
        }
        TElementoABB<T> nodoActual=this;
        while(nodoActual.derecho!=null){
            nodoActual=nodoActual.derecho;
        }
        return nodoActual.elemento;
    }
    public T claveAnterior(TElementoABB<T> elemento) {
        if (elemento == null) {
            return null;

        }
        if (this.elemento == null) {
            return null;
        }
        TElementoABB<T> nodoActual = this;
        TElementoABB<T> anterior = null;
        while (nodoActual != null) {
            if (elemento.getElemento().compareTo(nodoActual.getElemento()) < 0) { //Si el elemento es menor al elemento del nodo actual
                nodoActual = nodoActual.izquierdo;
            } else if (elemento.getElemento().compareTo(nodoActual.getElemento()) > 0) { //si el elemento es mayor al elemento del nodo actual
                anterior = nodoActual;
                nodoActual = nodoActual.derecho;
            } else {
                if (nodoActual.izquierdo != null) {
                    anterior = nodoActual.izquierdo;
                    while (anterior.derecho!= null) {
                        anterior = anterior.derecho;
                    }
                }
                break;

            }
        }
        return anterior!=null?anterior.getElemento():null; //Si anterior es distinto de null, entonces devuelve el elemento del nodo anterior, sino devuelve null
    }
    public int cantNodos(TElementoABB<T> nodo, int nivelObj, int nivelActual) {
        if (nodo==null){
            return 0;
        }
        if (nivelActual==nivelObj){
            return 1;
        }

        int nivelIzq=cantNodos(nodo.izquierdo,nivelObj, nivelActual +1);
        int nivelDer=cantNodos(nodo.izquierdo,nivelObj, nivelActual +1);
        return nivelIzq+nivelDer;
    }
    public int cantHojas(TElementoABB<T> nodo, int nivel){
        if (nodo==null) {
            return 0;
        }
        if (nodo.izquierdo==null && nodo.derecho==null){
            System.out.println("HOJA: " + nodo.elemento+ ", NIVEL: " + nivel);
            return 1;
        }
        int nivelIzq=cantHojas(nodo.izquierdo, nivel+1); //Hace recursion y baja niveles
        int nivelDer=cantHojas(nodo.derecho, nivel+1);
        return nivelIzq+nivelDer;
    }
    public boolean verificarABB(T minimo, T maximo){
        if(this==null){
            return true;
        }
        if(minimo!=null && elemento.compareTo(minimo)<=0 || maximo!=null && elemento.compareTo(maximo)>0){
            return false;
        }
        boolean izqOk=true;
        boolean derOk=true;
        if(izquierdo!=null){
            izqOk=izquierdo.verificarABB(minimo,elemento);
        }
        if(derecho!=null){
            derOk=derecho.verificarABB(elemento,maximo);
        }
        return izqOk && derOk;
    }
}

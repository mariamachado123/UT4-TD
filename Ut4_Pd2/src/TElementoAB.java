public class TElementoAB<T> implements IElementoAB<T> {
    private T elemento;
    private TElementoAB<T> raiz;
    private TElementoAB<T> izquierdo;
    private TElementoAB<T> derecho;
    private final Comparable etiqueta;

    public TElementoAB(Comparable etiqueta,T elemento) {
        this.elemento = elemento;
        this.raiz = null;
        this.izquierdo = null;
        this.derecho = null;
        this.etiqueta = etiqueta;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return this.izquierdo;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return this.derecho;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.izquierdo = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.derecho = elemento;

    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if(unaEtiqueta==null || this.etiqueta==null){
            System.out.println("ELEMENTO NO ENCONTRADO(null): "+ unaEtiqueta);
            return null;
        }
        if (unaEtiqueta.equals(this.etiqueta)) {
            System.out.println("ELEMENTO ENCONTRADO: " + unaEtiqueta);
            return this.raiz;
        }
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (izquierdo != null) {
                return izquierdo.buscar(unaEtiqueta);
            }else{
                System.out.println("ELEMENTO NO ENCONTRADO: " + unaEtiqueta);
                return null;
            }
        } else {
            if (derecho != null) {
                return  derecho.buscar(unaEtiqueta);
            }else {
                System.out.println("ELEMENTO NO ENCONTRADO: " + unaEtiqueta);
                return null;
            }

        }

    }

    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        if(this.etiqueta == null || this.etiqueta.equals(elemento.getEtiqueta())) {
            return false;
        }
        if (elemento.getEtiqueta().compareTo(this.etiqueta) < 0) {
            if (izquierdo == null) {
                izquierdo = elemento;
                System.out.println("ELEMENTO INSERTADO: "+ elemento.getEtiqueta().toString());
                return true;
            } else {
                if(izquierdo.insertar(elemento)){
                    return true;
                }
                return false;

            }
        }
        if (derecho == null) {
            derecho = elemento;
            System.out.println("ELEMENTO INSERTADO: "+ elemento.getEtiqueta().toString());
            return true;
        } else {
            if(derecho.insertar(elemento)){
                return true;
            }
            return false;
        }
    }



    @Override
    public String preOrden() {
        String resultado = "";
        resultado = resultado + imprimir() + " ";

        if (izquierdo != null) {
            resultado = izquierdo.preOrden();
        }
        if (derecho != null) {
            resultado = derecho.preOrden();
        }
        return resultado;

    }
    public String imprimir() {
        return String.valueOf(this.elemento);
    }


    @Override
    public String inOrden() {
        String resultado = "";
        if (izquierdo != null) {
            resultado = izquierdo.inOrden();
        }
        resultado = resultado + imprimir() + " ";
        if (derecho != null) {
            resultado = derecho.inOrden();
        }
        return resultado;
    }

    @Override
    public String postOrden() {
        String resultado = "";
        if (izquierdo != null) {
            resultado = izquierdo.postOrden();
        }
        if (derecho != null) {
            resultado = derecho.postOrden();
        }
        if(elemento != null) {
            resultado = elemento.toString();
        }
        resultado = resultado + imprimir()+ " ";
        return resultado;

    }
    public String PreOrdenNivel(int nivel){
        String resultado = "";
        if (nivel<0) {
            return "";
        }
        if (nivel==0) {
            return this.etiqueta.toString() + " ";
        }
        if(this.etiqueta==null){
            return resultado;
        }
        for (int i = 0; i < nivel; i++) {
            resultado = resultado + "  ";
        }
        resultado = resultado + this.etiqueta.toString() + " ";
        if (izquierdo != null) {
            resultado = resultado + izquierdo.PreOrdenNivel(nivel+1);
        }
        if (derecho != null) {
            resultado = resultado + derecho.PreOrdenNivel(nivel+1);
        }
        return resultado;
    }
    public String PreOrdenDesdeClave(Comparable claveBusqueda, int nivelActual){
        if (this.etiqueta.compareTo(claveBusqueda) == 0) {
            return this.PreOrdenNivel(nivelActual);
        }

        String resultado = "";
        if (izquierdo != null) {
            resultado = izquierdo.PreOrdenDesdeClave(claveBusqueda, nivelActual + 1);
        }
        if (derecho != null && resultado.isEmpty()) {
            resultado = derecho.PreOrdenDesdeClave(claveBusqueda, nivelActual + 1);
        }
        return resultado;

    }

    @Override
    public T getDatos() {
        return this.elemento;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        if (izquierdo==null) {
            return derecho;
        }
        if (derecho==null) {
            return izquierdo;
        }
        TElementoAB<T> elHijo = izquierdo;
        TElementoAB<T> elPadre=this.raiz;
        if (elHijo.derecho!=null) {
            elPadre = elHijo;
            elHijo = elHijo.derecho;
        }
        if (elPadre!=this.raiz) {
            elPadre.derecho = elHijo.izquierdo;
            elHijo.izquierdo=izquierdo;
        }
        elHijo.derecho=derecho;
        return elHijo;
    }
}

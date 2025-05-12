public class TElementoAB<T> implements IElementoAB<T> {
    private T elemento;
    private TElementoAB<T> izquierdo;
    private TElementoAB<T> derecho;
    private final Comparable etiqueta;

    public TElementoAB(Comparable etiqueta,T elemento) {
        this.elemento = elemento;
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
        if (unaEtiqueta == null || this.etiqueta == null) {
            System.out.println("Búsqueda con parámetro null");
            return null;
        }

        int comparacion = unaEtiqueta.compareTo(this.etiqueta);

        if (comparacion == 0) {
            System.out.println("¡Encontrado!: " + unaEtiqueta);
            return this;
        }

        TElementoAB<T> resultado = null;
        if (comparacion < 0 && izquierdo != null) {
            resultado = izquierdo.buscar(unaEtiqueta);
        } else if (comparacion > 0 && derecho != null) {
            resultado = derecho.buscar(unaEtiqueta);
        }

        if (resultado == null) {
            if(izquierdo==null && derecho==null) {
                System.out.println(unaEtiqueta + " no existe en este subárbol");
            }
        }

        return resultado;
    }




    @Override
    public String preOrden() {
        String resultado = "";
        resultado = resultado + imprimir() + " ";

        if (izquierdo != null) {
            resultado += izquierdo.preOrden();
        }
        if (derecho != null) {
            resultado += derecho.preOrden();
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
            resultado += izquierdo.postOrden();
        }
        if (derecho != null) {
            resultado += derecho.postOrden();
        }
        resultado += resultado + imprimir()+ " ";
        return resultado;

    }
    public String PreOrdenNivel(int nivel){
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < nivel; i++) {
            resultado.append("  ");
        }
        resultado.append(this.etiqueta).append("\n");
        if (izquierdo != null) {
            resultado.append(izquierdo.PreOrdenNivel(nivel + 1));
        }
        if (derecho != null) {
            resultado.append(derecho.PreOrdenNivel(nivel + 1));
        }
        return resultado.toString();
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
        TElementoAB<T> elPadre=this;
        if (elHijo.derecho!=null) {
            elPadre = elHijo;
            elHijo = elHijo.derecho;
        }
        if (elPadre!=this) {
            elPadre.derecho = elHijo.izquierdo;
            elHijo.izquierdo=izquierdo;
        }
        elHijo.derecho=derecho;
        return elHijo;
    }
    @Override
    public boolean insertar (TElementoAB<T> elemento){
        if (elemento == null || elemento.getEtiqueta() == null) {
            return false;
        }

        int comparacion = this.etiqueta.compareTo(elemento.getEtiqueta());

        if (comparacion > 0) {
            if (this.izquierdo == null) {
                this.izquierdo = elemento;
                return true;
            } else {
                return this.izquierdo.insertar(elemento);
            }
        } else if (comparacion < 0) {
            if (this.derecho == null) {
                this.derecho = elemento;
                return true;
            } else {
                return this.derecho.insertar(elemento);
            }
        } else {

            return false;
        }
    }
}

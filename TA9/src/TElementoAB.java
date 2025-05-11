public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable<T> etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {

            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
    @Override
    public String inOrden() {
        StringBuilder tempStr=new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().inOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }
        return tempStr.toString();

    }

    @Override
    public void inOrden(Lista<T> unaLista) {
        if(hijoIzq!=null){
            hijoIzq.inOrden(unaLista);
        }
        unaLista.insertar(new Nodo<>(this.getEtiqueta(), this.getDatos()));
        if(hijoDer!=null){
            hijoDer.inOrden(unaLista);
        }
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }



    @Override
    public int obtenerAltura() {
        if (this.getHijoIzq() == null && this.getHijoDer() == null) {
            return 0;
        }
        else {
            int izq = (this.getHijoIzq() != null) ? this.getHijoIzq().obtenerAltura() : -1;
            int der = (this.getHijoDer() != null) ? this.getHijoDer().obtenerAltura() : -1;
            return 1 + Math.max(izq, der);
        }

    }

    @Override
    public int obtenerTamanio() {
        int cantidad = 1;
        if (this.getHijoDer() == null && this.getHijoIzq() == null) {
            return 1;
        }
        else {
            if (this.getHijoIzq() != null) {
                cantidad += this.getHijoIzq().obtenerTamanio(); // Sumo el tamaño del subárbol izquierdo
            }

            if (this.getHijoDer() != null) {
                cantidad += this.getHijoDer().obtenerTamanio();// Sumo el tamaño del subárbol derecho
            }

            return cantidad;
        }

    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (unaEtiqueta.equals(this.etiqueta)) {
            return 0;
        }
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (this.hijoIzq != null) {
                return 1 + this.hijoIzq.obtenerNivel(unaEtiqueta);
            }
        } else {
            if (this.hijoDer != null) {
                return 1 + this.hijoDer.obtenerNivel(unaEtiqueta);
            }
        }
        return -1;
    }

    @Override
    public int obtenerCantidadHojas() {
        int hojas = 0;
        if (this.hijoIzq != null) {
            hojas += this.hijoIzq.obtenerCantidadHojas();
        }
        if (this.hijoDer != null) {
            hojas += this.hijoDer.obtenerCantidadHojas();
        }
        if (this.hijoIzq == null && this.hijoDer == null) {
            hojas = 1;
        }
        return hojas;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        return quitaElNodo();
    }



    private TElementoAB quitaElNodo() {
        if (hijoIzq == null) {
            return hijoDer;
        }
        if (hijoDer == null) {
            return hijoIzq;
        }
        TElementoAB<T> elHijo = hijoIzq;
        TElementoAB<T> elPadre = this;
        while (elHijo.getHijoDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }
        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }
        elHijo.setHijoDer(hijoDer);

        setHijoIzq(null);
        setHijoDer(null);

        return elHijo;
    }


}

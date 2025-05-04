
import ut3.ta2.ManejadorArchivosGenerico;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TArbolBB arbol = new TArbolBB();
        String [] claves=ManejadorArchivosGenerico.leerArchivo("TA9/src/altasPrueba.txt");
        List<String> lineasSalida=new ArrayList<>();
        for (String clave:claves){
            TElementoAB<String> elementoAB=new TElementoAB<>(clave,clave);
            boolean insercionExit=arbol.insertar(elementoAB);
            int cont= insercionExit?1:0;
            String lineaSalida=clave + " " + cont;
            lineasSalida.add(lineaSalida);
        }

        // cargar los productos desde el archivo "altasprueba.txt"
        // listar los productos ordenados por codigo, junto con su cantidad existente
        //emitir el valor del stock
        // simular las ventas a partir del archivo "ventaspruebas.txt"
        // simular la eliminación de productos a partir del archivo "elimPrueba.txt"
        // listar los productos ordenados por codigo, junto con su cantidad existente



    }
}
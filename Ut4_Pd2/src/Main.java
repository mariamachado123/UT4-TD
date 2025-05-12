//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static <T> void main(String[] args) {
        ManejadorArchivosGenerico manejadorArchivosGenerico = new ManejadorArchivosGenerico();
        manejadorArchivosGenerico.leerArchivo("Ut4_Pd2/src/claves1.txt");

        TArbol<Integer> arbol=new TArbol<>();
        ManejadorArchivosGenerico manejadorArchivosGenerico1=new ManejadorArchivosGenerico();
        manejadorArchivosGenerico1.leerArchivo("Ut4_Pd2/src/clavesPrueba.txt");
        String[] lineas = manejadorArchivosGenerico1.leerArchivo("Ut4_Pd2/src/clavesPrueba.txt");
        System.out.println("Contenido del archivo:");
        for (String linea : lineas) {
            System.out.println("Línea leída: " + linea);
            try {
                int clave = Integer.parseInt(linea.trim());
                TElementoAB<Integer> elemento = new TElementoAB<>(clave, clave);
                System.out.println("Intentando insertar: " + clave);
                arbol.insertar(elemento);
            } catch (NumberFormatException e) {
                System.out.println("Error al parsear: " + linea);
            }
        }
        TElementoAB<Integer> resultado1=arbol.buscar(4567);
        TElementoAB<Integer> resultado2=arbol.buscar(12);
        TElementoAB<Integer> resultado3=arbol.buscar(8978);
        TElementoAB<Integer> resultado4=arbol.buscar(5354);
        if (lineas.length >= 10) {
            String claveStr = lineas[9].trim();
            try {
                int decimaClave = Integer.parseInt(claveStr);

                TElementoAB<Integer> encontrado = arbol.buscar(decimaClave);

                System.out.println("La clave " + decimaClave + " SÍ existe en el árbol");


            } catch (NumberFormatException e) {
                System.out.println("La décima clave no es un número válido: " + claveStr);
            }
        } else {
            System.out.println("El archivo tiene menos de 10 claves");
        }
        System.out.println(arbol.PreOrdenEtiqueta(10,0));
    }
}
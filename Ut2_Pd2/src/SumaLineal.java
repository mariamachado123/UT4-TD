import java.lang.reflect.Array;
import java.util.ArrayList;

public class SumaLineal {
    public int sumaLineal(ArrayList<Integer> A, int n){
        if(A.size()==0 || n>A.size()){
            System.out.println("Error");
            return -1;
        }
        if (n<0){
            System.out.println("Error: numero negativo");
            return -1;
        }
        if (n==0){
            return 0;
        }
        if (n==1){
            return A.get(0);
        }
        else {
            return sumaLineal(A, n-1)+A.get(n-1);
        }
    }
   public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        ArrayList<Integer> list1=new ArrayList<Integer>();

        SumaLineal s = new SumaLineal();
        System.out.println(s.sumaLineal(list, -1));
        System.out.println(s.sumaLineal(list1, 2));
        System.out.println(s.sumaLineal(list, 3));
   }
}

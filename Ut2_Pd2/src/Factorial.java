public class Factorial {
    public int factorial(int n) {
        if (n==0){
            return 1;
        }
        if (n<0){
            return -1;

        }
        else {
            return (n*(factorial(n-1)));
        }
    }
    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(f.factorial(-1));
        System.out.println(f.factorial(5));
        System.out.println(f.factorial(4));
        System.out.println(f.factorial(0));

    }
}

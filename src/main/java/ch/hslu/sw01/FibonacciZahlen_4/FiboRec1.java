package ch.hslu.sw01.FibonacciZahlen_4;

public class FiboRec1 {

    public static int fiboRec1(int a){
        if ((a <= 1)){
            if (a == 1) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return ((fiboRec1(a - 1 ) + fiboRec1(a -2)));
        }
    }

    public static void main(String[] args) {
        System.out.println(fiboRec1(10));
    }

}

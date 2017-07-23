package aufgabe_6_upn;


public class Main {
    public static void main (String[] args) {
        UPN upn = new UPN("17 52 18 + 81 99 - * 71 + *");
        System.out.println(upn.calc());
    }
}

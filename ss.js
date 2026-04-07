import java.util.Scanner

public class buclesJava{
    public static void main (String[] args){
        int contador = 0;
        while (contador <= 5){
            System.out.println(contador);
            contador++;
        }
        Scanner teclado = new Scanner (System.in);
        int opcion = 0;
        while (opcion != 3){
            System.out.println("Elixe unha opcion");
            System.out.println("1.Saudar");
            System.out.println("2.Despedirse");
            System.out.println("3.Sair");
            String op = teclado.nextline();
            opcion = Integer.parseInt (op);
       }
    }
}
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
            Main e = new Main();
        e.fibonacci(4181);
    }
    public void fibonacci(int numero){
        int primeiroTermo = 0, segundoTermo = 1, terceiroTermo;
        ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
        listaNumeros.add(primeiroTermo);
        listaNumeros.add(segundoTermo);
        for (int i = 3;i <= numero; i++){
            terceiroTermo = primeiroTermo + segundoTermo;
            primeiroTermo = segundoTermo;
            segundoTermo = terceiroTermo;
            listaNumeros.add(terceiroTermo);
        }
        if(listaNumeros.contains(numero)){
            System.out.println("O Numero " + numero + " Faz parte da lista de fibonacci");
        } else{
            System.out.println("o Numero nao faz  parte da lista de fibonacci");
        }
    }
}

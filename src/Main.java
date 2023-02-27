import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Main e = new Main();
        e.Questao2(34);
        e.Questao3();
        e.Questao4();
        e.Questao5("Lucas");
    }
    public void Questao2(int numero){
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
    public void Questao3 () {
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();
        ArrayList<String> vendas = new ArrayList<String>();
        //Lendo Arquivos do Json
        try{
            jsonObject = (JSONObject) parser.parse(new FileReader("C:/Users/vikin/Downloads/output.json"));
            for(int i = 1; i < 31; i++){
                String str = "1";
                int num = Integer.parseInt(str);
                num = i;
                str = Integer.toString(num);
                vendas.add((String) jsonObject.get(str));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e ) {
            e.printStackTrace();
        }
        //Transformando array de string em Int
        ArrayList<Integer> vendasInt = new ArrayList<Integer>();
        for(String str : vendas){
            int num = Integer.parseInt(str);
            vendasInt.add(num);
        }
        //Calculos pedidos da questão
        //Maior Valor
        int max = vendasInt.get(0);
        for(int i = 0; i < 30; i++){
            if (vendasInt.get(i) > max){
                max = vendasInt.get(i);
            }
        }
        //Menor Valor
        int min = vendasInt.get(0);
        for(int i = 0; i < 30; i++){
            if (vendasInt.get(i) < min){
                min = vendasInt.get(i);
            }
        }
        //Media do mes
        int totalVendas = 0;
        int mediaMensal = 0;
        int totalDias = 0;
        for(int i = 0; i<30; i++){
           totalVendas += vendasInt.get(i);
        }
        mediaMensal = totalVendas/30;
        for (int i = 0; i<30; i++){
            if (mediaMensal < vendasInt.get(i)){
               totalDias++;
            }
        }
        System.out.println("O Menor valor de faturamento foi: " + min);
        System.out.println("O Maior valor de faturamento foi: " + max);
        System.out.println("A Numero de dias que foi maior que a media mensal: " + totalDias);
    }
    public void Questao4(){
        DecimalFormat df = new DecimalFormat("#.##");

        double sp = 67836.36d;
        double rj = 36678.66d;
        double mg = 29229.88d;
        double es = 27165.48d;
        double outros = 19849.53d;
        double somaTotal = sp + rj + mg + es + outros;

        double porcetagemSp = (sp/somaTotal) * 100d;
        double porcetagemRj= (rj/somaTotal) * 100d;
        double porcetagemMg = (mg/somaTotal) * 100d;
        double porcetagemEs = (es/somaTotal) * 100d;
        double porcetagemOutros = (outros/somaTotal) * 100d;

        System.out.println("Porcetagem de SP: " + df.format(porcetagemSp));
        System.out.println("Porcetagem de RJ: " + df.format(porcetagemRj));
        System.out.println("Porcetagem de MG: " + df.format(porcetagemMg));
        System.out.println("Porcetagem de ES: " + df.format(porcetagemEs));
        System.out.println("Porcetagem de Outros: " + df.format(porcetagemOutros));
    }
    public void Questao5(String nome){
        String nomeReverso = "";
        for(int i = nome.length()-1; i>= 0; i--){
            nomeReverso += nome.charAt(i);
        }
        System.out.println(nomeReverso);
    }
}

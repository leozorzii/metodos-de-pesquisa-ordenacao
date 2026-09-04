
package app.test;

import java.util.ArrayList;
import app.model.Ordenacao;
import app.controller.Utils;
import app.view.View;

/**
 *
 * @author leozorzii
 */
public class TestOrdenacao {
    public static void main(String[] args) {       
        ArrayList<Integer> listaBolha = new ArrayList<>();
        ArrayList<Integer> listaPente = new ArrayList<>();
        ArrayList<Long> metricas = new ArrayList<>();
        long tempoInicio, tempoFim, tempoTotal; 
        
        //desempenho do bolha
        System.out.println("Metodo Bolha");
        Utils.popularLista(listaBolha, 100000);
        tempoInicio = System.nanoTime();
        metricas.addAll(Ordenacao.bolha(listaBolha));
        tempoFim = System.nanoTime();
        tempoTotal = (tempoFim - tempoInicio)/1000000;        
        metricas.add(tempoTotal);        
        View.exibirMetricas(metricas);
        
        //desempenho do pente
        System.out.println("Metodo Pente");
        metricas.clear(); //limpeza das metricas do bolha
        Utils.popularLista(listaPente, 100000);
        tempoInicio = System.nanoTime();
        metricas.addAll(Ordenacao.pente(listaPente));
        tempoFim = System.nanoTime();
        tempoTotal = (tempoFim - tempoInicio)/1000000;        
        metricas.add(tempoTotal);        
        View.exibirMetricas(metricas);
    }    
}

package app.controller;

import java.util.ArrayList;
import app.model.Ordenacao;
import app.view.View;

public class Controller {
	/**
	 * Coordena a geração da lista, a ordenação, a medição e a exibição.
	 */
	public static void executar() {
		executarOrdenacao("Metodo Bolha", Ordenacao.Tipo.BOLHA);
		executarOrdenacao("Metodo Pente", Ordenacao.Tipo.PENTE);
	}
	/**
	 * Executa um algoritmo de ordenação e exibe suas métricas.
	 *
	 * @param nomeMetodo nome do método que será exibido
	 * @param tipo tipo de ordenação que será executado
	 */
	private static void executarOrdenacao(String nomeMetodo, Ordenacao.Tipo tipo) {
		ArrayList<Integer> lista = new ArrayList<>();
		Utils.popularLista(lista, 100000);

		long tempoInicio = System.nanoTime(); 
		ArrayList<Long> metricas = tipo == Ordenacao.Tipo.BOLHA //operador ternario para decisao de bolha e pente
				? Ordenacao.bolha(lista)
				: Ordenacao.pente(lista);
		long tempoTotal = (System.nanoTime() - tempoInicio) / 1000000;//Obtem o instante final - o inicial e converte para mili segundos
		metricas.add(tempoTotal);

		View.exibirNomeMetodo(nomeMetodo);
		View.exibirMetricas(metricas);
	}
}

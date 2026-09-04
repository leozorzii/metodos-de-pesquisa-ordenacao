package app.view;

import java.util.ArrayList;

public class View {
    /**
     * Exibe o nome do método de ordenação.
     *
     * @param nomeMetodo nome do método que será exibido
     */
    public static void exibirNomeMetodo(String nomeMetodo){
        System.out.println(nomeMetodo);
    }
    /**
     * Exibe uma frase e os itens de uma lista.
     *
     * @param frase frase que será exibida
     * @param lista lista que será exibida
     */
    public static void exibirLista(String frase, ArrayList<Integer>lista){
        System.out.println(frase);
        for (Integer item : lista) {
            System.out.println(item);
        }

    }
	/**
	 * Exibe as métricas produzidas pelos métodos de ordenação.
	 *
	 * @param metricas lista contendo comparações, trocas e tempo de processamento
	 */
    public static void exibirMetricas(ArrayList<Long>metricas){
        
        System.out.println("total de comparacoes       :" + metricas.get(0));//comparacoes
        System.out.println("total de trocas            :" + metricas.get(1));//trocas
        System.out.println("Tempo de processamento (ms):" + metricas.get(2));//tempo
    }
}

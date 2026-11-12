package model;

import java.util.ArrayList;

/**
 * Algoritmos de ordenação usados no laboratório e suas métricas de desempenho.
 *
 * Cada método ordena a lista recebida e devolve duas métricas em
 * {ArrayList}: quantidade de comparações (índice 0) e quantidade de
 * trocas (índice 1).
 *
 */
public class Ordenacao {

    /**
     * Ordena a lista pelo método da bolha (Bubble Sort).
     *
     * <p>Percorre pares vizinhos e troca quando estão fora de ordem, repetindo
     * o processo enquanto houver troca em uma passagem completa.</p>
     *
     * @param lista Lista de inteiros que será ordenada in-place.
     * @return Métricas da execução: comparações no índice 0 e trocas no índice 1.
     */
    public static ArrayList bolha(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int aux;
        boolean houveTroca;
        int i;
        do {
            houveTroca = false;
            for (i = 0; i < lista.size() - 1; i++) {
                qtdComparacoes++;
                if (lista.get(i) > lista.get(i + 1)) {
                    houveTroca = true;
                    aux = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, aux);
                    qtdTrocas++;
                }
            }
        } while (houveTroca);
        metricas.add((float)qtdComparacoes);
        metricas.add((float)qtdTrocas);
        return metricas;
    }

    /**
     * Ordena a lista pelo método da seleção (Selection Sort).
     *
     * @param lista Lista de inteiros que será ordenada in-place.
     * @return Métricas da execução: comparações no índice 0 e trocas no índice 1.
     */
    public static ArrayList selecao(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int i, j, posMenor, aux;
        posMenor = 0;

        // A troca fica dentro do for (i). Fora do laço, i == lista.size()
        // e lista.get(i) gera IndexOutOfBoundsException.
        for (i = 0; i < lista.size(); i++) {
            posMenor = i;
            for (j = i+1; j < lista.size(); j++) {
                qtdComparacoes++;
                if (lista.get(j) < lista.get(posMenor)) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                aux = lista.get(i);
                lista.set(i, lista.get(posMenor));
                lista.set(posMenor, aux);
                qtdTrocas++;
            }
        }
        metricas.add((float)qtdComparacoes);
        metricas.add((float)qtdTrocas);
        return metricas;
    }

    /**
     * Ordena a lista pelo método da inserção (Insertion Sort).
     *
     * @param lista Lista de inteiros que será ordenada in-place.
     * @return Métricas da execução: comparações no índice 0 e trocas no índice 1.
     */
    public static ArrayList insercao(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int i, j, aux;

        for (i = 1; i < lista.size(); i++) {
            aux = lista.get(i);
            for (j = i-1; j > 0 && aux < lista.get(j); j-- , qtdComparacoes++) {
                qtdTrocas++;
                lista.set(j+1, lista.get(j));
            }
            lista.set(j+1, aux);
        }
        metricas.add((float)qtdComparacoes);
        metricas.add((float)qtdTrocas);
        return metricas;
    }

    /**
     * Ordena a lista pelo método do pente (Comb Sort).
     *
     * @param lista Lista de inteiros que será ordenada in-place.
     * @return Métricas da execução: comparações no índice 0 e trocas no índice 1.
     */
    public static ArrayList pente(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int aux;
        boolean houveTroca;
        int i;
        int distancia = lista.size();
        do {
            distancia = (int)(distancia/1.3);
            if (distancia <= 0) {
                distancia = 1;
            }
            houveTroca = false;
            for (i = 0; i + distancia < lista.size(); i++) {
                qtdComparacoes++;
                if (lista.get(i) > lista.get(i + distancia)) {
                    houveTroca = true;
                    aux = lista.get(i);
                    lista.set(i, lista.get(i + distancia));
                    lista.set(i + distancia, aux);
                    qtdTrocas++;
                }
            }
        } while (distancia > 1 || houveTroca);
        metricas.add((float)qtdComparacoes);
        metricas.add((float)qtdTrocas);
        return metricas;
    }
}

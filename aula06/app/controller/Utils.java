package app.controller;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe de métodos auxiliares utilizados pelo sistema.
 */
public class Utils {
    /**
     * Popula uma lista com números aleatórios entre 200 e 399.
     *
     * @param lista lista que será populada
     * @param qtd quantidade de números que serão adicionados à lista
     */
    public static void popularLista(ArrayList<Integer>lista, int qtd){
        Random gerador = new Random();
        for (int i = 0; i < qtd; i++) {
            lista.add(gerador.nextInt(200,400));
        }
    }
}

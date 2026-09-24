package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Utilitário de persistência em arquivo texto para a lista de números.
 */
public class Util {

    /**
     * Carrega números inteiros de um arquivo texto para a lista informada.
     *
     * @param nomeArquivo Caminho e nome do arquivo a ser lido.
     * @param lista       Lista que receberá os inteiros encontrados no arquivo.
     * @return {true} se a leitura e a conversão ocorreram sem erro;
     *         {false} caso contrário.
     */
    public static boolean carregarArquivoEmLista(String nomeArquivo, ArrayList<Integer> lista) {
        try {
            FileReader procurador;
            procurador = new FileReader(nomeArquivo);
            BufferedReader leitor = new BufferedReader(procurador);
            String linha;
            do {
                linha = leitor.readLine();
                if (linha != null) {
                    lista.add(Integer.parseInt(linha));
                }
            } while (linha != null);
            leitor.close();
            return true;
        } catch (Exception e) {
            //System.out.println("Erro " + e.getMessage());
            return false;
        }
    }
}

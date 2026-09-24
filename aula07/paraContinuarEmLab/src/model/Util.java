package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Utilitário de persistência em arquivo texto para a lista de números.
 *
 * <p>Lê um arquivo no formato exigido pelo laboratório (um inteiro por linha)
 * e preenche a lista recebida por parâmetro.</p>
 *
 * @author laboratorio
 * @version 1.0
 */
public class Util {

    /**
     * Carrega números inteiros de um arquivo texto para a lista informada.
     *
     * <p>Cada linha válida é convertida com {@code Integer.parseInt} e adicionada
     * em {@code lista}. Qualquer falha de leitura ou conversão interrompe o
     * processo e o método devolve {@code false}.</p>
     *
     * @param nomeArquivo Caminho e nome do arquivo a ser lido.
     * @param lista       Lista que receberá os inteiros encontrados no arquivo.
     * @return {@code true} se a leitura e a conversão ocorreram sem erro;
     *         {@code false} caso contrário.
     * @author laboratorio
     * @version 1.0
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

package controller;

import java.util.ArrayList;
import model.Ordenacao;
import model.Util;

/**
 * Orquestra o fluxo entre a view e o modelo
 */
public class Controller {

    /**
     * Lista de números carregada a partir do arquivo informado na view.
     */
    ArrayList<Integer> listaNumeros = new ArrayList<>();

    /**
     * Substitui o conteúdo da lista pelos números lidos do arquivo.
     *
     * <p>Antes da leitura a lista atual é esvaziada para evitar misturar
     * dados de um arquivo anterior com o novo carregamento.</p>
     *
     * @param nomeArquivo Caminho e nome do arquivo texto com um inteiro por linha.
     */
    public boolean carregarArquivo(String nomeArquivo) {
        listaNumeros.clear();
        return Util.carregarArquivoEmLista(nomeArquivo, listaNumeros);
    }

    /**
     * Executa o algoritmo de ordenação correspondente ao texto do combo da view.
     *
     * <p>Trabalha sobre uma cópia da lista original para que novas execuções
     * possam usar os mesmos números sem reabrir o arquivo. Os nomes aceitos
     * são os do combo: Bolha, Seleção, Inserção e Pente.</p>
     *
     * @param metodo Nome do método de ordenação selecionado na interface.
     * @return Lista de métricas em que a posição 0 é a quantidade de comparações
     *         e a posição 1 é a quantidade de trocas; lista vazia se o método for inválido.
     */
    public ArrayList<Float> execute(String metodo) {
        ArrayList<Integer> copiaLista = new ArrayList<>(listaNumeros);//nao quebra a referencia original
        switch (metodo) {
            case "Bolha":
                return Ordenacao.bolha(copiaLista);
            case "Seleção":
                return Ordenacao.selecao(copiaLista);
            case "Inserção":
                return Ordenacao.insercao(copiaLista);
            case "Pente":
                return Ordenacao.pente(copiaLista);
            default:
                return new ArrayList<>();
        }
    }

    /**
     * Remove todos os números atualmente armazenados na lista.
     *
     * <p>Usado pelo botão Limpar da view para recomeçar o experimento
     * sem resíduos da execução anterior.</p>
     *
     */
    public void limparLista() {
        listaNumeros.clear();
    }

    /**
     * Informa quantos números estão carregados na lista.
     *
     * <p>A view usa esse valor tanto para validar o Executar quanto para
     * preencher o campo de quantidade no painel de resultados.</p>
     *
     * @return Tamanho atual da lista de números.
     */
    public int quantidade() {
        return listaNumeros.size();
    }
}

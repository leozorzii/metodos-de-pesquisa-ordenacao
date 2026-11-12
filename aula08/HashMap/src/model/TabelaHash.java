package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Guarda as sessões numa tabela hash: chave = número do celular, valor = Sessao.
 * O mapa é privado; quem usa a classe só enxerga as operações abaixo.
 */
public class TabelaHash {

    private Map<String, Sessao> sessoes = new HashMap<>();

    /** Troca todo o conteúdo pela carga nova (só chamado quando a leitura deu certo). */
    public void substituir(Map<String, Sessao> novasSessoes) {
        sessoes = novasSessoes;
    }

    /** Insere (ou sobrescreve, se o número já existir). */
    public void inserir(Sessao sessao) {
        sessoes.put(sessao.getNumero(), sessao);
    }

    /** Busca direta pela chave, O(1). Retorna null se o número não existir. */
    public Sessao buscar(String numero) {
        return sessoes.get(numero);
    }

    /** Todas as sessões, sem ordem garantida (HashMap não guarda ordem de inserção). */
    public Collection<Sessao> todas() {
        return sessoes.values();
    }

    public int tamanho() {
        return sessoes.size();
    }

    public boolean estaVazia() {
        return sessoes.isEmpty();
    }
}

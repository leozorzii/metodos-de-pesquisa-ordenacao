
class View:
    """agrupa os metodos de apresentacao de dados para o usuario."""

    @staticmethod
    def exibir_lista(lista: list, frase: str) -> None:
        """exibe o conteudo de uma lista de inteiros e o total de registros

        Args:
            lista (list): lista com numeros inteiros
            frase (str): mensagem exibida antes do conteudo da lista
        """
        print(frase)
        for item in lista:
            print(item)
        print("----------------------")
        print("total de registros", len(lista))

    @staticmethod
    def exibir_tempo_execucao(rotina: int, tempo_ms: int) -> None:
        """exibe o tempo de execucao de uma rotina em milissegundos

        Args:
            rotina (int): numero identificador da rotina medida
            tempo_ms (int): tempo gasto pela rotina, em milissegundos
        """
        print(f"rotina {rotina}: {tempo_ms} ms!")

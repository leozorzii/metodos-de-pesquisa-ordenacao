"""utilitarios de geracao de dados para os testes de desempenho."""

import random


class Util:
    """agrupa metodos auxiliares de manipulacao de listas."""

    @staticmethod
    def popular_lista(lista: list, tam: int, min_valor: int, max_valor: int, aleatorio: bool) -> None:
        """popula uma lista com numeros aleatorios ou sequenciais dentro de uma faixa

        Args:
            lista (list): lista que recebera os numeros
            tam (int): quantidade de numeros a serem inseridos
            min_valor (int): valor minimo - inicio da faixa
            max_valor (int): valor maximo - fim da faixa
            aleatorio (bool): se True popula com valores aleatorios, se False popula em ordem crescente
        """
        if aleatorio:
            # popula com valores aleatorios, podendo haver repeticao
            for _ in range(tam):
                lista.append(random.randint(min_valor, max_valor))
        else:
            # popula a lista de forma sequencial a partir do valor minimo
            for i in range(tam):
                lista.append(min_valor + i)

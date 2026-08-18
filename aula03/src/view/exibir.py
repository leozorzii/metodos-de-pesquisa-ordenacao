import os
from model.util import Util


class View:

        
    @staticmethod
    def exibir_lista(lista, frase):
        Util.limpar()
        print(frase)
        for item in lista:
            print(item)

    @staticmethod
    def exibir_resultados_dos_mpo(nome_metodo, tempo, qtd_comparacoes, qtd_trocas):
        """Metodo para exibicao de qualquer metodo de ordenacao"""

        print(f"Metodo Utilizado: {nome_metodo}")
        print(f"tempo de rotina: {tempo:.2f}s")
        print(f"quantidade de comparacoes: {qtd_comparacoes}")
        print(f"quantidade de trocas: {qtd_trocas}")
        print("--------------------------------------------\n")
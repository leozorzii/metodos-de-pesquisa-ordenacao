import time
from model.ordenacao import Ordenacao
from aula03.src.view.exibir import View


class Main():
    
    @staticmethod
    def executar_metodo(nome, metodo, lista_original):
        lista = lista_original.copy()
        
        tempo_inicio = time.perf_counter()
        qtd_comparacoes, qtd_trocas = metodo(lista)
        tempo_fim = time.perf_counter()
        
        tempo = tempo_fim = tempo_inicio
        
        View.exibir_resultados_dos_mpo(nome,tempo,qtd_comparacoes, qtd_trocas)
    
    @staticmethod
    def execute():
        lista_inicial = [64, 34, 22, 10, 42, 66, 88]
        
        View.limpar()
        
        Main.executar_metodo("Bolha", Ordenacao.bolha, lista_inicial)
        Main.executar_metodo("Seleção", Ordenacao.selecao, lista_inicial)
        Main.executar_metodo("Inserção", Ordenacao.insercao, lista_inicial)
        



if __name__ == "__main__":
    Main.execute()
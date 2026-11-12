import time
from model.ordenacao import Ordenacao
from view.exibir import View


class ControllerOrdenacao():
    
    @staticmethod
    def executar_metodo(nome, metodo, lista_original):
        lista = lista_original.copy()
        
        tempo_inicio = time.perf_counter()
        qtd_comparacoes, qtd_trocas = metodo(lista)
        tempo_fim = time.perf_counter()
        
        tempo = tempo_fim - tempo_inicio
        
        View.exibir_resultados_dos_mo(nome,tempo,qtd_comparacoes, qtd_trocas)
    
    @staticmethod
    def execute():
        View.limpar()
        
        lista_inicial = View.ler_lista_usuario()
        
        
        ControllerOrdenacao.executar_metodo("Bolha", Ordenacao.bolha, lista_inicial)
        ControllerOrdenacao.executar_metodo("Seleção", Ordenacao.selecao, lista_inicial)
        ControllerOrdenacao.executar_metodo("Inserção", Ordenacao.insercao, lista_inicial)
        




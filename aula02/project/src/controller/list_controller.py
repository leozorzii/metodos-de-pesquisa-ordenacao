import time
from project.src.model.util import Util
from project.src.view.displays_view import View

class Controller:
    def executar_processamento(self):
        """executa as rotinas de populacao das listas e exibe o tempo de cada uma
        """
        lista_aleatoria = []
        lista_sequencial = []
        #rotina aleatoria
        temp_inicio = time.perf_counter_ns()
        Util.popular_lista(lista_aleatoria, 100000, 100, 100000, True)
        tempo_fim = time.perf_counter_ns()
        View.exibir_tempo_execucao(1, (tempo_fim - temp_inicio) // 1000000)
        #rotina sequencial
        temp_inicio = time.perf_counter_ns()
        Util.popular_lista(lista_sequencial, 100000, 1, 100000, False)
        tempo_fim = time.perf_counter_ns()
        View.exibir_tempo_execucao(2, (tempo_fim - temp_inicio) // 1_000_000)

        # View.exibir_lista(lista_aleatoria, "Lista Aleatoria: ") #caso queira exibir a lista

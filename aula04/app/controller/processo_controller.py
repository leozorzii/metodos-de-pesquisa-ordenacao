from app.model.popular_lista import Util
from app.model.ordenacao import Ordenacao
from app.view.processo_view import ProcessoView

class ProcessoController:
    @staticmethod
    def executar():
        lista_processos = []
        Util.popular_lista(lista_processos, quantidade=4)
        
        ProcessoView.exibir_lista(lista_processos, "\n--[Exibindo lista original]--")
        
        Ordenacao.bolha(lista_processos)
        
        ProcessoView.exibir_lista(lista_processos, "\n--[Exibindo lista ordenada pelo id]--")
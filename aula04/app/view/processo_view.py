class ProcessoView:
    @staticmethod
    def exibir_lista(lista_processos, mensagem):
        """recebe uma lista de processos e uma mensagem de contexto para exibir
        """
        print(mensagem)
        for item in lista_processos:
            print(item)
            
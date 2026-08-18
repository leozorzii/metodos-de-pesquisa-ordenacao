import random, os

class Util:
    @staticmethod
    def popular_lista_aleatoria(lista, quantidade, inicio, fim):
        for _ in range(quantidade):
            lista.append( random.randint(inicio, fim) ) 
            
    @staticmethod
    def limpar():
        os.system('cls')
        
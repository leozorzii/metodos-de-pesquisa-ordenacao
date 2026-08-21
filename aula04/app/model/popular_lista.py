import random
from app.model.processo import Processo

class Util:
    @staticmethod
    def popular_lista(lista, quantidade):
        for i in range(quantidade):
            lista.append(
                Processo(random.randint(100, 499), f"gerando uma string {random.randint(0, quantidade)}")
            )
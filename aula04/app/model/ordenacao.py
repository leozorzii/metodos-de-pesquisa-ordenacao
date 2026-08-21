class Ordenacao:
    
    @staticmethod
    def bolha(lista):
        """Método de ordenação que ordena objetos de uma lista

        Returns:
            List(int): retorna a lista ordenada
        """
        houve_troca = True
        n = len(lista)
        
        while houve_troca:
            houve_troca = False
            for i in  range(n-1):
                if lista[i] > lista[i+1]:
                    temp = lista[i]    
                    lista[i] = lista[i+1]
                    lista[i+1] = temp
                    houve_troca = True
                    
        return lista
class Ordenacao:

    @staticmethod
    def bolha(lista):
        houve_troca = True
        qtd_comparacoes = 0
        qtd_trocas = 0
        fim = len(lista)

        while houve_troca:
            houve_troca = False
            for i in range(fim - 1):
                qtd_comparacoes += 1
                if lista[i] > lista[i + 1]:
                    qtd_trocas += 1
                    houve_troca = True
                    tmp = lista[i]
                    lista[i] = lista[i + 1]
                    lista[i + 1] = tmp
            fim -= 1

        return qtd_comparacoes, qtd_trocas

    @staticmethod
    def selecao(lista):
        qtd_comparacoes = 0
        qtd_trocas = 0
        for i in range(len(lista) - 1):
            posMenor = i
            for j in range(i + 1, len(lista)):
                qtd_comparacoes += 1
                if lista[j] < lista[posMenor]:
                    posMenor = j
            if i != posMenor:
                qtd_trocas += 1
                tmp = lista[i]
                lista[i] = lista[posMenor]
                lista[posMenor] = tmp

        return qtd_comparacoes, qtd_trocas

    @staticmethod
    def insercao(lista):
        """
        Exemplo
        3, 1, 2
        3 > 1 → troca → 1, 3, 2
        3 > 2 → troca → 1, 2, 3
        """
        qtd_comparacoes = 0
        qtd_trocas = 0
        
        for i in range(1, len(lista)):
            j = i
            
            while j > 0:
                qtd_comparacoes += 1
                
                if lista[j-1] > lista[j]:
                #troca de lugar o indice, o que era o ultimo passa pra posicao do que ta olhando
                    lista[j-1], lista[j] = lista[j], lista[j-1]                
                    qtd_trocas += 1
                    j -= 1
                else:
                    break
        return qtd_comparacoes, qtd_trocas
  
     
    @staticmethod
    def sort(lista):
        lista.sort()
        return "N/A", "N/A"
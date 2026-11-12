def pesquisa_binaria(lista, alvo):
    inicio = 0
    fim = len(lista) - 1
    comparacoes = 0

    while inicio <= fim:
        meio = (inicio + fim) // 2          # divisão inteira
        comparacoes += 1
        valor = lista[meio]
        print(f"Passo {comparacoes}: inicio={inicio}, fim={fim}, meio={meio}, valor={valor}", end=" -> ")

        if valor == alvo:
            print(f"{alvo} = {valor}, ENCONTRADO!")
            return meio, comparacoes
        elif alvo < valor:
            print(f"{alvo} < {valor}, procura na metade esquerda")
            fim = meio - 1
        else:
            print(f"{alvo} > {valor}, procura na metade direita")
            inicio = meio + 1

    return -1, comparacoes                  # não encontrado


# Entrada do usuário
entrada = input("Digite os números da lista separados por vírgula: ")
lista = [int(i) for i in entrada.split(",")] #separa os numeros vindos na virgula, percorre a lista e separa, splita

if lista != sorted(lista):
    print("A lista não está ordenada! Ordenando antes da pesquisa...")
    lista.sort()

print("Lista:", lista)
alvo = int(input("Digite o número a procurar: "))
print()

posicao, total = pesquisa_binaria(lista, alvo)

print()
if posicao != -1:
    print(f"Número {alvo} encontrado na posição {posicao}.")
else:
    print(f"Número {alvo} não está na lista.")
print(f"Total de comparações: {total}")
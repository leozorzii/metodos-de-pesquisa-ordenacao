# Caderno de Anotações: Métodos de Pesquisa e Ordenação

---

## Aula 1: Fundamentos & Ordenação

### Conceitos Fundamentais

- **Complexidade:** Medida do esforço computacional (tempo de execução e uso de memória).
- **Ordenação:** Mensurada principalmente pela **quantidade de comparações** e **quantidade de trocas** realizadas.

### Operações Básicas (CRUD)

- **C (Create):** Criação / Inserção de dados
- **R (Retrieve / Read):** Leitura / Consulta de dados
- **U (Update):** Atualização / Alteração de dados
- **D (Delete):** Remoção / Exclusão de dados

> **Nota:** Para a utilização eficiente de determinadas estruturas (como Árvores Binárias de Busca), os dados precisam estar **ordenados**.

### Algoritmos de Ordenação

- **Bubble Sort:** O maior elemento "sobe" como uma bolha a cada iteração até o final da lista _(uso majoritariamente didático)_.
- **Merge Sort:** Algoritmo de divisão e conquista com complexidade O(n log n).
- **Quick Sort:** Ordenação rápida baseada em escolha de pivô e particionamento.

---

## Aula 2: Medição de Desempenho & Arquitetura

- **Temporização (Benchmarking):** Medição e análise prática do tempo de execução dos algoritmos sob diferentes volumes de dados.
- **Padrão MVC (Model-View-Controller):** Separação de responsabilidades para organização e padronização do código:
  - **Model:** Estruturas de dados, entidades e regras de negócio.
  - **View:** Interface de apresentação e interação com o usuário (console/UI).
  - **Controller:** Intermediador do fluxo entre a interface e os dados.

---

## Aula 3: Implementação de Algoritmos Básicos

### Métodos de Ordenação Trabalhados

1. **Selection Sort (Seleção):** Busca iterativamente o menor elemento restante e o posiciona no início.
2. **Insertion Sort (Inserção):** Constrói a ordenação inserindo cada elemento em sua posição relativa na sublista já ordenada.
3. **Bubble Sort (Bolha):** Realiza trocas consecutivas de pares adjacentes fora de ordem.

### Atividade / Próximos Passos

- Refatorar a implementação dos métodos de ordenação para operarem dentro da arquitetura **MVC**.

---

## Aula 4: MVC no Bubble Sort, Métodos Java & Camadas

### Aplicação Prática de MVC

- Isolamento do algoritmo de ordenação dentro da camada de service/controller.
- Modelagem de classes de domínio organizadas no `Model`.

### Métodos Essenciais em Java

- **`compareTo()` (`Comparable` / `Comparator`):** Define o critério de comparação e ordem natural entre objetos (retorna < 0, 0 ou > 0).
- **`equals()`:** Responsáveis pela verificação de igualdade lógica e geração de hash para estruturas associativas.
- **`toString()`:** Sobrescrita para representação amigável do objeto.

### Arquitetura de Software

- **Construção e Refatoração em Camadas:** Desacoplamento de responsabilidades, facilitando manutenção, escalabilidade e legibilidade do código.

---

## Aula 6: MVC em Java & Benchmark de Ordenação

### Aplicação Prática de MVC

- **Model (`Ordenacao`):** Concentra os algoritmos de ordenação Bubble Sort e Comb Sort, além da contagem de comparações e trocas.
- **View (`View`):** Responsável pela exibição dos nomes dos métodos, listas e métricas no console.
- **Controller (`Controller`):** Coordena o fluxo da aplicação, criando a lista, escolhendo o algoritmo, medindo o tempo e encaminhando os resultados para a View.
- **Classe principal (`Main`):** Apenas inicia a execução do Controller.
- **Classe auxiliar (`Utils`):** Popula as listas com números aleatórios para os experimentos.

### Enumeração de Tipos

- **`enum Tipo`:** Representa um conjunto fixo de opções de ordenação (`BOLHA` e `PENTE`), permitindo que o Controller escolha o algoritmo de forma mais clara e segura.

### Benchmark

- **Benchmark:** Processo de executar algoritmos em condições definidas e coletar medidas para comparar seus desempenhos.
- **Dados analisados:** Quantidade de comparações, quantidade de trocas e tempo de processamento.
- **Medição de tempo:** `System.nanoTime()` registra o instante inicial e final da ordenação. A diferença é convertida de nanossegundos para milissegundos.
- **Condições do experimento:** Cada método é executado sobre uma lista com 100.000 números aleatórios.
- **Interpretação:** As métricas permitem observar o comportamento prático dos algoritmos, mas os resultados podem variar conforme os dados e o ambiente de execução.

### Estrutura de Teste

- **`TestOrdenacao`:** Executa os algoritmos, mede seus tempos e exibe as métricas para comparação.
- **Objetivo:** Avaliar o desempenho dos métodos de ordenação em um experimento prático.
- **Resultado Final:** O foco foi medir e comparar a execução dos algoritmos, não desenvolver o código a partir de testes automatizados prévios.


## Aula 7: Merge Sort, Quick Sort + 1ª Avaliação

Paradigma comum aos dois métodos: **dividir para conquistar**. Ambos são recursivos e organizam o trabalho em forma de árvore de chamadas.

### Merge Sort (Intercalação)

- **Categoria:** codificação complexa.
- **Complexidade:** O(n log n).
- **Ecossistema visto em aula:** Java.
- **Ideia:** divide a estrutura de forma **mais ou menos uniforme** (metade e metade) até chegar em partes mínimas; a ordenação acontece na **volta da recursão**, quando as partes são intercaladas.
- **Dois métodos envolvidos:**
  1. **Recursão:** quebra a lista até o caso base.
  2. **Intercalação (merge):** combina duas metades já ordenadas em uma só sequência ordenada.

```
ida (divisão)                         volta (intercalação)
     |                                         A
     |                          ordenação      |
     V                          ocorre aqui    |
lista grande  →  metades  →  ...  →  merge das partes
```

### Quick Sort (Pivô)

- **Categoria:** codificação complexa.
- **Complexidade:** O(n log n) no caso médio; piora se o pivô for mal escolhido.
- **Ecossistema visto em aula:** C#.
- **Ideia:** escolhe um **pivô**, posiciona-o na estrutura e recorre às partições à esquerda e à direita. **Não divide de forma uniforme** — o tamanho das partições depende do pivô.
- **Dois métodos envolvidos:**
  1. **Recursão:** aplica o processo nas partições.
  2. **Posicionamento do pivô:** elementos menores de um lado, maiores do outro.

### Comparação Rápida

- **Merge Sort:** divisão equilibrada; ordena na intercalação (retorno das chamadas).
- **Quick Sort:** divisão desigual (pivô); ordena ao posicionar o pivô.
- **Uso prático:** métodos de baixa complexidade (bolha, seleção, inserção) servem bem para volumes pequenos ou didática; Merge e Quick entram quando o volume cresce e O(n²) deixa de ser viável.

### Laboratório (para continuar em lab)

Projeto em **MVC** com interface gráfica (Swing):

- **Model (`Model`):** guarda a lista de inteiros carregada.
- **View (`JFramePrincipal`):** caminho do arquivo, escolha do método, execução e exibição de métricas (quantidade de números, comparações, trocas e tempo).
- **Controller (`Ordenacao`):** Bolha, Seleção, Inserção e Pente, com contagem de comparações e trocas.
- **Utilitário (`Util`):** carrega o arquivo texto na lista.

---

### 1ª Avaliação — O que saber

#### Por que ordenar?

Ordenar reduz o custo das consultas posteriores, permite critérios estáveis de apresentação e é pré-requisito de estruturas e buscas eficientes (por exemplo, busca binária e algumas árvores). Sem ordem, cada pesquisa tende a percorrer a coleção inteira.

#### Ordenação por 1ª, 2ª e 3ª chave (ordenação aninhada)

É o desempate por critérios sucessivos:

1. **1ª chave:** critério principal (ex.: nome).
2. **2ª chave:** usado só quando a 1ª chave empata (ex.: idade).
3. **3ª chave:** novo desempate (ex.: matrícula).

Na prática: compara-se o critério 1; se for igual, o critério 2; se ainda for igual, o critério 3.

#### Grau de complexidade

Mede o esforço do algoritmo em função do tamanho da entrada (comparações, trocas, tempo). Exemplos do curso:

- **Baixa complexidade (simples, em geral O(n²)):** Bubble Sort, Selection Sort, Insertion Sort — fáceis de implementar; ruins em listas grandes.
- **Alta complexidade de implementação, melhor desempenho (em geral O(n log n)):** Merge Sort, Quick Sort, Comb/Pente — mais código e recursão/particionamento; adequados a volumes maiores.

#### Três métodos que devem ser reescritos (e o motivo)

Ao ordenar/pesquisar **objetos** (não só `Integer`), esses métodos definem como o objeto é visto, comparado e considerado igual:

- **`toString()`:** representação textual amigável do objeto (exibição na View, logs e depuração). Sem ele, aparece só a referência padrão da classe.
- **`compareTo()` (`Comparable` / `Comparator`):** critério de ordem (1ª/2ª/3ª chave). Retorna < 0, 0 ou > 0 e é o que os algoritmos usam para decidir quem vem antes.
- **`equals()`:** igualdade lógica entre objetos (não a igualdade de referência). Necessário para busca, remoção e estruturas que testam se dois elementos são o mesmo dado.

#### Qual o melhor método de pesquisa e ordenação para cada situação?

Não existe um único “melhor”; depende do volume, da memória, da implementação e se os dados já estão quase ordenados:

| Situação | Caminho típico |
| --- | --- |
| Lista pequena / didática | Bolha, Seleção ou Inserção |
| Lista quase ordenada | Inserção (poucas movimentações) |
| Volume grande, divisão equilibrada, estabilidade | Merge Sort |
| Volume grande, boa escolha de pivô, pouca memória extra | Quick Sort |
| Melhoria simples sobre a bolha | Pente (Comb Sort) |
| Pesquisa em lista **desordenada** | Sequencial (linear) |
| Pesquisa em lista **ordenada** | Binária (muito menos comparações) |


AULA 08

estabilidade vs Instabilidade
estavel:
        bolha, insercao e merge
instaveis: 
          seleção 
          pente(por causa da distancia/gap/h)
          quick(por causa da distancia)
Complexida: alta(muito esforço) versus baixa(pouco esforço)
  -- como se calcula o esforço ou a complexidade em ordenacao = (quantidade de comparacoes + quantidade de trocas)
  -Funções de Complexidade:
  - O(n!) -  fatorial
  - O(n^k) - polinomial
  - O(n^2) - exponencial
  - O(n. log n) - linear vezes logaritmica
  - O(n) - linear (1000 elementos = 1000 de esforço)
  - O(log n) logaritmica(todos os algoritmos baseados na filosifa de ÁRVORE)
  *Peculiaridades*
  - bolha - agitacao: a estrutura ja estiver ordenada, ha baixo esforço - O(n) 
  pente: com a entrada da distancia, o pente fica muito melhor em termos de complexidade. o pente trabalha com distancia. Enquanto a distancia foi > 1, o metodo é instavel, quando a distancia = 1, o metodo se transforma no bolha e fica estavel.
  - seleção: se um vetor estiver ordenado, o metodo continua fazendo o mesmo esforço de ordenação de um vetor desordenado.
  MERGE e o QUICk: sao baseados em tecnicas recursivas. Para cada metodo, há dois submetodos. ex:
  merge: chamada recursiva e o submetodo intercalação(ordenação se da na volta do empilhamento)(dividi o max que da e depois volta ordenando)
  quick: chamada recursiva e o submetodo ´posicionar o pivo no seu lugar certo no empilhamento´, C# o utiliza
  ganha em processamento mas perde em memoria(!conferir essa afirmacao)


--Outros metodos de ordenacao
*SHELL SORT*: uma evolucao do insercao. Usa a mesma filosofia do pente com o bolha. Ou seja aplica o uso de distancia(gap).
*NOTA:* Como o pente, o shell, ao trabalhar com distancia é instavel, mas quando a distancia fica 1 ele se transforma no inserção e passa a ser estavel

*HEAP SORT*: baseado na teoria de arvore, porem dentro de uma lista

*BUCKET SORT*: metodo de ordenacao pelo digito do numero

*RADIX SORT*: melhoria do bucket


*Exemplo em c# do bolha*

void bolha(List<int>lista)
{
  int tmp, dist = lista.Count();
  bool houve_troca;
  do 
  {
    dist = (int)dist /1.3;
    if(dist <= 1)
    {
      dist = 1;
    }
    houve_troca = false;
    for(int i = 0; i+dist < lista.Count() -1; i++)
    {
      if(lista[i] > lista[i+dist])
      {
        houve_troca = true;
        tmp = lista[i];
        lista[i] = lista[i+dist];
        lista[i+dist] = tmp;
      }
    }
  }while(dist > 1 || houve_troca);
}
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

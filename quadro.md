#  Caderno de Anotações: Métodos de Pesquisa e Ordenação

---

## Aula 1: Fundamentos & Ordenação

### Conceitos Fundamentais
* **Complexidade:** Medida do esforço computacional (tempo de execução e uso de memória).
* **Ordenação:** Mensurada principalmente pela **quantidade de comparações** e **quantidade de trocas** realizadas.

### Operações Básicas (CRUD)
* **C (Create):** Criação / Inserção de dados
* **R (Retrieve / Read):** Leitura / Consulta de dados
* **U (Update):** Atualização / Alteração de dados
* **D (Delete):** Remoção / Exclusão de dados

> **Nota:** Para a utilização eficiente de determinadas estruturas (como Árvores Binárias de Busca), os dados precisam estar **ordenados**.

### Algoritmos de Ordenação
* **Bubble Sort:** O maior elemento "sobe" como uma bolha a cada iteração até o final da lista *(uso majoritariamente didático)*.
* **Merge Sort:** Algoritmo de divisão e conquista com complexidade O(n log n).
* **Quick Sort:** Ordenação rápida baseada em escolha de pivô e particionamento.

---

## Aula 2: Medição de Desempenho & Arquitetura

* **Temporização (Benchmarking):** Medição e análise prática do tempo de execução dos algoritmos sob diferentes volumes de dados.
* **Padrão MVC (Model-View-Controller):** Separação de responsabilidades para organização e padronização do código:
  * **Model:** Estruturas de dados, entidades e regras de negócio.
  * **View:** Interface de apresentação e interação com o usuário (console/UI).
  * **Controller:** Intermediador do fluxo entre a interface e os dados.

---

## Aula 3: Implementação de Algoritmos Básicos

### Métodos de Ordenação Trabalhados
1. **Selection Sort (Seleção):** Busca iterativamente o menor elemento restante e o posiciona no início.
2. **Insertion Sort (Inserção):** Constrói a ordenação inserindo cada elemento em sua posição relativa na sublista já ordenada.
3. **Bubble Sort (Bolha):** Realiza trocas consecutivas de pares adjacentes fora de ordem.

### Atividade / Próximos Passos
* Refatorar a implementação dos métodos de ordenação para operarem dentro da arquitetura **MVC**.

---

## Aula 4: MVC no Bubble Sort, Métodos Java & Camadas

### Aplicação Prática de MVC
* Isolamento do algoritmo de ordenação dentro da camada de service/controller.
* Modelagem de classes de domínio organizadas no `Model`.

### Métodos Essenciais em Java
* **`compareTo()` (`Comparable` / `Comparator`):** Define o critério de comparação e ordem natural entre objetos (retorna < 0, 0 ou > 0).
* **`equals()`:** Responsáveis pela verificação de igualdade lógica e geração de hash para estruturas associativas.
* **`toString()`:** Sobrescrita para representação amigável do objeto.

### Arquitetura de Software
* **Construção e Refatoração em Camadas:** Desacoplamento de responsabilidades, facilitando manutenção, escalabilidade e legibilidade do código.
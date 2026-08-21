# 📚 Aula 04 - Migração e Aplicação do Padrão MVC

## Objetivo

Migrar o código Java existente para outra linguagem de programação aplicando o padrão arquitetural **MVC** (Model-View-Controller).

---

## Task

### 1 Código de Referência

- **Localização**: `aula04/example/OrdenaListaObjetos.java`
- Estude o código Java para entender a lógica e estrutura

### 2 Migração de Linguagem

Escolher **uma** das seguintes linguagens e migre o código:

-  **Python**
-  **C#**
-  **C++**

### 3️ Aplicar o Padrão MVC

Estruture o código migrado seguindo o padrão **Model-View-Controller**:

| Componente     | Responsabilidade                       |
| -------------- | -------------------------------------- |
| **Model**      | Lógica de negócio e ordenação de dados |
| **View**       | Apresentação e exibição dos resultados |
| **Controller** | Intermediário entre Model e View       |

---

## Estrutura de Diretórios

A estrutura esperada é similar à de `aula03/project/`:

```
aula04/
├── app/
│   ├── __init__.py
│   ├── main.py
│   ├── controller/
│   │   ├── __init__.py
│   │   └── [seu_controller].py
│   ├── model/
│   │   ├── __init__.py
│   │   └── [sua_logica].py
│   └── view/
│       ├── __init__.py
│       └── [sua_view].py
└── example/
    └── OrdenaListaObjetos.java
```

---

## Checklist de Implementação

- [x] Código migrado para a linguagem escolhida
- [x] Padrão MVC implementado corretamente
- [x] Model contém a lógica de ordenação
- [x] View realiza a exibição de dados
- [x] Controller coordena as operações
- [x] Código testado e funcional

# Comex

## Informações gerais dos pedidos em _pedidos.csv_
- Campos: **CATEGORIA, PRODUTO, PREÇO, QUANTIDADE, DATA, CLIENTE**


### RELATÓRIO DE VALORES TOTAIS
- TOTAL DE PEDIDOS REALIZADOS: 16
- TOTAL DE PRODUTOS VENDIDOS: 35
- TOTAL DE CATEGORIAS: 5
- MONTANTE DE VENDAS: R$ 178.374,49
- PEDIDO MAIS BARATO: R$ 95,17 (Clean Code)
- PEDIDO MAIS CARO: R$ 55.056,00 (iPhone 13 Pro)


### QUESTÕES DDD

#### 1 - Quais padrões táticos do DDD cada classe implementa?
As classes possuem linguagem ubíqua, com nomeclaturas claras e oróximas ao mundo real. O código também foi organizado/dividido em 3 pacotes: aplicacao, dominio e infra, facilitando manutenções futuras.

#### 2 - Quais os agregados da aplicação, qual sua raiz e que classes os compõem?
A classe Usuario é uma agregada, tendo como dependente a classe Perfil.

#### 3 - Quais contextos delimitados existem?
Os controllers, onde há os métodos de listar todos, listar por id, inserir, alterar e remover.
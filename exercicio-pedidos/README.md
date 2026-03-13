# Sistema de Pedidos (Composição & Enums)

Este projeto foi desenvolvido como um exercício prático para consolidar os conceitos de **Enumerações** e **Composição** em Java, fazendo parte da Seção 12 do curso de Java Completo do professor Nelio Alves.

## Enunciado do Desafio
O objetivo foi criar um sistema capaz de ler os dados de um pedido com N itens. Ao final, o programa deve exibir um sumário completo detalhando o instante do pedido, seu status, os dados do cliente e a listagem de todos os itens com seus respectivos subtotais e o preço total final.


## Tecnologias e Conceitos Aplicados
Neste exercício, apliquei os tópicos estudados na Seção 12 (mais outros de seções anteriores):

* **Enumerações (Enums):** Para representar os estados do pedido (`PENDING_PAYMENT`, `PROCESSING`, `SHIPPED`, `DELIVERED`).
* **Composição de Objetos:** Implementação da relação "Tem-um", onde a classe `Order` contém `Client` e uma lista de `OrderItem`.
* **StringBuilder:** Utilizado no método `toString` da classe `Order` para montar o relatório final de forma eficiente.
* **Lógica de Programação:** Cálculos de subtotal por item e total geral do pedido delegados às classes responsáveis.

## 🏗️ Estrutura do Projeto
* `application`: Classe `Program` com a lógica de interação com o usuário.
* `entities`: Classes de modelo como `Client`, `Product`, `Order` e `OrderItem`.
* `entities.enums`: Enumeração `OrderStatus`.

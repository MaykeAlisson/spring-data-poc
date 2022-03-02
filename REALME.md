docker run --name mysqldb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=jesus -d mysql

# Cozinha
{
    "nome": "Tailandeza"
}
------
{
    "nome": "Brasileira"
}
-----
{
    "nome": "Japoneza"
}
-----
{
    "nome": "Mexicana"
}

# Restaurante
{
    "nome": "Comida TAI",
    "taxaFrete": 10.50,
    "idCozinha": 1
}

# Usuario
{
"nome": "Mayke",
"ddd": "34",
"telefone": "1345678978",
"endereco" : {
        "cep": "38414356",
        "numero": 451
}
}

# PedidoRequest
{
"itens": [
{
"descricao": "Item1",
"quantidade": 3,
"valor": 10.35
},
{
"descricao": "Item2",
"quantidade": 2,
"valor": 8.38
}
],
"idUsuario": 1,
"idRestaurante": 1,
"idFormaPagamento": 1,
"status": {
"descricao": "Status",
"ocorencia": "2021-03-04T18:43:36"
}
}

# Spring Data Jpa

### keywords  
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords

* findBy{ATRIBUTO} : Busca onde atributo igual valor passado
* findBy{ATRIBUTO}Containing : Busca onde ATRIBUTO contem (like = %valor%)
* existsBy{ATRIBUTO} : Retorna um boolean se existe o atributo com o valor informado
* countBy{ATRIBUTO} : Retorna a quantidade de resgistro com o valor do atributo informado

#### * Todo relacionamento com o final ...ToOne por default usa Eager Loading
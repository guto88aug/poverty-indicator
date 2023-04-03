<h1>Bem-vindo ao Proverty Indicator</h4>
Serviço responsável por consultar informações de indicadores e paises das APIs do World Bank


O Banco Mundial https://www.worldbank.org/ mantém uma série de indicadores econômicos, disponibilizados web, arquivos para download, e APIs. Um desses dados é o indicador que avalia a quantidade de pessoas em situação de extrema pobreza no mundo, vivendo com até $ 1,90/dia. Este desafio consiste em construir uma aplicação que apresente os indicadores de determinado país (um voz vez), ordenados por ano. A aplicação deve permitir que o usuário digite o código do país para em seguida solicitar os índices históricos. Ou seja, quando o usuário entrar no sistema, irá visualizar um formulário, após o preenchimento e submissão desse, será apresentada uma tabela com o resultado obtido da API do Banco Mundial.

Estruta da aplicação

<b>Backend</b>

Sistema Java desenvolvido em spring boot na versão 2.7.0, utilizando o feing para orquestração de acesso ao banco mundial (http://api.worldbank.org).

<b>Frontend</b>

Sistema em Angular na versão 15.2.4, com material.

<b>Execução do projeto</b>

### Passo 1

Clonar o projeto pelo endereço abaixo:

```shell script
$ git clone https://github.com/guto88aug/poverty-indicator.git poverty-indicator
```

### Passo 2 
Acessa o diretório no qual foi clonado o objeto

```shell script
$ cd poverty-indicator
```
### Passo 3 
Executar o Docker compose

```shell script
$ docker-compose up -d
```

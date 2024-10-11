# Projeto 1 - Estrutura de Dados Avançada

Este projeto implementa operações em grafos, incluindo a Dupla Coloração e outras manipulações em grafos. Ele foi desenvolvido como parte da disciplina de Estrutura de Dados Avançada.
## 🚀 Funcionalidades

Leitura de Grafos a partir de arquivos de texto no formato especificado.
Dupla Coloração de grafos.
Outras operações relacionadas a grafos, como cálculo de caminhos, conexões e análise de componentes.

## 🛠 Modos de Execução

Você pode executar o projeto de duas formas:
1. Usando o arquivo JAR

Para rodar o programa usando o arquivo JAR pré-compilado:

Abra o Prompt de Comando (CMD) no seu computador.
Navegue até o diretório onde o arquivo CodeDFSAdjacencyMatrix.jar está localizado.
Execute o seguinte comando:

```bash
java -jar CodeDFSAdjacencyMatrix.jar
```
2. Usando o código fonte

Caso prefira compilar e executar o código fonte:
Abra o projeto em uma IDE de sua preferência (como IntelliJ IDEA, Eclipse, ou NetBeans).
Execute a classe Main para rodar o programa.

## 📂 Formato de Entrada

O programa requer um arquivo de entrada de texto (.txt) para definir o grafo. O arquivo deve seguir a seguinte estrutura:

Primeira linha: Define se o grafo é Direcionado (D) ou Não Direcionado (ND).
Linhas subsequentes: Cada linha define uma aresta no formato vértice1,vértice2, representando uma conexão entre os dois vértices.

Exemplo de arquivo de entrada:
```bash
ND
1,2
2,3
3,4
```
Nesse exemplo, o grafo é não direcionado e possui três arestas: uma ligando os vértices 1 e 2, outra entre os vértices 2 e 3, e a última entre os vértices 3 e 4.
## 📝 Execução do Programa

### Executando o Programa:
Ao iniciar o programa, um menu será exibido.
Selecione a primeira opção para carregar o arquivo de entrada do grafo.

### Inserindo o Caminho do Arquivo:
Quando solicitado, digite o caminho completo para o arquivo .txt de entrada.

### Operações no Grafo:
Após carregar o grafo, você poderá realizar diversas operações, como a Dupla Coloração e outras análises relacionadas ao grafo.

### Gerando Arquivo de Saída:
Ao final das operações, se desejar gerar um arquivo de saída, forneça o nome do arquivo e o caminho onde ele deve ser salvo.

## ⚙️ Requisitos

Java 17 ou superior instalado.
Um arquivo de entrada .txt contendo o grafo a ser analisado.

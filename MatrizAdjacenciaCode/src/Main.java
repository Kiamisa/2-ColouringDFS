import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = null;
        BPColoracao BPColoracao = null;
        OpGrafo opGrafo = null;

        // Exibe o menu principal
        while (true) {
            System.out.println("\n---- Menu Principal ----");
            System.out.println("1. Carregar Grafo");
            System.out.println("2. Realizar Coloração");
            System.out.println("3. Salvar Resultado em Arquivo");
            System.out.println("4. Operações no Grafo");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            // Lê a opção do usuário
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o caminho do arquivo: ");
                    String caminhoArquivo = scanner.nextLine();
                    fileManager = new FileManager(caminhoArquivo);
                    int[][] arestas = fileManager.getArestasList().toArray(new int[0][]);
                    BPColoracao = new BPColoracao(fileManager.getMatAdj(),arestas);
                    opGrafo = new OpGrafo(fileManager.getMatAdj());
                    System.out.println("Grafo carregado com sucesso.");
                    break;
                case 2:
                    if (BPColoracao == null) {
                        System.out.println("Carregue um grafo primeiro (opção 1).");
                    } else {
                        BPColoracao.TesteVisita();
                        System.out.println("Coloração realizada com sucesso.");
                    }
                    break;
                case 3:
                    if (BPColoracao == null) {
                        System.out.println("Carregue um grafo primeiro (opção 1).");
                    } else {
                        System.out.print("Digite o caminho do arquivo de saída: ");
                        String caminhoSaida = scanner.nextLine();
                        BPColoracao.Saida(caminhoSaida);
                        System.out.println("Resultado salvo com sucesso.");
                    }
                    break;
                case 4:
                    if (opGrafo == null) {
                        System.out.println("Carregue um grafo primeiro (opção 1).");
                    } else {
                        menuOperacoesGrafo(opGrafo, scanner);
                    }
                    break;
                case 5:
                    System.out.println("Saindo do programa. Até mais!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void menuOperacoesGrafo(OpGrafo opGrafo, Scanner scanner) {
        while (true) {
            System.out.println("\n---- Operações no Grafo ----");
            System.out.println("1. Verificar se dois vértices são adjacentes");
            System.out.println("2. Calcular o grau de um vértice");
            System.out.println("3. Buscar todos os vizinhos de um vértice");
            System.out.println("4. Visitar todas as arestas do grafo");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma operação: ");

            int OpOperacao = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer do scanner

            switch (OpOperacao) {
                case 1:
                    verificarAdjacentes(scanner, opGrafo);
                    break;
                case 2:
                    calcularGrau(scanner, opGrafo);
                    break;
                case 3:
                    buscarVizinhos(scanner, opGrafo);
                    break;
                case 4:
                    visitarArestas(opGrafo);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void verificarAdjacentes(Scanner scanner, OpGrafo opGrafo) {
        System.out.print("Digite o primeiro vértice (vX): ");
        int vX = scanner.nextInt();
        System.out.print("Digite o segundo vértice (vY): ");
        int vY = scanner.nextInt();

        boolean saoAdjacentes = opGrafo.saoAdjacentes(vX, vY);
        if (saoAdjacentes) {
            System.out.println("Os vértices " + vX + " e " + vY + " são adjacentes.");
        } else {
            System.out.println("Os vértices " + vX + " e " + vY + " não são adjacentes.");
        }
    }

    private static void calcularGrau(Scanner scanner, OpGrafo opGrafo) {
        System.out.print("Digite o vértice para calcular o grau: ");
        int vertice = scanner.nextInt();

        int grau = opGrafo.calcularGrauVertice(vertice);
        System.out.println("O grau do vértice " + vertice + " é: " + grau);
    }

    private static void buscarVizinhos(Scanner scanner, OpGrafo opGrafo) {
        System.out.print("Digite o vértice para buscar vizinhos: ");
        int vertice = scanner.nextInt();

        int[] vizinhos = opGrafo.vizinhosDoVertice(vertice);
        System.out.println("Vizinhos do vértice " + vertice + ": " + Arrays.toString(vizinhos));
    }

    private static void visitarArestas(OpGrafo opGrafo) {
        opGrafo.visitarArestas();
    }
}

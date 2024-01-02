import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class BPColoracao {
    private int[][] matrizAdjacencia;
    private int[] coresVertices;
    private boolean[] visitado;
    private int[][] arestas;

    public BPColoracao(int[][] matrizAdjacencia, int[][] arestas) {
        if (matrizAdjacencia == null || matrizAdjacencia.length == 0 || matrizAdjacencia.length != matrizAdjacencia[0].length) {
            throw new IllegalArgumentException("Matriz de adjacência inválida.");
        }

        this.matrizAdjacencia = matrizAdjacencia;
        int numVert = matrizAdjacencia.length;
        this.coresVertices = new int[numVert];
        Arrays.fill(coresVertices, -1);
        this.visitado = new boolean[numVert];
        this.arestas = arestas;
    }


    public void TesteVisita() {
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            if (!visitado[i]) {
                if (!BuscaProfundidade(i, 0)) {
                    return;
                }
            }
        }
    }

    private boolean BuscaProfundidade(int vert, int corAtual) {
        visitado[vert] = true;
        coresVertices[vert] = corAtual;

        System.out.println("Visitando vértice " + vert + " com cor " + corAtual);

        int novaCor = (corAtual + 1) % 2; // Usando apenas duas cores (0 e 1)

        for (int vizinho = 0; vizinho < matrizAdjacencia.length; vizinho++) {
            if (matrizAdjacencia[vert][vizinho] == 1) {
                if (!visitado[vizinho]) {
                    // Encontrou um vértice não visitado, mapeia a cor corretamente
                    if (!BuscaProfundidade(vizinho, novaCor)) {
                        return false;
                    }
                } else if (coresVertices[vert] == coresVertices[vizinho]) {
                    System.out.println("Conflito de cores entre vértices " + vert + " e " + vizinho);
                    return false;
                }
            }
        }
        return true;
    }

    public void Saida(String filePath) {
        try (FileWriter escritor = new FileWriter(filePath)) {
            escritor.write("\nResultado:\n");
            for (int i = 1; i < coresVertices.length; i++) {
                String linha = String.format("O vértice %d tem a cor %d%n", i, coresVertices[i]);
                escritor.write(linha);
            }
            escritor.write("\nArestas:\n");
            for (int[] aresta : arestas) {
                int vertice1 = aresta[0];
                int vertice2 = aresta[1];
                String linha = String.format("(%d,%d)%n", vertice1, vertice2);
                escritor.write(linha);
            }
            System.out.println("Salvo com sucesso: " + filePath);
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}

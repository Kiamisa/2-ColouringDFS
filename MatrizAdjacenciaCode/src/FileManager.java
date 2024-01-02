import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    private String caminho;
    private boolean ehDirecionado;
    private int[][] matrizAdjacencia;
    private int NumVert;
    private List<int[]> arestasList;

    public FileManager(String caminho) {
        this.caminho = caminho;
        try {
            this.matrizAdjacencia = ConstrucaoMatriz();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado. Verifique o caminho e tente novamente.");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Erro na construção da matriz de adjacência: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private int[][] ConstrucaoMatriz() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(caminho));

        if (!scanner.hasNextLine()) {
            throw new IllegalArgumentException("Arquivo vazio.");
        }

        String primLinha = scanner.nextLine().trim().toUpperCase();
        if(primLinha.equals("D")){
            this.ehDirecionado=true;
        }else if(primLinha.equals("ND")){
            this.ehDirecionado=false;
        }else{
            throw new IllegalArgumentException("Formato de grafo inválido. Por favor, digite 'D' ou 'ND'");
        }

        arestasList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            int[] arestas = proxAresta(scanner);
            arestasList.add(arestas);
        }

        int numVert = arestasList.stream().mapToInt(a -> Math.max(a[0], a[1])).max().orElse(0) + 1;
        int[][] matrizAdj = new int[numVert][numVert];

        for (int[] arestas : arestasList) {
            int verticeOrigem = arestas[0];
            int verticeDestino = arestas[1];

            if (verticeOrigem >= 0 && verticeOrigem < numVert && verticeDestino >= 0 && verticeDestino < numVert) {
                matrizAdj[verticeOrigem][verticeDestino] = 1;
                if (!ehDirecionado) {
                    matrizAdj[verticeDestino][verticeOrigem] = 1;
                }
            }
        }
        this.NumVert = numVert;
        return matrizAdj;
    }

    private int[] proxAresta(Scanner scanner) throws IllegalArgumentException {
        String[] parte = scanner.nextLine().split(",");
        if (parte.length != 2) {
            throw new IllegalArgumentException("Erro ao ler aresta! Verifique se há algum erro.");
        } else {
            int vX = Integer.parseInt(parte[0]);
            int vY = Integer.parseInt(parte[1]);
            if (ehDirecionado) {
                return new int[]{vX, vY};
            } else {
                return new int[]{Math.min(vX, vY), Math.max(vX, vY)};
            }
        }
    }

    public int[][] getMatAdj() {
        return matrizAdjacencia;
    }

    public List<int[]> getArestasList() {
        return arestasList;
    }
}

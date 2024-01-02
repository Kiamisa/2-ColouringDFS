public class OpGrafo {
    private int[][] matrizAdjacencia;
    private boolean ehDirecionado;

    public OpGrafo(int[][] matrizAdjacencia) {
        if (matrizAdjacencia == null || matrizAdjacencia.length == 0 || matrizAdjacencia.length != matrizAdjacencia[0].length) {
            throw new IllegalArgumentException("Matriz de adjacência inválida.");
        }

        this.matrizAdjacencia = matrizAdjacencia;
        this.ehDirecionado = ehDirecionado;
    }

    public boolean saoAdjacentes(int vX, int vY) {
        if (vX < 0 || vX >= matrizAdjacencia.length || vY < 0 || vY >= matrizAdjacencia.length) {
            throw new IllegalArgumentException("Vértices inválidos.");
        }

        if (ehDirecionado) {
            return matrizAdjacencia[vX][vY] == 1;
        } else {
            return matrizAdjacencia[vX][vY] == 1 || matrizAdjacencia[vY][vX] == 1;
        }
    }

    public int calcularGrauVertice(int vertice) {
        if (vertice < 0 || vertice >= matrizAdjacencia.length) {
            throw new IllegalArgumentException("Vértice inválido.");
        }

        int grau = 0;
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            if (ehDirecionado) {
                grau += matrizAdjacencia[vertice][i];
            } else {
                grau += matrizAdjacencia[vertice][i] + matrizAdjacencia[i][vertice];
            }
        }
        return grau;
    }
    public int[] vizinhosDoVertice(int vertice) {
        if (vertice < 0 || vertice >= matrizAdjacencia.length) {
            throw new IllegalArgumentException("Vértice inválido.");
        }

        int grau = calcularGrauVertice(vertice);
        int[] vizinhos = new int[grau];
        int index = 0;

        for (int i = 0; i < matrizAdjacencia.length; i++) {
            if (ehDirecionado) {
                if (matrizAdjacencia[vertice][i] == 1) {
                    vizinhos[index++] = i;
                }
            } else {
                if (matrizAdjacencia[vertice][i] == 1 || matrizAdjacencia[i][vertice] == 1) {
                    vizinhos[index++] = i;
                }
            }
        }

        return vizinhos;
    }
    public void visitarArestas() {
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                if (ehDirecionado) {
                    if (matrizAdjacencia[i][j] == 1) {
                        System.out.println("Aresta do vértice " + i + " para o vértice " + j);
                    }
                } else {
                    if (matrizAdjacencia[i][j] == 1) {
                        System.out.println("Aresta entre os vértices " + i + " e " + j);
                    }
                }
            }
        }
    }
}

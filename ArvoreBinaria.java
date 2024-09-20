public class ArvoreBinaria {
    private Node raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    // Método de inserir com double
    public void inserir(double valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    // Método inserir recursivo com double
    private Node inserirRecursivo(Node atual, double valor) {
        if (atual == null) {
            return new Node(valor); 
        }

        if (valor < atual.valor) {
            atual.esquerdo = inserirRecursivo(atual.esquerdo, valor);
        } else if (valor > atual.valor) {
            atual.direito = inserirRecursivo(atual.direito, valor);
        }

        return atual; 
    }

    // Método de travessia in-order
    public void inOrder() {
        inOrderRecursivo(raiz);
    }

    private void inOrderRecursivo(Node atual) {
        if (atual != null) {
            inOrderRecursivo(atual.esquerdo);
            System.out.print(atual.valor + " ");
            inOrderRecursivo(atual.direito);
        }
    }

    // Método de remoção
    public void remover(double valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    // Método remover recursivo com double
    private Node removerRecursivo(Node atual, double valor) {
        if (atual == null) {
            return null;
        }

        if (valor < atual.valor) {
            atual.esquerdo = removerRecursivo(atual.esquerdo, valor);
        } else if (valor > atual.valor) {
            atual.direito = removerRecursivo(atual.direito, valor);
        } else {
            if (atual.esquerdo == null && atual.direito == null) {
                return null;
            } else if (atual.esquerdo == null) {
                return atual.direito;
            } else if (atual.direito == null) {
                return atual.esquerdo;
            } else {
                Node sucessor = encontrarMenorValor(atual.direito);
                atual.valor = sucessor.valor;
                atual.direito = removerRecursivo(atual.direito, sucessor.valor);
            }
        }
        return atual;
    }

    // Método auxiliar para encontrar o menor valor (sucessor)
    private Node encontrarMenorValor(Node atual) {
        while (atual.esquerdo != null) {
            atual = atual.esquerdo;
        }
        return atual;
    }
}

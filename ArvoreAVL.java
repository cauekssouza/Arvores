// Classe Arvore Avl 
public class ArvoreAVL {

    // Método para obter a altura de um nó
    int altura(No no) {
        if (no == null) {
            return 0;
        }
        return no.altura;
    }

    // Método para obter o valor máximo
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Rotação para a direita
    No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        // Realiza a rotação
        x.direita = y;
        y.esquerda = T2;

        // Atualiza as alturas dos nós
        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;

        return x; // Retorna nova raiz
    }

    // Rotação para a esquerda
    No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        // Realiza a rotação
        y.esquerda = x;
        x.direita = T2;

        // Atualiza as alturas dos nós
        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;

        return y; // Retorna nova raiz
    }

    // Método de balanceamento
    int getBalance(No no) {
        if (no == null) {
            return 0;
        }
        return altura(no.esquerda) - altura(no.direita);
    }

    // Função para inserir um nó na árvore AVL
    No inserir(No no, int chave) {
        if (no == null) {
            return new No(chave);
        }

        if (chave < no.chave) {
            no.esquerda = inserir(no.esquerda, chave);
        } else if (chave > no.chave) {
            no.direita = inserir(no.direita, chave);
        } else {
            return no; // Não permite chaves duplicadas
        }

        // Atualiza a altura do nó ancestral
        no.altura = 1 + max(altura(no.esquerda), altura(no.direita));

        // Obtém o fator de balanceamento
        int balance = getBalance(no);

        // Caso esquerdo
        if (balance > 1 && chave < no.esquerda.chave) {
            return rotacaoDireita(no);
        }

        // Caso direito direito
        if (balance < -1 && chave > no.direita.chave) {
            return rotacaoEsquerda(no);
        }

        // Caso esquerdo direito
        if (balance > 1 && chave > no.esquerda.chave) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        // Caso direito esquerdo
        if (balance < -1 && chave < no.direita.chave) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        // Retorna o nó (inalterado) se estiver balanceado
        return no;
    }

    // Método para imprimir a árvore em ordem pré-fixada
    void preOrder(No no) {
        if (no != null) {
            System.out.print(no.chave + " ");
            preOrder(no.esquerda);
            preOrder(no.direita);
        }
    }
}

// Classe auxiliar para representar um nó da árvore AVL
class No {
    int chave;
    No esquerda, direita;
    int altura;

    public No(int chave) {
        this.chave = chave;
        this.altura = 1; 
    }
}

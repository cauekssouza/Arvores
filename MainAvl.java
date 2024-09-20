public class MainAvl {
    public static void main(String[] args) {
        ArvoreAVL arvoreAVL = new ArvoreAVL();
        No raiz = null;

        // Inserindo valores na árvore
        raiz = arvoreAVL.inserir(raiz, 10);
        raiz = arvoreAVL.inserir(raiz, 20);
        raiz = arvoreAVL.inserir(raiz, 30);
        raiz = arvoreAVL.inserir(raiz, 35);
        raiz = arvoreAVL.inserir(raiz, 90);
        raiz = arvoreAVL.inserir(raiz, 100);
        raiz = arvoreAVL.inserir(raiz, 110);

        // Percorrendo a árvore em ordem pré-fixada
        System.out.println("Percurso da Árvore AVL:");
        arvoreAVL.preOrder(raiz);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        // Inserção de valores na árvore
        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(20);
        arvoreBinaria.inserir(30);
        arvoreBinaria.inserir(40);
        arvoreBinaria.inserir(50);
        arvoreBinaria.inserir(60);
        arvoreBinaria.inserir(70);
        arvoreBinaria.inserir(80);
        arvoreBinaria.inserir(90);
        arvoreBinaria.inserir(13);


        // Exibe a árvore em ordem
        System.out.println("Travessia em ordem:");
        arvoreBinaria.inOrder();
        System.out.println(); 

        
        arvoreBinaria.remover(10);
        
       

        // Exibe a árvore novamente após a remoção
        System.out.println("Travessia em ordem: ");
        arvoreBinaria.inOrder();
        System.out.println(); 
    }
}

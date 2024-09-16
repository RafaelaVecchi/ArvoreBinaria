public class Main {
    public static void main(String[] args){

        ArvoreBinBusca arvore = new ArvoreBinBusca();

        int[] valores = {14, 15, 4, 9, 7, 18, 3, 5, 16, 20, 17, 9, 5};

        // loop para inserir os elementos na árvore binária
        for(int valor : valores){
            arvore.inserirElemento(valor);
        }

        // exemplo de percurso InOrder
        System.out.println("===== In-Ordem =====");
        arvore.percorrerPosOrdem();

        // Remover maior e menor
        arvore.removerMaior();
        arvore.removerMenor();

        // Remover um elemento com valor N
        arvore.removeElemento(5);

        System.out.println("==== InOrder após remoção do Menor e Maior elemento: ====");
        arvore.percorrerPosOrdem();
    }
}

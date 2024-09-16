// uma arvore binária de busca não possui elementos repetidos
// a raiz é sempre o primeiro elemento
class ArvoreBinBusca {
    private Node raiz;
    public ArvoreBinBusca() {
        raiz = null;
    }

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public void inserirElemento(int dado) {
        if (isEmpty()) {
            this.raiz = new Node(dado);
            return;
        }
        inserirRecursivo(raiz, dado);
    }

    public void inserirRecursivo(Node atual, int dado) {
        if (dado > atual.getDado()) {
            if (atual.getDireita() == null) {
                atual.setDireita(new Node(dado));
                return;
            } else {
                inserirRecursivo(atual.getDireita(), dado);
            }
        }

        if (dado < atual.getDado()) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(new Node(dado));
                return;
            } else {
                inserirRecursivo(atual.getEsquerda(), dado);
            }
        }
    }

    // pré-ordem percorre pra esquerda primeiro
    public void percorrerPreOrdem() {
        percorrerPreOrdemRec(raiz);
        System.out.println();
    }

    private void percorrerPreOrdemRec(Node atual) {
        if (atual != null) {
            System.out.print(atual.getDado() + " "); // Visita o nó
            percorrerPreOrdemRec(atual.getEsquerda()); // Visita a subárvore esquerda
            percorrerPreOrdemRec(atual.getDireita()); // Visita a subárvore direita
        }
    }

    // in-ordem percorre na ordem, da esquerda para direita
    public void percorrerInOrdem() {
        percorrerInOrdemRec(raiz);
        System.out.println();
    }

    private void percorrerInOrdemRec(Node atual) {
        if (atual != null) {
            percorrerInOrdemRec(atual.getEsquerda()); // Visita a subárvore esquerda
            System.out.print(atual.getDado() + " "); // Visita o nó
            percorrerInOrdemRec(atual.getDireita()); // Visita a subárvore direita
        }
    }

    // pós-ordem percorre
    public void percorrerPosOrdem() {
        percorrerPosOrdemRec(raiz);
        System.out.println();
    }

    private void percorrerPosOrdemRec(Node atual) {
        if (atual != null) {
            percorrerPosOrdemRec(atual.getEsquerda()); // Visita a subárvore esquerda
            percorrerPosOrdemRec(atual.getDireita()); // Visita a subárvore direita
            System.out.print(atual.getDado() + " "); // Visita o nó
        }
    }

    // o maior elemento está localizado a extrema direita
    public void removerMaior() {
        if (raiz == null) {
            System.out.println("Àrvore Vazia");
            return;
        }
        raiz = removerMaiorRec(raiz);
        /* Ao atribuir o retorno da função recursiva removerMaiorRec() à variável raiz, garantimos que,
         * quando um nó é removido, o ponteiro que apontava para esse nó é atualizado para outro nó apropriado.*/
    }

    private Node removerMaiorRec(Node atual) {
        if (atual.getDireita() == null) {
            return atual.getEsquerda(); // O maior nó é removido, substituído pela subárvore esquerda (se houver)
        }
        atual.setDireita(removerMaiorRec(atual.getDireita())); // Continua procurando o maior na subárvore direita
        return atual;
    }

    // o menor elemento está localizado a extrema esquerda
    public void removerMenor() {
        if (raiz == null) {
            System.out.println("Àrvore Vazia");
            return;
        }
        raiz = removerMenorRec(raiz);
    }

    private Node removerMenorRec(Node atual) {
        if (atual.getEsquerda() == null) {
            return atual.getDireita(); // O menor nó é removido, substituído pela subárvore direita (se houver)
        }
        atual.setEsquerda(removerMenorRec(atual.getEsquerda())); // Continua procurando o menor na subárvore esquerda
        return atual;
    }

    // Método para remover um elemento com valor N
    public void removeElemento(int dado) {
        raiz = removerElementoRec(raiz, dado);
    }

    // Método recursivo para encontrar e remover o elemento
    private Node removerElementoRec(Node atual, int dado) {
        if (atual == null) {
            System.out.println("Valor " + dado + " não encontrado.");
            return null; // Elemento não encontrado
        }

        // Procura o valor N na árvore
        if (dado < atual.getDado()) {
            atual.setEsquerda(removerElementoRec(atual.getEsquerda(), dado));
        } else if (dado > atual.getDado()) {
            atual.setDireita(removerElementoRec(atual.getDireita(), dado));
        } else {
            // Caso o nó a ser removido tenha sido encontrado
            if (atual.getEsquerda() == null) {
                return atual.getDireita(); // Substitui pelo filho direito
            }
            if (atual.getDireita() == null) {
                return atual.getEsquerda(); // Substitui pelo filho esquerdo
            }

            // Nó com dois filhos: substitui pelo menor valor da subárvore direita
            Node sucessor = encontrarMinimo(atual.getDireita());
            atual.setDado(sucessor.getDado());
            atual.setDireita(removerElementoRec(atual.getDireita(), sucessor.getDado()));
        }
        return atual; // Retorna o nó atualizado
    }

    // Método auxiliar para encontrar o menor valor em uma subárvore
    private Node encontrarMinimo(Node atual) {
        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }
        return atual;
    }
}

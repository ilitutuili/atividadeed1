class No {
    String linha;
    No ant;
    No prox;

    public No(String linha) {
        this.linha = linha;
        this.ant = null;
        this.prox = null;
    }
}

class EditorTexto {
    private No inicio;
    private No fim;
    private int tamanho;

    public EditorTexto() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    // Inserir no início
    public void inserirInicio(String linha) {
        No novo = new No(linha);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.prox = inicio;
            inicio.ant = novo;
            inicio = novo;
        }
        tamanho++;
    }

    // Inserir no fim
    public void inserirFim(String linha) {
        No novo = new No(linha);
        if (fim == null) {
            inicio = fim = novo;
        } else {
            fim.prox = novo;
            novo.ant = fim;
            fim = novo;
        }
        tamanho++;
    }

    // Inserir em uma posição específica (1 = início)
    public void inserirPosicao(String linha, int posicao) {
        if (posicao < 1 || posicao > tamanho + 1) {
            System.out.println("Posição inválida!");
            return;
        }

        if (posicao == 1) {
            inserirInicio(linha);
            return;
        }

        if (posicao == tamanho + 1) {
            inserirFim(linha);
            return;
        }

        No novo = new No(linha);
        No atual = inicio;

        for (int i = 1; i < posicao - 1; i++) {
            atual = atual.prox;
        }

        novo.prox = atual.prox;
        novo.ant = atual;

        atual.prox.ant = novo;
        atual.prox = novo;

        tamanho++;
    }

    // Remover linha pela posição
    public void remover(int posicao) {
        if (posicao < 1 || posicao > tamanho) {
            System.out.println("Posição inválida!");
            return;
        }

        if (posicao == 1) {
            inicio = inicio.prox;
            if (inicio != null) inicio.ant = null;
            else fim = null;
            tamanho--;
            return;
        }

        if (posicao == tamanho) {
            fim = fim.ant;
            fim.prox = null;
            tamanho--;
            return;
        }

        No atual = inicio;
        for (int i = 1; i < posicao; i++) {
            atual = atual.prox;
        }

        atual.ant.prox = atual.prox;
        atual.prox.ant = atual.ant;

        tamanho--;
    }

    // Exibir do início ao fim
    public void exibirFrente() {
        No atual = inicio;
        int linha = 1;
        System.out.println("\n--- Documento (Frente) ---");
        while (atual != null) {
            System.out.println(linha + ": " + atual.linha);
            atual = atual.prox;
            linha++;
        }
    }

    // Exibir do fim ao início
    public void exibirTras() {
        No atual = fim;
        int linha = tamanho;
        System.out.println("\n--- Documento (Trás) ---");
        while (atual != null) {
            System.out.println(linha + ": " + atual.linha);
            atual = atual.ant;
            linha--;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();

        editor.inserirInicio("Linha A");
        editor.inserirFim("Linha B");
        editor.inserirFim("Linha C");
        editor.inserirPosicao("Linha Inserida na posição 2", 2);

        editor.exibirFrente();
        editor.exibirTras();

        editor.remover(3);

        editor.exibirFrente();
        editor.exibirTras();
    }
}

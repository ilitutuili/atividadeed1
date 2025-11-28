class Fila {
    private No inicio;
    private No fim;
    private int tamanho;

    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    // Adicionar cliente na fila
    public void enfileirar(int senha) {
        No novo = new No(senha);
        if (estaVazia()) {
            inicio = novo;
        } else {
            fim.prox = novo;
        }
        fim = novo;
        tamanho++;
    }

    // Chamar o próximo cliente
    public int desenfileirar() {
        if (estaVazia()) {
            System.out.println("Fila vazia!");
            return -1;
        }
        int senha = inicio.senha;
        inicio = inicio.prox;
        tamanho--;
        if (inicio == null) {
            fim = null;
        }
        return senha;
    }

    // Mostrar próximo da fila (sem remover)
    public int frente() {
        if (estaVazia()) {
            System.out.println("Fila vazia!");
            return -1;
        }
        return inicio.senha;
    }

    // Quantidade de clientes aguardando
    public int tamanho() {
        return tamanho;
    }

    // Verificar se está vazia
    public boolean estaVazia() {
        return tamanho == 0;
    }
}

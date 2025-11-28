import java.util.Scanner;

// Classe da Pilha
class Pilha {
    private int elementos[];
    private int topo;

    // Construtor
    public Pilha(int tamanho) {
        elementos = new int[tamanho];
        topo = -1;
    }

    // Operação empilhar
    public void empilhar(int elemento) {
        topo++;
        elementos[topo] = elemento;
    }

    // Operação desempilhar
    public int desempilhar() {
        int elemento = elementos[topo];
        topo--;
        return elemento;
    }

    // Operação topo
    public int topo() {
        return elementos[topo];
    }

    // Verifica se está vazia
    public boolean estaVazia() {
        return topo == -1;
    }
}

public class ConversaoDecimalBinario {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número inteiro positivo: ");
        int n = sc.nextInt();
        
        // Criando a pilha (tamanho suficiente)
        Pilha pilha = new Pilha(32); // 32 bits
        
        int numero = n;
        
        // Processo de conversão
        while (numero > 0) {
            int resto = numero % 2;     // calcula o bit
            pilha.empilhar(resto);      // empilha o resto
            numero = numero / 2;        // divide N por 2
        }
        
        // Exibindo o resultado binário (desempilhando)
        System.out.print("Binário: ");
        while (!pilha.estaVazia()) {
            System.out.print(pilha.desempilhar());
        }
        
        System.out.println();
    }
}

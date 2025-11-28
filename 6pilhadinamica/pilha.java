// ...existing code...
import java.util.Scanner;

public class pilha {
    // Pilha dinâmica usando lista ligada
    static class PilhaDin<T> {
        private static class Node<T> {
            T valor;
            Node<T> prox;
            Node(T v, Node<T> p) { valor = v; prox = p; }
        }

        private Node<T> topo;

        public PilhaDin() { topo = null; }

        public void push(T valor) {
            topo = new Node<>(valor, topo);
        }

        public T pop() {
            if (isEmpty()) return null;
            T v = topo.valor;
            topo = topo.prox;
            return v;
        }

        public T peek() {
            return isEmpty() ? null : topo.valor;
        }

        public boolean isEmpty() {
            return topo == null;
        }

        public void clear() {
            topo = null;
        }

        // Imprime do topo para a base (mais recente primeiro)
        public void printAll() {
            if (isEmpty()) {
                System.out.println("[Histórico vazio]");
                return;
            }
            System.out.println("Histórico (mais recente primeiro):");
            Node<T> cur = topo;
            int i = 1;
            while (cur != null) {
                System.out.printf("%d: %s%n", i++, cur.valor);
                cur = cur.prox;
            }
        }
    }

    // Menu simples para simular histórico de navegação
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilhaDin<String> historico = new PilhaDin<>();
        boolean rodando = true;

        while (rodando) {
            System.out.println();
            System.out.println("=== Simulador de Histórico de Navegação ===");
            System.out.println("1 - Adicionar nova URL");
            System.out.println("2 - Voltar (remover topo)");
            System.out.println("3 - Mostrar página atual (topo)");
            System.out.println("4 - Exibir todo o histórico");
            System.out.println("5 - Limpar histórico");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            String opc = sc.nextLine().trim();
            switch (opc) {
                case "1":
                    System.out.print("Digite a URL: ");
                    String url = sc.nextLine().trim();
                    if (!url.isEmpty()) {
                        historico.push(url);
                        System.out.println("URL adicionada: " + url);
                    } else {
                        System.out.println("URL vazia: nada adicionado.");
                    }
                    break;
                case "2":
                    String removida = historico.pop();
                    if (removida == null) System.out.println("Histórico vazio. Nada a remover.");
                    else System.out.println("Voltando — URL removida: " + removida);
                    break;
                case "3":
                    String atual = historico.peek();
                    if (atual == null) System.out.println("Nenhuma página atual (histórico vazio).");
                    else System.out.println("Página atual: " + atual);
                    break;
                case "4":
                    historico.printAll();
                    break;
                case "5":
                    historico.clear();
                    System.out.println("Histórico limpo.");
                    break;
                case "0":
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        System.out.println("Encerrando simulador.");
        sc.close();
    }
}
// ...existing code...
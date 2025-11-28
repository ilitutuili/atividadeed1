import java.util.*;

public class deques {
    private Deque<String> cartas;
    
    public deques() {
        cartas = new LinkedList<>();
    }
    
    // Adicionar carta no início do baralho
    public void inserirInicio(String carta) {
        cartas.addFirst(carta);
        System.out.println("Carta '" + carta + "' adicionada no início.");
    }
    
    // Adicionar carta no fim do baralho
    public void inserirFim(String carta) {
        cartas.addLast(carta);
        System.out.println("Carta '" + carta + "' adicionada no fim.");
    }
    
    // Remover carta do início
    public String removerInicio() {
        if (cartas.isEmpty()) {
            System.out.println("Deque vazio!");
            return null;
        }
        String carta = cartas.removeFirst();
        System.out.println("Carta '" + carta + "' removida do início.");
        return carta;
    }
    
    // Remover carta do fim
    public String removerFim() {
        if (cartas.isEmpty()) {
            System.out.println("Deque vazio!");
            return null;
        }
        String carta = cartas.removeLast();
        System.out.println("Carta '" + carta + "' removida do fim.");
        return carta;
    }
    
    // Comprar uma carta do topo (início)
    public String frente() {
        if (cartas.isEmpty()) {
            System.out.println("Nenhuma carta disponível!");
            return null;
        }
        return cartas.getFirst();
    }
    
    // Visualizar todas as cartas
    public void tras() {
        if (cartas.isEmpty()) {
            System.out.println("Deque vazio!");
            return;
        }
        System.out.println("Cartas no deque: " + cartas);
    }
    
    // Verificar se o deque está vazio
    public boolean estaVazio() {
        return cartas.isEmpty();
    }
    
    // Embaralhar (inverter a ordem das cartas)
    public void embaralhar() {
        List<String> lista = new ArrayList<>(cartas);
        Collections.shuffle(lista);
        cartas = new LinkedList<>(lista);
        System.out.println("Cartas embaralhadas!");
    }
    
    // Menu interativo
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("\n========== JOGO DE CARTAS - DEQUE ==========");
            System.out.println("1 - Adicionar carta no início");
            System.out.println("2 - Adicionar carta no fim");
            System.out.println("3 - Remover carta do início");
            System.out.println("4 - Remover carta do fim");
            System.out.println("5 - Ver primeira carta");
            System.out.println("6 - Ver todas as cartas");
            System.out.println("7 - Embaralhar cartas");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite a carta: ");
                    String cartaInicio = scanner.nextLine();
                    inserirInicio(cartaInicio);
                    break;
                    
                case 2:
                    System.out.print("Digite a carta: ");
                    String cartaFim = scanner.nextLine();
                    inserirFim(cartaFim);
                    break;
                    
                case 3:
                    removerInicio();
                    break;
                    
                case 4:
                    removerFim();
                    break;
                    
                case 5:
                    String primeira = frente();
                    if (primeira != null) {
                        System.out.println("Primeira carta: " + primeira);
                    }
                    break;
                    
                case 6:
                    tras();
                    break;
                    
                case 7:
                    embaralhar();
                    break;
                    
                case 8:
                    System.out.println("Obrigado por jogar! Até logo!");
                    continuar = false;
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
    
    // Main para testar
    public static void main(String[] args) {
        deques jogo = new deques();
        jogo.menu();
    }
}
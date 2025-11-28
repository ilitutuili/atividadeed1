import java.util.Scanner;

public class SistemaBanco {
    public static void main(String[] args) {
        Fila fila = new Fila();
        Scanner sc = new Scanner(System.in);
        int opcao, senha = 1;

        do {
            System.out.println("\n=== Sistema de Atendimento Bancário ===");
            System.out.println("1 - Gerar nova senha");
            System.out.println("2 - Chamar próximo cliente");
            System.out.println("3 - Ver próximo cliente");
            System.out.println("4 - Quantidade de clientes na fila");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    fila.enfileirar(senha);
                    System.out.println("Senha gerada: " + senha);
                    senha++;
                    break;

                case 2:
                    int chamado = fila.desenfileirar();
                    if (chamado != -1) {
                        System.out.println("Chamando senha: " + chamado);
                    }
                    break;

                case 3:
                    int prox = fila.frente();
                    if (prox != -1) {
                        System.out.println("Próximo da fila: " + prox);
                    }
                    break;

                case 4:
                    System.out.println("Clientes aguardando: " + fila.tamanho());
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}

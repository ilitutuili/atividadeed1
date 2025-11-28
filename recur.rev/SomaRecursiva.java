// ...existing code...
import java.util.Scanner;

public class SomaRecursiva {

    // ...existing code...
    public static int somaDigitos(int n) {
        // Caso base: se o número tem apenas um dígito
        if (n < 10) {
            return n;
        }

        // Caso recursivo: soma o último dígito com a soma dos demais
        return (n % 10) + somaDigitos(n / 10);
    }

    // ...existing code...
    // changed code: main com menu interativo
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1 - Calcular soma dos dígitos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            if (!sc.hasNextInt()) {
                sc.next(); // descarta entrada inválida
                System.out.println("Opção inválida.");
                continue;
            }

            int opc = sc.nextInt();
            switch (opc) {
                case 1:
                    System.out.print("Digite um número inteiro: ");
                    if (!sc.hasNextInt()) {
                        sc.next();
                        System.out.println("Entrada inválida.");
                        break;
                    }
                    int numero = sc.nextInt();
                    if (numero < 0) numero = Math.abs(numero);
                    int resultado = somaDigitos(numero);
                    System.out.println("Soma dos dígitos de " + numero + " = " + resultado);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
    // ...existing code...
}
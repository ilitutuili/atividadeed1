import java.util.Scanner;

class Document {
    String name;
    int pages;

    Document(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return name + " (" + pages + " páginas)";
    }
}

class Node {
    Document doc;
    Node next;

    Node(Document doc) {
        this.doc = doc;
    }
}

class PrinterQueue {
    private Node head;
    private Node tail;
    private int size;
    private int totalPages;

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(String name, int pages) {
        Document d = new Document(name, pages);
        Node node = new Node(d);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        totalPages += pages;
    }

    public Document dequeue() {
        if (isEmpty()) return null;
        Document d = head.doc;
        head = head.next;
        if (head == null) tail = null;
        size--;
        totalPages -= d.pages;
        return d;
    }

    // remove first document with matching name (case-sensitive)
    public boolean cancel(String name) {
        if (isEmpty()) return false;
        if (head.doc.name.equals(name)) {
            dequeue();
            return true;
        }
        Node prev = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.doc.name.equals(name)) {
                prev.next = cur.next;
                if (cur == tail) tail = prev;
                size--;
                totalPages -= cur.doc.pages;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    public void showAll() {
        if (isEmpty()) {
            System.out.println("Fila vazia.");
            return;
        }
        System.out.println("Documentos na fila:");
        Node cur = head;
        int pos = 1;
        while (cur != null) {
            System.out.println(pos + ". " + cur.doc);
            cur = cur.next;
            pos++;
        }
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int size() {
        return size;
    }
}

public class PrinterQueueSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrinterQueue queue = new PrinterQueue();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Simulador de Impressora ---");
            System.out.println("1. Adicionar documento");
            System.out.println("2. Processar (imprimir) próximo");
            System.out.println("3. Cancelar documento (por nome)");
            System.out.println("4. Mostrar todos os documentos");
            System.out.println("5. Total de páginas aguardando");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1":
                    System.out.print("Nome do documento: ");
                    String name = sc.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Nome inválido.");
                        break;
                    }
                    System.out.print("Número de páginas: ");
                    String pagesStr = sc.nextLine().trim();
                    try {
                        int pages = Integer.parseInt(pagesStr);
                        if (pages <= 0) {
                            System.out.println("Número de páginas deve ser > 0.");
                        } else {
                            queue.enqueue(name, pages);
                            System.out.println("Documento adicionado.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida para páginas.");
                    }
                    break;
                case "2":
                    Document printed = queue.dequeue();
                    if (printed == null) {
                        System.out.println("Nenhum documento para imprimir.");
                    } else {
                        System.out.println("Imprimindo: " + printed);
                    }
                    break;
                case "3":
                    System.out.print("Nome do documento a cancelar: ");
                    String cancelName = sc.nextLine().trim();
                    if (cancelName.isEmpty()) {
                        System.out.println("Nome inválido.");
                        break;
                    }
                    boolean removed = queue.cancel(cancelName);
                    System.out.println(removed ? "Documento cancelado." : "Documento não encontrado.");
                    break;
                case "4":
                    queue.showAll();
                    break;
                case "5":
                    System.out.println("Total de páginas aguardando: " + queue.getTotalPages());
                    break;
                case "6":
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
        System.out.println("Encerrando simulador.");
    }
}
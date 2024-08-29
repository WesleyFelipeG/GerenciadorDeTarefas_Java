import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Tarefa> tarefas = new ArrayList<>();

    public static void main(String[] args) {

        int contador = 0;
        while (contador != 5) {
            System.out.println(" ");
            menuDoGerenciador();
            contador = sc.nextInt();
            sc.nextLine();
            System.out.println(" ");
            switch (contador) {
                case 1:
                    adicionarTarefa();
                    pausar();
                    break;
                case 2:
                    removerTarefa();
                    pausar();
                    break;
                case 3:
                    marcarTarefaConcluida();
                    pausar();
                    break;
                case 4:
                    listarTarefas();
                    pausar();
                    break;
                case 5:
                    System.out.println("Fechando programa...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    // Função que retorna o menu a cada loop
    private static void menuDoGerenciador() {
        System.out.println("|________________________________________________|");
        System.out.println("|             Gerenciador de tarefas             |");
        System.out.println("|________________________________________________|");
        System.out.println("|-Pressione [1] para adicionar tarefa            |");
        System.out.println("|-Pressione [2] para remover tarefa              |");
        System.out.println("|-Pressione [3] para marcar tarefa como conluida |");
        System.out.println("|-Pressione [4] para listar tarefas              |");
        System.out.println("|-Pressione [5] para fechar o programa           |");
        System.out.println("|________________________________________________|");

    }

    // Função da opção 1: Adicionar Tarefa
    private static void adicionarTarefa() {
        System.out.println("Digite o nome da tarefa: ");
        String nome = sc.nextLine();
        tarefas.add(new Tarefa(nome));
    }

    // Função da opção 2: Remover tarefas
    private static void removerTarefa() {
        listarTarefas();
        System.out.println("Digite o índice da tarefa para remove-la: ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index >= 0 && index < tarefas.size()) {
            tarefas.remove(index);
            System.out.println("Tarefa removida.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Função da opção 3: Marcar tarefa como concluida
    private static void marcarTarefaConcluida() {
        listarTarefas();
        System.out.println("Digite o índice da tarefa para marcar como concluida: ");
        int index = sc.nextInt();
        if (index >= 0 && index < tarefas.size()) {
            Tarefa tarefa = tarefas.get(index);
            tarefa.concluir();
            System.out.println("Tarefa concluida.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Função da opção 4: Listar Tarefas
    private static void listarTarefas() {
        System.out.println("|________________________________________________|");
        System.out.println("|                Lista de Tarefas                |");
        System.out.println("|________________________________________________|");
        if (tarefas.isEmpty()) {
            System.out.println("|                  Lista vazia                   |");
        } else {
            for (int i = 0; i < tarefas.size(); i++) {
                Tarefa tarefa = tarefas.get(i);
                System.out.println("| " + i + " | " + tarefa.getNome() + " | " + (tarefa.isConcluida() ? " [Concluída]" : "[Pendente]"));
            }
        }
        System.out.println("|________________________________________________|");
    }

    // Pausa entre funções do código
    private static void pausar() {
        System.out.println("Pressione [Enter] para continuar.");
        sc.nextLine();

    }
}
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TarefaDAO dao = new TarefaDAO(); // Iniciamos nosso gerenciador de banco

        int opcao = 0;
        while (opcao != 4) {
            System.out.println("\n--- TO-DO LIST (SQLITE) ---");
            System.out.println("1. Nova Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Deletar Tarefa");
            System.out.println("4. Sair");
            System.out.print("Escolha: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer do enter

            switch (opcao) {
                case 1:
                    System.out.print("Descrição da tarefa: ");
                    String desc = scanner.nextLine();
                    dao.salvar(new Tarefa(desc));
                    System.out.println("Salvo no banco com sucesso!");
                    break;
                case 2:
                    List<Tarefa> lista = dao.listar();
                    System.out.println("\n--- LISTA ---");
                    for (Tarefa t : lista) {
                        System.out.println(t);
                    }
                    break;
                case 3:
                    System.out.print("Digite o ID para deletar: ");
                    int id = scanner.nextInt();
                    dao.deletar(id);
                    System.out.println("Deletado!");
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
package main;

import controle.ControleTarefa;
import tarefa.Tarefa;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\n=== CONTROLE DE TAREFAS ===");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Descrição da Tarefa: ");
                    String descricao = scanner.nextLine();
                    Tarefa tarefa = new Tarefa(id, descricao);
                    ControleTarefa.getInstance().adicionarTarefa(tarefa);
                    System.out.println("Tarefa adicionada!");
                    break;

                case 2:
                    ArrayList<Tarefa> tarefas = ControleTarefa.getInstance().getTarefas();
                    if (tarefas.isEmpty()) {
                        System.out.println("Não há tarefas cadastradas.");
                    } else {
                        System.out.println("Lista de Tarefas:");
                        for (Tarefa t : tarefas) {
                            System.out.println("ID: " + t.getId() + " | Descrição: " + t.getDescricao() + " | Concluída: " + (t.isConcluida() ? "Sim" : "Não"));
                        }
                    }
                    break;    

                case 3:
                    System.out.println("Digite o id da tarefa a ser encontrada: ");
                    int buscaId = scanner.nextInt();
                    Tarefa tarefaEncontrada = ControleTarefa.getInstance().buscarTarefaPorId(buscaId);
                    if (tarefaEncontrada!= null){
                        System.out.println("Tarefa encontrada: Id: "+ tarefaEncontrada.getId()+ " | Descrição: "+ tarefaEncontrada.getDescricao() + " | Concluída: " + (tarefaEncontrada.isConcluida() ? "Sim" : "Não"));
                    } else {
                        System.out.println("Tarefa não encontrada por este Id: "+ buscaId);
                    }
                    break;

                case 5:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        }
    }
}

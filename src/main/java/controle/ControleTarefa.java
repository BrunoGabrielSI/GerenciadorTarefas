package controle;

import tarefa.Tarefa;

import java.util.ArrayList;

public class ControleTarefa {

    private ArrayList<Tarefa> tarefas;
    private static ControleTarefa instancia;
    private ControleTarefa() {
        this.tarefas = new ArrayList<>();
    }

    public static ControleTarefa getInstance(){

        if (instancia == null){
            instancia = new ControleTarefa();
        }
        return instancia;
    }

    public void adicionarTarefa(Tarefa tarefa){
            this.tarefas.add(tarefa);
    }

    public ArrayList<Tarefa> getTarefas() {
        return this.tarefas;
    }

    public Tarefa buscarTarefaPorId(int id){
        for (Tarefa tarefa : tarefas){
            if (tarefa.getId() == id){
                return tarefa;
            }
        }
        return null;
    }



}

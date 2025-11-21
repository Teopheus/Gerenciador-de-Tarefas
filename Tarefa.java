public class Tarefa {
    private int id;
    private String descricao;
    private boolean finalizada;

    public Tarefa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.finalizada = false;
    }
    
    // Construtor auxiliar para quando formos criar uma nova (sem ID ainda)
    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    // Getters e Setters (importantes para o banco preencher os dados depois)
    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public boolean isFinalizada() { return finalizada; }

    @Override
    public String toString() {
        return id + ": " + descricao + (finalizada ? " [FEITO]" : " [PENDENTE]");
    }
}
public class Usuario {
    String nome;
    String matricula;
    String senha;
    Curso curso;

    static int qtd_obj;
    private int codigo;

    Usuario(){
        qtd_obj++;
        this.codigo = qtd_obj;
    }

    public void cadastrar_dados(String nome, String matricula, String senha, Curso curso){
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
        this.curso = curso;

    }

    public void exibir_dados(){
        System.out.println("\nNome do aluno: " + nome);
        System.out.println("Matricula do aluno: " + matricula);
        System.out.println("Curso do aluno: " + curso.getNome());

    }
}

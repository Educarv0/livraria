import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    Usuario aluno;
    Exemplar exemplar;
    String data_emprestimo;
    String data_entrega;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public void cadastrar_dados_emprestimo(Usuario aluno, Exemplar exemplar, String data_emprestimo){
        this.aluno = aluno;
        this.exemplar = exemplar;
        this.data_emprestimo = data_emprestimo;

        LocalDate dataEmp = LocalDate.parse(data_emprestimo, FORMATTER);
        LocalDate dataEnt = dataEmp.plusDays(7);
        this.data_entrega = dataEnt.format(FORMATTER);

        exemplar.setStatus("Emprestado");

    }

    public void exibir_dados(){
        System.out.println("\nAluno: " + aluno.nome);
        System.out.println("Livro emprestado: " + exemplar.getLivro().getNome());
        System.out.println("Data de emprestimo do livro: " + data_emprestimo);
        System.out.println("Data de entrega do livro: " + data_entrega);


    }
}

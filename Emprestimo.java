import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Emprestimo {
    Scanner input = new Scanner(System.in);

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
        LocalDate dataEnt = dataEmp.plusDays(15);
        this.data_entrega = dataEnt.format(FORMATTER);

        exemplar.setStatus("Emprestado");

    }

    public void exibir_dados(){
        if (this.aluno == null || this.exemplar == null || this.data_emprestimo == null) {
        System.out.println("\nDados de empréstimo não cadastrados.");
        return;
        }
        System.out.println("\nAluno: " + aluno.nome);
        System.out.println("Livro emprestado: " + exemplar.getLivro().getNome());
        System.out.println("Data de emprestimo do livro: " + data_emprestimo);
        System.out.println("Data de entrega do livro: " + data_entrega);

    }

    public void alterar_dados(Curso curso_INF, Curso curso_AL, Curso curso_MA, Curso curso_AT, Curso curso_FL, Curso curso_ELE, Livro livro1, Livro livro2, Usuario usuario1, Usuario usuario2, Usuario usuarioES, Exemplar Exemplar_OO, Exemplar Exemplar_LN){

        System.out.println("O que deseja alterar?");
        System.out.println("1 - Nome");
        System.out.println("2 - Matricula");
        System.out.println("3 - Curso");
        System.out.println("4 - Livro");

        int op1 = input.nextInt();


        switch (op1) {
            case 1:
                System.out.println("Novo nome: ");
                aluno.nome = input.next();
                System.out.println("Alterado com sucesso");
                break;

            case 2:
                System.out.println("Novo valor: ");
                aluno.matricula = input.next();
                System.out.println("Alterado com sucesso");
                break;

            case 3:
            
                System.out.println("\nNovo curso: ");
                System.out.println("1 - Informáica");
                System.out.println("2 - Alimentos");
                System.out.println("3 - Meio ambiente");
                System.out.println("4 - Automação");
                System.out.println("5 - Florestas");
                System.out.println("6 - Eletromecánica");

                int Curso_escolhido = input.nextInt();
                aluno.curso = (Curso_escolhido == 1) ? curso_INF : (Curso_escolhido == 2) ? curso_AL : (Curso_escolhido == 3) ? curso_MA : (Curso_escolhido == 4) ? curso_AT : (Curso_escolhido == 5) ? curso_FL :  curso_ELE ;
                break;

            case 4:
                System.out.println("O que deseja fazer?");
                System.out.println("1 - Devolver o livro");
                System.out.println("2 - Trocar de livro");
                int op_alterar_livro = input.nextInt();

                switch (op_alterar_livro) {
                    case 1:
                        if (this.exemplar != null) {
                            // Libera o exemplar
                            this.exemplar.setStatus("Livre");
                            
                            // Remove os dados do empréstimo
                            this.aluno = null;
                            this.exemplar = null;
                            this.data_emprestimo = null;
                            this.data_entrega = null;
                            
                            System.out.println("Livro devolvido com sucesso!");
                        } else {
                            System.out.println("Não há livro para devolver.");
                        }
                        break;
                                
                    case 2:
                    
                        if (exemplar.getLivro().getNome() == "O Oceano no Fim do Caminho"){
                            if (Exemplar_LN.getStatus() == "Emprestado") {
                                System.out.println("O outro exemplar disponível já está emprestado");
                            }
                            else{
                                System.out.println("O livro atual é O Oceano no Fim do Caminho");
                                System.out.println("Deseja trocar pelo livro Luzes do Norte?");
                                System.out.println("1 - Sim\n2 - Não");
                                int opl = input.nextInt();

                                switch (opl) {
                                    case 1:
                                        this.exemplar.setStatus("Livre");
                                        this.exemplar = Exemplar_LN;
                                        Exemplar_LN.setStatus("Emprestado");

                                        System.out.println("Data emprestimo: (Dia/Mês/Ano");
                                        data_emprestimo = input.next();
                                        
                                        break;
                                    case 2:
                                        System.out.println("Você continua com o livro O Oceano no Fim do Caminho");
                                        break;

                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                            }
                        }
                            
                        else if (exemplar.getLivro().getNome() == "Luzes do Norte"){
                            if (Exemplar_OO.getStatus() == "Emprestado") {
                                System.out.println("O outro exemplar disponível já está emprestado");
                            }
                            else{
                                System.out.println("O livro atual é Luzes do Norte");
                                System.out.println("Deseja trocar pelo O Oceano no Fim do Caminho?");
                                System.out.println("1 - Sim\n2 - Não");
                                int opl = input.nextInt();

                                switch (opl) {
                                    case 1:
                                        this.exemplar.setStatus("Livre");
                                        this.exemplar = Exemplar_OO;
                                        Exemplar_OO.setStatus("Emprestado");
                                        System.out.println("Data emprestimo: (Dia/Mês/Ano");
                                        data_emprestimo = input.next();
                                        
                                        break;
                                    case 2:
                                        System.out.println("Você continua com o livro Luzes do Norte");
                                        break;

                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                            }
                        }
                    break;
                }
                break;

            default:
            System.out.println("Opção inválida");
                break;
        }
    }
}

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String nome_Usu = "", matricula_Usu = "", senha_Usu = "", data_emprestimo = "", matriculaES = "";
        int op1 = 0;  

        Usuario usuarioES = new Usuario();
        Curso Curso_Usu;
        Emprestimo Emprestimo = new Emprestimo();
        Emprestimo Emprestimo1 = new Emprestimo();
        Emprestimo Emprestimo2 = new Emprestimo();

        Livro livro1 = new Livro("O Oceano no Fim do Caminho", "Neil Gaiman", 2013);
        Livro livro2 = new Livro("Luzes do Norte", "Giulianna Domingues", 2022);

        Curso curso_INF = new Curso("Informática");
        Curso curso_AL = new Curso("Alimentos");
        Curso curso_MA = new Curso("Meio Ambiente");
        Curso curso_AT = new Curso("Automação Industrial");
        Curso curso_FL = new Curso("Florestas");
        Curso curso_ELE = new Curso("Eletromecánica");

        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();
        usuario2.setNome("Carlos");
        usuario2.setMatricula("123");
        usuario2.setCurso(curso_INF);
        usuario2.setSenha("123");

        Exemplar Exemplar_OO = new Exemplar(livro1);
        Exemplar Exemplar_LN = new Exemplar(livro2);

        do {
            
            System.out.println("\n1 - Cadastrar");
            System.out.println("2 - Pegar livro emprestado");
            System.out.println("3 - Dados do aluno e status livros");
            System.out.println("4 - Alterar");
            System.out.println("5 - Sair");
            op1 = input.nextInt();

            switch (op1) {
                case 1:
                    System.out.println("\nQual o seu nome?");
                    nome_Usu = input.next();

                    System.out.println("\nQual a sua matricula?");
                    matricula_Usu = input.next();

                    System.out.println("\nQual a sua senha?");
                    senha_Usu = input.next();

                    System.out.println("\nQual o seu curso?");
                    System.out.println("1 - Informáica");
                    System.out.println("2 - Alimentos");
                    System.out.println("3 - Meio ambiente");
                    System.out.println("4 - Automação");
                    System.out.println("5 - Florestas");
                    System.out.println("6 - Eletromecánica");

                    int Curso_escolhido = input.nextInt();
                    Curso_Usu = (Curso_escolhido == 1) ? curso_INF : (Curso_escolhido == 2) ? curso_AL : (Curso_escolhido == 3) ? curso_MA : (Curso_escolhido == 4) ? curso_AT : (Curso_escolhido == 5) ? curso_FL :  curso_ELE ;
                    
                    usuario1.cadastrar_dados(nome_Usu, matricula_Usu, senha_Usu, Curso_Usu);
                    break;
            
                case 2:

                    System.out.println("Coloque a matricula do usuario que irá pegar o livro:");
                    matriculaES = input.next();

                    if (matriculaES.equals(usuario1.matricula)) {
                        usuarioES = usuario1;
                        Emprestimo = Emprestimo1;
                    }
                    else if (matriculaES.equals(usuario2.matricula)) {
                        usuarioES = usuario2;
                        Emprestimo = Emprestimo2;
                    }
                    else {
                        System.out.println("Matricula inválida");
                        break;
                    }
                    
                    System.out.println("\nQual dos livros você deseja pegar?");
                    System.out.println("1 - O Oceano no Fim do Caminho");
                    System.out.println("2 - Luzes do Norte");
                    int Livro_escolhido = input.nextInt();
                    switch (Livro_escolhido) {
                        case 1:
                            if (Exemplar_OO.getStatus() == "Emprestado") {
                                System.out.println("Livro já emprestado");
                                break;
                            }
                            else{
                                System.out.println("Data emprestimo: (Dia/Mês/Ano");
                                data_emprestimo = input.next();
                                Emprestimo.cadastrar_dados_emprestimo(usuarioES, Exemplar_OO, data_emprestimo);
                                Exemplar_OO.setStatus("Emprestado");
                            break;
                            }
                        case 2:
                            if (Exemplar_LN.getStatus() == "Emprestado") {
                                System.out.println("Livro já emprestado");
                                break;
                            }
                            else{
                                System.out.println("Data emprestimo: (Dia/Mês/Ano");
                                data_emprestimo = input.next();
                                Emprestimo.cadastrar_dados_emprestimo(usuarioES, Exemplar_LN, data_emprestimo);
                                Exemplar_LN.setStatus("Emprestado");

                            break;
                            }
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }

                    break;
                case 3:

                    System.out.println("\nQue dados você quer?");
                    System.out.println("1 - Dados dos usuarios");
                    System.out.println("2 - Dados dos emprestimos");
                    System.out.println("3 - Dados dos exemplares");
                    System.out.println("4 - Dados dos livros");

                    int op_exibir = input.nextInt();

                    switch (op_exibir) {
                        case 1:
                            System.out.println("Coloque a matricula do usuario que deseja os dados:");
                            matriculaES = input.next();

                            if (matriculaES.equals(usuario1.matricula)) {
                                usuarioES = usuario1;
                                usuarioES.exibir_dados();

                            }
                            else if (matriculaES.equals(usuario2.matricula)) {
                                usuarioES = usuario2;
                                usuarioES.exibir_dados();

                            }
                            else {
                                System.out.println("Matricula inválida");
                                continue;
                            }      
                            break;
                    
                        case 2:
                            System.out.println("Coloque a matricula do usuario que deseja os dados de emprestimo:");
                            matriculaES = input.next();

                            if (matriculaES.equals(usuario1.matricula)) {
                                Emprestimo = Emprestimo1;
                                Emprestimo.exibir_dados();

                            }
                            else if (matriculaES.equals(usuario2.matricula)) {
                                Emprestimo = Emprestimo2;
                                Emprestimo.exibir_dados();
                            }
                            else {
                                System.out.println("Matricula inválida");
                                continue;
                            }
                            break;
                        
                        case 3:
                            System.out.println("Deseja os dados de qual dos exemplares?");
                            System.out.println("1 - O Oceano no Fim do Caminho");
                            System.out.println("2 - Luzes do Norte");
                            int op_exibir_exemplar = input.nextInt();

                            switch (op_exibir_exemplar) {
                                case 1:
                                    Exemplar_OO.exibir_dados();
                                    break;
                                case 2:
                                    Exemplar_LN.exibir_dados();
                                    break;
                            
                                default:
                                    System.out.println("Opção inválida");
                                    continue;
                            }
                            break;
                        
                        case 4:
                            System.out.println("Deseja os dados de qual livro?");
                            System.out.println("1 - O Oceano no Fim do Caminho");
                            System.out.println("2 - Luzes do Norte");
                            int op_exibir_livro = input.nextInt();

                            switch (op_exibir_livro) {

                                case 1:
                                    livro1.exibir_dados();
                                    break;
                                case 2:
                                    livro2.exibir_dados();
                                    break;
                            
                                default:
                                    System.out.println("Opção inválida");
                                    continue;
                            }
                            break;

                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    break;
                    
                case 4:
                    System.out.println("Coloque a matricula do usuario que deseja alterar os dados:");
                    matriculaES = input.next();

                    if (matriculaES.equals(usuario1.matricula)) {
                        Emprestimo = Emprestimo1;

                    }
                    else if (matriculaES.equals(usuario2.matricula)) {
                        Emprestimo = Emprestimo2;
                    }
                    else {
                        System.out.println("Matricula inválida");
                        continue;
                    }
                    Emprestimo.alterar_dados(curso_INF, curso_AL, curso_MA, curso_AT, curso_FL, curso_ELE, livro1, livro2, usuario1, usuario2, usuarioES, Exemplar_OO, Exemplar_LN);
                    break;
                default:
                    break;

            }
        } while (op1 != 5);


    }
}

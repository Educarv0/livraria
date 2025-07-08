import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String nome_Usu = "", matricula_Usu = "", senha_Usu = "", status_Exemplar = "Livre", data_emprestimo = "";
        int op1 = 0;  
        Usuario usuario = new Usuario();
        Curso Curso_Usu;
        Emprestimo Emprestimo = new Emprestimo();


        Livro livro1 = new Livro();
        livro1.setNome("O meu Café esfriou e eu lembrei da gente");
        livro1.setAutor("Lucas Lopes");
        livro1.setAno(2023);

        Livro livro2 = new Livro();
        livro2.setNome("Box Harry Potter");
        livro2.setAutor("JK Rowling");
        livro2.setAno(2002);

        Curso curso_INF = new Curso();
        curso_INF.setNome("Informática");
        Curso curso_AL = new Curso();
        curso_AL.setNome("Alimentos");
        Curso curso_MA = new Curso();
        curso_MA.setNome("Meio Ambiente");
        Curso curso_AT = new Curso();
        curso_AT.setNome("Automação Industrial");
        Curso curso_FL = new Curso();
        curso_FL.setNome("Florestas");
        Curso curso_ELE = new Curso();
        curso_ELE.setNome("Eletromecánica");


        Exemplar Exemplar_OO = new Exemplar();
        Exemplar_OO.setStatus("Livre");
        Exemplar_OO.setLivro(livro1);
        Exemplar Exemplar_LN = new Exemplar();
        Exemplar_LN.setStatus("Livre");
        Exemplar_LN.setLivro(livro2);

        do {
            
            System.out.println("\n1 - Cadastrar");
            System.out.println("2 - Pegar livro emprestado");
            System.out.println("2 - Dados do aluno e status livros");
            System.out.println("4 - Alterar");
            System.out.println("5 - Atualizar");
            System.out.println("6 - Sair");
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
                    
                    usuario.cadastrar_dados(nome_Usu, matricula_Usu, senha_Usu, Curso_Usu);
                    break;
            
                case 2:

                    System.out.println("Qual dos livros você deseja pegar?");
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
                                System.out.println("Data emprestimo:");
                                data_emprestimo = input.next();
                                Emprestimo.cadastrar_dados_emprestimo(usuario, Exemplar_OO, data_emprestimo);
                            break;
                            }
                        case 2:
                            if (Exemplar_LN.getStatus() == "Emprestado") {
                                System.out.println("Livro já emprestado");
                                break;
                            }
                            else{
                                System.out.println("Data emprestimo:");
                                data_emprestimo = input.next();
                                Emprestimo.cadastrar_dados_emprestimo(usuario, Exemplar_LN, data_emprestimo);

                            break;
                            }
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                     
                    Emprestimo.exibir_dados();

                    break;
                
                default:
                    break;

            }
        } while (op1 != 5);


    }
}

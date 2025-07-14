public class Livro {
    private String nome;
    private String autor;
    private int ano;

    public Livro(String nome, String autor, int ano) {
        this.nome = nome;
        this.autor = autor;
        this.ano = ano;
    }

    public void exibir_dados(){
        System.out.println("\nNome do livro: " + nome);
        System.out.println("Autor do livro: " + autor);
        System.out.println("Ano de publicação do livro: " + ano);

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    
}

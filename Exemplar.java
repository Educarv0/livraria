public class Exemplar {
    private static int proximoCodigo = 1;
    private int codigo;
    private String status;
    private Livro livro;

    public Exemplar() {
        this.codigo = proximoCodigo++;
        this.status = "Livre";
    }

    public void exibir_dados(){
        System.out.println("\nCodigo do livro: " + codigo);
        System.out.println("Status do livro: " + status);
        System.out.println("Nome do livro: " + livro.getNome());

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }


}

public class Produto {

    // Atributos da classe
    private int idProduto, quantidade, qtdCompra;
    private String nomeProduto;
    private double valorProduto;


    // ------------ Métodos get e set dos atributos ------------ //
    // Id dos produtos
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }


    // Nome dos produtos
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }


    // Valor dos produtos
    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }


    // Quantidade de produtos
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    // Quantidade de produtos para a compra
    public int getQtdCompra() {
        return qtdCompra;
    }

    public void setQtdCompra(int quantidadeCompra) {
        this.qtdCompra = quantidadeCompra;
    }



    

    // Construtor padrão
    public Produto(){}

    public Produto(int idProduto, String nomeProduto, double valorProduto, int quantidade){
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.quantidade = quantidade;
    }

    public Produto(int idProduto, String nomeProduto, double valorProduto, int quantidade,  int qtdCompra){
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.quantidade = quantidade;
        this.qtdCompra = qtdCompra;
    }
    

}

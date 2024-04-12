import java.util.HashMap;

public class ServicoVenda {

    // Lista responsável por armazenar as vendas dos produtos
    HashMap<Integer, Produto> vendas = new HashMap<Integer, Produto>();


    // ----------- Método principais da lista de produtos ----------- //
    //Adcionar compra
    public void adcionarProduto(Produto produto){
        vendas.put(produto.getIdProduto(), produto);
    }

    // Visualizar a lista de compras
    public String visualizarCompra(){
        String varAuxiliar = "";

        for (HashMap.Entry<Integer, Produto> vendas : vendas.entrySet()) {
            varAuxiliar += "Id: " + vendas.getValue().getIdProduto() + "   -   Produto: "  + vendas.getValue().getNomeProduto() + "   -   Valor: "  + vendas.getValue().getValorProduto() + "   -   Quantidade comprada: "  + vendas.getValue().getQtdCompra() + "\n";
        }
       
        return varAuxiliar;
    }

    // Limpar lista de compras
    public void limparCompras(){
        vendas.clear();
    }
}

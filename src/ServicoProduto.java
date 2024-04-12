import java.util.HashMap;
import javax.swing.*;

public class ServicoProduto {

    // Lista responsável por armazenar os nomes dos produtos
    HashMap<Integer, Produto> produtos = new HashMap<Integer, Produto>();

    
    // ----------- Método get da lista de produtos ----------- // 
    public String buscarNome(int idProduto){
        Produto produto = produtos.get(idProduto);

        return produto.getNomeProduto();
    }

    public double buscarValor(int idProduto){
        Produto produto = produtos.get(idProduto);

        return produto.getValorProduto();
    }

    public int buscarQuantidade(int idProduto){
        Produto produto = produtos.get(idProduto);

        return produto.getQuantidade();
    }



    // ----------- Método principais da lista de produtos ----------- // 
    // Listar produtos
    public void listarProduto(Produto produto){
        produtos.put(produto.getIdProduto(), produto);
    }

    // Visualizar lista de produtos
    public String visualizarProduto(){
        String varAuxiliar = "";

        for (HashMap.Entry<Integer, Produto> produtos : produtos.entrySet()) {
            varAuxiliar += "Id: " + produtos.getValue().getIdProduto() + "   -   Produto: "  + produtos.getValue().getNomeProduto() + "   -   Valor: "  + produtos.getValue().getValorProduto() +  "   -   Quantidade: "  + produtos.getValue().getQuantidade() +"\n";
        }
       
        return varAuxiliar;
    }

    // Editar produto
    public void editarProduto(int idProduto, String nomeProduto){ // Editar o nome do produto
        Produto produto = produtos.get(idProduto);

        produto.setNomeProduto(nomeProduto);
        produtos.put(idProduto,produto);
    }

    public void editarProduto(int idProduto, double valorProduto){ // Editar valor do produto
        Produto produto = produtos.get(idProduto);

        produto.setValorProduto(valorProduto);
        produtos.put(idProduto,produto);

    }

    public void editarProduto(int idProduto, int quantidade){ // Editar a quantidade dos produtos
        Produto produto = produtos.get(idProduto);
        
        produto.setQuantidade(quantidade);
        produtos.put(idProduto,produto); 
    }

    // Remover produto
    public boolean removerProduto(int idProduto){
        Produto produto = produtos.get(idProduto);
        boolean statusItem;

        if(produtos.containsValue(produto) == true){
            statusItem = Constantes.ITEM_ENCONTRADO; 
            
            produtos.remove(idProduto);
        }
        else{
            statusItem = Constantes.ITEM_NAO_ENCONTRADO;
            
            JOptionPane.showMessageDialog(null, "Produto não encontrado, tente novamente!");
        }

        return statusItem;
    }

    public void removerProdutoQuantidade(int idProduto){
        produtos.remove(idProduto);
    }

    // Verificar se o produto já foi cadastrado
    public boolean verficStatusCadastro(int idProduto){
        Produto produto = produtos.get(idProduto);
        boolean statusItem;

        if(produtos.containsValue(produto) != true){
            statusItem = Constantes.ITEM_ENCONTRADO;
        }
        else{
            statusItem = Constantes.ITEM_NAO_ENCONTRADO;
 
            JOptionPane.showMessageDialog(null, "Produto já cadastrado, tente novamente!");
        }

        return statusItem;
    }

    // Verificar se o produto já foi cadastrado
    public boolean verficStatusProduto(int idProduto){
        Produto produto = produtos.get(idProduto);
        boolean statusItem;

        if(produtos.containsValue(produto) == true){
            statusItem = Constantes.ITEM_ENCONTRADO;
        }
        else{
            statusItem = Constantes.ITEM_NAO_ENCONTRADO;
 
            JOptionPane.showMessageDialog(null, "Produto não encontardo, tente novamente!");
        }

        return statusItem;
    }
}

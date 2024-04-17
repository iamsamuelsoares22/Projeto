
import javax.swing.*;

public class ServicoMenu {

    // Atributos da classe
    private static int idProduto, quantidade, quantidadeCompra;
    private static String nomeProduto;
    private static double valorProduto;
    private static double valorTotal = 0;

    // Variáveis de escolha 
    private int qtd = 0;
    private boolean statusItem;
    private boolean sairEstoque = false;
    private boolean sairFluxoCaixas = false;
    private boolean produtoRetirado = false;
   

    //-------------------------------------- Listas de escolha -------------------------------------- //
    // Menu do gerenciamento de estoque
    private static String[] estoqueStrings = {"Cadastrar", "Visualizar", "Editar", "Remover", "Menu"}; 
    private static String[] editarProdutoStrings = {"Nome", "Valor", "Quantidade","Finalizar"}; 
    // Menu do gerenciamento do fluxo de caixas
    private static String[] fluxoCaixasStrings = {"Adcionar", "Lista de compras", "Finalizar compra", "Menu"}; 

    // Criando Instâncias
    Produto produto = new Produto();
    ServicoProduto servicoProduto = new ServicoProduto();
    ServicoVenda servicoVenda = new ServicoVenda();
    
    
    public void menuEstoque(){
        
        sairEstoque = false;

        while(sairEstoque == false){
            int escolhaEstoque = JOptionPane.showOptionDialog(null, "Gerenciamento do estoque: ", "ESTOQUE", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, estoqueStrings, estoqueStrings[0]);
            
            switch (escolhaEstoque + 1) {

                case 1: // Cadastrar
                    while (true) {
                        idProduto = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o id do produto: "));

                        if(servicoProduto.verficStatusCadastro(idProduto)){
                            break;
                        }
                    }

                    nomeProduto = JOptionPane.showInputDialog(null, "Digite o nome do produto: ");
                    valorProduto = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor do produto: "));
                    
                    while (true) {
                        quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade do produto: "));

                        if (quantidade <= 0){
                            JOptionPane.showMessageDialog(null, "Você não pode adcionar uma quantidade zero ou negativa!");
                        }
                        else{
                            break;
                        }
                    }

                    Produto produto = new Produto(idProduto, nomeProduto, valorProduto, quantidade); 

                    servicoProduto.listarProduto(produto);
                    qtd += 1;
                    break;

                case 2: // Visualizar
                    JOptionPane.showMessageDialog(null, "Meus produtos: \n" + servicoProduto.visualizarProduto());
                    break;
                
                case 3: // Editar

                    if(qtd != 0){
                        while (true) {
                            idProduto = Integer.parseInt(JOptionPane.showInputDialog(null, "Meus produtos: \n" + servicoProduto.visualizarProduto() + "\n \n Digite o id do produto que deseja editar: "));
    
                            if(servicoProduto.verficStatusProduto(idProduto)){
                                break;
                            }
                        }
    
                        while (true) {
                            produtoRetirado = false;
                            int editarProduto = JOptionPane.showOptionDialog(null, "Opções de edição: ", "EDITAR PRODUTO", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, editarProdutoStrings, editarProdutoStrings[0]);
                        
                            // Editar nome, valor ou quantidade
                            if(editarProduto == Constantes.OPCOES_NOME){
    
                                while (true) {
                                    nomeProduto = JOptionPane.showInputDialog(null, "Digite o nome de atualização do produto: ");
                                           
                                    if(servicoProduto.verficStatusProduto(idProduto)){
                                        servicoProduto.editarProduto(idProduto, nomeProduto); 
                                        JOptionPane.showMessageDialog(null, "Nome do produto atualizado!");
                                        break;
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Esse produto não existe mais!");
                                        break;
                                    }
                                }   
                            } 
    
                            else if(editarProduto == Constantes.OPCOES_VALOR){
    
                                while (true) {
                                    valorProduto = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor de atualização do produto: "));
                                           
                                    if(servicoProduto.verficStatusProduto(idProduto)){
                                        servicoProduto.editarProduto(idProduto, valorProduto);
                                        JOptionPane.showMessageDialog(null, "Valor do produto atualizado!");
                                        break;
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Esse produto não existe mais!");
                                        break;
                                    }
                                }
                            }
    
                            else if(editarProduto == Constantes.OPCOES_QUANTIDADE){
                                while(true){
                                    quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade do produto: "));
     
                                    if(quantidade == 0){
                                        servicoProduto.removerProdutoQuantidade(idProduto);
                                        JOptionPane.showMessageDialog(null, "Você removeu esse produto!");
                                        qtd -= 1;
                                        produtoRetirado = true;
                                        break;
                                    }
                                    else if(quantidade < 0){
                                        JOptionPane.showMessageDialog(null, "Você não pode inserir uma quantidade negativa!");
                                    }
                                    else{
                                        servicoProduto.editarProduto(idProduto, quantidade);
                                        JOptionPane.showMessageDialog(null, "Quantidade do produto atualizada!");
                                        break;
                                    }
                                    
                                }  
                            }
    
                            else{
                                break;
                            }
    
    
                            if(produtoRetirado == true){ // Sair do (editar) caso n exista mais o produto
                                break;
                            }
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Não existe nenhum produto cadastrado!");
                    }

                    break;
                
                case 4: // Remover

                    if(qtd != 0){
                        while (true) {
                            idProduto = Integer.parseInt(JOptionPane.showInputDialog(null, "Meus produtos: \n" + servicoProduto.visualizarProduto() + "\n \n Digite o id do produto que deseja remover: "));
                            statusItem = servicoProduto.removerProduto(idProduto);
    
                            if(statusItem == true){
                                break;
                            }
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Não existe nenhum produto cadastrado!");
                    }

                    break;
                
                case 5: // Menu
                    sairEstoque = true;
            }
        }
    }

    public void menuFluxodeCaixas(){

        sairFluxoCaixas = false;
        valorTotal = 0;
        servicoVenda.limparCompras();

        while(sairFluxoCaixas == false){
            int escolhaFluxoCaixas = JOptionPane.showOptionDialog(null, "Gerenciamento do fluxo de caixas: ", "FLUXO DE CAIXAS", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, fluxoCaixasStrings, fluxoCaixasStrings[0]);

            switch (escolhaFluxoCaixas + 1) {

                case 1: // Adcionar

                    if(qtd != 0){
                        while (true) { // Verificar se o produto foi cadastrado
                            idProduto = Integer.parseInt(JOptionPane.showInputDialog(null, "Meus produtos: \n" + servicoProduto.visualizarProduto() + "\n \n Digite o id do produto que deseja comprar: "));
    
                            if(servicoProduto.verficStatusProduto(idProduto)){
                                break;
                            }
                        }
    
                        while(true){ // Verificar se a quantidade comprada é superior ao estoque
                            quantidadeCompra = Integer.parseInt(JOptionPane.showInputDialog(null, "Meus produtos: \n" + servicoProduto.visualizarProduto() + "\n \n Digite a quantidade que deseja comprar: "));
    
                            if(quantidadeCompra <= servicoProduto.buscarQuantidade(idProduto)){
                                break;
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Você não pode pedir uma quantidade superior ao estoque!");
                            }
                        }
    
                        // Retornando valores do produto
                        nomeProduto = servicoProduto.buscarNome(idProduto);
                        valorProduto = servicoProduto.buscarValor(idProduto);
                        quantidade = servicoProduto.buscarQuantidade(idProduto);
    
                        // Valor total de venda
                        valorTotal = valorTotal + (servicoProduto.buscarValor(idProduto) * quantidadeCompra);
    
                        // Reajustando a quantidade de produtos
                        quantidade = servicoProduto.buscarQuantidade(idProduto) - quantidadeCompra;
                        servicoProduto.editarProduto(idProduto, quantidade);
    
                        if (quantidade == 0){
                            servicoProduto.removerProdutoQuantidade(idProduto);
                            qtd -= 1;
                        }
    
                        // Adcionando compra na sua lista
                        Produto produto = new Produto(idProduto, nomeProduto, valorProduto, quantidade, quantidadeCompra);  
                        servicoVenda.adcionarProduto(produto);  
    
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Não existe nenhum produto cadastrado!");
                    }

                    break; 
            
                case 2: // Lista de compras
                    JOptionPane.showMessageDialog(null, "Lista de compras: \n" + servicoVenda.visualizarCompra() + "Valor total: R$ " + valorTotal + "\n \nAgradecemos pela compra, retorne sempre!");
                    break;
                
                case 3: // Finalizar compra
                    JOptionPane.showMessageDialog(null, "Lista de compras:\n\n" + servicoVenda.visualizarCompra() + "Valor total: R$ " + valorTotal + "\n \nAgradecemos pela compra, retorne sempre!");
                    sairFluxoCaixas = true;
                    break;
            
                case 4: // Menu
                    sairFluxoCaixas = true;
                    break;
            }
        }
    }
}

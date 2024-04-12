import javax.swing.*;

public class Main {
    public static void main(String[] args){

        // Listas de escolhas
        boolean sair = false;
        String[] menuStrings = {"Estoque", "Fluxos de caixa", "sair"};

        ServicoMenu servicoMenu = new ServicoMenu();


        // ------------ inicio do programa principal ------------ // 
        JOptionPane.showMessageDialog(null, "Bem-vindo ao gerenciador de estoque e fluxo de caixas");
        
        while (sair == false) {
            int menuPrincipal = JOptionPane.showOptionDialog(null, "Gerenciar: ", "MENU", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, menuStrings, menuStrings[0]);
        
            switch (menuPrincipal + 1) {
                case 1: // Estoque
                    servicoMenu.menuEstoque();
                    menuPrincipal = 0;
                    break;
    
                case 2: // Fluxo de caixa
                    servicoMenu.menuFluxodeCaixas();
                    menuPrincipal = 0;
                    break;

                case 3: // Sair do programa
                    sair = true;
                    break;
            }
        }

        JOptionPane.showMessageDialog(null, "Saindo do programa...");
    }
}

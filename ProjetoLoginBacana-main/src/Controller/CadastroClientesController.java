package Controller;

import Model.CadastroClienteModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CadastroClientesController {

    public void criarClienteController(String nomeCliente, String cepCliente, String enderecoCliente, String foneCliente, String emailCliente) {
        
        // Cria��o do novo cliente
        CadastroClienteModel novoCliente = new CadastroClienteModel(nomeCliente, cepCliente, enderecoCliente, foneCliente, emailCliente);
        
        // Verifica��o do retorno
        boolean sucesso = salvarClienteNoBanco(novoCliente); // Implementar m�todo de salvamento

        // Verifica��o do retorno
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Registro realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao realizar o registro no banco de dados!");
        }
    }

    private boolean salvarClienteNoBanco(CadastroClienteModel cliente) {
        // Aqui voc� implementaria a l�gica para salvar o cliente no banco de dados.
        // Retorne true se o salvamento foi bem-sucedido e false caso contr�rio.
        
        // Exemplo fict�cio:
        try {
            // C�digo para salvar no banco
            return true; // Supondo que a opera��o foi bem-sucedida
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Em caso de falha
        }
    }
    
    public ArrayList<CadastroClienteModel> filtroClienteController(String idCliente){
        CadastroClienteModel op = new CadastroClienteModel();
        return op.filtroClienteModel(idCliente);
    }
}

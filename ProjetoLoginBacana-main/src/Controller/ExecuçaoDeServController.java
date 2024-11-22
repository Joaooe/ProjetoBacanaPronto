
package Controller;

import Model.ExecucaoServicoModel;
import Model.OrdemServicoModel;


public class ExecuçaoDeServController {
    
    public void gerarOrdServController(String idCliente, String equipamento, String defeito) {

        ExecucaoServicoModel novoServico = new ExecucaoServicoModel(idCliente, equipamento, defeito);
        novoServico.salvarOrdemServModel(novoServico);
        
    }

    public boolean finalizarOrdemServico(String numeroOS, String nomeTecnico, String descricaoReparo, double valorReparo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
}

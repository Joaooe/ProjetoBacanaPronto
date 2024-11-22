package Controller;

import Model.ExecucaoServicoModel;
import Model.OrdemServicoModel;
import java.util.ArrayList;

public class OrdemServController {

    public void gerarOrdServController(String idCliente, String equipamento, String defeito) {
        OrdemServicoModel novoServico = new OrdemServicoModel(idCliente, equipamento, defeito);
        novoServico.salvarOrdemServModel(novoServico);
    }

    public boolean finalizarOrdemServico(ExecucaoServicoModel numeroOS) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  

}

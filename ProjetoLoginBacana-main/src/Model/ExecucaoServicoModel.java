package Model;

import DAL.GerenciarBancoOrdServ;
import java.sql.*;

public class ExecucaoServicoModel {

    private String idOrdemServico;
    private String equipamento;
    private String defeito;
    private String idCliente;

    public ExecucaoServicoModel() {
    }

    public ExecucaoServicoModel(String idCliente, String equipamento, String defeito) {
        this.equipamento = equipamento;
        this.defeito = defeito;
        this.idCliente = idCliente;
    }

    public String getIdOrdemServico() {
        return idOrdemServico;
    }

    public void setIdOrdemServico(String idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
    

    public void salvarOrdemServModel(ExecucaoServicoModel novoServico) {

        GerenciarBancoOrdServ op = new GerenciarBancoOrdServ();
        op.salvarOrdServBD(novoServico);
        
        
        
    }

  
}

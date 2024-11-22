package Model;

import DAL.GerenciarBancoOrdServ;
import java.sql.*;
import java.util.ArrayList;

public class OrdemServicoModel {

    private String idOrdemServico;
    private String equipamento;
    private String defeito;
    private String idCliente;

    public OrdemServicoModel() {
    }

    public OrdemServicoModel(String idCliente, String equipamento, String defeito) {
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

    public void salvarOrdemServModel(OrdemServicoModel novoServico) {

        GerenciarBancoOrdServ op = new GerenciarBancoOrdServ();
        op.salvarOrdServBD(novoServico);

    }
    
    

    // Getters e Setters
//
//    public void salvar() {
//        // Definindo a consulta SQL para inserir os dados
//        String query = "INSERT INTO ordem_servico (id_cliente, tipo_equipamento, marca, modelo, defeito_relato) VALUES (?, ?, ?, ?, ?)";
//
//        // Usando try-with-resources para garantir que a conexão e o PreparedStatement sejam fechados corretamente
//        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Assistencia_BD", "root", "root"); 
//             PreparedStatement stmt = conn.prepareStatement(query)) {
//
//            // Atribuindo os valores aos parâmetros da consulta SQL
//            stmt.setInt(1, this.idCliente);
//            stmt.setString(2, this.tipoEquipamento);
//            stmt.setString(3, this.marca);
//            stmt.setString(4, this.modelo);
//            stmt.setString(5, this.defeitoRelato);
//
//            // Executando a atualização (inserção)
//            stmt.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}

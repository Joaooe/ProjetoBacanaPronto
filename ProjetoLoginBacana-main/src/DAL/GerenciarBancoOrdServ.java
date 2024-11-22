package DAL;

import Model.ExecucaoServicoModel;
import Model.OrdemServicoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class GerenciarBancoOrdServ {

    public void salvarOrdServBD(OrdemServicoModel novoServico) {

        //Boolean sucesso = null;
        String sql = "insert into TB_ORDSERV (ID_CLIENTE, EQUIPAMENTO, DEFEITO) values (?, ?, ?)";
        PreparedStatement pst = null;
        Connection connection = null;

        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sql);
            pst.setString(1, novoServico.getIdCliente());
            pst.setString(2, novoServico.getEquipamento());
            pst.setString(3, novoServico.getDefeito());
            pst.executeUpdate();
            System.out.println("Registro inserido com sucesso no banco de dados!");
            //sucesso = true;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            System.out.println("Login ou email existente no banco de dados!");
            //sucesso = false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO::GerenciadorBancoDados::salvarUsuarioBD");
            //sucesso = false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void salvarOrdServBD(ExecucaoServicoModel novoServico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

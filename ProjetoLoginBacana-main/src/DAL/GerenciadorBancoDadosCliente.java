package DAL;

import Model.CadastroClienteModel;
import Model.CadastroUsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GerenciadorBancoDadosCliente {

    public Boolean salvarClienteBD(CadastroClienteModel novoCliente) {

        Boolean sucesso = null;
        String sql = "insert into TB_CLIENTES (NOME_CLIENTE, CEP_CLIENTE, ENDERECO_CLIENTE, FONE_CLIENTE, EMAIL_CLIENTE) values (?, ?, ?, ?, ?)";
        PreparedStatement pst = null;
        Connection connection = null;

        try {
            connection = (Connection) new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sql);
            pst.setString(1, novoCliente.getNomeCliente());
            pst.setString(2, novoCliente.getCepCliente());
            pst.setString(3, novoCliente.getEnderecoCliente());
            pst.setString(4, novoCliente.getFone());
            pst.setString(5, novoCliente.getEmail());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO::GerenciadorBancoDados::salvarCLIENTEBD");
            sucesso = false;
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
            return sucesso;
        }
    }

    public ArrayList<CadastroClienteModel> filtragemClienteBD(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<CadastroClienteModel> listagemClienteBD() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void deletarClienteBD(String id_user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void alterarClienteBD(CadastroUsuarioModel usuarioAtualizado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void resetSenha(CadastroUsuarioModel senhaAtualizada) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<CadastroClienteModel> recuperarClienteBD(String id_user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<CadastroClienteModel> filtroClientesDAL(String idCliente) {

        ArrayList<CadastroClienteModel> listaFiltrada = new ArrayList<>();
        String sql = "SELECT * from TB_CLIENTES where ID_CLIENTE = " + idCliente;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection connection = null;

        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String idCli = rs.getString("ID_CLIENTE");
                String nomeCliente = rs.getString("NOME_CLIENTE");
                String enderecoCliente = rs.getString("ENDERECO_CLIENTE");
                // Adicionar um novo construtor na classe CadastroUsuarioModel
                // Que contenha id_user e perfil Usuario
                CadastroClienteModel itemLista = new CadastroClienteModel(nomeCliente, null, nomeCliente, null, null);
                listaFiltrada.add(itemLista);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO::OperBancoDados::SelecionarDados");
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

        return listaFiltrada;

    }

}

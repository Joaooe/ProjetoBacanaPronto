package DAL;

import Model.CadastroClienteModel;
import Model.CadastroUsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GerenciadorBancoDados {

    //Metodo ser� utilizado para busca de login e senha no banco de dados
    public boolean verificarLoginSenha(String login, String password) {

        String sql = "SELECT * from TB_USERS where login = ? and password = ? ";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection connection = null;
        Boolean contemDados = null;

        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, password);
            rs = pst.executeQuery();

            if (rs.next()) {
                contemDados = true;
            } else {
                contemDados = false;
            }

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("ERRO::OperBancoDados::verificarLoginSenha");
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
        return contemDados;
    }

    public Boolean salvarUsuarioBD(CadastroUsuarioModel novoUsuario) {

        Boolean sucesso = null;
        String sql = "insert into TB_USERS (USER_NAME, EMAIL, LOGIN, PASSWORD, PERFIL_USER) values (?, ?, ?, ?, ?)";
        PreparedStatement pst = null;
        Connection connection = null;

        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sql);
            pst.setString(1, novoUsuario.getUsername());
            pst.setString(2, novoUsuario.getEmail());
            pst.setString(3, novoUsuario.getLogin());
            pst.setString(4, novoUsuario.getPassword());
            pst.setString(5, novoUsuario.getPerfil());
            pst.executeUpdate();
            System.out.println("Registro inserido com sucesso no banco de dados!");
            sucesso = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Login ou email existente no banco de dados!");
            sucesso = false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO::GerenciadorBancoDados::salvarUsuarioBD");
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
        }

        return sucesso;
    }

    public ArrayList<CadastroUsuarioModel> listagemUsuariosBD() {

        ArrayList<CadastroUsuarioModel> listaCompleta = new ArrayList<>();
        String sql = "SELECT * from TB_USERS";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection connection = null;

        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String idUser = rs.getString("ID_USER");
                String userName = rs.getString("USER_NAME");
                String email = rs.getString("EMAIL");
                String login = rs.getString("LOGIN");
                String password = rs.getString("PASSWORD");
                String perfilUser = rs.getString("PERFIL_USER");
                // Adicionar um novo construtor na classe CadastroUsuarioModel
                // Que contenha id_user e perfil Usuario
                CadastroUsuarioModel itemLista = new CadastroUsuarioModel(idUser, userName, email, login, password, perfilUser);
                listaCompleta.add(itemLista);
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

        return listaCompleta;

    }

    // M�todo que lista usu�rios conforme pesquisa
    public ArrayList<CadastroUsuarioModel> filtragemUsuariosBD(String nome) {

        ArrayList<CadastroUsuarioModel> listaFiltrada = new ArrayList<>();
        String sql = "SELECT * from TB_USERS where USER_NAME like'%" + nome + "%' order by USER_NAME";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection connection = null;

        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String idUser = rs.getString("ID_USER");
                String userName = rs.getString("USER_NAME");
                String email = rs.getString("EMAIL");
                String login = rs.getString("LOGIN");
                String password = rs.getString("PASSWORD");
                String perfilUser = rs.getString("PERFIL_USER");
                // Adicionar um novo construtor na classe CadastroUsuarioModel
                // Que contenha id_user e perfil Usuario
                CadastroUsuarioModel itemLista = new CadastroUsuarioModel(idUser, userName, email, login, password, perfilUser);
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

    //filtragemUsuariosBD
    public void deletarUsuarioBD(String id_user) {

        String sql = "delete from TB_USERS where ID_USER = ?";
        PreparedStatement pst = null;
        Connection connection = null;

        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sql);
            pst.setString(1, id_user);
            pst.executeUpdate();
            System.out.println("User excluded with sucess!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO::OperBancoDados::deletarUsuarioBD");
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
    
    //M�todo para atualizar as informa��es do banco de dados
    //deletarUsuarioBD
    public void alterarUsuarioBD(CadastroUsuarioModel usuarioAtualizado) {
        String sql = "update TB_USERS set USER_NAME=?, EMAIL=?, LOGIN=?, PERFIL_USER=? where ID_USER = ?";
        PreparedStatement pst = null;
        Connection connection = null;

        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sql);
            pst.setString(1, usuarioAtualizado.getUsername());
            pst.setString(2, usuarioAtualizado.getEmail());
            pst.setString(3, usuarioAtualizado.getLogin());
            pst.setString(4, usuarioAtualizado.getPerfil());
            pst.setString(5, usuarioAtualizado.getId());
            pst.executeUpdate();
            System.out.println("Item alterado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO::OperBancoDados::alterarUsuarioBD");
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
    
    public void resetSenha(CadastroUsuarioModel senhaResetada){
            String sql = "update TB_USERS set PASSWORD = ? where ID_USER = ?";
        PreparedStatement pst = null;
        Connection connection = null;

        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sql);
            pst.setString(1, senhaResetada.getPassword());
            pst.setString(2, senhaResetada.getId());
            
            pst.executeUpdate();
            System.out.println("Senha resetada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO::OperBancoDados::resetarSenhaBD");
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
    public ArrayList<CadastroUsuarioModel> recuperarUsuariosBD(String id_user) {

        ArrayList<CadastroUsuarioModel> listaCompleta = new ArrayList<>();
        String sql = "SELECT * from TB_Users WHERE ID_USER = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection connection = null;

        try {
            connection = new ConnectionFactory().getConnection();
            pst = connection.prepareStatement(sql);
            pst.setString(1, id_user);
            rs = pst.executeQuery();
            while (rs.next()) {
                String idUser = rs.getString("ID_USER");
                String userName = rs.getString("USER_NAME");
                String email = rs.getString("EMAIL");
                String login = rs.getString("LOGIN");
                String password = rs.getString("PASSWORD");
                String perfilUser = rs.getString("PERFIL_USER");
                // Adicionar um novo construtor na classe CadastroUsuarioModel
                // Que contenha id_user e perfil Usuario
                CadastroUsuarioModel itemLista = new CadastroUsuarioModel(idUser, userName, email, login, password, perfilUser);
                listaCompleta.add(itemLista);
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

        return listaCompleta;

    }

    public ArrayList<CadastroClienteModel> listagemClienteBD() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<CadastroClienteModel> filtragemClienteBD(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
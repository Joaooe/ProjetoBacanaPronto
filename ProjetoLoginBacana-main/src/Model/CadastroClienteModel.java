package Model;

import DAL.GerenciadorBancoDadosCliente;
import java.util.ArrayList;

public class CadastroClienteModel {

    private String id; // Se o ID for necessário, mas não está sendo utilizado aqui
    private String nomeCliente;
    private String cepCliente;
    private String enderecoCliente;
    private String fone;
    private String email;

    public CadastroClienteModel() {
    }

    // Construtor com ID
    public CadastroClienteModel(String id, String nomeCliente, String cepCliente, String enderecoCliente, String fone, String email) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.cepCliente = cepCliente;
        this.enderecoCliente = enderecoCliente;
        this.fone = fone;
        this.email = email;
    }

    // Construtor sem ID
    public CadastroClienteModel(String nomeCliente, String cepCliente, String enderecoCliente, String fone, String email) {
        this.nomeCliente = nomeCliente;
        this.cepCliente = cepCliente;
        this.enderecoCliente = enderecoCliente;
        this.fone = fone;
        this.email = email;
    }

    // Método para enviar dados ao banco de dados
    public boolean enviarDadosDbDAL() {
        GerenciadorBancoDadosCliente op = new GerenciadorBancoDadosCliente();

        // Chama o método que salva o cliente no banco de dados
        return op.salvarClienteBD(this); // Passa o objeto atual
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<CadastroClienteModel> filtroClienteModel(String idCliente) {

        GerenciadorBancoDadosCliente op = new GerenciadorBancoDadosCliente();
        return op.filtroClientesDAL(idCliente);

    }
}

package br.com.zup.Cadastros.cadastro.dtos;

public class ResumoCadastroDTO {
    private String cpf;
    private String nome;
    private String sobrenome;

    public ResumoCadastroDTO() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}

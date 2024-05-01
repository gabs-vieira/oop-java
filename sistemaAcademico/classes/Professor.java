package sistemaAcademico.classes;

import java.math.BigInteger;
import java.util.List;

public class Professor {

    private BigInteger id;
    private String nome;
    private String endereco;
    private String cpf;
    private String departamento;


    public Professor(BigInteger id, String nome, String endereco, String cpf, String departamento) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.departamento = departamento;
    }

    public static void adicionarProfessores(List<Professor> professores) {
        String[] nomes = {"João", "Maria", "Pedro", "Ana", "José"};
        String[] enderecos = {"Rua A", "Rua B", "Rua C", "Rua D", "Rua E"};
        String[] cpfs = {"111.111.111-11", "222.222.222-22", "333.333.333-33", "444.444.444-44", "555.555.555-55"};
        String[] departamentos = {"Departamento X", "Departamento Y", "Departamento Z", "Departamento W", "Departamento V"};

        for (int i = 0; i < 5; i++) {
            BigInteger id = BigInteger.valueOf(i + 1);
            Professor professor = new Professor(id, nomes[i], enderecos[i], cpfs[i], departamentos[i]);
            professores.add(professor);
        }
    }


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}

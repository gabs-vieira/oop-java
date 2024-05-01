package sistemaAcademico.classes;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class Aluno {

    private BigInteger id;
    private String nome;
    private String endereco;
    private String cpf;
    private int idade = 0;
    private Date dataNascimento; //Scanned in the "dd/MM/yyyy" format

    public Aluno( BigInteger id, String nome, String endereco, String cpf) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public static void adicionarAlunos(List<Aluno> alunos) {
        String[] nomes = {"Rafael", "Jeff", "Gabriel", "Bianca", "Larissa"};
        String[] enderecos = {"Rua H", "Rua I", "Rua J", "Rua K", "Rua L"};
        String[] cpfs = {"666.666.666-66", "777.777.777-77", "888.888.888-88", "999.999.999-99", "123.123.123-12"};

        for (int i = 0; i < 5; i++) {
            BigInteger id = BigInteger.valueOf(i + 1);
            Aluno aluno = new Aluno(id, nomes[i], enderecos[i], cpfs[i]);
            alunos.add(aluno);
        }
    }

    // Getters and Setters
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

    public int getIdade() {

        if ( idade > 0 ){
            return idade;

        } else if ( dataNascimento != null){
            Date dataAtual = new Date();
            long diferenca = dataAtual.getTime() - dataNascimento.getTime();
            long diferencaEmDias = diferenca / (1000 * 60 * 60 * 24);
            int idadecalc = (int) (diferencaEmDias / 365.25);
            return idadecalc;

        }else{
            return -1;
        }
    }

    public int getIdadeInt(){
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

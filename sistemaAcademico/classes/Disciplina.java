package sistemaAcademico.classes;

import java.math.BigInteger;
import java.util.List;

public class Disciplina {

    private BigInteger id;
    private String nome;
    private int cargaHoraria;

    public Disciplina(BigInteger id, String nome, String endereco, String cpf) {
    }


    public BigInteger getId() {
        return id;
    }

    public Disciplina(BigInteger id, String nome, int cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }
    public static void adicionarDisciplinas(List<Disciplina> disciplinas) {
        String[] nomes = {"Matemática", "História", "Geografia", "Biologia", "Química"};
        int[] cargasHorarias = {60, 70, 80, 90, 100};

        for (int i = 0; i < 5; i++) {
            BigInteger id = BigInteger.valueOf(i + 1);
            Disciplina disciplina = new Disciplina(id, nomes[i], cargasHorarias[i]);
            disciplinas.add(disciplina);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}

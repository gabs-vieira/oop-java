package sistemaAcademico.classes;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

public class Turma {

    private BigInteger id;
    private String nome;
    private Timestamp horario;
    private String local;
    private Disciplina disciplina;
    private Professor professor;
    public List<Aluno> alunos;

    public Turma(BigInteger id, String nome, Timestamp horario, String local, Disciplina disciplina, Professor professor, List<Aluno> alunos) {
        this.id = id;
        this.nome = nome;
        this.horario = horario;
        this.local = local;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = alunos;
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

    public Timestamp getHorario() {
        return horario;
    }

    public void setHorario(Timestamp horario) {
        this.horario = horario;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}

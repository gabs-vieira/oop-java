package sistemaAcademico;

import sistemaAcademico.classes.Aluno;
import sistemaAcademico.classes.Disciplina;
import sistemaAcademico.classes.Professor;
import sistemaAcademico.classes.Turma;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Timestamp;
import java.math.BigInteger;

import static sistemaAcademico.classes.Aluno.adicionarAlunos;
import static sistemaAcademico.classes.Disciplina.adicionarDisciplinas;
import static sistemaAcademico.classes.Professor.adicionarProfessores;

public class Main {

    // Listas de objetos
    static List<Turma> turmas = new ArrayList<>();
    static List<Professor> professores = new ArrayList<>();
    static List<Disciplina> disciplinas = new ArrayList<>();
    static List<Aluno> alunos = new ArrayList<>();


    public static void main(String[] args) {

        adicionarProfessores(professores);
        adicionarDisciplinas(disciplinas);
        adicionarAlunos(alunos);

        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Cadastrar Turma");
            System.out.println("2. Matricular Aluno");
            System.out.println("3. Cancelar Matrícula");
            System.out.println("4. Turmas");
            System.out.println("5. Exit");
            System.out.print("Selecione qual seção quer abordar: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    cadastrarTurma();
                    break;

                case 2:
                    matricularAluno(scanner, turmas, alunos);
                    break;
                case 3:
                    cancelarMatricula(scanner, turmas, alunos);
                    break;
                case 4:
                    listarTurmas();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente..");
            }
        }
    }


    public static void cadastrarTurma() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome da turma: ");
        String nome = scanner.nextLine();
        System.out.print("Horário (no formato yyyy-MM-dd HH:mm:ss): ");
        String horarioStr = scanner.nextLine();
        Timestamp horario = Timestamp.valueOf(horarioStr);
        System.out.print("Local: ");
        String local = scanner.nextLine();

        // Disciplina
        System.out.println("Disciplinas disponíveis:");
        for (int i = 0; i < disciplinas.size(); i++) {
            System.out.println((i + 1) + " " + disciplinas.get(i).getNome());
        }
        System.out.print("Escolha a disciplina (número): ");
        int disciplinaIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Disciplina disciplina = disciplinas.get(disciplinaIndex);

        // Professor
        System.out.println("Professores disponíveis:");
        for (int i = 0; i < professores.size(); i++) {
            System.out.println((i + 1) + " " + professores.get(i).getNome());
        }
        System.out.print("Escolha o professor (número): ");
        int professorIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Professor professor = professores.get(professorIndex);

        // Alunos
        boolean continuarMatricula = true;
        List<Aluno> alunosMatriculados = new ArrayList<>();

        while (continuarMatricula) {
            // Alunos
            System.out.println("Alunos disponíveis:");
            for (int i = 0; i < alunos.size(); i++) {
                System.out.println((i + 1) + " " + alunos.get(i).getNome());
            }
            System.out.print("Escolha o aluno (número) ou 0 para parar: ");
            int alunoIndex = Integer.parseInt(scanner.nextLine()) - 1;
            if (alunoIndex == -1) {
                continuarMatricula = false;
            } else {
                Aluno aluno = alunos.get(alunoIndex);
                alunosMatriculados.add(aluno);
            }


        }
        Turma turma = new Turma(BigInteger.valueOf(1), nome, horario, local, disciplina, professor, alunosMatriculados);
        turmas.add(turma);
    }

    private static void matricularAluno(Scanner scanner, List<Turma> turmas, List<Aluno> alunosCadastrados) {
        scanner.nextLine(); // Limpar o buffer

        System.out.println("Selecione a turma para matricular o aluno: ");
        for (int i = 0; i < turmas.size(); i++) {
            System.out.println((i + 1) + " " + turmas.get(i).getNome());
        }

        System.out.print("Escolha a turma (número): ");
        int turmaIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Turma turma = turmas.get(turmaIndex);

        System.out.println("Lista de alunos disponíveis:");
        for (Aluno aluno : alunosCadastrados) {
            System.out.println("ID: " + aluno.getId() + " - Nome: " + aluno.getNome());
        }

        System.out.print("Digite o ID do aluno que deseja matricular: ");
        BigInteger alunoId = BigInteger.valueOf(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer

        boolean alunoEncontrado = false;
        for (Aluno aluno : turma.getAlunos()) {
            if (aluno.getId() == alunoId) {
                System.out.println("Este aluno já está matriculado nesta turma.");
                alunoEncontrado = true;
                break;
            }
        }

        if (alunoEncontrado) {
            return;
        }

        Aluno alunoSelecionado = null;
        for (Aluno aluno : alunosCadastrados) {
            if (aluno.getId() == alunoId) {
                alunoSelecionado = aluno;
                break;
            }
        }

        if (alunoSelecionado == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        turma.alunos.add(alunoSelecionado);
        System.out.println("Aluno matriculado com sucesso na turma " + turma.getNome());
    }

    private static void cancelarMatricula(Scanner scanner, List<Turma> turmas, List<Aluno> alunosCadastrados) {
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Selecione a turma para cancelar a matrícula do aluno: ");
        for (int i = 0; i < turmas.size(); i++) {
            System.out.println((i + 1) + " " + turmas.get(i).getNome());
        }

        System.out.print("Escolha a turma (número): ");
        int turmaIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Turma turma = turmas.get(turmaIndex);

        System.out.println("Lista de alunos da turma:");
        List<Aluno> alunosTurma = turma.getAlunos();
        for (int i = 0; i < alunosTurma.size(); i++) {
            Aluno aluno = alunosTurma.get(i);
            System.out.println("ID: " + aluno.getId() + " - Nome: " + aluno.getNome());
        }

        System.out.print("Digite o ID do aluno que deseja cancelar a matrícula: ");
        BigInteger alunoId = BigInteger.valueOf(Integer.parseInt(scanner.nextLine()));

        // Verifica se o aluno está matriculado na turma
        boolean alunoEncontrado = false;
        for (int i = 0; i < alunosTurma.size(); i++) {
            Aluno aluno = alunosTurma.get(i);
            if (aluno.getId() == alunoId) {
                turma.alunos.remove(aluno);
                System.out.println("Matrícula do aluno cancelada com sucesso na turma " + turma.getNome());
                alunoEncontrado = true;
                break;
            }
        }

        if (!alunoEncontrado) {
            System.out.println("Aluno não encontrado nesta turma.");
        }
    }

    public static void listarTurmas(){
        for (int i = 0; i < turmas.size(); i++) {
            System.out.println("Turma: " + turmas.get(i).getNome());
            System.out.println("Horário: " + turmas.get(i).getHorario());
            System.out.println("Local: " + turmas.get(i).getLocal());
            System.out.println("Disciplina: " + turmas.get(i).getDisciplina().getNome());
            System.out.println("Professor: " + turmas.get(i).getProfessor().getNome());
            System.out.println("Alunos: ");
            for (Aluno aluno : turmas.get(i).getAlunos()) {
                System.out.println("ID: " + aluno.getId() + " - Nome: " + aluno.getNome());
            }
            System.out.println();
        }
    }
}
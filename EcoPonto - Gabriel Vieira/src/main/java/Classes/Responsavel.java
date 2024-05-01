package Classes;

import java.util.ArrayList;
import java.util.Iterator;

public class Responsavel {

    private static int idCounter = 0;
    private int id;
    private String nome;
    private String cpf;



    public Responsavel( String nome, String cpf ) {
        this.id = idCounter++;
        this.nome = nome;
        this.cpf = cpf;
    }

    public static ArrayList<Responsavel> criarResponsavelPadrao(){
        ArrayList<Responsavel> responsaveis = new ArrayList<Responsavel>();
        responsaveis.add(new Responsavel("Responsável Padrão", "000.000.000-00"));
        return responsaveis;
    }

    public static void addResponsavel(ArrayList<Responsavel> responsaveis, String nome, String cpf){
        responsaveis.add(new Responsavel(nome, cpf));
    }

    public static void removeResponsavel(int id, ArrayList<Responsavel> responsaveis) {
        Iterator<Responsavel> iterator = responsaveis.iterator();
        while (iterator.hasNext()) {
            Responsavel residuo = iterator.next();
            if (residuo.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    //Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}




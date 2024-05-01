package Classes;

import java.util.ArrayList;

public class Ecoponto {

    private static int idCounter = 0;
    private int id;
    private String nome;
    private String endereco;
    private Responsavel responsavel;
    private ArrayList<Residuo> residuos;


    public Ecoponto(String nome, String endereco, Responsavel responsavel, ArrayList<Residuo> residuos) {
        this.id = idCounter++;
        this.nome = nome;
        this.endereco = endereco;
        this.responsavel = responsavel;
        this.residuos = residuos;
    }

//    Ecoponto ecoponto = new Ecoponto(nome, endereco, responsavel, residuosEcoponto);
    public static void  addEcoponto( ArrayList<Ecoponto> ecopontos ,String nome, String endereco, Responsavel responsavel, ArrayList<Residuo> residuos ){
        ecopontos.add(new Ecoponto(nome, endereco, responsavel, residuos));
    }

    public static void addResiduoEcoponto(Ecoponto ecoponto, Residuo residuo){
        ecoponto.getResiduos().add(residuo);
    }

    public static void removeResiduoEcoponto(Ecoponto ecoponto, Residuo residuo){
        ecoponto.getResiduos().remove(residuo);
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

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Responsavel getResponsavel() {
        return this.responsavel ;
    }
    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public ArrayList<Residuo> getResiduos() {
        return residuos;
    }
    public void setResiduos(ArrayList<Residuo> residuos) {
        this.residuos = residuos;
    }
}



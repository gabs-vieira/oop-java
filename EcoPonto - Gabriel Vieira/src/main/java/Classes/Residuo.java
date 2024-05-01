package Classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

//import lombok.Getter;
//import lombok.Setters;


public class Residuo {
    private static int idCounter = 0;
    private int id;
    private String origem;


    //Constructors
    public Residuo(String origem) {
        this.id = idCounter++;
        this.origem = origem;
    }

    //Methods
    public static ArrayList<Residuo> criarResiduosPadrao() {
        ArrayList<Residuo> residuos = new ArrayList<Residuo>();

        //Lista de resíduos segundo a SINIR: Sistema Nacional de Informações sobre a Gestão dos Resíduos Sólidos
        residuos.add(new Residuo("Doméstico"));
        residuos.add(new Residuo("Limpeza Urbana"));
        residuos.add(new Residuo("Sólidos Urbanos"));
        residuos.add(new Residuo("Estabelecimentos Comerciais"));
        residuos.add(new Residuo("Saneamento Básico"));
        residuos.add(new Residuo("Industrial"));
        residuos.add(new Residuo("Serviço de Saúde"));
        residuos.add(new Residuo("Agrossilvopastoris"));
        residuos.add(new Residuo("Transportes"));
        residuos.add(new Residuo("Mineração"));

        return residuos;
    }


    public static void  addResiduo( ArrayList<Residuo> residuos, String origem){
        residuos.add(new Residuo(origem));
    }

    public static void removeResiduo(int id, ArrayList<Residuo> residuos) {
        Iterator<Residuo> iterator = residuos.iterator();
        while (iterator.hasNext()) {
            Residuo residuo = iterator.next();
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
    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }

}
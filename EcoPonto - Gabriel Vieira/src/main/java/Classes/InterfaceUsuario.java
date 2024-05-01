package Classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class InterfaceUsuario {

    ArrayList<Residuo> residuos = Residuo.criarResiduosPadrao();
    ArrayList<Responsavel> responsaveis = Responsavel.criarResponsavelPadrao();
    ArrayList<Ecoponto> ecopontos = new ArrayList<Ecoponto>();


    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu");
            System.out.println("Escolha qual seção quer abordar");
            System.out.println(" 1 - Resíduos");
            System.out.println(" 2 - Responsaveis");
            System.out.println(" 3 - Ecopontos");
            System.out.println(" 4 - Encerrar");


            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    menuResiduos();
                    break;
                case 2:
                    menuResponsaveis();
                    break;
                case 3:
                    menuEcopontos();
                    break;
                case 4:
                    System.out.println("Encerrando...");
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }
    }


    public void menuResiduos() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu Resíduos");
            System.out.println("Escolha qual ação deseja realizar");
            System.out.println(" 1 - Cadastrar Resíduo");
            System.out.println(" 2 - Remover Resíduo");
            System.out.println(" 3 - Listar Resíduos");
            System.out.println(" 4 - Voltar");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite a origem (nome) do resíduo");
                    String nome = scanner.next();
                    Residuo.addResiduo(this.residuos, nome);
                    break;
                case 2:

                    //Listar os resíduos para o usuário escolher qual remover
                    for (Residuo residuo : this.residuos) {
                        System.out.println("ID: " + residuo.getId() + " Origem: " + residuo.getOrigem());
                    }

                    System.out.println("Digite o id do resíduo que deseja remover");

                    int id = scanner.nextInt();
                    Residuo.removeResiduo(id, this.residuos);
                    break;
                case 3:
                    for (Residuo residuo : this.residuos) {
                        System.out.println("ID: " + residuo.getId() + " Origem: " + residuo.getOrigem());
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }
    }

    public void menuResponsaveis() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu Responsaveis");
            System.out.println("Escolha qual ação deseja realizar");
            System.out.println(" 1 - Cadastrar Responsável");
            System.out.println(" 2 - Remover Responsável");
            System.out.println(" 3 - Listar Responsável");
            System.out.println(" 4 - Voltar");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome do responsável");
                    String nome = scanner.next();
                    System.out.println("Digite o cpf do responsável");
                    String cpf = scanner.next();
                    Responsavel.addResponsavel(this.responsaveis, nome, cpf);
                    break;
                case 2:

                    //Listar os responsáveis para o usuário escolher qual remover
                    for (Responsavel responsavel : this.responsaveis) {
                        System.out.println("ID: " + responsavel.getId() + " Nome: " + responsavel.getNome() + " CPF: " + responsavel.getCpf());
                    }

                    System.out.println("Digite o id do responsável que deseja remover");

                    int id = scanner.nextInt();
                    Responsavel.removeResponsavel(id, this.responsaveis);
                    break;

                case 3:
                    for (Responsavel responsavel : this.responsaveis) {
                        System.out.println("ID: " + responsavel.getId() + " Nome: " + responsavel.getNome() + " CPF: " + responsavel.getCpf());
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }
    }


    public void menuEcopontos() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu Ecopontos");
            System.out.println("Escolha qual ação deseja realizar");
            System.out.println(" 1 - Cadastrar Ecoponto");
            System.out.println(" 2 - Remover Ecoponto da Lista Padrão");
            System.out.println(" 3 - Listar todos os Ecopontos");
            System.out.println(" 4 - Gerenciar Resíduos de um Ecoponto");
            System.out.println(" 5 - Gerenciar Responsáveis de um Ecoponto");
            System.out.println(" 6 - Voltar");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome do ecoponto");
                    String nome = scanner.next();
                    System.out.println("Digite o endereço do ecoponto");
                    String endereco = scanner.next();


                    // Solicitar ao usuário que escolha um responsável
                    Responsavel responsavel = null;
                    while (responsavel == null) {
                        // Listar os responsáveis disponíveis
                        for (Responsavel r : this.responsaveis) {
                            System.out.println("ID: " + r.getId() + " Nome: " + r.getNome() + " CPF: " + r.getCpf());
                        }

                        // Solicitar ao usuário que escolha um ID
                        System.out.println("Digite o ID do responsável do ecoponto");
                        int idResponsavel = scanner.nextInt();

                        // Verificar se o ID escolhido corresponde a um responsável existente
                        for (Responsavel r : this.responsaveis) {
                            if (r.getId() == idResponsavel) {
                                responsavel = r;
                                break;
                            }
                        }

                        // Se responsavel ainda for null, o ID fornecido não corresponde a um responsável existente
                        if (responsavel == null) {
                            System.out.println("ID de responsável não encontrado. Tente novamente.");
                        }
                    }

                    ArrayList<Residuo> residuosEcoponto = new ArrayList<Residuo>();

                    // Solicitar ao usuário que escolha os resíduos
                    while (true) {
                        // Listar os resíduos disponíveis
                        for (Residuo r : this.residuos) {
                            System.out.println("ID: " + r.getId() + " Origem: " + r.getOrigem());
                        }

                        // Solicitar ao usuário que escolha um ID
                        System.out.println("Digite o ID do resíduo do ecoponto");
                        int idResiduo = scanner.nextInt();

                        // Verificar se o ID escolhido corresponde a um resíduo existente
                        Residuo residuo = null;
                        for (Residuo r : this.residuos) {
                            if (r.getId() == idResiduo) {
                                residuo = r;
                                break;
                            }
                        }

                        // Se residuo ainda for null, o ID fornecido não corresponde a um resíduo existente
                        if (residuo == null) {
                            System.out.println("ID de resíduo não encontrado. Tente novamente.");
                        } else {
                            residuosEcoponto.add(residuo);
                        }

                        // Perguntar se o usuário deseja adicionar mais resíduos
                        System.out.println("Deseja adicionar mais resíduos? (s/n)");
                        String resposta = scanner.next();
                        if (!resposta.equals("s")) {
                            break;
                        }
                    }


                    //Adicionar o ecoponto na lista global
                    Ecoponto.addEcoponto(this.ecopontos, nome, endereco, responsavel, residuosEcoponto);
                    break;


                case 2:
                    //Listar os ecopontos para remoçao
                    for (Ecoponto ecoponto : this.ecopontos) {
                        System.out.println( "ID: " + ecoponto.getId()  + " Nome: " + ecoponto.getNome());
                    }

                    System.out.println("Digite o ID do ecoponto que deseja remover");
                    int idEcoponto = scanner.nextInt();

                    Iterator<Ecoponto> iterator = this.ecopontos.iterator();
                    while (iterator.hasNext()) {
                        Ecoponto ecoponto = iterator.next();
                        if (ecoponto.getId() == idEcoponto) {
                            iterator.remove();
                            break;
                        }
                    }

                    break;


                case 3:
                    //Listar os ecopontos para o usuário escolher qual remover
                    for (Ecoponto ecoponto : this.ecopontos) {
                        System.out.println("Nome: " + ecoponto.getNome() + " Endereço: " + ecoponto.getEndereco());

                        //Listar os Responsáveis do ecoponto
                        System.out.println("Responsável: " + ecoponto.getResponsavel().getNome());

                        //Listar os resíduos do ecoponto
                        for (Residuo residuo : ecoponto.getResiduos()) {
                            System.out.println("ID: " + residuo.getId() + " Origem: " + residuo.getOrigem());
                        }

                        System.out.println(" "); //Break para melhorar a visualização
                    }

                    break;



                case 4:
                    menuGerenciamentoResiduosEcoponto();
                    break;

                case 5:
                    menuGerenciamentoResponsaveisEcoponto();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }
    }

    public void menuGerenciamentoResiduosEcoponto() {
        Scanner scanner = new Scanner(System.in);


        //Listar os nomes dos Ecopontos
        for (Ecoponto ecoponto : this.ecopontos) {
            System.out.println("ID: " + ecoponto.getId() + " Nome: " + ecoponto.getNome());
        }

        System.out.println("Digite o ID do ecoponto que deseja gerenciar os resíduos");
        int idEcoponto = scanner.nextInt();

        Ecoponto ecoponto = null;
        for (Ecoponto e : this.ecopontos) {
            if (e.getId() == idEcoponto) {
                ecoponto = e;
                break;
            }
        }

        if (ecoponto == null) {
            System.out.println("Ecoponto não encontrado");
            return;
        }

        while (true) {
            System.out.println("Menu de Gerenciamento de Resíduos do Ecoponto " + ecoponto.getNome());
            System.out.println("Escolha qual ação deseja realizar");
            System.out.println(" 1 - Adicionar Resíduo");
            System.out.println(" 2 - Remover Resíduo");
            System.out.println(" 3 - Listar Resíduos");
            System.out.println(" 4 - Voltar");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    // Listar os resíduos disponíveis
                    for (Residuo r : this.residuos) {
                        System.out.println("ID: " + r.getId() + " Origem: " + r.getOrigem());
                    }

                    // Solicitar ao usuário que escolha um ID
                    System.out.println("Digite o ID do resíduo que deseja adicionar ao ecoponto");
                    int idResiduo = scanner.nextInt();

                    // Verificar se o ID escolhido corresponde a um resíduo existente
                    Residuo residuo = null;
                    for (Residuo r : this.residuos) {
                        if (r.getId() == idResiduo) {
                            residuo = r;
                            break;
                        }
                    }

                    // Se residuo ainda for null, o ID fornecido não corresponde a um resíduo existente
                    if (residuo == null) {
                        System.out.println("ID de resíduo não encontrado. Tente novamente.");
                    } else {
                        ecoponto.addResiduoEcoponto(  ecoponto, residuo);
                        System.out.println("Resíduo adicionado com sucesso ao ecoponto " + ecoponto.getNome());
                    }
                    break;

                case 2:
                    // Listar os resíduos do ecoponto para o usuário escolher qual remover
                    for (Residuo r : ecoponto.getResiduos()) {
                        System.out.println("ID: " + r.getId() + " Origem: " + r.getOrigem());
                    }

                    // Solicitar ao usuário que escolha um ID
                    System.out.println("Digite o ID do resíduo que deseja remover do ecoponto");
                    int idRemover = scanner.nextInt();

                    // Verificar se o ID escolhido corresponde a um resíduo existente no ecoponto
                    Residuo residuoremover = null;
                    for (Residuo r : ecoponto.getResiduos()) {
                        if (r.getId() == idRemover) {
                            residuoremover = r;
                            break;
                        }
                    }

                    // Se residuoremover ainda for null, o ID fornecido não corresponde a um resíduo existente
                    if (residuoremover == null) {
                        System.out.println("ID de resíduo não encontrado no ecoponto. Tente novamente.");
                    } else {
                        Ecoponto.removeResiduoEcoponto(ecoponto, residuoremover);
                        System.out.println("Resíduo removido com sucesso do ecoponto " + ecoponto.getNome());
                    }

                case 3:
                    // Listar os resíduos do ecoponto
                    for (Residuo r : ecoponto.getResiduos()) {
                        System.out.println("ID: " + r.getId() + " Origem: " + r.getOrigem());
                    }
                    break;

                case 4:
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    public void menuGerenciamentoResponsaveisEcoponto() {
        Scanner scanner = new Scanner(System.in);

        //Listar os nomes dos Ecopontos
        for (Ecoponto ecoponto : this.ecopontos) {
            System.out.println("ID: " + ecoponto.getId() + " Nome: " + ecoponto.getNome());
        }

        System.out.println("Digite o ID do ecoponto que deseja gerenciar os responsáveis");
        int idEcoponto = scanner.nextInt();

        Ecoponto ecoponto = null;
        for (Ecoponto e : this.ecopontos) {
            if (e.getId() == idEcoponto) {
                ecoponto = e;
                break;
            }
        }

        if (ecoponto == null) {
            System.out.println("Ecoponto não encontrado");
            return;
        }

        while (true) {
            System.out.println("Menu de Gerenciamento de Responsável do Ecoponto " + ecoponto.getNome());
            System.out.println("Responsável atual: " + ecoponto.getResponsavel().getNome());

            System.out.println("Escolha qual ação deseja realizar");
            System.out.println(" 1 - Alterar Responsável");
            System.out.println(" 2 - Voltar");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    // Listar os responsáveis disponíveis
                    for (Responsavel r : this.responsaveis) {
                        System.out.println("ID: " + r.getId() + " Nome: " + r.getNome() + " CPF: " + r.getCpf());
                    }

                    // Solicitar ao usuário que escolha um ID
                    System.out.println("Digite o ID do novo responsável do ecoponto");
                    int idResponsavel = scanner.nextInt();

                    // Verificar se o ID escolhido corresponde a um responsável existente
                    Responsavel novoResponsavel = null;
                    for (Responsavel r : this.responsaveis) {
                        if (r.getId() == idResponsavel) {
                            novoResponsavel = r;
                            break;
                        }
                    }

                    // Se novoResponsavel ainda for null, o ID fornecido não corresponde a um responsável existente
                    if (novoResponsavel == null) {
                        System.out.println("ID de responsável não encontrado. Tente novamente.");
                    } else {
                        ecoponto.setResponsavel(novoResponsavel);
                        System.out.println("Responsável alterado com sucesso no ecoponto " + ecoponto.getNome());
                    }
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }


}


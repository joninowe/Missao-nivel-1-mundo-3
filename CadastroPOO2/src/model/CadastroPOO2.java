/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author jon
 */
public class CadastroPOO2 {
     
    public static void main(String[] args) {

        PessoaFisicaRepo pfRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pjRepo = new PessoaJuridicaRepo();

        Scanner scan = new Scanner(System.in);
        String escolha;

        do {
            System.out.println("==============================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir/Salvar Dados");
            System.out.println("7 - Recuperar/Carregar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("==============================");

            escolha = scan.next();

            switch (escolha) {

                // Incluir
                case "1":
                    do {
                        System.out.println("==============================");
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica | M - Menu");

                        escolha = scan.next();
                        scan.nextLine();

                        switch (escolha.toUpperCase()) {
          
                            case "F":
                                System.out.print("Digite o id da pessoa: ");
                                int idInformado = scan.nextInt();
                                System.out.println("Insira os dados... ");
                                scan.nextLine();
                                System.out.print("Nome: ");
                                String nome = scan.nextLine();
                                System.out.print("CPF: ");
                                String cpf = scan.nextLine();
                                System.out.print("Idade: ");
                                int idade = scan.nextInt();
                                
                                int pfRepoSize = pfRepo.obterTodos().size(); 
                                
                                PessoaFisica pessoaFisica = new PessoaFisica(idInformado, nome, cpf, idade);
                                pfRepo.inserir(pessoaFisica);

                                System.out.println("Inclusao realizada com sucesso!");
                                pessoaFisica.exibir();
                                break;

                            case "J":
                                System.out.print("Digite o id da pessoa: ");
                                int idInformado2 = scan.nextInt();
                                scan.nextLine();
                                System.out.print("Nome: ");
                                nome = scan.nextLine();
                                System.out.print("CNPJ: ");
                                String cnpj = scan.nextLine();

                                int pjRepoSize = pjRepo.obterTodos().size();
       
                                PessoaJuridica pessoaJuridica = new PessoaJuridica(idInformado2, nome, cnpj);
                                pjRepo.inserir(pessoaJuridica);

                                System.out.println("Inclusao realizada com sucesso!");
                                pessoaJuridica.exibir();
                                break;
                                
                            case "M":                        
                                break;
                                
                            default:
                                System.out.println("Opcao invalida.");
                                break;
                        }
                    } while (!escolha.equalsIgnoreCase("M"));
                    break;

                // Alterar
                case "2":
                    do {
                        System.out.println("==============================");
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica | M - Menu");

                        escolha = scan.next();
                        scan.nextLine();

                        switch (escolha.toUpperCase()) {

                            case "F":
                                System.out.println("Digite o ID da pessoa: ");
                                int idPessoaFisica = scan.nextInt();
                                scan.nextLine();
                                
                                PessoaFisica pessoaFisicaLocalizada = pfRepo.obter(idPessoaFisica);

                                if (pessoaFisicaLocalizada != null) {
                                    pessoaFisicaLocalizada.exibir();

                                    System.out.println("Nome atual: " + pessoaFisicaLocalizada.getNome());
                                    System.out.print("Novo nome: ");
                                    String novoNome = scan.nextLine();

                                    System.out.println("CPF atual: " + pessoaFisicaLocalizada.getCpf());
                                    System.out.print("Novo CPF: ");
                                    String novoCPF = scan.nextLine();

                                    System.out.println("Idade atual: " + pessoaFisicaLocalizada.getIdade());
                                    System.out.print("Nova Idade: ");
                                    int novaIdade = scan.nextInt();

                                    pfRepo.alterar(pessoaFisicaLocalizada, novoNome, novoCPF, novaIdade);

                                    System.out.println("Pessoa alterada com sucesso!");
                                } else
                                    System.out.println("Pessoa nao localizada! ");
                                break;

                            case "J":
                                System.out.println("Digite o ID da pessoa: ");
                                int idPessoaJuridica = scan.nextInt();
                                scan.nextLine();

                                PessoaJuridica pessoaJuridicaLocalizada = pjRepo.obter(idPessoaJuridica);

                                if (pessoaJuridicaLocalizada != null) {
                                    pessoaJuridicaLocalizada.exibir();

                                    System.out.println("Nome atual: " + pessoaJuridicaLocalizada.getNome());
                                    System.out.println("Novo nome: ");
                                    String novoNome = scan.nextLine();

                                    System.out.println("CNPJ atual: " + pessoaJuridicaLocalizada.getCnpj());
                                    System.out.println("Novo CNPJ: ");
                                    String novoCNPJ = scan.nextLine();

                                    pjRepo.alterar(pessoaJuridicaLocalizada, novoNome, novoCNPJ);

                                    System.out.println("Pessoa alterada com sucesso!");
                                } else
                                    System.out.println("Pessoa nao localizada!");
                                break;
                                
                            case "M":                        
                                break;
                                
                            default:
                                System.out.println("Opcao invalida.");
                                break;
                        }
                    } while (!escolha.equalsIgnoreCase("M"));
                    break;

                // EXCLUIR
                case "3":
                    do {
                        System.out.println("==============================");
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica | M - Menu");

                        escolha = scan.next();
                        scan.nextLine();

                        switch (escolha.toUpperCase()) {

                            case "F":
                                System.out.println("Digite o ID da pessoa: ");
                                int idPessoaFisica = scan.nextInt();

                                PessoaFisica pessoaFisicaLocalizada = pfRepo.obter(idPessoaFisica);

                                if (pessoaFisicaLocalizada != null) {
                                    pessoaFisicaLocalizada.exibir();
                                    pfRepo.excluir(idPessoaFisica);

                                    System.out.println("Pessoa excluida com sucesso!");
                                } else
                                    System.out.println("Pessoa nao localizada!");
                                break;


                            case "J":
                                System.out.println("Digite o ID da pessoa: ");
                                int idPessoaJuridica = scan.nextInt();

                                PessoaJuridica pessoaJuridicaLocalizada = pjRepo.obter(idPessoaJuridica);

                                if (pessoaJuridicaLocalizada != null) {
                                    pessoaJuridicaLocalizada.exibir();

                                    pjRepo.excluir(idPessoaJuridica);

                                    System.out.println("Pessoa excluida com sucesso!");
                                } else
                                    System.out.println("Pessoa nao localizada!");
                                break;
                            
                            case "M":                        
                                break;

                            default:
                                System.out.println("Opcao invalida.");
                                break;
                        }

                    } while (!escolha.equalsIgnoreCase("M"));
                    break;

                // obterId
                case "4":
                    do {
                        System.out.println("==============================");
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica | M - Menu");

                        escolha = scan.next();
                        scan.nextLine();

                        switch (escolha.toUpperCase()) {

                            case "F":
                                System.out.println("Digite o ID da pessoa: ");
                                int idPessoaFisica = scan.nextInt();

                                PessoaFisica pessoaFisicaLocalizada = pfRepo.obter(idPessoaFisica);

                                if (pessoaFisicaLocalizada != null) {
                                    System.out.println("Pessoa localizada!");
                                    pessoaFisicaLocalizada.exibir();
                                } else
                                    System.out.println("Pessoa nao localizada!");
                                break;

                            case "J":
                                System.out.println("Digite o ID da pessoa: ");
                                int idPessoaJuridica = scan.nextInt();

                                PessoaJuridica pessoaJuridicaLocalizada = pjRepo.obter(idPessoaJuridica);

                                if (pessoaJuridicaLocalizada != null) {
                                    System.out.println("Pessoa localizada!");

                                    pessoaJuridicaLocalizada.exibir();
                                } else
                                    System.out.println("Pessoa nao localizada!");
                                break;

                            case "M":                        
                                break;    
                                
                            default:
                                System.out.println("Opcao invalida.");
                                break;
                        }

                    } while (!escolha.equalsIgnoreCase("M"));
                    break;

                //obterTodos 
                case "5":
                    do {
                        System.out.println("==============================");
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica | M - Menu");

                        escolha = scan.next();
                        scan.nextLine();

                        switch (escolha.toUpperCase()) {

                            case "F":
                                System.out.println("Lista de pessoas Fisicas: ");
                                pfRepo.obterTodos()
                                        .forEach(pessoaFisica -> {
                                            pessoaFisica.exibir();
                                            System.out.println();
                                        });
                                break;

                            case "J":
                                System.out.println("Lista de pessoas juridicas: ");
                                pjRepo.obterTodos()
                                        .forEach(pessoaJuridica -> {
                                            pessoaJuridica.exibir();
                                            System.out.println();
                                        });
                                break;
                                
                            case "M":                        
                                break;    

                            default:
                                System.out.println("Opcao invalida");
                                break;
                        }

                    } while (!escolha.equalsIgnoreCase("M"));
                    break;

                // Persistir/Salvar
                case "6":
                    System.out.println("Escolha o nome do arquivo");
                    escolha = scan.next();
                    scan.nextLine();
                    try {
                        pfRepo.persistir(escolha+".fisica.bin");
                        pjRepo.persistir(escolha+".juridica.bin");
                    } catch (IOException erro) {
                        System.out.println("Erro ao persistir/salvar os dados: " + erro.getMessage());
                    }
                    break;

                //Recuperar/Carregar
                case "7":
                    System.out.println("Informe o nome do arquivo salvo");
                    escolha = scan.next();
                    scan.nextLine();
                    try {
                        pfRepo.recuperar(escolha+".fisica.bin");
                        pjRepo.recuperar(escolha+".juridica.bin");
                    } catch (ClassNotFoundException | IOException erro) {
                        System.out.println("Erro ao recuperar os dados: " + erro.getMessage());
                    }
                    break;
                
                case "0":
                    System.out.println("Sistema Finalizado com sucesso.");
                    break;
                   
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        } while (!escolha.equals("0"));   
        scan.close();
    }
}

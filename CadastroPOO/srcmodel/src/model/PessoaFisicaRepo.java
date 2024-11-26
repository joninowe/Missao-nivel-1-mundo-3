/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.io.*;


/**
 *
 * @author jon
 */
public class PessoaFisicaRepo {
    
    private ArrayList<PessoaFisica> listaPessoasFisicas = new ArrayList<>();
    
    public void inserir(PessoaFisica pessoaFisica){
        listaPessoasFisicas.add(pessoaFisica);
    }

    public void alterar(PessoaFisica pessoaFisica, String novoNome, String novoCpf, int novaIdade) {
        pessoaFisica.setNome(novoNome);
        pessoaFisica.setCpf(novoCpf);
        pessoaFisica.setIdade(novaIdade);
    }

    public void excluir(int id) {
        try{
        listaPessoasFisicas.remove(obter(id));
        }catch(NoSuchElementException e){
            System.out.println("erro");
        }
    }    
    
    public PessoaFisica obter(int id) {
        Optional<PessoaFisica> pessoaFisicaLocalizada = listaPessoasFisicas.stream().
                filter(pessoaFisica -> pessoaFisica.getId() == id).findFirst();
        if (pessoaFisicaLocalizada.isPresent()) {
           return pessoaFisicaLocalizada.get();
        } else {
           return null;
        }
    }
    
    public ArrayList<PessoaFisica> obterTodos(){
        return listaPessoasFisicas;
    }
    
    public void persistir(String arquivo)throws IOException {
        ObjectOutputStream arquivoSaida = new ObjectOutputStream(new FileOutputStream(arquivo));
        arquivoSaida.writeObject(listaPessoasFisicas);
        arquivoSaida.close();
        System.out.println("Dados de pessoas fisicas armazenados.");
    }
    
    public void recuperar(String arquivo) throws IOException, ClassNotFoundException {
        ObjectInputStream arquivoEntrada = new ObjectInputStream(new FileInputStream(arquivo));
        listaPessoasFisicas = (ArrayList<PessoaFisica>) arquivoEntrada.readObject();
        arquivoEntrada.close();
        System.out.println("Dados de pessoas fisicas recuperados.");
    }
}
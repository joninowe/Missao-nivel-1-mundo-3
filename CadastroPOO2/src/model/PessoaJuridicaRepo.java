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
public class PessoaJuridicaRepo {
    
    private ArrayList<PessoaJuridica> listaPessoasJuridicas = new ArrayList<>();
    
    public void inserir(PessoaJuridica pessoaJuridica){
        listaPessoasJuridicas.add(pessoaJuridica);
    }

    public void alterar(PessoaJuridica pessoaJuridica, String novoNome, String novoCnpj) {
        pessoaJuridica.setNome(novoNome);
        pessoaJuridica.setCnpj(novoCnpj);
    }
    
    public void excluir(int id){
        listaPessoasJuridicas.remove(obter(id));
    }    
    
    public PessoaJuridica obter(int id) {
        Optional<PessoaJuridica> pessoaJuridicaLocalizada = listaPessoasJuridicas.stream().
                filter(pessoaJuridica -> pessoaJuridica.getId() == id).findFirst();
        if (pessoaJuridicaLocalizada.isPresent()) {
           return pessoaJuridicaLocalizada.get();
        } else {
           return null;
        }
    }

    public ArrayList<PessoaJuridica> obterTodos(){
        return listaPessoasJuridicas;
    }
    
    public void persistir(String arquivo)throws IOException {
        ObjectOutputStream arquivoSaida = new ObjectOutputStream(new FileOutputStream(arquivo));
        arquivoSaida.writeObject(listaPessoasJuridicas);
        arquivoSaida.close();
        System.out.println("\nDados das pessoas juridicas armazenados.");    
    }

    public void recuperar(String arquivo)throws IOException, ClassNotFoundException {
        ObjectInputStream arquivoEntrada = new ObjectInputStream(new FileInputStream(arquivo));
        listaPessoasJuridicas = (ArrayList<PessoaJuridica>) arquivoEntrada.readObject();
        arquivoEntrada.close();
        System.out.println("Dados de pessoas juridicas recuperados.");
    }

}

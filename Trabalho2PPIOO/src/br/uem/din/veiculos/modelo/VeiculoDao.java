/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.veiculos.modelo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Vini
 */
public class VeiculoDao {
    private List<Veiculo> listaVeiculos = new ArrayList();
    Veiculo veiculo;
    Scanner leitor = new Scanner(System.in);
    
    public void criarVeiculo(){
        leitor = new Scanner(System.in);
        int variavelVeiculo = 0;
        //Try catch para o caso da pessoa apertar uma letra ao invés de numero.
        try {
           System.out.println("Digite [1] para cadastrar Automovel ou Digite [2] para cadastrar Motocicleta \n");      
           variavelVeiculo = leitor.nextInt();

        } catch (InputMismatchException E) {
            System.out.println("Por favor!!! Digite um valor Numérico Válido");         
        }
            
        if(variavelVeiculo == 1 || variavelVeiculo == 2){
                if(variavelVeiculo == 1){
                    veiculo = new Automovel();
                    veiculo.setEstado(Estado.PARADO);
                    
                    System.out.println("Cadastre uma placa para seu veiculo");
                    String placaVeiculo = leitor.next();
                    
                    placaVeiculo = placaVeiculo.toUpperCase();
                    
                    for(int i = 0 ; i < listaVeiculos.size(); i++){
                        if(listaVeiculos.get(i).getPlaca().trim().equals(placaVeiculo.trim())){
                            System.out.println("Já Existe Essa Placa Cadastrada em Nosso Sistema.");
                            return;
                        }  
                    }
                   
                    veiculo.setPlaca(placaVeiculo);
                    
                    listaVeiculos.add(veiculo);
                    System.out.println("Automovel cadastrado com sucesso");
                }
                if(variavelVeiculo == 2){
                    veiculo = new Motocicleta();
                    veiculo.setEstado(Estado.PARADO);
                    
                    System.out.println("Cadastre uma placa para seu veiculo");
                    String placaVeiculo = leitor.next();
                    
                    placaVeiculo = placaVeiculo.toUpperCase();
                    
                    for(int i = 0 ; i < listaVeiculos.size(); i++){
                        if(listaVeiculos.get(i).getPlaca().trim().equals(placaVeiculo.trim())){
                            System.out.println("Já Existe Essa Placa Cadastrada em Nosso Sistema.");
                            return;
                        }  
                    }
                    
                    veiculo.setPlaca(placaVeiculo);
                    
                    listaVeiculos.add(veiculo);
                    System.out.println("Motocicleta cadastrada com sucesso");                 
                }          
        }  
    }
    
    public void consultarVeiculos(){
        if(listaVeiculos.isEmpty()){
            System.out.println("Ainda não há Veiculos Cadastrados");
        }else{
            System.out.println("--------LISTA DE VEICULOS----------");
            for(Veiculo v : listaVeiculos){       
                System.out.println(v.getPlaca());
            } 
        }  
    }
    
    public void alterarVeiculo(){
        boolean existeVeiculo = false;
        if(!listaVeiculos.isEmpty()){
            System.out.println("Informe a placa a ser Editada");
            leitor = new Scanner(System.in);
            String placaEditada = leitor.next();
            placaEditada = placaEditada.toUpperCase();

            for(int i = 0; i < listaVeiculos.size(); i++){
                if(listaVeiculos.get(i).getPlaca().trim().equals(placaEditada.trim())){
                    System.out.println("-----Dados Anteriores----");
                    System.out.println("Placa : "+ listaVeiculos.get(i).getPlaca().trim());

                    System.out.println("-----Digite a nova placa a ser alterada-----");

                    String novaPlaca = leitor.next();

                    novaPlaca = novaPlaca.toUpperCase();


                    listaVeiculos.get(i).setPlaca(novaPlaca);

                    System.out.println("Placa do Veiculo Alterada com Sucesso");
                    existeVeiculo = true;
                }
            } 
            
            if(existeVeiculo == false){
                System.out.println("Placa não encontrada ou Inválida");
            }
            
        }else{
            System.out.println("Ainda não há Veiculos Cadastrados");
        }
    }
    
    public void deletarVeiculo(){
        boolean existeVeiculo = false;
        if(!listaVeiculos.isEmpty()){
            System.out.println("-----Informe a Placa do Veiculo a Ser Deletado-----");
            leitor = new Scanner(System.in);
            String placaDeletada = leitor.next();

            placaDeletada = placaDeletada.toUpperCase();

            for(int i = 0 ; i < listaVeiculos.size(); i++){
                if(listaVeiculos.get(i).getPlaca().trim().equals(placaDeletada.trim())){
                    listaVeiculos.remove(i);
                    System.out.println("Veiculo Deletado Com Sucesso");
                    existeVeiculo = true;
                }  
            }
            if(existeVeiculo = false){
                System.out.println("Placa não encontrada ou Inválida");
            }
        }
    }
    
    public Veiculo escolherVeiculo(){
        boolean existeVeiculo = false;
        leitor = new Scanner(System.in);
        if(!listaVeiculos.isEmpty()){
            System.out.println("-----Informe a Placa do Veiculo que Deseja Escolher-----");
            String placaEscolhida = leitor.next();
            
            placaEscolhida = placaEscolhida.toUpperCase();
            
            for(int i = 0; i < listaVeiculos.size(); i++){
                if(listaVeiculos.get(i).getPlaca().trim().equals(placaEscolhida.trim())){
                    
                    System.out.println("Placa escolhida com Sucesso");
                    System.out.println(listaVeiculos.get(i).getPlaca());                 
                    return listaVeiculos.get(i);       
                }   
            }
            
            if(existeVeiculo == false){
                System.out.println("Placa não encontrada ou Inválida");
                return null;
            }
            
        }else{
            System.out.println("Ainda não há Veiculos Cadastrados");
            return null;
        }
        
        return null;
    }
}

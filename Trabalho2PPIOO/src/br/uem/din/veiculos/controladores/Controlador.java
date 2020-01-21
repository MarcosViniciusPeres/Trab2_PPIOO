package br.uem.din.veiculos.controladores;

import br.uem.din.veiculos.modelo.Automovel;
import br.uem.din.veiculos.modelo.Estado;
import br.uem.din.veiculos.modelo.Motocicleta;
import br.uem.din.veiculos.modelo.Veiculo;
import br.uem.din.veiculos.modelo.VeiculoDao;
import java.util.ArrayList;
import java.util.List;

public class Controlador {
    VeiculoDao veiculoDao = new VeiculoDao();
    
    public void criarVeiculo() {
        veiculoDao.criarVeiculo();   
    }
    
    public void consultarVeiculo(){
        List<Veiculo> lista = new ArrayList();
        
        lista = veiculoDao.consultarVeiculos();
         
        if(lista.isEmpty()){
            System.out.println("Ainda não há Veiculos Cadastrados");
        }else{
            System.out.println("--------LISTA DE VEICULOS----------");
            for(Veiculo v : lista){       
                System.out.println(v.getPlaca());
            } 
        }
    }
    
    public void alterarVeiculo(){
        veiculoDao.alterarVeiculo();
    }
    
    public void deletarVeiculo(){
        veiculoDao.consultarVeiculos();
        veiculoDao.deletarVeiculo();
    }
    
    public Veiculo escolherVeiculo(){ 
       return  veiculoDao.escolherVeiculo();
    }
    
    public void deslocar(Veiculo v) {
        v.deslocar();
        System.out.println("Percorridos " + v.getQuilometragem() + "km");
    }
    
    public void acelerar(Veiculo v) {
        if (v.getEstado().equals(Estado.MOVIMENTO)) {
            v.acelerar();
            System.out.println("Velocidade = " + v.getVelocidade() + "km/h");
        } else {
            System.out.println("Impossivel acelerar – Veículo está parado");
        }
    }
    
    public void frear(Veiculo v) {
        v.frear();
        System.out.println("Veiculo Freou");
    }
    
    public void acelerarTurbo(Veiculo v){
        if (v.getEstado().equals(Estado.MOVIMENTO)) {
            v.acelerarTurbo();
            System.out.println("Velocidade = " + v.getVelocidade() + "km/h");
        } else {
            System.out.println("Impossivel acelerar – Veículo está parado");
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.veiculos.controladores;

import br.uem.din.veiculos.modelo.Automovel;
import br.uem.din.veiculos.modelo.Estado;
import br.uem.din.veiculos.modelo.Motocicleta;
import br.uem.din.veiculos.modelo.Veiculo;
import br.uem.din.veiculos.modelo.VeiculoDao;

/**
 *
 * @author Vini
 */
public class Controlador {
    VeiculoDao veiculoDao = new VeiculoDao();
    
    public void criarVeiculo() {
        veiculoDao.criarVeiculo();   
    }
    
    public void consultarVeiculo(){
        veiculoDao.consultarVeiculos();
    }
    
    public void alterarVeiculo(){
        veiculoDao.alterarVeiculo();
    }
    
    public void deletarVeiculo(){
        veiculoDao.consultarVeiculos();
        veiculoDao.deletarVeiculo();
    }
    
    public Veiculo escolherVeiculo(){
       Veiculo v = veiculoDao.escolherVeiculo();
       return v;
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
        System.out.println("Veiculo freou");
    }
    
}

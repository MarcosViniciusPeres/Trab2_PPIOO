/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.veiculos.modelo;

/**
 *
 * @author Vini
 */
public class Automovel extends Veiculo {
    private int KM;
    private int velocidade;
    private String placa;

    @Override
    public void deslocar() {
        if(this.getEstado().equals(Estado.PARADO)){
            this.setEstado(Estado.MOVIMENTO);
        }
        KM += 10;
        this.setQuilometragem(KM);
    }

    @Override
    public void acelerar() {
        if(this.getEstado().equals(Estado.MOVIMENTO)){
            velocidade += 5;
            this.setVelocidade(velocidade);
        }
    }

    @Override
    public void frear() {
        this.setEstado(Estado.PARADO);
        velocidade = 0;
    }
    
}

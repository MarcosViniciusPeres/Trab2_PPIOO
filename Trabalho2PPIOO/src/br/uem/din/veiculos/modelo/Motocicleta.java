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
public class Motocicleta extends Veiculo{
    private final int KM = 10;
    private final int velocidade = 5;

    @Override
    public void deslocar() {
        if(this.getEstado().equals(Estado.PARADO)){
            this.setEstado(Estado.MOVIMENTO);
        }
        this.setQuilometragem(KM);
    }

    @Override
    public void acelerar() {
        if(this.getEstado().equals(Estado.MOVIMENTO)){
            this.setVelocidade(velocidade);
        }
    }

    @Override
    public void frear() {
        this.setEstado(Estado.PARADO);
    }
}

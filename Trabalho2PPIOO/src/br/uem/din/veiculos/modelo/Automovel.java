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
    private final int KM = 10;
    private final int VELOCIDADE = 5;
    private String placa;

    @Override
    public void deslocar() {
        if(this.getEstado().equals(Estado.PARADO)){
            this.setEstado(Estado.MOVIMENTO);
        }
        this.setQuilometragem(KM);
    }

    @Override
    public void acelerar() {
        if(acelerarAutomatico() == true){
            if(this.getEstado().equals(Estado.MOVIMENTO)){    
                this.setVelocidade(VELOCIDADE);
            }
        }else{
            System.out.println("Não poderá acelerar, Irá Passar a Velocidade de 100 km/h");
        }
    }

    @Override
    public void frear() {
        this.setEstado(Estado.PARADO);
    }
    
    @Override
    public void acelerarTurbo(){
        try{
            if(acelerarAutomatico() == true){    
                if(this.getEstado().equals(Estado.MOVIMENTO)){            
                        int velocidade2x = 2*VELOCIDADE;
                        this.setVelocidade(velocidade2x);                
                    }
            }else{
                System.out.println("Não poderá acelerar, Irá Passar a Velocidade de 100 km/h");
            }
        }catch(NullPointerException exception){
            System.out.println("Problema ao escolher um Veiculo.");
        }      
    }
    
    @Override
    public boolean acelerarAutomatico(){  
        try {
            if(this.getEstado().equals(Estado.MOVIMENTO)){
                if(this.getVelocidade() < 100){
                    return true;
                }
            }
        }catch(NullPointerException exception){
            System.out.println("Problema ao escolher um Veiculo.");
        }     
        return false;     
    }
    
}

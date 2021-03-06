package br.uem.din.veiculos.modelo;

public class Automovel extends Veiculo {
    private final int KM = 10;
    private final int VELOCIDADE = 5;

    public Automovel() {
    }
    
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
            System.out.println("Problema ao escolher um Automovel.");
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
            System.out.println("Problema ao escolher um Automovel.");
        }     
        return false;     
    }
    
}

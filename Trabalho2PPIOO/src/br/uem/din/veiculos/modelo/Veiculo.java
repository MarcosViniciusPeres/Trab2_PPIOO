package br.uem.din.veiculos.modelo;

public abstract class Veiculo {
    public int velocidade;
    public int quilometragem;
    public String placa;
    public Estado estado;

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade += velocidade;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem += quilometragem;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public abstract void deslocar();
    public abstract void acelerar();
    public abstract void frear();
    public abstract void acelerarTurbo();
    public abstract boolean acelerarAutomatico();
    
}

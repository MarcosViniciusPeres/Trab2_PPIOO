/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.veiculos.fronteira;

import br.uem.din.veiculos.controladores.Controlador;
import br.uem.din.veiculos.modelo.Veiculo;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Vini
 */
public class Tela {
    Controlador controlador = new Controlador();
    Scanner scanner = new Scanner(System.in);
    
    public Acao menu() {
        int opcao;
        //exibe as acoes
        for (Acao acao : Acao.values()) {
            System.out.println(acao.ordinal() + " - " + acao.name());
        }
        System.out.print("Digite sua opcao: ");
        opcao = scanner.nextInt();
        //busca qual a acao selecionada
        for (Acao acao : Acao.values()) {
            if (acao.ordinal() == opcao) {
                return acao; //retorna a acao selecionada
            }
        }
        return null;
    }
        
    public void iniciar() {
        Veiculo v = controlador.escolherVeiculo();
        
        if(v == null){
            return;
        }
        
        Acao acao;
        do {
            acao = menu();
            switch (acao) {
                case DESLOCAR:
                    controlador.deslocar(v);
                    break;
                case ACELERAR:
                    controlador.acelerar(v);
                    break;
                case FREAR:
                    controlador.frear(v);
                    break;
                case VOLTAR:
                    this.crudVeiculos();
                    break;
            }
        } while (!acao.equals(Acao.SAIR));
    }
    
    public void crudVeiculos(){
        int opcao = 1;

        while (opcao != 0) {

            scanner = new Scanner(System.in);
            System.out.println("\n--------------------OPÇÕES---------------------");
            System.out.println("(1) Adcionar Veiculo"
                    + "\n(2) Consultar Veículo"
                    + "\n(3) Alterar Veículo"
                    + "\n(4) Deletar Veículo"
                    + "\n(5) Escolher Automovel"
                    + "\n(0) Sair do programa");
            System.out.println("-----------------------------------------------");
            System.out.print("Digite uma opção valida: ");

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException E) {
                opcao = -1;
            }
            
            switch (opcao) {
                case 0:
                    System.out.println("Saindo do Programa");
                    System.exit(0);
                case 1:
                    controlador.criarVeiculo();
                    break;
                case 2:
                    controlador.consultarVeiculo();
                    break;
                case 3:
                    controlador.alterarVeiculo();
                    break;
                case 4:
                    controlador.deletarVeiculo();
                    break;
                case 5:
                    this.iniciar();
                default:
                    System.out.println("ERRO: Opção inválida.");
                    break;
            }
        }
    }    
    
    
}

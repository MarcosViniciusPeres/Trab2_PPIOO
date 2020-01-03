/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.veiculos.fronteira;

import br.uem.din.veiculos.controladores.Controlador;
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
        controlador.criarAutomovel();
        Acao acao;
        do {
            acao = menu();
            switch (acao) {
                case DESLOCAR:
                    controlador.deslocar(controlador.getVeiculo());
                    break;
                case ACELERAR:
                    controlador.acelerar(controlador.getVeiculo());
                    break;
                case FREAR:
                    controlador.frear(controlador.getVeiculo());
                    break;
            }
        } while (!acao.equals(Acao.SAIR));
    }
    
}

package lp2.lab01.ppt;

import java.util.Scanner;

public class PedraPapelTesoura {
	private String[] escolhas = {"PEDRA", "PAPEL", "TESOURA"};
	private Scanner sc = new Scanner(System.in);
	private String[][] jogadasPossiveis = {
			{"EMPATE!", "JOGADOR 2 VENCEU! PAPEL ENROLA PEDRA!", "JOGADOR 1 VENCEU! PEDRA QUEBRA TESOURA!"},
			{"JOGADOR 1 VENCEU! PAPEL ENROLA PEDRA!", "EMPATE", "JOGADOR 2 VENCEU! TESOURA CORTA PAPEL!"},
			{"JOGADOR 2 VENCEU! PEDRA QUEBRA TESOURA!", "JOGADOR 1 VENCEU! TESOURA CORTA PAPEL!", "EMPATE"}
	};
	private int rodada = 1;
	
	public void linhaDeiguais() {
		System.out.println("=============================");
	}
	
	public void linha() {
		System.out.println("-----------------------------");
	}
	
	public void titulo(String txt) {
		linhaDeiguais();
		System.out.println("          " + txt.toUpperCase());
		linhaDeiguais();
	}
	
	public int verificarSelecao(String valor, int max, int min) {
		int num = 0;
		try {
			num = Integer.parseInt(valor);
			
			if (num < min || num > max) {
				linha();
				System.out.println("Essa opção não está listada!");
				linha();
				num = 0;
			}
		} catch (NumberFormatException e) {
			linha();
			System.out.println("Não use símbolos ou letras!");
			linha();
			num = 0;
		}
		return num;
	}
	
	public int menuDeEscolha(int jog) {
		String entrada = "";
		int ind = 0;
		
		do {
			System.out.println("Jogador "+jog+", faça sua escolha!");
			System.out.println("[1] PEDRA    [2] PAPEL    [3] TESOURA");
			System.out.print("-> ");
			entrada = sc.nextLine(); 
			ind = verificarSelecao(entrada, 3, 1);
		} while (ind == 0);
		
		linha();
		
		return ind-1;
	}
	
	public String calculaVitoria(int jog1, int jog2) {
		this.rodada += 1;
		return jogadasPossiveis[jog1][jog2];
	}
	
	public boolean verificarContinuidade() {
		String entrada = "";
		int opcao = 0;
		do {
			System.out.println("Deseja continuar jogando?");
			System.out.println("[1] Sim    [2] Não");
			System.out.print("-> ");
			entrada = sc.nextLine();
			opcao = verificarSelecao(entrada, 2, 1);
		} while (opcao == 0);
		
		return opcao == 1;
	}
	
	public static void main(String[] args) {
		PedraPapelTesoura jg = new PedraPapelTesoura();
		boolean continuarJogando = true;
		do {
			jg.titulo("Rodada " + jg.rodada);
			int jogador1 = jg.menuDeEscolha(1);
			int jogador2 = jg.menuDeEscolha(2);
			System.out.println("JOGADOR 1 ESCOLHEU "+jg.escolhas[jogador1]+"");
			System.out.println("JOGADOR 2 ESCOLHEU "+jg.escolhas[jogador2]+"");
			String vencedor = jg.calculaVitoria(jogador1, jogador2);
			System.out.println(vencedor);
			jg.linha();
			
			continuarJogando = jg.verificarContinuidade();
			
		} while (continuarJogando);

	}

}

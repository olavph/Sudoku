package sudoku.busca;

import java.util.ArrayList;

import sudoku.Casa;
import sudoku.Tabela;

public class BuscaCegaEmProfundidade implements MetodoDeBusca {

	@Override
	public ArrayList<Tabela> expandir(Tabela tabela) {
		ArrayList<Tabela> proximosNodos = new ArrayList<Tabela>();
		Integer linha = 0;
		Integer coluna = 0;
		Casa casaVazia = primeiraCasaVazia(tabela, linha, coluna);
		
		if (casaVazia != null) {
			// Cria tabelas com todos os valores possíveis para a casa escolhida
			for (int valor = 1; valor <= tabela.getDimensao(); valor ++) {
				Tabela novoNodo = new Tabela(tabela);
				novoNodo.setCasa(valor, linha, coluna);
				proximosNodos.add(novoNodo);
			}
		}
		return proximosNodos;
	}
	
	private Casa primeiraCasaVazia(Tabela tabela, Integer linha, Integer coluna) {
		for (linha = 0; linha < tabela.getDimensao(); linha ++) {
			for (coluna = 0; coluna < tabela.getDimensao(); coluna ++) {
				if (!tabela.getCasa(linha, coluna).estaPreenchida()) {
					return tabela.getCasa(linha, coluna);
				}
			}
		}
		return null;
	}

	@Override
	public void adicionar(ArrayList<Tabela> nodosAntigos, ArrayList<Tabela> nodosNovos) {
		nodosAntigos.addAll(0, nodosNovos);
	}

}

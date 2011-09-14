package sudoku.busca;

import java.util.ArrayList;
import java.util.HashSet;

import sudoku.Casa;
import sudoku.Tabela;

public class BuscaCegaEmLargura implements MetodoDeBusca {

	Integer linha, coluna;

    @Override
    public ArrayList<Tabela> expandir(Tabela tabela) {
        ArrayList<Tabela> proximosNodos = new ArrayList<Tabela>();
        Casa casaVazia = primeiraCasaVazia(tabela);

        if (casaVazia != null) {
            // Cria tabelas com todos os valores possíveis para a casa escolhida
        	HashSet<Integer> restricoes = tabela.getRestricoes(linha, coluna);
            for (int valor = 1; valor <= tabela.getDimensao(); valor++) {
            	if (!restricoes.contains(valor)) {
	                Tabela novoNodo = new Tabela(tabela);
	                novoNodo.setCasa(valor, linha, coluna);
	                proximosNodos.add(novoNodo);
            	}
            }
        }
        return proximosNodos;
    }

    private Casa primeiraCasaVazia(Tabela tabela) {
        for (linha = 0; linha < tabela.getDimensao(); linha++) {
            for (coluna = 0; coluna < tabela.getDimensao(); coluna++) {
                if (!tabela.getCasa(linha, coluna).estaPreenchida()) {
                    return tabela.getCasa(linha, coluna);
                }
            }
        }
        return null;
    }

    @Override
    public void adicionar(ArrayList<Tabela> nodosAntigos, ArrayList<Tabela> nodosNovos) {
        nodosAntigos.addAll(nodosAntigos.size(), nodosNovos);
    }

}

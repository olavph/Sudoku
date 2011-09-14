package sudoku.busca;

import java.util.ArrayList;
import java.util.HashSet;

import sudoku.Casa;
import sudoku.Tabela;

public class BuscaComSatisfacaoDeRestricoesMaisRestringida implements MetodoDeBusca {

	Integer linhaMaisRestringida, colunaMaisRestringida;
	HashSet<Integer> restricoes = new HashSet<Integer>();

    @Override
    public ArrayList<Tabela> expandir(Tabela tabela) {
        ArrayList<Tabela> proximosNodos = new ArrayList<Tabela>();
        Casa casaEscolhida = casaMaisRestringida(tabela);

        if (casaEscolhida != null) {
            // Cria tabelas com todos os valores possíveis para a casa escolhida
            for (Integer valor = 1; valor <= tabela.getDimensao(); valor++) {
            	if (!restricoes.contains(valor)) {
                    Tabela novoNodo = new Tabela(tabela);
                    novoNodo.setCasa(valor, linhaMaisRestringida, colunaMaisRestringida);
                    proximosNodos.add(novoNodo);
            	}
            }
        }
        return proximosNodos;
    }

    private Casa casaMaisRestringida(Tabela tabela) {
    	Casa escolhida = null;
    	restricoes.clear();
        for (int linha = 0; linha < tabela.getDimensao(); linha++) {
            for (int coluna = 0; coluna < tabela.getDimensao(); coluna++) {
            	if (!tabela.getCasa(linha, coluna).estaPreenchida()) {
	            	HashSet<Integer> r = tabela.getRestricoes(linha, coluna);
	            	if (r.size() > restricoes.size()) {
	            		linhaMaisRestringida = linha;
	            		colunaMaisRestringida = coluna;
	            		restricoes = r;
	            		escolhida = tabela.getCasa(linha, coluna);
	            	}
            	}
            }
        }
        return escolhida;
    }

	@Override
	public void adicionar(ArrayList<Tabela> nodosAntigos, ArrayList<Tabela> nodosNovos) {
		nodosAntigos.addAll(0, nodosNovos);
	}

}

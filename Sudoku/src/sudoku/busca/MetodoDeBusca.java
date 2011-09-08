package sudoku.busca;

import java.util.ArrayList;

import sudoku.Tabela;

public interface MetodoDeBusca {
	
	ArrayList<Tabela> expandir(Tabela nodo);
	void adicionar(ArrayList<Tabela> nodosAntigos, ArrayList<Tabela> nodosNovos);

}

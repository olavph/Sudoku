package sudoku;

import java.util.ArrayList;


public class ListaDeRestricoes {
	private ArrayList<Integer> lista;
	
	public ListaDeRestricoes() { 
		lista = new ArrayList<Integer>();
	}
	
	public void add(int inteiro) { 
		System.out.println("ADD!");
		if(!estaNaLista(inteiro)) { 
			lista.add(inteiro);
		}
	}
	
	public void remove(int inteiro) { 
		System.out.println("REM!");
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		if(estaNaLista(inteiro)) {
			for(Integer i : lista) { 
				if(i.compareTo(inteiro) != 0) 
					tempList.add(i);
			}
		}
		lista = tempList;
	}
	
	private boolean estaNaLista(int inteiro) { 
		System.out.println("Lista: " + lista + " " + inteiro);
		for(Integer i : lista) { 
			if(i.compareTo(inteiro) == 0) 
				return true;
		}
		System.out.println("retornando falso)");
		return false;
	}

	public int size() {
		return lista.size();
	}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

public class Tabela {

	private Casa[][] casas;
	private Vector<HashSet<Casa>> quadrantes;
	private int dimensao;
	private HashMap<Casa, ListaDeRestricoes> restricoes = new HashMap<Casa, ListaDeRestricoes>();

	// faz a alocação de toda a tabela instanciando todas as casas conforme a
	// dimensao
	// e evidencia o quadrante a qual cada casa pertence
	public Tabela(int n, String[][] estI) {
		casas = new Casa[n][n];
		quadrantes = new Vector<HashSet<Casa>>(n);
		for (int i = 0; i < n; i++) {
			quadrantes.add(new HashSet<Casa>());
		}
		dimensao = n;

		double sqrt = Math.sqrt(n);
		int raizDaDimensao = (int) sqrt;
		if (raizDaDimensao != sqrt) {
			System.out.println("Dimensão inválida");
			return;
		}

		for (int linha = 0; linha < n; linha++) {
			for (int coluna = 0; coluna < n; coluna++) {
				casas[linha][coluna] = new Casa(estI[linha][coluna]);
				int numeroDoQuadrante = coluna / raizDaDimensao + linha
						/ raizDaDimensao * raizDaDimensao;
				quadrantes.get(numeroDoQuadrante).add(casas[linha][coluna]);
			}
		}
	}

	// faz a alocação de toda a tabela instanciando todas as casas conforme a
	// dimensao
	// e evidencia o quadrante a qual cada casa pertence
	public Tabela(int n) {
		casas = new Casa[n][n];

		quadrantes = new Vector<HashSet<Casa>>(n);
		for (int i = 0; i < n; i++) {
			quadrantes.add(new HashSet<Casa>());
		}
		dimensao = n;

		double sqrt = Math.sqrt(n);
		int raizDaDimensao = (int) sqrt;
		if (raizDaDimensao != sqrt) {
			System.out.println("Dimensão inválida");
			return;
		}

		for (int linha = 0; linha < n; linha++) {
			for (int coluna = 0; coluna < n; coluna++) {
				casas[linha][coluna] = new Casa();
				int numeroDoQuadrante = coluna / raizDaDimensao + linha
						/ raizDaDimensao * raizDaDimensao;
				quadrantes.get(numeroDoQuadrante).add(casas[linha][coluna]);
			}
		}
	}

	public int getQuadranteNumero(int linha, int coluna) {
		int raizDaDimensao = (int) Math.sqrt(dimensao);
		int numeroDoQuadrante = coluna / raizDaDimensao + linha
				/ raizDaDimensao * raizDaDimensao;
		return numeroDoQuadrante;
	}

	public Tabela(Tabela original) {
		dimensao = original.getDimensao();
		casas = new Casa[dimensao][dimensao];
		quadrantes = new Vector<HashSet<Casa>>(dimensao);
		for (int i = 0; i < dimensao; i++) {
			quadrantes.add(new HashSet<Casa>());
		}

		for (int linha = 0; linha < original.getDimensao(); linha++) {
			for (int coluna = 0; coluna < original.getDimensao(); coluna++) {
				casas[linha][coluna] = new Casa(original.getCasa(linha, coluna));
				quadrantes.get(getQuadranteNumero(linha, coluna)).add(
						casas[linha][coluna]);
			}
		}
	}

	// retorna as casas da linha i passada como parâmetro
	public Casa[] getLinha(int i) {
		Casa[] temp = new Casa[dimensao];
		System.arraycopy(casas[i], 0, temp, 0, dimensao);
		return temp;
	}

	// retorna as casas da coluna j passada como parâmetro
	public Casa[] getColuna(int j) {
		Casa[] temp = new Casa[dimensao];
		for (int i = 0; i < dimensao; i++) {
			temp[i] = casas[i][j];
		}
		return temp;
	}

	// retorna as casas do quadrante quadr passado como parâmetro comeca no
	// quadrante 1
	public HashSet<Casa> getQuadrante(int numeroDoQuadrante) {
		return quadrantes.get(numeroDoQuadrante);
	}
	
	private void createRestricao(Casa c) {
		if(restricoes.get(c) == null) {
			System.out.println("Criando lista de restricoes = " + c);
			restricoes.put(c, new ListaDeRestricoes());
		}
	}
	
	// Cuida das restricoes da casa 
	private void addRestricao(Casa estaCasa, int n, int i, int j) {
		System.out.println("Casa[" + i + "][" + j + "] número atualizado de: " + estaCasa.getNumero() + " para " + n);
		if (estaCasa.getNumero() != 0) {
			for (Casa c : getLinha(i)) {
				if (!c.equals(estaCasa))
					restricoes.get(c).remove(estaCasa.getNumero());
			}

			for (Casa c : getLinha(j)) {
				if (!c.equals(estaCasa))
					restricoes.get(c).remove(estaCasa.getNumero());
			}
			for (Casa c : getQuadrante(getQuadranteNumero(i, j))) {
				if (!c.equals(estaCasa))
					restricoes.get(c).remove(estaCasa.getNumero());
			}
		} 
		for (Casa c : getLinha(i)) {
			if (!c.equals(estaCasa)) {
				createRestricao(c);
				restricoes.get(c).add(n);
				System.out.println("Tamanho das restricoes da casa " + c + " - "  + restricoes.get(c).size());
			}
		}

		for (Casa c : getLinha(j)) {
			if (!c.equals(estaCasa)) {
				createRestricao(c);
				restricoes.get(c).add(n);
				System.out.println("Tamanho das restricoes da casa " + c + " - "  + restricoes.get(c).size());
			}
		}
		for (Casa c : getQuadrante(getQuadranteNumero(i, j))) {
			if (!c.equals(estaCasa)) { 
				createRestricao(c);
				restricoes.get(c).add(n);
				System.out.println("Tamanho das restricoes da casa " + c + " - "  + restricoes.get(c).size());
			}
		}
	}
	
	// seta o valor n de uma casa na posicao (i,j)
	public void setCasa(String n, int i, int j) {
		Casa estaCasa = casas[i][j];
		addRestricao(estaCasa, Integer.parseInt(n), i, j);
		estaCasa.setNumero(n);

	}

	public void setCasa(int n, int i, int j) {
		Casa estaCasa = casas[i][j];
		addRestricao(estaCasa, n, i, j);
		estaCasa.setNumero(n);
	}

	// retorna a casa na posicao (linha, coluna)
	public Casa getCasa(int linha, int coluna) {
		return casas[linha][coluna];
	}

	// retorna o valor da dimensao da tabela
	public int getDimensao() {
		return dimensao;
	}

	@Override
	public String toString() {
		String string = "";
		for (int linha = 0; linha < dimensao; linha++) {
			for (int coluna = 0; coluna < dimensao; coluna++) {
				string += casas[linha][coluna].toString() + " ";
			}
			string += "\n";
		}
		return string;
	}

}
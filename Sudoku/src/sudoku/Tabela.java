/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.HashSet;
import java.util.Vector;

public class Tabela {

	private Casa[][] casas;
	private Vector<HashSet<Casa>> quadrantes;
    private int dimensao;

    //faz a alocação de toda a tabela instanciando todas as casas conforme a dimensao 
    //e evidencia o quadrante a qual cada casa pertence
    public Tabela(int n, String[][] estI) {
        casas = new Casa[n][n];
        quadrantes = new Vector<HashSet<Casa>>(n);
        for (int i = 0; i < n; i ++) {
        	quadrantes.add(new HashSet<Casa>());
        }
        dimensao = n;
        
        double sqrt = Math.sqrt(n);
        int raizDaDimensao = (int) sqrt;
        if (raizDaDimensao != sqrt) {
        	System.out.println("Dimensão inválida");
        	return;
        }
        
        for (int linha = 0; linha < n; linha ++) {
			for (int coluna = 0; coluna < n; coluna ++) {
				casas[linha][coluna] = new Casa(estI[linha][coluna]);
				int numeroDoQuadrante = coluna / raizDaDimensao + linha / raizDaDimensao * raizDaDimensao; 
				quadrantes.get(numeroDoQuadrante).add(casas[linha][coluna]);
			}
		}
    }

    //faz a alocação de toda a tabela instanciando todas as casas conforme a dimensao 
    //e evidencia o quadrante a qual cada casa pertence
    public Tabela(int n) {
    	casas = new Casa[n][n];
        quadrantes = new Vector<HashSet<Casa>>(n);
        for (int i = 0; i < n; i ++) {
        	quadrantes.add(new HashSet<Casa>());
        }
        dimensao = n;
        
        double sqrt = Math.sqrt(n);
        int raizDaDimensao = (int) sqrt;
        if (raizDaDimensao != sqrt) {
        	System.out.println("Dimensão inválida");
        	return;
        }
        
        for (int linha = 0; linha < n; linha ++) {
			for (int coluna = 0; coluna < n; coluna ++) {
				casas[linha][coluna] = new Casa();
				int numeroDoQuadrante = coluna / raizDaDimensao + linha / raizDaDimensao * raizDaDimensao; 
				quadrantes.get(numeroDoQuadrante).add(casas[linha][coluna]);
			}
		}
    }

    public Tabela(Tabela original) {
    	dimensao = original.getDimensao();
    	casas = new Casa[dimensao][dimensao];
        quadrantes = new Vector<HashSet<Casa>>(dimensao);
        for (int i = 0; i < dimensao; i ++) {
        	quadrantes.add(new HashSet<Casa>());
        }
    	
    	int raizDaDimensao = (int) Math.sqrt(dimensao);
    	for (int linha = 0; linha < original.getDimensao(); linha ++) {
			for (int coluna = 0; coluna < original.getDimensao(); coluna ++) {
				casas[linha][coluna] = new Casa(original.getCasa(linha, coluna));
				int numeroDoQuadrante = coluna / raizDaDimensao + linha / raizDaDimensao * raizDaDimensao; 
				quadrantes.get(numeroDoQuadrante).add(casas[linha][coluna]);
			}
		}
	}

	//retorna as casas da linha i passada como parâmetro
    public Casa[] getLinha(int i) {
        Casa[] temp = new Casa[dimensao];
        System.arraycopy(casas[i], 0, temp, 0, dimensao);
        return temp;
    }

    //retorna as casas da coluna j passada como parâmetro
    public Casa[] getColuna(int j) {
        Casa[] temp = new Casa[dimensao];
        for (int i = 0; i < dimensao; i++) {
            temp[i] = casas[i][j];
        }
        return temp;
    }

    //retorna as casas do quadrante quadr passado como parâmetro comeca no quadrante 1
    public HashSet<Casa> getQuadrante(int numeroDoQuadrante) {
        return quadrantes.get(numeroDoQuadrante);
    }

    //seta o valor n de uma casa na posicao (i,j)
    public void setCasa(String n, int i, int j) {
        casas[i][j].setNumero(n);
    }

    public void setCasa(int n, int i, int j) {
        casas[i][j].setNumero(n);
    }

    //retorna a casa na posicao (linha, coluna)
    public Casa getCasa(int linha, int coluna) {
        return casas[linha][coluna];
    }

    //retorna o valor da dimensao da tabela
    public int getDimensao() {
        return dimensao;
    }

	@Override
	public String toString() {
		String string = "";
		for (int linha = 0; linha < dimensao; linha ++) {
			for (int coluna = 0; coluna < dimensao; coluna ++) {
				string += casas[linha][coluna].toString() + " ";
			}
			string += "\n";
		}
		return string;
	}
    
}
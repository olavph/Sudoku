package sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFormattedTextField;

import sudoku.busca.BuscaCegaEmProfundidade;

public class Solucionador {

    private long nosGerados;
    private long memoria;
    private long tempoExec;

    public Solucionador() {
    }

    public Tabela buscaCegaProf(Tabela jogo, JFormattedTextField jftf) throws InterruptedException {
    	ArrayList<Tabela> nodos = new ArrayList<Tabela>();
    	nodos.add(jogo);
    	BuscaCegaEmProfundidade metodoDeBusca = new BuscaCegaEmProfundidade();
    	while (nodos.size() > 0) {
    		Tabela nodo = nodos.remove(0);
    		if (estadoFinal(nodo))
    			return nodo;
    		if (estadoValido(nodo))
    			metodoDeBusca.adicionar(nodos, metodoDeBusca.expandir(nodo));
    	}
    	//return null;
    	
    	
        long dif, initial = 0, initialMemo = 0;
        Tabela resp = null;
        initial = System.currentTimeMillis();
        initialMemo = Runtime.getRuntime().totalMemory();
        System.out.println(initialMemo);
        Tabela temp = new Tabela(jogo.getDimensao());
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(1l);//se tirar o sleep o update da interface trava
            dif = System.currentTimeMillis() - initial;
            jftf.setText(Long.toString(dif));
            
        }
        memoria = Runtime.getRuntime().totalMemory() ;// nao funciona como esperado falta achar uma forma de retornar a memoria
        System.out.println(memoria);
        memoria-=  initialMemo;
        tempoExec = System.currentTimeMillis() - initial;
        return resp;
    }

    public Tabela buscaSatisfRestricao(Tabela jogo, JFormattedTextField jftf) throws InterruptedException {
        Tabela resp = null;
        return resp;
    }

    public Tabela buscaSatisfRestringida(Tabela jogo, JFormattedTextField jftf) throws InterruptedException {
        Tabela resp = null;
        return resp;
    }

    public long getNos() {
        return nosGerados;
    }

    public long getMemoria() {
        return memoria;
    }

    public long getTempo() {
        return memoria;
    }

    // Testa se o estado respeita as regras do sudoku
    public boolean estadoValido(Tabela tabela) {
        for (int i = 0; i < tabela.getDimensao(); i++) {
        	// Valida a linha
        	Casa[] linha = tabela.getLinha(i);
            HashSet<Integer> numeros = new HashSet<Integer>();
            for (Casa casa : linha) {
				if (casa.estaPreenchida()) {
					if (numeros.contains(casa.getNumero())) {
						return false;
					}
					numeros.add(casa.getNumero());
				}
			}
            
            // Valida a coluna
            Casa[] coluna = tabela.getColuna(i);
            numeros = new HashSet<Integer>();
            for (Casa casa : coluna) {
				if (casa.estaPreenchida()) {
					if (numeros.contains(casa.getNumero())) {
						return false;
					}
					numeros.add(casa.getNumero());
				}
			}
            
            // Valida o quadrante
            HashSet<Casa> quadrante = tabela.getQuadrante(i);
            numeros = new HashSet<Integer>();
            for (Casa casa : quadrante) {
				if (casa.estaPreenchida()) {
					if (numeros.contains(casa.getNumero())) {
						return false;
					}
					numeros.add(casa.getNumero());
				}
			}
        }
        return true;
    }
    
    public boolean estadoFinal(Tabela tabela) {
    	for (int i = 0; i < tabela.getDimensao(); i++) {
        	// Valida a linha
        	Casa[] linha = tabela.getLinha(i);
            HashSet<Integer> numeros = new HashSet<Integer>();
            for (Casa casa : linha) {
				if (casa.estaPreenchida()) {
					if (numeros.contains(casa.getNumero())) {
						return false;
					}
					numeros.add(casa.getNumero());
				} else {
					return false;
				}
			}
            
            // Valida a coluna
            Casa[] coluna = tabela.getColuna(i);
            numeros = new HashSet<Integer>();
            for (Casa casa : coluna) {
				if (casa.estaPreenchida()) {
					if (numeros.contains(casa.getNumero())) {
						return false;
					}
					numeros.add(casa.getNumero());
				} else {
					return false;
				}
			}
            
            // Valida o quadrante
            HashSet<Casa> quadrante = tabela.getQuadrante(i);
            numeros = new HashSet<Integer>();
            for (Casa casa : quadrante) {
				if (casa.estaPreenchida()) {
					if (numeros.contains(casa.getNumero())) {
						return false;
					}
					numeros.add(casa.getNumero());
				} else {
					return false;
				}
			}
        }
        return true;
	}
}

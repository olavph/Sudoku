package sudoku;

import java.util.ArrayList;
import java.util.HashSet;

import sudoku.busca.MetodoDeBusca;

public class Solucionador {

    private long nosGerados;
    private long memoria;
    

    public Solucionador() {
    }

    public Tabela executarBusca(Tabela jogo, MetodoDeBusca metodoDeBusca) throws InterruptedException {
        ArrayList<Tabela> nodos = new ArrayList<Tabela>();
        nodos.add(jogo);
        while (nodos.size() > 0) {
            Tabela nodo = nodos.remove(0);
            if (estadoFinal(nodo)) {
                return nodo;
            }
            if (estadoValido(nodo)) {
                metodoDeBusca.adicionar(nodos, metodoDeBusca.expandir(nodo));
            }
            
        }
        return null;
    }

    public long getNos() {
        return nosGerados;
    }

    public long getMemoria() {
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

    // Testa se o estado e o estado final
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

package sudoku;

import javax.swing.JFormattedTextField;

public class Solucionador {

    private long nosGerados;
    private long memoria;
    private long tempoExec;

    public Solucionador() {
    }

    Tabela buscaCegaProf(Tabela jogo, JFormattedTextField jftf) throws InterruptedException {
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

    Tabela buscaSatisfRestricao(Tabela jogo, JFormattedTextField jftf) throws InterruptedException {
        Tabela resp = null;
        return resp;
    }

    Tabela buscaSatisfRestringida(Tabela jogo, JFormattedTextField jftf) throws InterruptedException {
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

    //testa se o estado respeita as regras do sudoku
    boolean estadoValido(Tabela t) {
        int dim = t.getDimensao();
        Casa[] linha, coluna, quadrante;
        boolean valido = true;
        for (int i = 0; i < dim; i++) {
            linha = t.getLinha(i);//validar toda a linha
            for (int j = 0; j < linha.length; j++) {
                for (int k = 0; k < dim; k++) {
                    if (linha[j].estaPreenchido()) {
                        if (j != k && linha[j].getNumero() == linha[k].getNumero()) {
                            valido = false;
                        }
                    }
                }
            }
            coluna = t.getColuna(i);//validar toda a coluna
            for (int j = 0; j < linha.length; j++) {
                for (int k = 0; k < dim; k++) {
                    if (coluna[j].estaPreenchido()) {
                        if (j != k && linha[j].getNumero() == linha[k].getNumero()) {
                            valido = false;
                        }
                    }
                }
            }
            quadrante = t.getQuadrante(i+1);//validar todo o quadrante 
            for (int j = 0; j < linha.length; j++) {
                for (int k = 0; k < dim; k++) {
                    if (quadrante[j].estaPreenchido()) {
                        if (j != k && linha[j].getNumero() == linha[k].getNumero()) {
                            valido = false;
                        }
                    }
                }
            }
        }
        return valido;
    }
}

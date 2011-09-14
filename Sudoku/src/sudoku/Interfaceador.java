/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import sudoku.busca.BuscaCegaEmLargura;
import sudoku.busca.BuscaCegaEmProfundidade;
import sudoku.busca.BuscaComSatisfacaoDeRestricoesMaisRestringida;
import sudoku.busca.MetodoDeBusca;

public class Interfaceador implements Runnable {

    private Tabela jogoSdk;
    private MetodoDeBusca metodoSol;
    private Solucionador res;
    public Form_sudoku jtxf;
    private Cronometro crono;
    private AnalisadorDeMemoria memo;

    public Interfaceador(int dim, String[][] estI, String metodo, Form_sudoku txf) {
        jogoSdk = new Tabela(dim, estI);
        setarMetodoSol(metodo);
        jtxf = txf;
        res = new Solucionador();
        crono = new Cronometro(jtxf.jftxf_tempo);
        memo = new AnalisadorDeMemoria();
    }

    public Interfaceador() {
        res = new Solucionador();
    }

    @Override
    public void run() {
        resolverJogo();
    }

    //Seta o metodo de solucao do sudoku
    private void setarMetodoSol(String metodo) {
        if (metodo.equalsIgnoreCase("CEGA_PROF")) {
            metodoSol = new BuscaCegaEmProfundidade();
        } else if (metodo.equalsIgnoreCase("SATIS_RESTRICAO")) {
            metodoSol = new BuscaCegaEmLargura();
        } else if (metodo.equalsIgnoreCase("SATIS_RESTRINGIDA")) {
            metodoSol = new BuscaComSatisfacaoDeRestricoesMaisRestringida();
        }
    }

    //metodo que chama os metodos de resolucao do jogo
    private void resolverJogo() {
    	crono.comeca();
    	memo.comeca();
        Tabela t = null;
        try {
        	t = res.executarBusca(jogoSdk, metodoSol);
        } catch (InterruptedException ex) {
            jtxf.liberar_trancarUi(true);
            return;
        }
        crono.termina();
        memo.termina();
        long memoria = memo.getMemoriaMaxima();
        long nos = res.getNos();
        JOptionPane.showMessageDialog(jtxf, "Memoria gasta = " + memoria + "\r\nNúmero de nós = " + nos);
        jtxf.liberar_trancarUi(true);
        mostrarSolucao(jtxf, t);
    }

    //Mostra a tabela t para a area de jogo
    private void mostrarTabela(JTable jtab_TabelaJogo, Tabela t) {
        if (t != null) {
            int dim = t.getDimensao();
            
                        
            if (dim == 4) {
                jtab_TabelaJogo.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {"A", t.getCasa(0, 0).getNumero(), t.getCasa(0, 1).getNumero(), t.getCasa(0, 2).getNumero(), t.getCasa(0, 3).getNumero()},
                            {"B", t.getCasa(1, 0).getNumero(), t.getCasa(1, 1).getNumero(), t.getCasa(1, 2).getNumero(), t.getCasa(1, 3).getNumero()},
                            {"C", t.getCasa(2, 0).getNumero(), t.getCasa(2, 1).getNumero(), t.getCasa(2, 2).getNumero(), t.getCasa(2, 3).getNumero()},
                            {"D", t.getCasa(3, 0).getNumero(), t.getCasa(3, 1).getNumero(), t.getCasa(3, 2).getNumero(), t.getCasa(3, 3).getNumero()}},
                        new String[]{"", "a", "b", "c", "d"}) {

                    boolean[] canEdit = new boolean[]{
                        false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
            } else if (dim == 9) {
                jtab_TabelaJogo.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {"A", t.getCasa(0, 0).getNumero(), t.getCasa(0, 1).getNumero(), t.getCasa(0, 2).getNumero(), t.getCasa(0, 3).getNumero(), t.getCasa(0, 4).getNumero(), t.getCasa(0, 5).getNumero(), t.getCasa(0, 6).getNumero(), t.getCasa(0, 7).getNumero(), t.getCasa(0, 8).getNumero()},
                            {"B", t.getCasa(1, 0).getNumero(), t.getCasa(1, 1).getNumero(), t.getCasa(1, 2).getNumero(), t.getCasa(1, 3).getNumero(), t.getCasa(1, 4).getNumero(), t.getCasa(1, 5).getNumero(), t.getCasa(1, 6).getNumero(), t.getCasa(1, 7).getNumero(), t.getCasa(1, 8).getNumero()},
                            {"C", t.getCasa(2, 0).getNumero(), t.getCasa(2, 1).getNumero(), t.getCasa(2, 2).getNumero(), t.getCasa(2, 3).getNumero(), t.getCasa(2, 4).getNumero(), t.getCasa(2, 5).getNumero(), t.getCasa(2, 6).getNumero(), t.getCasa(2, 7).getNumero(), t.getCasa(2, 8).getNumero()},
                            {"D", t.getCasa(3, 0).getNumero(), t.getCasa(3, 1).getNumero(), t.getCasa(3, 2).getNumero(), t.getCasa(3, 3).getNumero(), t.getCasa(3, 4).getNumero(), t.getCasa(3, 5).getNumero(), t.getCasa(3, 6).getNumero(), t.getCasa(3, 7).getNumero(), t.getCasa(3, 8).getNumero()},
                            {"E", t.getCasa(4, 0).getNumero(), t.getCasa(4, 1).getNumero(), t.getCasa(4, 2).getNumero(), t.getCasa(4, 3).getNumero(), t.getCasa(4, 4).getNumero(), t.getCasa(4, 5).getNumero(), t.getCasa(4, 6).getNumero(), t.getCasa(4, 7).getNumero(), t.getCasa(4, 8).getNumero()},
                            {"F", t.getCasa(5, 0).getNumero(), t.getCasa(5, 1).getNumero(), t.getCasa(5, 2).getNumero(), t.getCasa(5, 3).getNumero(), t.getCasa(5, 4).getNumero(), t.getCasa(5, 5).getNumero(), t.getCasa(5, 6).getNumero(), t.getCasa(5, 7).getNumero(), t.getCasa(5, 8).getNumero()},
                            {"G", t.getCasa(6, 0).getNumero(), t.getCasa(6, 1).getNumero(), t.getCasa(6, 2).getNumero(), t.getCasa(6, 3).getNumero(), t.getCasa(6, 4).getNumero(), t.getCasa(6, 5).getNumero(), t.getCasa(6, 6).getNumero(), t.getCasa(6, 7).getNumero(), t.getCasa(6, 8).getNumero()},
                            {"H", t.getCasa(7, 0).getNumero(), t.getCasa(7, 1).getNumero(), t.getCasa(7, 2).getNumero(), t.getCasa(7, 3).getNumero(), t.getCasa(7, 4).getNumero(), t.getCasa(7, 5).getNumero(), t.getCasa(7, 6).getNumero(), t.getCasa(7, 7).getNumero(), t.getCasa(7, 8).getNumero()},
                            {"I", t.getCasa(8, 0).getNumero(), t.getCasa(8, 1).getNumero(), t.getCasa(8, 2).getNumero(), t.getCasa(8, 3).getNumero(), t.getCasa(8, 4).getNumero(), t.getCasa(8, 5).getNumero(), t.getCasa(8, 6).getNumero(), t.getCasa(8, 7).getNumero(), t.getCasa(8, 8).getNumero()}},
                        new String[]{"", "a", "b", "c", "d", "e", "f", "g", "h", "i"}) {

                    boolean[] canEdit = new boolean[]{
                        false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
            } else {
                jtab_TabelaJogo.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {"A", t.getCasa(0, 0).getNumero(), t.getCasa(0, 1).getNumero(), t.getCasa(0, 2).getNumero(), t.getCasa(0, 3).getNumero(), t.getCasa(0, 4).getNumero(), t.getCasa(0, 5).getNumero(), t.getCasa(0, 6).getNumero(), t.getCasa(0, 7).getNumero(), t.getCasa(0, 8).getNumero(), t.getCasa(0, 9).getNumero(), t.getCasa(0, 10).getNumero(), t.getCasa(0, 11).getNumero(), t.getCasa(0, 12).getNumero(), t.getCasa(0, 13).getNumero(), t.getCasa(0, 14).getNumero(), t.getCasa(0, 15).getNumero()},
                            {"B", t.getCasa(1, 0).getNumero(), t.getCasa(1, 1).getNumero(), t.getCasa(1, 2).getNumero(), t.getCasa(1, 3).getNumero(), t.getCasa(1, 4).getNumero(), t.getCasa(1, 5).getNumero(), t.getCasa(1, 6).getNumero(), t.getCasa(1, 7).getNumero(), t.getCasa(1, 8).getNumero(), t.getCasa(1, 9).getNumero(), t.getCasa(1, 10).getNumero(), t.getCasa(1, 11).getNumero(), t.getCasa(1, 12).getNumero(), t.getCasa(1, 13).getNumero(), t.getCasa(1, 14).getNumero(), t.getCasa(1, 15).getNumero()},
                            {"C", t.getCasa(2, 0).getNumero(), t.getCasa(2, 1).getNumero(), t.getCasa(2, 2).getNumero(), t.getCasa(2, 3).getNumero(), t.getCasa(2, 4).getNumero(), t.getCasa(2, 5).getNumero(), t.getCasa(2, 6).getNumero(), t.getCasa(2, 7).getNumero(), t.getCasa(2, 8).getNumero(), t.getCasa(2, 9).getNumero(), t.getCasa(2, 10).getNumero(), t.getCasa(2, 11).getNumero(), t.getCasa(2, 12).getNumero(), t.getCasa(2, 13).getNumero(), t.getCasa(2, 14).getNumero(), t.getCasa(2, 15).getNumero()},
                            {"D", t.getCasa(3, 0).getNumero(), t.getCasa(3, 1).getNumero(), t.getCasa(3, 2).getNumero(), t.getCasa(3, 3).getNumero(), t.getCasa(3, 4).getNumero(), t.getCasa(3, 5).getNumero(), t.getCasa(3, 6).getNumero(), t.getCasa(3, 7).getNumero(), t.getCasa(3, 8).getNumero(), t.getCasa(3, 9).getNumero(), t.getCasa(3, 10).getNumero(), t.getCasa(3, 11).getNumero(), t.getCasa(3, 12).getNumero(), t.getCasa(3, 13).getNumero(), t.getCasa(3, 14).getNumero(), t.getCasa(3, 15).getNumero()},
                            {"E", t.getCasa(4, 0).getNumero(), t.getCasa(4, 1).getNumero(), t.getCasa(4, 2).getNumero(), t.getCasa(4, 3).getNumero(), t.getCasa(4, 4).getNumero(), t.getCasa(4, 5).getNumero(), t.getCasa(4, 6).getNumero(), t.getCasa(4, 7).getNumero(), t.getCasa(4, 8).getNumero(), t.getCasa(4, 9).getNumero(), t.getCasa(4, 10).getNumero(), t.getCasa(4, 11).getNumero(), t.getCasa(4, 12).getNumero(), t.getCasa(4, 13).getNumero(), t.getCasa(4, 14).getNumero(), t.getCasa(4, 15).getNumero()},
                            {"F", t.getCasa(5, 0).getNumero(), t.getCasa(5, 1).getNumero(), t.getCasa(5, 2).getNumero(), t.getCasa(5, 3).getNumero(), t.getCasa(5, 4).getNumero(), t.getCasa(5, 5).getNumero(), t.getCasa(5, 6).getNumero(), t.getCasa(5, 7).getNumero(), t.getCasa(5, 8).getNumero(), t.getCasa(5, 9).getNumero(), t.getCasa(5, 10).getNumero(), t.getCasa(5, 11).getNumero(), t.getCasa(5, 12).getNumero(), t.getCasa(5, 13).getNumero(), t.getCasa(5, 14).getNumero(), t.getCasa(5, 15).getNumero()},
                            {"G", t.getCasa(6, 0).getNumero(), t.getCasa(6, 1).getNumero(), t.getCasa(6, 2).getNumero(), t.getCasa(6, 3).getNumero(), t.getCasa(6, 4).getNumero(), t.getCasa(6, 5).getNumero(), t.getCasa(6, 6).getNumero(), t.getCasa(6, 7).getNumero(), t.getCasa(6, 8).getNumero(), t.getCasa(6, 9).getNumero(), t.getCasa(6, 10).getNumero(), t.getCasa(6, 11).getNumero(), t.getCasa(6, 12).getNumero(), t.getCasa(6, 13).getNumero(), t.getCasa(6, 14).getNumero(), t.getCasa(6, 15).getNumero()},
                            {"H", t.getCasa(7, 0).getNumero(), t.getCasa(7, 1).getNumero(), t.getCasa(7, 2).getNumero(), t.getCasa(7, 3).getNumero(), t.getCasa(7, 4).getNumero(), t.getCasa(7, 5).getNumero(), t.getCasa(7, 6).getNumero(), t.getCasa(7, 7).getNumero(), t.getCasa(7, 8).getNumero(), t.getCasa(7, 9).getNumero(), t.getCasa(7, 10).getNumero(), t.getCasa(7, 11).getNumero(), t.getCasa(7, 12).getNumero(), t.getCasa(7, 13).getNumero(), t.getCasa(7, 14).getNumero(), t.getCasa(7, 15).getNumero()},
                            {"I", t.getCasa(8, 0).getNumero(), t.getCasa(8, 1).getNumero(), t.getCasa(8, 2).getNumero(), t.getCasa(8, 3).getNumero(), t.getCasa(8, 4).getNumero(), t.getCasa(8, 5).getNumero(), t.getCasa(8, 6).getNumero(), t.getCasa(8, 7).getNumero(), t.getCasa(8, 8).getNumero(), t.getCasa(8, 9).getNumero(), t.getCasa(8, 10).getNumero(), t.getCasa(8, 11).getNumero(), t.getCasa(8, 12).getNumero(), t.getCasa(8, 13).getNumero(), t.getCasa(8, 14).getNumero(), t.getCasa(8, 15).getNumero()},
                            {"J", t.getCasa(9, 0).getNumero(), t.getCasa(9, 1).getNumero(), t.getCasa(9, 2).getNumero(), t.getCasa(9, 3).getNumero(), t.getCasa(9, 4).getNumero(), t.getCasa(9, 5).getNumero(), t.getCasa(9, 6).getNumero(), t.getCasa(9, 7).getNumero(), t.getCasa(9, 8).getNumero(), t.getCasa(9, 9).getNumero(), t.getCasa(9, 10).getNumero(), t.getCasa(9, 11).getNumero(), t.getCasa(9, 12).getNumero(), t.getCasa(9, 13).getNumero(), t.getCasa(9, 14).getNumero(), t.getCasa(9, 15).getNumero()},
                            {"K", t.getCasa(10, 0).getNumero(), t.getCasa(10, 1).getNumero(), t.getCasa(10, 2).getNumero(), t.getCasa(10, 3).getNumero(), t.getCasa(10, 4).getNumero(), t.getCasa(10, 5).getNumero(), t.getCasa(10, 6).getNumero(), t.getCasa(10, 7).getNumero(), t.getCasa(10, 8).getNumero(), t.getCasa(10, 9).getNumero(), t.getCasa(10, 10).getNumero(), t.getCasa(10, 11).getNumero(), t.getCasa(10, 12).getNumero(), t.getCasa(10, 13).getNumero(), t.getCasa(10, 14).getNumero(), t.getCasa(10, 15).getNumero()},
                            {"L", t.getCasa(11, 0).getNumero(), t.getCasa(11, 1).getNumero(), t.getCasa(11, 2).getNumero(), t.getCasa(11, 3).getNumero(), t.getCasa(11, 4).getNumero(), t.getCasa(11, 5).getNumero(), t.getCasa(11, 6).getNumero(), t.getCasa(11, 7).getNumero(), t.getCasa(11, 8).getNumero(), t.getCasa(11, 9).getNumero(), t.getCasa(11, 10).getNumero(), t.getCasa(11, 11).getNumero(), t.getCasa(11, 12).getNumero(), t.getCasa(11, 13).getNumero(), t.getCasa(11, 14).getNumero(), t.getCasa(11, 15).getNumero()},
                            {"M", t.getCasa(12, 0).getNumero(), t.getCasa(12, 1).getNumero(), t.getCasa(12, 2).getNumero(), t.getCasa(12, 3).getNumero(), t.getCasa(12, 4).getNumero(), t.getCasa(12, 5).getNumero(), t.getCasa(12, 6).getNumero(), t.getCasa(12, 7).getNumero(), t.getCasa(12, 8).getNumero(), t.getCasa(12, 9).getNumero(), t.getCasa(12, 10).getNumero(), t.getCasa(12, 11).getNumero(), t.getCasa(12, 12).getNumero(), t.getCasa(12, 13).getNumero(), t.getCasa(12, 14).getNumero(), t.getCasa(12, 15).getNumero()},
                            {"N", t.getCasa(13, 0).getNumero(), t.getCasa(13, 1).getNumero(), t.getCasa(13, 2).getNumero(), t.getCasa(13, 3).getNumero(), t.getCasa(13, 4).getNumero(), t.getCasa(13, 5).getNumero(), t.getCasa(13, 6).getNumero(), t.getCasa(13, 7).getNumero(), t.getCasa(13, 8).getNumero(), t.getCasa(13, 9).getNumero(), t.getCasa(13, 10).getNumero(), t.getCasa(13, 11).getNumero(), t.getCasa(13, 12).getNumero(), t.getCasa(13, 13).getNumero(), t.getCasa(13, 14).getNumero(), t.getCasa(13, 15).getNumero()},
                            {"O", t.getCasa(14, 0).getNumero(), t.getCasa(14, 1).getNumero(), t.getCasa(14, 2).getNumero(), t.getCasa(14, 3).getNumero(), t.getCasa(14, 4).getNumero(), t.getCasa(14, 5).getNumero(), t.getCasa(14, 6).getNumero(), t.getCasa(14, 7).getNumero(), t.getCasa(14, 8).getNumero(), t.getCasa(14, 9).getNumero(), t.getCasa(14, 10).getNumero(), t.getCasa(14, 11).getNumero(), t.getCasa(14, 12).getNumero(), t.getCasa(14, 13).getNumero(), t.getCasa(14, 14).getNumero(), t.getCasa(14, 15).getNumero()},
                            {"P", t.getCasa(15, 0).getNumero(), t.getCasa(15, 1).getNumero(), t.getCasa(15, 2).getNumero(), t.getCasa(15, 3).getNumero(), t.getCasa(15, 4).getNumero(), t.getCasa(15, 5).getNumero(), t.getCasa(15, 6).getNumero(), t.getCasa(15, 7).getNumero(), t.getCasa(15, 8).getNumero(), t.getCasa(15, 9).getNumero(), t.getCasa(15, 10).getNumero(), t.getCasa(15, 11).getNumero(), t.getCasa(15, 12).getNumero(), t.getCasa(15, 13).getNumero(), t.getCasa(15, 14).getNumero(), t.getCasa(15, 15).getNumero()}
                        },
                        new String[]{
                            "", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"}) {

                    boolean[] canEdit = new boolean[]{
                        false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
            }
            for(int i =0; i< dim; i++)
                for(int j=1; j<dim+1; j++)
                    if(((Integer)(jtab_TabelaJogo.getValueAt(i, j)))== 0)
                        jtab_TabelaJogo.setValueAt(null, i, j);
        }
    }

    //Preenche a tabela com o resultado do jogo
    private void mostrarSolucao(Form_sudoku jtxf, Tabela t) {
        if (t != null) {
            int dim = t.getDimensao();
            if (dim == 4) {
                jtxf.jtab_TabelaJogo.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {"A", t.getCasa(0, 0).getNumero(), t.getCasa(0, 1).getNumero(), t.getCasa(0, 2).getNumero(), t.getCasa(0, 3).getNumero()},
                            {"B", t.getCasa(1, 0).getNumero(), t.getCasa(1, 1).getNumero(), t.getCasa(1, 2).getNumero(), t.getCasa(1, 3).getNumero()},
                            {"C", t.getCasa(2, 0).getNumero(), t.getCasa(2, 1).getNumero(), t.getCasa(2, 2).getNumero(), t.getCasa(2, 3).getNumero()},
                            {"D", t.getCasa(3, 0).getNumero(), t.getCasa(3, 1).getNumero(), t.getCasa(3, 2).getNumero(), t.getCasa(3, 3).getNumero()}},
                        new String[]{"", "a", "b", "c", "d"}) {

                    boolean[] canEdit = new boolean[]{
                        false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
            } else if (dim == 9) {
                jtxf.jtab_TabelaJogo.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {"A", t.getCasa(0, 0).getNumero(), t.getCasa(0, 1).getNumero(), t.getCasa(0, 2).getNumero(), t.getCasa(0, 3).getNumero(), t.getCasa(0, 4).getNumero(), t.getCasa(0, 5).getNumero(), t.getCasa(0, 6).getNumero(), t.getCasa(0, 7).getNumero(), t.getCasa(0, 8).getNumero()},
                            {"B", t.getCasa(1, 0).getNumero(), t.getCasa(1, 1).getNumero(), t.getCasa(1, 2).getNumero(), t.getCasa(1, 3).getNumero(), t.getCasa(1, 4).getNumero(), t.getCasa(1, 5).getNumero(), t.getCasa(1, 6).getNumero(), t.getCasa(1, 7).getNumero(), t.getCasa(1, 8).getNumero()},
                            {"C", t.getCasa(2, 0).getNumero(), t.getCasa(2, 1).getNumero(), t.getCasa(2, 2).getNumero(), t.getCasa(2, 3).getNumero(), t.getCasa(2, 4).getNumero(), t.getCasa(2, 5).getNumero(), t.getCasa(2, 6).getNumero(), t.getCasa(2, 7).getNumero(), t.getCasa(2, 8).getNumero()},
                            {"D", t.getCasa(3, 0).getNumero(), t.getCasa(3, 1).getNumero(), t.getCasa(3, 2).getNumero(), t.getCasa(3, 3).getNumero(), t.getCasa(3, 4).getNumero(), t.getCasa(3, 5).getNumero(), t.getCasa(3, 6).getNumero(), t.getCasa(3, 7).getNumero(), t.getCasa(3, 8).getNumero()},
                            {"E", t.getCasa(4, 0).getNumero(), t.getCasa(4, 1).getNumero(), t.getCasa(4, 2).getNumero(), t.getCasa(4, 3).getNumero(), t.getCasa(4, 4).getNumero(), t.getCasa(4, 5).getNumero(), t.getCasa(4, 6).getNumero(), t.getCasa(4, 7).getNumero(), t.getCasa(4, 8).getNumero()},
                            {"F", t.getCasa(5, 0).getNumero(), t.getCasa(5, 1).getNumero(), t.getCasa(5, 2).getNumero(), t.getCasa(5, 3).getNumero(), t.getCasa(5, 4).getNumero(), t.getCasa(5, 5).getNumero(), t.getCasa(5, 6).getNumero(), t.getCasa(5, 7).getNumero(), t.getCasa(5, 8).getNumero()},
                            {"G", t.getCasa(6, 0).getNumero(), t.getCasa(6, 1).getNumero(), t.getCasa(6, 2).getNumero(), t.getCasa(6, 3).getNumero(), t.getCasa(6, 4).getNumero(), t.getCasa(6, 5).getNumero(), t.getCasa(6, 6).getNumero(), t.getCasa(6, 7).getNumero(), t.getCasa(6, 8).getNumero()},
                            {"H", t.getCasa(7, 0).getNumero(), t.getCasa(7, 1).getNumero(), t.getCasa(7, 2).getNumero(), t.getCasa(7, 3).getNumero(), t.getCasa(7, 4).getNumero(), t.getCasa(7, 5).getNumero(), t.getCasa(7, 6).getNumero(), t.getCasa(7, 7).getNumero(), t.getCasa(7, 8).getNumero()},
                            {"I", t.getCasa(8, 0).getNumero(), t.getCasa(8, 1).getNumero(), t.getCasa(8, 2).getNumero(), t.getCasa(8, 3).getNumero(), t.getCasa(8, 4).getNumero(), t.getCasa(8, 5).getNumero(), t.getCasa(8, 6).getNumero(), t.getCasa(8, 7).getNumero(), t.getCasa(8, 8).getNumero()}},
                        new String[]{"", "a", "b", "c", "d", "e", "f", "g", "h", "i"}) {

                    boolean[] canEdit = new boolean[]{
                        false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
            } else {
                jtxf.jtab_TabelaJogo.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {"A", t.getCasa(0, 0).getNumero(), t.getCasa(0, 1).getNumero(), t.getCasa(0, 2).getNumero(), t.getCasa(0, 3).getNumero(), t.getCasa(0, 4).getNumero(), t.getCasa(0, 5).getNumero(), t.getCasa(0, 6).getNumero(), t.getCasa(0, 7).getNumero(), t.getCasa(0, 8).getNumero(), t.getCasa(0, 9).getNumero(), t.getCasa(0, 10).getNumero(), t.getCasa(0, 11).getNumero(), t.getCasa(0, 12).getNumero(), t.getCasa(0, 13).getNumero(), t.getCasa(0, 14).getNumero(), t.getCasa(0, 15).getNumero()},
                            {"B", t.getCasa(1, 0).getNumero(), t.getCasa(1, 1).getNumero(), t.getCasa(1, 2).getNumero(), t.getCasa(1, 3).getNumero(), t.getCasa(1, 4).getNumero(), t.getCasa(1, 5).getNumero(), t.getCasa(1, 6).getNumero(), t.getCasa(1, 7).getNumero(), t.getCasa(1, 8).getNumero(), t.getCasa(1, 9).getNumero(), t.getCasa(1, 10).getNumero(), t.getCasa(1, 11).getNumero(), t.getCasa(1, 12).getNumero(), t.getCasa(1, 13).getNumero(), t.getCasa(1, 14).getNumero(), t.getCasa(1, 15).getNumero()},
                            {"C", t.getCasa(2, 0).getNumero(), t.getCasa(2, 1).getNumero(), t.getCasa(2, 2).getNumero(), t.getCasa(2, 3).getNumero(), t.getCasa(2, 4).getNumero(), t.getCasa(2, 5).getNumero(), t.getCasa(2, 6).getNumero(), t.getCasa(2, 7).getNumero(), t.getCasa(2, 8).getNumero(), t.getCasa(2, 9).getNumero(), t.getCasa(2, 10).getNumero(), t.getCasa(2, 11).getNumero(), t.getCasa(2, 12).getNumero(), t.getCasa(2, 13).getNumero(), t.getCasa(2, 14).getNumero(), t.getCasa(2, 15).getNumero()},
                            {"D", t.getCasa(3, 0).getNumero(), t.getCasa(3, 1).getNumero(), t.getCasa(3, 2).getNumero(), t.getCasa(3, 3).getNumero(), t.getCasa(3, 4).getNumero(), t.getCasa(3, 5).getNumero(), t.getCasa(3, 6).getNumero(), t.getCasa(3, 7).getNumero(), t.getCasa(3, 8).getNumero(), t.getCasa(3, 9).getNumero(), t.getCasa(3, 10).getNumero(), t.getCasa(3, 11).getNumero(), t.getCasa(3, 12).getNumero(), t.getCasa(3, 13).getNumero(), t.getCasa(3, 14).getNumero(), t.getCasa(3, 15).getNumero()},
                            {"E", t.getCasa(4, 0).getNumero(), t.getCasa(4, 1).getNumero(), t.getCasa(4, 2).getNumero(), t.getCasa(4, 3).getNumero(), t.getCasa(4, 4).getNumero(), t.getCasa(4, 5).getNumero(), t.getCasa(4, 6).getNumero(), t.getCasa(4, 7).getNumero(), t.getCasa(4, 8).getNumero(), t.getCasa(4, 9).getNumero(), t.getCasa(4, 10).getNumero(), t.getCasa(4, 11).getNumero(), t.getCasa(4, 12).getNumero(), t.getCasa(4, 13).getNumero(), t.getCasa(4, 14).getNumero(), t.getCasa(4, 15).getNumero()},
                            {"F", t.getCasa(5, 0).getNumero(), t.getCasa(5, 1).getNumero(), t.getCasa(5, 2).getNumero(), t.getCasa(5, 3).getNumero(), t.getCasa(5, 4).getNumero(), t.getCasa(5, 5).getNumero(), t.getCasa(5, 6).getNumero(), t.getCasa(5, 7).getNumero(), t.getCasa(5, 8).getNumero(), t.getCasa(5, 9).getNumero(), t.getCasa(5, 10).getNumero(), t.getCasa(5, 11).getNumero(), t.getCasa(5, 12).getNumero(), t.getCasa(5, 13).getNumero(), t.getCasa(5, 14).getNumero(), t.getCasa(5, 15).getNumero()},
                            {"G", t.getCasa(6, 0).getNumero(), t.getCasa(6, 1).getNumero(), t.getCasa(6, 2).getNumero(), t.getCasa(6, 3).getNumero(), t.getCasa(6, 4).getNumero(), t.getCasa(6, 5).getNumero(), t.getCasa(6, 6).getNumero(), t.getCasa(6, 7).getNumero(), t.getCasa(6, 8).getNumero(), t.getCasa(6, 9).getNumero(), t.getCasa(6, 10).getNumero(), t.getCasa(6, 11).getNumero(), t.getCasa(6, 12).getNumero(), t.getCasa(6, 13).getNumero(), t.getCasa(6, 14).getNumero(), t.getCasa(6, 15).getNumero()},
                            {"H", t.getCasa(7, 0).getNumero(), t.getCasa(7, 1).getNumero(), t.getCasa(7, 2).getNumero(), t.getCasa(7, 3).getNumero(), t.getCasa(7, 4).getNumero(), t.getCasa(7, 5).getNumero(), t.getCasa(7, 6).getNumero(), t.getCasa(7, 7).getNumero(), t.getCasa(7, 8).getNumero(), t.getCasa(7, 9).getNumero(), t.getCasa(7, 10).getNumero(), t.getCasa(7, 11).getNumero(), t.getCasa(7, 12).getNumero(), t.getCasa(7, 13).getNumero(), t.getCasa(7, 14).getNumero(), t.getCasa(7, 15).getNumero()},
                            {"I", t.getCasa(8, 0).getNumero(), t.getCasa(8, 1).getNumero(), t.getCasa(8, 2).getNumero(), t.getCasa(8, 3).getNumero(), t.getCasa(8, 4).getNumero(), t.getCasa(8, 5).getNumero(), t.getCasa(8, 6).getNumero(), t.getCasa(8, 7).getNumero(), t.getCasa(8, 8).getNumero(), t.getCasa(8, 9).getNumero(), t.getCasa(8, 10).getNumero(), t.getCasa(8, 11).getNumero(), t.getCasa(8, 12).getNumero(), t.getCasa(8, 13).getNumero(), t.getCasa(8, 14).getNumero(), t.getCasa(8, 15).getNumero()},
                            {"J", t.getCasa(9, 0).getNumero(), t.getCasa(9, 1).getNumero(), t.getCasa(9, 2).getNumero(), t.getCasa(9, 3).getNumero(), t.getCasa(9, 4).getNumero(), t.getCasa(9, 5).getNumero(), t.getCasa(9, 6).getNumero(), t.getCasa(9, 7).getNumero(), t.getCasa(9, 8).getNumero(), t.getCasa(9, 9).getNumero(), t.getCasa(9, 10).getNumero(), t.getCasa(9, 11).getNumero(), t.getCasa(9, 12).getNumero(), t.getCasa(9, 13).getNumero(), t.getCasa(9, 14).getNumero(), t.getCasa(9, 15).getNumero()},
                            {"K", t.getCasa(10, 0).getNumero(), t.getCasa(10, 1).getNumero(), t.getCasa(10, 2).getNumero(), t.getCasa(10, 3).getNumero(), t.getCasa(10, 4).getNumero(), t.getCasa(10, 5).getNumero(), t.getCasa(10, 6).getNumero(), t.getCasa(10, 7).getNumero(), t.getCasa(10, 8).getNumero(), t.getCasa(10, 9).getNumero(), t.getCasa(10, 10).getNumero(), t.getCasa(10, 11).getNumero(), t.getCasa(10, 12).getNumero(), t.getCasa(10, 13).getNumero(), t.getCasa(10, 14).getNumero(), t.getCasa(10, 15).getNumero()},
                            {"L", t.getCasa(11, 0).getNumero(), t.getCasa(11, 1).getNumero(), t.getCasa(11, 2).getNumero(), t.getCasa(11, 3).getNumero(), t.getCasa(11, 4).getNumero(), t.getCasa(11, 5).getNumero(), t.getCasa(11, 6).getNumero(), t.getCasa(11, 7).getNumero(), t.getCasa(11, 8).getNumero(), t.getCasa(11, 9).getNumero(), t.getCasa(11, 10).getNumero(), t.getCasa(11, 11).getNumero(), t.getCasa(11, 12).getNumero(), t.getCasa(11, 13).getNumero(), t.getCasa(11, 14).getNumero(), t.getCasa(11, 15).getNumero()},
                            {"M", t.getCasa(12, 0).getNumero(), t.getCasa(12, 1).getNumero(), t.getCasa(12, 2).getNumero(), t.getCasa(12, 3).getNumero(), t.getCasa(12, 4).getNumero(), t.getCasa(12, 5).getNumero(), t.getCasa(12, 6).getNumero(), t.getCasa(12, 7).getNumero(), t.getCasa(12, 8).getNumero(), t.getCasa(12, 9).getNumero(), t.getCasa(12, 10).getNumero(), t.getCasa(12, 11).getNumero(), t.getCasa(12, 12).getNumero(), t.getCasa(12, 13).getNumero(), t.getCasa(12, 14).getNumero(), t.getCasa(12, 15).getNumero()},
                            {"N", t.getCasa(13, 0).getNumero(), t.getCasa(13, 1).getNumero(), t.getCasa(13, 2).getNumero(), t.getCasa(13, 3).getNumero(), t.getCasa(13, 4).getNumero(), t.getCasa(13, 5).getNumero(), t.getCasa(13, 6).getNumero(), t.getCasa(13, 7).getNumero(), t.getCasa(13, 8).getNumero(), t.getCasa(13, 9).getNumero(), t.getCasa(13, 10).getNumero(), t.getCasa(13, 11).getNumero(), t.getCasa(13, 12).getNumero(), t.getCasa(13, 13).getNumero(), t.getCasa(13, 14).getNumero(), t.getCasa(13, 15).getNumero()},
                            {"O", t.getCasa(14, 0).getNumero(), t.getCasa(14, 1).getNumero(), t.getCasa(14, 2).getNumero(), t.getCasa(14, 3).getNumero(), t.getCasa(14, 4).getNumero(), t.getCasa(14, 5).getNumero(), t.getCasa(14, 6).getNumero(), t.getCasa(14, 7).getNumero(), t.getCasa(14, 8).getNumero(), t.getCasa(14, 9).getNumero(), t.getCasa(14, 10).getNumero(), t.getCasa(14, 11).getNumero(), t.getCasa(14, 12).getNumero(), t.getCasa(14, 13).getNumero(), t.getCasa(14, 14).getNumero(), t.getCasa(14, 15).getNumero()},
                            {"P", t.getCasa(15, 0).getNumero(), t.getCasa(15, 1).getNumero(), t.getCasa(15, 2).getNumero(), t.getCasa(15, 3).getNumero(), t.getCasa(15, 4).getNumero(), t.getCasa(15, 5).getNumero(), t.getCasa(15, 6).getNumero(), t.getCasa(15, 7).getNumero(), t.getCasa(15, 8).getNumero(), t.getCasa(15, 9).getNumero(), t.getCasa(15, 10).getNumero(), t.getCasa(15, 11).getNumero(), t.getCasa(15, 12).getNumero(), t.getCasa(15, 13).getNumero(), t.getCasa(15, 14).getNumero(), t.getCasa(15, 15).getNumero()}
                        },
                        new String[]{
                            "", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"}) {

                    boolean[] canEdit = new boolean[]{
                        false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
            }
        } else {
            JOptionPane.showMessageDialog(jtxf, " Solução não encontrada !");
        }
    }

    boolean estadoInicialValido() {
        int dim = jogoSdk.getDimensao();
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (jogoSdk.getCasa(i, j).getNumero() < 0 || jogoSdk.getCasa(i, j).getNumero() > dim) {
                    return false;
                }
            }
        }
        return res.estadoValido(jogoSdk);
    }

    void gerarJogo(JTable jtab_TabelaJogo, int dim) {
        String[][] estI = new String[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                estI[i][j] = null;
            }
        }
        jogoSdk = new Tabela(dim, estI);
        boolean done = false;
        int index = 0;
        while (!done) {
            int posI = (int) ((dim-1) * Math.random());
            int posJ = (int) ((dim-1) * Math.random());

            if (!jogoSdk.getCasa(posI, posJ).estaPreenchida()) {
                    do {
                        jogoSdk.setCasa(1 + (int) (dim * Math.random()),posI, posJ);
                    } while (!estadoInicialValido());
                    index++;
                    if(index == dim)
                        done = true;
                }
            }
        mostrarTabela(jtab_TabelaJogo, jogoSdk);
    }
}

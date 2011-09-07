/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import javax.swing.JOptionPane;

public class Interfaceador implements Runnable {

    private Tabela jogoSdk;
    private MetodoSolucao metodoSol;
    private Solucionador res;
    public Form_sudoku jtxf;

    public Interfaceador(int dim, String[][] estI, String metodo, Form_sudoku txf) {
        jogoSdk = new Tabela(dim, estI);
        setarMetodoSol(metodo);
        jtxf = txf;
        res = new Solucionador();
    }

    @Override
    public void run() {
        resolverJogo();
    }

    private void setarMetodoSol(String metodo) {
        if (metodo.equalsIgnoreCase("CEGA_PROF")) {
            metodoSol = MetodoSolucao.BCEGA_PROFUNDIDADE;
        } else if (metodo.equalsIgnoreCase("SATIS_RESTRICAO")) {
            metodoSol = MetodoSolucao.BSATISF_RESTRICAO;
        } else if (metodo.equalsIgnoreCase("SATIS_RESTRINGIDA")) {
            metodoSol = MetodoSolucao.BSATISF_RESTRINGIDA;
        }
        //else
        //IMPLEMENTAR OUTRAS
    }

    private void resolverJogo() {
        Tabela t = null;
        if (metodoSol == MetodoSolucao.BCEGA_PROFUNDIDADE) {
            try {
                t = res.buscaCegaProf(jogoSdk, jtxf.jftxf_tempo);
            } catch (InterruptedException ex) {
                jtxf.liberar_trancarUi(true);
                return;
            }
        }
        if (metodoSol == MetodoSolucao.BSATISF_RESTRICAO) {
            try {
                t = res.buscaSatisfRestricao(jogoSdk, jtxf.jftxf_tempo);
            } catch (InterruptedException ex) {
                jtxf.liberar_trancarUi(true);
                return;
            }
        }
        if (metodoSol == MetodoSolucao.BSATISF_RESTRINGIDA) {
            try {
                t = res.buscaSatisfRestringida(jogoSdk, jtxf.jftxf_tempo);
            } catch (InterruptedException ex) {
                jtxf.liberar_trancarUi(true);
                return;
            }
        }
        long memoria = res.getMemoria();
        long nos = res.getNos();
        long tempo = res.getTempo();
        JOptionPane.showMessageDialog(jtxf, "Memoria gasta = " + memoria + "\r\nNúmero de nós = " + nos);
        jtxf.jftxf_tempo.setText(Long.toBinaryString(tempo));
        jtxf.liberar_trancarUi(true);
        mostrarSolucao(jtxf, t);
    }

    //Preenche a tabela com o resultado do jogo
    private void mostrarSolucao(Form_sudoku jtxf, Tabela t) {
        if (t != null) {
            int dim = t.getDimensao();
            if (dim == 4) {
                jtxf.jtab_TabelaJogo.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {"A", t.getCasa(0, 0), t.getCasa(0, 1), t.getCasa(0, 2), t.getCasa(0, 3)},
                            {"B", t.getCasa(1, 0), t.getCasa(1, 1), t.getCasa(1, 2), t.getCasa(1, 3)},
                            {"C", t.getCasa(2, 0), t.getCasa(2, 1), t.getCasa(2, 2), t.getCasa(2, 3)},
                            {"D", t.getCasa(3, 0), t.getCasa(3, 1), t.getCasa(3, 2), t.getCasa(3, 3)},
                            {"E", t.getCasa(4, 0), t.getCasa(4, 1), t.getCasa(4, 2), t.getCasa(4, 3)},
                            {"F", t.getCasa(5, 0), t.getCasa(5, 1), t.getCasa(5, 2), t.getCasa(5, 3)},
                            {"G", t.getCasa(6, 0), t.getCasa(6, 1), t.getCasa(6, 2), t.getCasa(6, 3)},
                            {"H", t.getCasa(7, 0), t.getCasa(7, 1), t.getCasa(7, 2), t.getCasa(7, 3)},
                            {"I", t.getCasa(8, 0), t.getCasa(8, 1), t.getCasa(8, 2), t.getCasa(8, 3)}},
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
                            {"A", t.getCasa(0, 0), t.getCasa(0, 1), t.getCasa(0, 2), t.getCasa(0, 3), t.getCasa(0, 4), t.getCasa(0, 5), t.getCasa(0, 6), t.getCasa(0, 7), t.getCasa(0, 8)},
                            {"B", t.getCasa(1, 0), t.getCasa(1, 1), t.getCasa(1, 2), t.getCasa(1, 3), t.getCasa(1, 4), t.getCasa(1, 5), t.getCasa(1, 6), t.getCasa(1, 7), t.getCasa(1, 8)},
                            {"C", t.getCasa(2, 0), t.getCasa(2, 1), t.getCasa(2, 2), t.getCasa(2, 3), t.getCasa(2, 4), t.getCasa(2, 5), t.getCasa(2, 6), t.getCasa(2, 7), t.getCasa(2, 8)},
                            {"D", t.getCasa(3, 0), t.getCasa(3, 1), t.getCasa(3, 2), t.getCasa(3, 3), t.getCasa(3, 4), t.getCasa(3, 5), t.getCasa(3, 6), t.getCasa(3, 7), t.getCasa(3, 8)},
                            {"E", t.getCasa(4, 0), t.getCasa(4, 1), t.getCasa(4, 2), t.getCasa(4, 3), t.getCasa(4, 4), t.getCasa(4, 5), t.getCasa(4, 6), t.getCasa(4, 7), t.getCasa(4, 8)},
                            {"F", t.getCasa(5, 0), t.getCasa(5, 1), t.getCasa(5, 2), t.getCasa(5, 3), t.getCasa(5, 4), t.getCasa(5, 5), t.getCasa(5, 6), t.getCasa(5, 7), t.getCasa(5, 8)},
                            {"G", t.getCasa(6, 0), t.getCasa(6, 1), t.getCasa(6, 2), t.getCasa(6, 3), t.getCasa(6, 4), t.getCasa(6, 5), t.getCasa(6, 6), t.getCasa(6, 7), t.getCasa(6, 8)},
                            {"H", t.getCasa(7, 0), t.getCasa(7, 1), t.getCasa(7, 2), t.getCasa(7, 3), t.getCasa(7, 4), t.getCasa(7, 5), t.getCasa(7, 6), t.getCasa(7, 7), t.getCasa(7, 8)},
                            {"I", t.getCasa(8, 0), t.getCasa(8, 1), t.getCasa(8, 2), t.getCasa(8, 3), t.getCasa(8, 4), t.getCasa(8, 5), t.getCasa(8, 6), t.getCasa(8, 7), t.getCasa(8, 8)}},
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
                            {"A", t.getCasa(0, 0), t.getCasa(0, 1), t.getCasa(0, 2), t.getCasa(0, 3), t.getCasa(0, 4), t.getCasa(0, 5), t.getCasa(0, 6), t.getCasa(0, 7), t.getCasa(0, 8), t.getCasa(0, 9), t.getCasa(0, 10), t.getCasa(0, 11), t.getCasa(0, 12), t.getCasa(0, 13), t.getCasa(0, 14), t.getCasa(0, 15)},
                            {"B", t.getCasa(1, 0), t.getCasa(1, 1), t.getCasa(1, 2), t.getCasa(1, 3), t.getCasa(1, 4), t.getCasa(1, 5), t.getCasa(1, 6), t.getCasa(1, 7), t.getCasa(1, 8), t.getCasa(1, 9), t.getCasa(1, 10), t.getCasa(1, 11), t.getCasa(1, 12), t.getCasa(1, 13), t.getCasa(1, 14), t.getCasa(1, 15)},
                            {"C", t.getCasa(2, 0), t.getCasa(2, 1), t.getCasa(2, 2), t.getCasa(2, 3), t.getCasa(2, 4), t.getCasa(2, 5), t.getCasa(2, 6), t.getCasa(2, 7), t.getCasa(2, 8), t.getCasa(2, 9), t.getCasa(2, 10), t.getCasa(2, 11), t.getCasa(2, 12), t.getCasa(2, 13), t.getCasa(2, 14), t.getCasa(2, 15)},
                            {"D", t.getCasa(3, 0), t.getCasa(3, 1), t.getCasa(3, 2), t.getCasa(3, 3), t.getCasa(3, 4), t.getCasa(3, 5), t.getCasa(3, 6), t.getCasa(3, 7), t.getCasa(3, 8), t.getCasa(3, 9), t.getCasa(3, 10), t.getCasa(3, 11), t.getCasa(3, 12), t.getCasa(3, 13), t.getCasa(3, 14), t.getCasa(3, 15)},
                            {"E", t.getCasa(4, 0), t.getCasa(4, 1), t.getCasa(4, 2), t.getCasa(4, 3), t.getCasa(4, 4), t.getCasa(4, 5), t.getCasa(4, 6), t.getCasa(4, 7), t.getCasa(4, 8), t.getCasa(4, 9), t.getCasa(4, 10), t.getCasa(4, 11), t.getCasa(4, 12), t.getCasa(4, 13), t.getCasa(4, 14), t.getCasa(4, 15)},
                            {"F", t.getCasa(5, 0), t.getCasa(5, 1), t.getCasa(5, 2), t.getCasa(5, 3), t.getCasa(5, 4), t.getCasa(5, 5), t.getCasa(5, 6), t.getCasa(5, 7), t.getCasa(5, 8), t.getCasa(5, 9), t.getCasa(5, 10), t.getCasa(5, 11), t.getCasa(5, 12), t.getCasa(5, 13), t.getCasa(5, 14), t.getCasa(5, 15)},
                            {"G", t.getCasa(6, 0), t.getCasa(6, 1), t.getCasa(6, 2), t.getCasa(6, 3), t.getCasa(6, 4), t.getCasa(6, 5), t.getCasa(6, 6), t.getCasa(6, 7), t.getCasa(6, 8), t.getCasa(6, 9), t.getCasa(6, 10), t.getCasa(6, 11), t.getCasa(6, 12), t.getCasa(6, 13), t.getCasa(6, 14), t.getCasa(6, 15)},
                            {"H", t.getCasa(7, 0), t.getCasa(7, 1), t.getCasa(7, 2), t.getCasa(7, 3), t.getCasa(7, 4), t.getCasa(7, 5), t.getCasa(7, 6), t.getCasa(7, 7), t.getCasa(7, 8), t.getCasa(7, 9), t.getCasa(7, 10), t.getCasa(7, 11), t.getCasa(7, 12), t.getCasa(7, 13), t.getCasa(7, 14), t.getCasa(7, 15)},
                            {"I", t.getCasa(8, 0), t.getCasa(8, 1), t.getCasa(8, 2), t.getCasa(8, 3), t.getCasa(8, 4), t.getCasa(8, 5), t.getCasa(8, 6), t.getCasa(8, 7), t.getCasa(8, 8), t.getCasa(8, 9), t.getCasa(8, 10), t.getCasa(8, 11), t.getCasa(8, 12), t.getCasa(8, 13), t.getCasa(8, 14), t.getCasa(8, 15)},
                            {"J", t.getCasa(9, 0), t.getCasa(9, 1), t.getCasa(9, 2), t.getCasa(9, 3), t.getCasa(9, 4), t.getCasa(9, 5), t.getCasa(9, 6), t.getCasa(9, 7), t.getCasa(9, 8), t.getCasa(9, 9), t.getCasa(9, 10), t.getCasa(9, 11), t.getCasa(9, 12), t.getCasa(9, 13), t.getCasa(9, 14), t.getCasa(9, 15)},
                            {"K", t.getCasa(10, 0), t.getCasa(10, 1), t.getCasa(10, 2), t.getCasa(10, 3), t.getCasa(10, 4), t.getCasa(10, 5), t.getCasa(10, 6), t.getCasa(10, 7), t.getCasa(10, 8), t.getCasa(10, 9), t.getCasa(10, 10), t.getCasa(10, 11), t.getCasa(10, 12), t.getCasa(10, 13), t.getCasa(10, 14), t.getCasa(10, 15)},
                            {"L", t.getCasa(11, 0), t.getCasa(11, 1), t.getCasa(11, 2), t.getCasa(11, 3), t.getCasa(11, 4), t.getCasa(11, 5), t.getCasa(11, 6), t.getCasa(11, 7), t.getCasa(11, 8), t.getCasa(11, 9), t.getCasa(11, 10), t.getCasa(11, 11), t.getCasa(11, 12), t.getCasa(11, 13), t.getCasa(11, 14), t.getCasa(11, 15)},
                            {"M", t.getCasa(12, 0), t.getCasa(12, 1), t.getCasa(12, 2), t.getCasa(12, 3), t.getCasa(12, 4), t.getCasa(12, 5), t.getCasa(12, 6), t.getCasa(12, 7), t.getCasa(12, 8), t.getCasa(12, 9), t.getCasa(12, 10), t.getCasa(12, 11), t.getCasa(12, 12), t.getCasa(12, 13), t.getCasa(12, 14), t.getCasa(12, 15)},
                            {"N", t.getCasa(13, 0), t.getCasa(13, 1), t.getCasa(13, 2), t.getCasa(13, 3), t.getCasa(13, 4), t.getCasa(13, 5), t.getCasa(13, 6), t.getCasa(13, 7), t.getCasa(13, 8), t.getCasa(13, 9), t.getCasa(13, 10), t.getCasa(13, 11), t.getCasa(13, 12), t.getCasa(13, 13), t.getCasa(13, 14), t.getCasa(13, 15)},
                            {"O", t.getCasa(14, 0), t.getCasa(14, 1), t.getCasa(14, 2), t.getCasa(14, 3), t.getCasa(14, 4), t.getCasa(14, 5), t.getCasa(14, 6), t.getCasa(14, 7), t.getCasa(14, 8), t.getCasa(14, 9), t.getCasa(14, 10), t.getCasa(14, 11), t.getCasa(14, 12), t.getCasa(14, 13), t.getCasa(14, 14), t.getCasa(14, 15)},
                            {"P", t.getCasa(15, 0), t.getCasa(15, 1), t.getCasa(15, 2), t.getCasa(15, 3), t.getCasa(15, 4), t.getCasa(15, 5), t.getCasa(15, 6), t.getCasa(15, 7), t.getCasa(15, 8), t.getCasa(15, 9), t.getCasa(15, 10), t.getCasa(15, 11), t.getCasa(15, 12), t.getCasa(15, 13), t.getCasa(15, 14), t.getCasa(15, 15)}
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
        }else
          JOptionPane.showMessageDialog(jtxf," Solução não encontrada !");  
    } 

    boolean estadoInicialValido() {
        int dim = jogoSdk.getDimensao();
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (jogoSdk.getCasaI(i, j) < 0 || jogoSdk.getCasaI(i, j) > dim) {
                    return false;
                }
            }
        }
        return res.estadoValido(jogoSdk);
    }
}

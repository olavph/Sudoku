/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Form_sudoku.java
 *
 * Created on 30/08/2011, 15:21:29
 */
package sudoku;


/**
 *
 * @author Usuario
 */
public class Form_sudoku extends javax.swing.JFrame {

    private String metodo;
    /** Creates new form Form_sudoku */
    public Form_sudoku() {
        initComponents();
                  
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtab_TabelaJogo = new javax.swing.JTable();
        btn_comecar = new javax.swing.JButton();
        btn_parar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jftxf_tempo = new javax.swing.JFormattedTextField();
        txf_metodo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txf_dimensao = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_arquivo = new javax.swing.JMenu();
        jmi_sair = new javax.swing.JMenuItem();
        jm_opcoes = new javax.swing.JMenu();
        jm_metodoSol = new javax.swing.JMenu();
        jmi_BCegaProfundidade = new javax.swing.JMenuItem();
        jmi_BSatifsRestrita = new javax.swing.JMenuItem();
        jmi_BSatisfRestringida = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jmi_4x4 = new javax.swing.JMenuItem();
        jmi_9x9 = new javax.swing.JMenuItem();
        jmi_16x16 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SUDOKU");
        setResizable(false);

        jtab_TabelaJogo.setBackground(new java.awt.Color(255, 255, 204));
        jtab_TabelaJogo.setForeground(new java.awt.Color(0, 51, 255));
        jtab_TabelaJogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"A", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"B", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"C", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"D", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"E", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"F", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"G", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"H", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"I", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"J", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"K", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"L", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"M", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"N", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"O", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtab_TabelaJogo.setToolTipText("");
        jtab_TabelaJogo.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jtab_TabelaJogo);

        btn_comecar.setText("Solucionar");
        btn_comecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_comecarActionPerformed(evt);
            }
        });

        btn_parar.setText("Parar");
        btn_parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pararActionPerformed(evt);
            }
        });

        jLabel1.setText("Tempo");

        jLabel2.setText("Método Escolhido");

        jftxf_tempo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));
        jftxf_tempo.setText("00:00:00");
        jftxf_tempo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jftxf_tempo.setEnabled(false);

        txf_metodo.setText("BCEP");
        txf_metodo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txf_metodo.setEnabled(false);

        jLabel3.setText("Dimensão");

        txf_dimensao.setText("16x16");
        txf_dimensao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txf_dimensao.setEnabled(false);

        jm_arquivo.setText("Arquivo");

        jmi_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jmi_sair.setText("Sair");
        jmi_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_sairActionPerformed(evt);
            }
        });
        jm_arquivo.add(jmi_sair);

        jMenuBar1.add(jm_arquivo);

        jm_opcoes.setText("Opções");

        jm_metodoSol.setText("Método de solução");

        jmi_BCegaProfundidade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jmi_BCegaProfundidade.setText("Busca Cega em Profundidade");
        jmi_BCegaProfundidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_BCegaProfundidadeActionPerformed(evt);
            }
        });
        jm_metodoSol.add(jmi_BCegaProfundidade);

        jmi_BSatifsRestrita.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        jmi_BSatifsRestrita.setText("Busca Com Satifação de restrição variavel restrita");
        jmi_BSatifsRestrita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_BSatifsRestritaActionPerformed(evt);
            }
        });
        jm_metodoSol.add(jmi_BSatifsRestrita);

        jmi_BSatisfRestringida.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        jmi_BSatisfRestringida.setText("Busca Com Satifação de restrição variavel restringida");
        jmi_BSatisfRestringida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_BSatisfRestringidaActionPerformed(evt);
            }
        });
        jm_metodoSol.add(jmi_BSatisfRestringida);

        jm_opcoes.add(jm_metodoSol);

        jMenu1.setText("Dimensão Tabela de Jogo");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jmi_4x4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.ALT_MASK));
        jmi_4x4.setText("4x4");
        jmi_4x4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_4x4ActionPerformed(evt);
            }
        });
        jMenu1.add(jmi_4x4);

        jmi_9x9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.ALT_MASK));
        jmi_9x9.setText("9x9");
        jmi_9x9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_9x9ActionPerformed(evt);
            }
        });
        jMenu1.add(jmi_9x9);

        jmi_16x16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.ALT_MASK));
        jmi_16x16.setText("16x16");
        jmi_16x16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_16x16ActionPerformed(evt);
            }
        });
        jMenu1.add(jmi_16x16);

        jm_opcoes.add(jMenu1);

        jMenuBar1.add(jm_opcoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_comecar, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(btn_parar, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(txf_metodo, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jftxf_tempo, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(txf_dimensao, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btn_comecar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_parar)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jftxf_tempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txf_metodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txf_dimensao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmi_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_sairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmi_sairActionPerformed

    private void jmi_BCegaProfundidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_BCegaProfundidadeActionPerformed
        metodo =  "CEGA_PROF";
        txf_metodo.setText("BCEP");
    }//GEN-LAST:event_jmi_BCegaProfundidadeActionPerformed

    private void jmi_BSatifsRestritaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_BSatifsRestritaActionPerformed
        metodo =  "SATIS_RESTRICAO";
        txf_metodo.setText("BSRVRestrita");
    }//GEN-LAST:event_jmi_BSatifsRestritaActionPerformed

    private void jmi_BSatisfRestringidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_BSatisfRestringidaActionPerformed
        metodo =  "SATIS_RESTRINGIDA";
        txf_metodo.setText("BSRVRestringida");
    }//GEN-LAST:event_jmi_BSatisfRestringidaActionPerformed

    private void btn_comecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_comecarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_comecarActionPerformed

    private void btn_pararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pararActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pararActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jmi_9x9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_9x9ActionPerformed
        txf_dimensao.setText("9x9");
    }//GEN-LAST:event_jmi_9x9ActionPerformed

    private void jmi_16x16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_16x16ActionPerformed
        txf_dimensao.setText("16x16");
    }//GEN-LAST:event_jmi_16x16ActionPerformed

    private void jmi_4x4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_4x4ActionPerformed
        txf_dimensao.setText("4x4");
    }//GEN-LAST:event_jmi_4x4ActionPerformed

  
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Form_sudoku().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_comecar;
    private javax.swing.JButton btn_parar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jftxf_tempo;
    private javax.swing.JMenu jm_arquivo;
    private javax.swing.JMenu jm_metodoSol;
    private javax.swing.JMenu jm_opcoes;
    private javax.swing.JMenuItem jmi_16x16;
    private javax.swing.JMenuItem jmi_4x4;
    private javax.swing.JMenuItem jmi_9x9;
    private javax.swing.JMenuItem jmi_BCegaProfundidade;
    private javax.swing.JMenuItem jmi_BSatifsRestrita;
    private javax.swing.JMenuItem jmi_BSatisfRestringida;
    private javax.swing.JMenuItem jmi_sair;
    private javax.swing.JTable jtab_TabelaJogo;
    private javax.swing.JTextField txf_dimensao;
    private javax.swing.JTextField txf_metodo;
    // End of variables declaration//GEN-END:variables
}

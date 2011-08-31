/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

public class Interfaceador implements Runnable {

    private Tabela jogoSdk;
    private MetodoSolucao metodoSol;
    private Solucionador res;
    
    public Interfaceador(int dim ,String[][] estI, String metodo) {
        jogoSdk = new Tabela(dim);
        preencheerTabela(estI);
        setarMetodoSol(metodo);
        
    }
    
    public void preencheerTabela(String[][] estadoI)
    {
        
    }

    @Override
    public void run() {
       resolverJogo ();
       
    }

    private void setarMetodoSol(String metodo) {
        if(metodo.equalsIgnoreCase("CEGA_PROF"))
            metodoSol = MetodoSolucao.BCEGA_PROFUNDIDADE;
        else if(metodo.equalsIgnoreCase("SATIS_RESTRICAO"))
            metodoSol = MetodoSolucao.BSATISF_RESTRICAO;
        else if(metodo.equalsIgnoreCase("SATIS_RESTRINGIDA"))
            metodoSol = MetodoSolucao.BSATISF_RESTRINGIDA;
        //else
            //IMPLEMENTAR OUTRAS
    }

    private void resolverJogo() {
        if(metodoSol == MetodoSolucao.BCEGA_PROFUNDIDADE)
            res.buscaCegaProf(jogoSdk);
        if(metodoSol == MetodoSolucao.BSATISF_RESTRICAO)
            res.buscaSatisfRestricao(jogoSdk);
        if(metodoSol == MetodoSolucao.BSATISF_RESTRINGIDA)
            res.buscaSatisfRestringida(jogoSdk);
    }
}

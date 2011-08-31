/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

public class Casa {

    private int numero;
    private int quadrante;
    private boolean preenchido;
    

    public Casa() {
        preenchido = false;
        numero = 0;//default para nao preenchido
        quadrante = 0;//default não preeenchido
    }
 
    public int getNumero() {
        return numero;
    }

    public boolean estaPreenchido() {
        return preenchido;
    }

    public void setNumero(int n) {
        numero = n;
        preenchido = true;
    }
    
    public int getQuadrante(){
        return quadrante;
    }
    
    public void setQuadrante(int q){
        quadrante = q;
    }
}
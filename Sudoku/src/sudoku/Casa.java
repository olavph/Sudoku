/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

public class Casa {

    private int numero;

    public Casa() {
        numero = 0;//default para nao preenchido
    }
    
    public Casa(int numero) {
        this.numero = numero;
    }
    
    public Casa(String numero) {
        setNumero(numero);
    }
 
    public Casa(Casa original) {
		numero = original.numero;
	}

	public int getNumero() {
        return numero;
    }

    public boolean estaPreenchida() {
        return numero != 0;
    }

    public void setNumero(String n) {
        try {
        	numero = Integer.parseInt(n);
        } catch(NumberFormatException ex) {
            numero = 0;
        }
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
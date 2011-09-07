/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

public class Tabela {

    private Casa[][] casas;
    private int dimensao;

    //faz a alocação de toda a tabela instanciando todas as casas conforme a dimensao 
    //e evidencia o quadrante a qual cada casa pertence
    public Tabela(int n, String[][] estI) {
        casas = new Casa[n][n];
        dimensao = n;

        switch (n) {
            case 4:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        casas[i][j] = new Casa();
                        if (estI[i][j] != null) {
                            casas[i][j].setNumero(estI[i][j]);
                        }
                        if ((i == 0 || i == 1)) {
                            if (j == 0 || j == 1) {
                                casas[i][j].setQuadrante(1);

                            } else {
                                casas[i][j].setQuadrante(3);
                            }
                        } else {
                            if (j == 0 || j == 1) {
                                casas[i][j].setQuadrante(2);
                            } else {
                                casas[i][j].setQuadrante(4);
                            }
                        }
                    }
                }
                break;
            case 9:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        casas[i][j] = new Casa();
                        if (estI[i][j] != null) {
                            casas[i][j].setNumero(estI[i][j]);
                        }
                        if ((i == 0 || i == 1 || i == 2)) {//primeiras 3 linhas
                            if (j == 0 || j == 1 || j == 2) {//primeiras 3 colunas
                                casas[i][j].setQuadrante(1);
                            } else if (j == 3 || j == 4 || j == 5) {//3 colunas do meio
                                casas[i][j].setQuadrante(2);
                            } else {                                //3 colunas finais
                                casas[i][j].setQuadrante(3);
                            }
                        } else if (i == 3 || i == 4 || i == 5) {// 3 linhas do meio
                            if (j == 0 || j == 1 || j == 2) {//primeiras 3 colunas
                                casas[i][j].setQuadrante(4);
                            } else if (j == 3 || j == 4 || j == 5) {//3 colunas do meio
                                casas[i][j].setQuadrante(5);
                            } else {
                                casas[i][j].setQuadrante(6);
                            }
                        } else {//3 ultimas linhas
                            if (j == 0 || j == 1 || j == 2) {//primeiras 3 colunas
                                casas[i][j].setQuadrante(7);
                            } else if (j == 3 || j == 4 || j == 5) {//3 colunas do meio
                                casas[i][j].setQuadrante(8);
                            } else {                        //3 colunas finais
                                casas[i][j].setQuadrante(9);
                            }
                        }
                    }
                }
                break;
            case 16:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        casas[i][j] = new Casa();
                        if (estI[i][j] != null) {
                            casas[i][j].setNumero(estI[i][j]);
                        }
                        if ((i == 0 || i == 1 || i == 2 || i == 3)) {//primeiras 4 linhas
                            if (j == 0 || j == 1 || j == 2 || j == 3) {//primeiras 4 colunas
                                casas[i][j].setQuadrante(1);
                            } else if (j == 4 || j == 5 || j == 6 || j == 7) {//4 colunas do meio
                                casas[i][j].setQuadrante(2);
                            } else if (j == 8 || j == 9 || j == 10 || j == 11) {//4 colunas do meio
                                casas[i][j].setQuadrante(3);
                            } else {
                                casas[i][j].setQuadrante(4);                    //4 colunas finais
                            }
                        } else if (i == 4 || i == 5 || i == 6 || i == 7) {// 4 linhas do meio
                            if (j == 0 || j == 1 || j == 2 || j == 3) {//primeiras 4 colunas
                                casas[i][j].setQuadrante(5);
                            } else if (j == 4 || j == 5 || j == 6 || j == 7) {//4 colunas do meio
                                casas[i][j].setQuadrante(6);
                            } else if (j == 8 || j == 9 || j == 10 || j == 11) {//4 colunas do meio
                                casas[i][j].setQuadrante(7);
                            } else {
                                casas[i][j].setQuadrante(8);                    //4 colunas finais
                            }
                        } else if (i == 8 || i == 9 || i == 10 || i == 11) {// 4 linhas do meio
                            if (j == 0 || j == 1 || j == 2 || j == 3) {//primeiras 4 colunas
                                casas[i][j].setQuadrante(9);
                            } else if (j == 4 || j == 5 || j == 6 || j == 7) {//4 colunas do meio
                                casas[i][j].setQuadrante(10);
                            } else if (j == 8 || j == 9 || j == 10 || j == 11) {//4 colunas do meio
                                casas[i][j].setQuadrante(11);
                            } else {
                                casas[i][j].setQuadrante(12);                    //4 colunas finais
                            }
                        } else {//4 ultimas linhas
                            if (j == 0 || j == 1 || j == 2 || j == 3) {//primeiras 4 colunas
                                casas[i][j].setQuadrante(13);
                            } else if (j == 4 || j == 5 || j == 6 || j == 7) {//4 colunas do meio
                                casas[i][j].setQuadrante(14);
                            } else if (j == 8 || j == 9 || j == 10 || j == 11) {//4 colunas do meio
                                casas[i][j].setQuadrante(15);
                            } else {
                                casas[i][j].setQuadrante(16);                    //4 colunas finais
                            }
                        }
                    }
                }
                break;
            default:
                System.out.println("Dimensão inválida");
                break;
        }
    }

    //faz a alocação de toda a tabela instanciando todas as casas conforme a dimensao 
    //e evidencia o quadrante a qual cada casa pertence
    public Tabela(int n) {
        casas = new Casa[n][n];
        dimensao = n;
        switch (n) {
            case 4:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        casas[i][j] = new Casa();
                        if ((i == 0 || i == 1)) {
                            if (j == 0 || j == 1) {
                                casas[i][j].setQuadrante(1);
                            } else {
                                casas[i][j].setQuadrante(3);
                            }
                        } else {
                            if (j == 0 || j == 1) {
                                casas[i][j].setQuadrante(2);
                            } else {
                                casas[i][j].setQuadrante(4);
                            }
                        }
                    }
                }
                break;
            case 9:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        casas[i][j] = new Casa();
                        if ((i == 0 || i == 1 || i == 2)) {//primeiras 3 linhas
                            if (j == 0 || j == 1 || j == 2) {//primeiras 3 colunas
                                casas[i][j].setQuadrante(1);
                            } else if (j == 3 || j == 4 || j == 5) {//3 colunas do meio
                                casas[i][j].setQuadrante(2);
                            } else {                                //3 colunas finais
                                casas[i][j].setQuadrante(3);
                            }
                        } else if (i == 3 || i == 4 || i == 5) {// 3 linhas do meio
                            if (j == 0 || j == 1 || j == 2) {//primeiras 3 colunas
                                casas[i][j].setQuadrante(4);
                            } else if (j == 3 || j == 4 || j == 5) {//3 colunas do meio
                                casas[i][j].setQuadrante(5);
                            } else {
                                casas[i][j].setQuadrante(6);
                            }
                        } else {//3 ultimas linhas
                            if (j == 0 || j == 1 || j == 2) {//primeiras 3 colunas
                                casas[i][j].setQuadrante(7);
                            } else if (j == 3 || j == 4 || j == 5) {//3 colunas do meio
                                casas[i][j].setQuadrante(8);
                            } else {                        //3 colunas finais
                                casas[i][j].setQuadrante(9);
                            }
                        }
                    }
                }
                break;
            case 16:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        casas[i][j] = new Casa();
                        if ((i == 0 || i == 1 || i == 2 || i == 3)) {//primeiras 4 linhas
                            if (j == 0 || j == 1 || j == 2 || j == 3) {//primeiras 4 colunas
                                casas[i][j].setQuadrante(1);
                            } else if (j == 4 || j == 5 || j == 6 || j == 7) {//4 colunas do meio
                                casas[i][j].setQuadrante(2);
                            } else if (j == 8 || j == 9 || j == 10 || j == 11) {//4 colunas do meio
                                casas[i][j].setQuadrante(3);
                            } else {
                                casas[i][j].setQuadrante(4);                    //4 colunas finais
                            }
                        } else if (i == 4 || i == 5 || i == 6 || i == 7) {// 4 linhas do meio
                            if (j == 0 || j == 1 || j == 2 || j == 3) {//primeiras 4 colunas
                                casas[i][j].setQuadrante(5);
                            } else if (j == 4 || j == 5 || j == 6 || j == 7) {//4 colunas do meio
                                casas[i][j].setQuadrante(6);
                            } else if (j == 8 || j == 9 || j == 10 || j == 11) {//4 colunas do meio
                                casas[i][j].setQuadrante(7);
                            } else {
                                casas[i][j].setQuadrante(8);                    //4 colunas finais
                            }
                        } else if (i == 8 || i == 9 || i == 10 || i == 11) {// 4 linhas do meio
                            if (j == 0 || j == 1 || j == 2 || j == 3) {//primeiras 4 colunas
                                casas[i][j].setQuadrante(9);
                            } else if (j == 4 || j == 5 || j == 6 || j == 7) {//4 colunas do meio
                                casas[i][j].setQuadrante(10);
                            } else if (j == 8 || j == 9 || j == 10 || j == 11) {//4 colunas do meio
                                casas[i][j].setQuadrante(11);
                            } else {
                                casas[i][j].setQuadrante(12);                    //4 colunas finais
                            }
                        } else {//4 ultimas linhas
                            if (j == 0 || j == 1 || j == 2 || j == 3) {//primeiras 4 colunas
                                casas[i][j].setQuadrante(13);
                            } else if (j == 4 || j == 5 || j == 6 || j == 7) {//4 colunas do meio
                                casas[i][j].setQuadrante(14);
                            } else if (j == 8 || j == 9 || j == 10 || j == 11) {//4 colunas do meio
                                casas[i][j].setQuadrante(15);
                            } else {
                                casas[i][j].setQuadrante(16);                    //4 colunas finais
                            }
                        }
                    }
                }
                break;
            default:
                System.out.println("Dimensão inválida");
                break;
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
    public Casa[] getQuadrante(int quadr) {
        Casa[] temp = new Casa[dimensao];
        int indice = 0;
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                if (casas[i][j].getQuadrante() == quadr) {
                    temp[indice] = casas[i][j];
                    indice++;
                }

            }
        }
        return temp;
    }

    //seta o valor n de uma casa na posicao (i,j)
    public void setCasa(String n, int i, int j) {
        casas[i][j].setNumero(n);
    }

    public void setCasa(int n, int i, int j) {
        casas[i][j].setNumero(n);
    }

    //retorna uma string do elemento na casa na posicao (i,j)
    public String getCasa(int i, int j) {
        return String.valueOf(casas[i][j].getNumero());
    }

    //retorna o valor númerico de uma casa na posicao (i,j)
    public int getCasaI(int i, int j) {
        return casas[i][j].getNumero();
    }

    //retorna o valor da dimensao da tabela
    public int getDimensao() {
        return dimensao;
    }
}
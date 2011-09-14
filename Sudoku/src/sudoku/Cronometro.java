package sudoku;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFormattedTextField;

public class Cronometro extends TimerTask {
	
	private JFormattedTextField campoDeTexto;
	private Timer temporizador;
	private long tempo;
	
	public Cronometro(JFormattedTextField campoDeTexto) {
		this.campoDeTexto = campoDeTexto;
		temporizador = new Timer();
	}

	public void comeca() {
		temporizador.schedule(this, 1, 1);
		tempo = 0;
	}

	public void termina() {
		temporizador.cancel();
	}

	@Override
	public void run() {
		tempo ++;
		campoDeTexto.setText(Long.toString(tempo));
	}

}

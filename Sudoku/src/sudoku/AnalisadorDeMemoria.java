package sudoku;

import java.util.Timer;
import java.util.TimerTask;

public class AnalisadorDeMemoria extends TimerTask {
	
	private Timer temporizador;
	private long memoriaMaxima;
	
	public AnalisadorDeMemoria() {
		temporizador = new Timer();
	}

	public void comeca() {
		System.gc();System.gc();System.gc();System.gc();
		temporizador.schedule(this, 0, 20);
	}

	public void termina() {
		temporizador.cancel();
	}
	
	public long getMemoriaMaxima() {
		return memoriaMaxima;
	}

	@Override
	public void run() {
		long memoriaAtual = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		memoriaMaxima = Math.max(memoriaMaxima, memoriaAtual);
	}

}

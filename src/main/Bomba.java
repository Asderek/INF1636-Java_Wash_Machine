package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import observe.ObservableState;

public class Bomba {
	ObservableState state;
	public float BombTime;
	ControladorMaquina chefe;
	Timer t;
	
	public Bomba(ObservableState estado, ControladorMaquina controlador)
	{
		state = estado;
		chefe = controlador;
	}
	
	public void start()
	{
		state.alteraEstado(state.getState().changeState());
		BombTime = state.getState().TimeDelay;
		t = new Timer((int) ((BombTime)*1000),null);
		t.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				t.stop();
				chefe.full(false);
				
				
			}
		});
		t.start();
	}
	public void stop()
	{}
}

package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import observe.ObservableState;

public class Valvula {
	ObservableState state;
	public float FillTime;
	ControladorMaquina chefe;
	Timer t;
	
	public Valvula(ObservableState estado, ControladorMaquina controlador)
	{
		state = estado;
		chefe = controlador;
	}
	
	public void open()
	{
		state.alteraEstado(state.getState().changeState());
		FillTime = state.getState().TimeDelay;
		t = new Timer((int) ((FillTime)*1000),null);
		t.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				t.stop();
				chefe.full(true);
			}
		});
		t.start();
	}
	
	public void close()
	{}
}

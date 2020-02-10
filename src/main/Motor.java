package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import observe.ObservableState;

public class Motor {
	
	ObservableState state;
	public float EnxagueTime;
	public float CentrifugaTime;
	ControladorMaquina chefe;
	Timer t;
	
	public Motor(ObservableState estado, ControladorMaquina controlador)
	{
		state = estado;
		chefe = controlador;
	}
	
	public void stop()
	{}
	public void slow()
	{
		state.alteraEstado(state.getState().changeState());
		EnxagueTime = state.getState().TimeDelay;
		t = new Timer((int) ((EnxagueTime)*1000),null);
		t.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				t.stop();
				chefe.timeOver();
				
			}
		});
		t.start();
	}	
	public void fast(final int ciclo)
	{
		state.alteraEstado(state.getState().changeState());
		CentrifugaTime = state.getState().TimeDelay;
		t = new Timer((int) ((CentrifugaTime)*1000),null);
		t.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				t.stop();
				if (ciclo<2)
				{
					chefe.Start();
				}
				else
				{
					state.alteraEstado(state.getState().changeState("Done"));
				}
			}
		});
		t.start();
	}
}

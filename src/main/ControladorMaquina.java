package main;

import observe.ObservableState;

public class ControladorMaquina {

	public int ciclo=0;
	Motor motor;
	Bomba bomb;
	Valvula valve;
	ObservableState state;
	
	public ControladorMaquina(ObservableState estado)
	{
		state = estado;
		valve = new Valvula(state, this);
		motor = new Motor(state, this);
		bomb = new Bomba(state, this);
		Start();
		
	}
	
	public void Start()
	{
		valve.open();		
	}
	
	public void full(boolean full)
	{
		if (full == true)
		{
			valve.close();
			motor.slow();
		}
		else
		{
			bomb.stop();
			ciclo++;
			motor.fast(ciclo);
			
		}
	}
	
	public void timeOver()
	{
		motor.stop();
		bomb.start();
	}
	
	

}

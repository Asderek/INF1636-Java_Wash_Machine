package observe;

import java.util.Observable;

import states.StateController;

public class ObservableState extends Observable{
	StateController state;
	
	public ObservableState(StateController estado)
	{
		this.state = estado;
	}
	
	public void alteraEstado(StateController estado)
	{
		this.state = estado;
		setChanged();
		notifyObservers();
	}
	
	public StateController getState()
	{
		return state;
	}
	
}

package main;

import draw.WashMachine;
import observe.ObservableState;
import states.StateController;
import states.StateIdle;

public class main {

	public static void main(String[] args) {
		StateController state = new StateIdle();
		ObservableState observerState = new ObservableState(state);
		WashMachine machine = new WashMachine(observerState);
		observerState.addObserver(machine);

	}

}

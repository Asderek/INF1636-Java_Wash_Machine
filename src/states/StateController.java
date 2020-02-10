package states;

import draw.WashMachine;

public abstract class StateController {
	
	protected String ImgURL;
	public int QtdImagens;
	public float TimeDelay = 1f;
	protected WashMachine machine;
	
	public String getImageString() {
		return ImgURL;
	}
	public abstract StateController changeState();
	public StateController changeState(String s)
	{
		return null;
	}
	
	public WashMachine getMachine() {
		return machine;
	}
	public void setMachine(WashMachine machine) {
		this.machine = machine;
	}
	
	
	

}

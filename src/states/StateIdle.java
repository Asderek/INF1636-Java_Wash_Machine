package states;

public class StateIdle extends StateController{
	
	public StateIdle()
	{
		ImgURL = "Idle";
		QtdImagens = 1;
		TimeDelay = 1f;
	}

	@Override
	public StateController changeState() {
		// TODO Auto-generated method stub
		StateEnchendo state = new StateEnchendo();
		state.setMachine(machine);
		return  state;
	}
}

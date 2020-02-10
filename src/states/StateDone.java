package states;

public class StateDone extends StateController{
	
	public StateDone()
	{
		ImgURL = "Done";
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

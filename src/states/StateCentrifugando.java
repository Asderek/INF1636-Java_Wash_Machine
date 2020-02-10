package states;

public class StateCentrifugando extends StateController{
	
	public StateCentrifugando()
	{
		ImgURL = "Centrifugando ";
		QtdImagens = 10;
		TimeDelay = 0.5f;
	}

	@Override
	public StateController changeState() {
		// TODO Auto-generated method stub
		StateEnchendo state = new StateEnchendo();
		state.setMachine(machine);
		return  state;
	}
	
	public StateController changeState(String s)
	{
		if (s=="Done")
		{
			StateController state = new StateDone();
			state.setMachine(machine);
			return state;
		}
		else
			return null;
	}

}

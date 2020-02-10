package states;

public class StateEsvaziando extends StateController{

	public StateEsvaziando()
	{
		ImgURL = "Esvaziando ";
		QtdImagens = 6;
		TimeDelay = 6f;
	}
	@Override
	public StateController changeState() {
		// TODO Auto-generated method stub
		StateCentrifugando state = new StateCentrifugando();
		state.setMachine(machine);
		return  state;
		
	}

}

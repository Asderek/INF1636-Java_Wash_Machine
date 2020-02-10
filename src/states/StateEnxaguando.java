package states;

public class StateEnxaguando extends StateController {
	public StateEnxaguando()
	{
		ImgURL = "Enxaguando ";
		QtdImagens = 9;
		TimeDelay = 0.9f;
		
	}
	@Override
	public StateController changeState() {
		//TODO blah
		StateEsvaziando state = new StateEsvaziando();
		state.setMachine(machine);
		return  state;
	}
	
}

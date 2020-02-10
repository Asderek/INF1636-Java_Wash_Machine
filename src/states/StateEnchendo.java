package states;

public class StateEnchendo extends StateController{
	public StateEnchendo()
	{
		ImgURL = "Enchendo ";
		QtdImagens = 5;
		TimeDelay = 5f;
	}

	@Override
	public StateController changeState() {
		// TODO Auto-generated method stub
		StateEnxaguando state = new StateEnxaguando();
		state.setMachine(machine);
		return  state;
		
	}

}

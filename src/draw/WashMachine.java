package draw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import main.ControladorMaquina;
import observe.ObservableState;
import states.StateController;


@SuppressWarnings("serial")
public class WashMachine extends JFrame implements Observer {

    JPanel Master;
    JPanel Top;
    JPanel Back;
    final WashMachine me;
    Draw Img;
    Timer t;
    ObservableState state;
    ControladorMaquina control;
   
    public void DrawWash(StateController estado)
    {
        Img = new Draw(estado.getImageString()+".png");
       
        Master = new JPanel();
        Top = new JPanel();
        JPanel Bot = new JPanel();
       
        int IdleWidth, IdleHeight;

        IdleWidth = Img.getImage().getWidth(null);
        IdleHeight = Img.getImage().getHeight(null);
       
        Top.setLayout(null);
        Top.setPreferredSize(new Dimension(IdleWidth, IdleHeight));

        Bot.setLayout(null);
        Bot.setPreferredSize(new Dimension(IdleWidth, 30));
       
        Master.setLayout(null);
        Master.setPreferredSize(new Dimension(IdleWidth, IdleHeight+30));
       
       
        JButton but = new JButton("Start");
        Bot.add(but);
        but.setBounds(1, 1, 100, 30);
        but.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	state.getState().setMachine(me);
            	System.out.println("click");
            	if (control==null)
            		control = new ControladorMaquina(state);
            	else
            	{
            		control.ciclo=1;
            		control.Start();
            	}
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {   
            }
        });
           
        Img.setOpaque(false);
        Top.add(Img);
        Img.setBounds(0,0, IdleWidth,IdleHeight );
        Master.add(Top);
        Top.setBounds(0, 0, IdleWidth, IdleHeight);
       
        Master.add(Bot);
        Bot.setBounds(0, IdleHeight+1, IdleWidth, 30);
       
        Master.setSize(IdleWidth, IdleHeight+30);
        this.add(Master);
        Master.setBounds(0,0,IdleWidth,IdleHeight+30);

        /*Essa Parte seta as configurações da Janela*/
        setTitle("WorkingAtTheClothesWash");
        setSize(IdleWidth,IdleHeight+30);
        //setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(new Color(0,0,0));
       
        pack();
        setVisible(true);
    }
   
    public WashMachine(ObservableState estado)
    {
        me = this;
        this.state = estado;
        DrawWash(estado.getState());
       
    }
   
    public void ChangeImg(String string)
    {
        Top.remove(Img);
        Master.remove(Top);
        this.remove(Master);
       
        Img = new Draw(string);
        Top.add(Img);
        Img.setBounds(0,0,Img.getImage().getWidth(null),Img.getImage().getHeight(null));
        Master.add(Top);
        Top.setBounds(0,0,Img.getImage().getWidth(null),Img.getImage().getHeight(null));
        this.add(Master);
        Master.setBounds(0,0,Img.getImage().getWidth(null),Img.getImage().getHeight(null)+30);
        repaint();
       
       
    }

    @Override
    public void update(Observable estado, Object arg) {
        if (estado == state)
        {
        	final StateController current = state.getState();
    		final Timer t = new Timer((int) ((current.TimeDelay)*1000/current.QtdImagens),null);
    		t.addActionListener(new ActionListener() {
    			int i=1;
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				if (current.QtdImagens != 1)
    				{
    					if (i>current.QtdImagens)
    					{
    						t.stop();	
    					}
    					else
    					{
    						ChangeImg(current.getImageString()+i+".png");
    						i++;
    					}
    					
    				}
    				else
    				{
    					ChangeImg(current.getImageString()+".png");
    					t.stop();
    				}
    				
    				
    			}
    		});
    		t.start();
    		
    	}
    		
       
    }


}
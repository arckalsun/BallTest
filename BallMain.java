package BallDemoTest;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class BallMain
{

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
				{
					public void run()
					{
						JFrame frame =  new BallFrame();
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				}
				);

	}

}

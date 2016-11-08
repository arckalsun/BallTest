package BallDemoTest;

import java.awt.*;

public class BallRunnable implements Runnable
{
	private BallDemo ball;
	private BallComponent c;

	private int time_interval = 20;

	public BallRunnable(BallComponent bcomp, BallDemo bball)
	{
		ball = bball;
		c = bcomp;
	}

	public void update(int ms) throws InterruptedException
	{

		
		ball.move(c.getBounds());
		// ™zœy
		int t = ms;
		while (c.detect() && t >= 2)
		{
			ball.move(c.getBounds());
			c.repaint();
			Thread.sleep(t);
			t -= 1;
			//System.out.println(t+" ");
		} 
		
		
		// ¸üÐÂ®‹Ãæ
		c.repaint();
		Thread.sleep(ms);
	}

	public void run()
	{

		try
		{
			while (true)
			{
				update(time_interval);

			}

		} catch (Exception e)
		{
			e.printStackTrace(System.out);
		}
	}

}

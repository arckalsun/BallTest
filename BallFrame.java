package BallDemoTest;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class BallFrame extends JFrame
{
	private BallComponent comp;
	
	//private int time_interval = 20;
	
	public BallFrame()
	{
		setTitle("做阻尼运动的二维动量小球完全弹性碰撞测试");
		comp = new BallComponent();
		add(comp, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Start", new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				addBall();
			}
		});

		addButton(buttonPanel, "Close", new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
		add(buttonPanel, BorderLayout.SOUTH);
		pack();

	}

	/**
	 * Adds a button to a container.
	 * 
	 * @param c
	 *            the container
	 * @param title
	 *            the button title
	 * @param listener
	 *            the action listener for the button
	 */
	public void addButton(Container c, String title, ActionListener listener)
	{
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}

	/**
	 * Adds a bouncing ball to the canvas and starts a thread to make it bounce
	 */
	public void addBall()
	{
		BallDemo b = new BallDemo();
		comp.add(b);
		Runnable r = new BallRunnable(comp,b);
		Thread t = new Thread(r);
		t.start();
	}
}

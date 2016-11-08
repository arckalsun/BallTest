package BallDemoTest;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class BallComponent extends JPanel
{
	private static final int DEFAULT_WIDTH = 450;
	private static final int DEFAULT_HEIGHT = 350;

	private java.util.List<BallDemo> balls = new ArrayList<>();
	
	public BallComponent()
	{
		this.setBackground(Color.BLACK);
	}
	public void add(BallDemo b)
	{
		balls.add(b);
	}

	// 输入两个运动的点，返回两个运动的点
	public BallPairs collide(BallDemo bd1, BallDemo bd2)
	{
		// b1
		double x1 = bd1.x;
		double y1 = bd1.y;
		double ux = bd1.Vx;
		double uy = bd1.Vy;
		// b2
		double x2 = bd2.x;
		double y2 = bd2.x;
		double vx = bd2.Vx;
		double vy = bd2.Vy;

		double ux_ = vx;
		double uy_ = uy;
		double vx_ = ux;
		double vy_ = vy;
		if (ux == 0 && uy == 0)
		{
			ux_ = vx;
			uy_ = vy;
			vx_ = 0;
			vy_ = 0;
		}
		if (vx == 0 && vy == 0)
		{
			vx_ = ux;
			vy_ = uy;
			ux_ = 0;
			uy_ = 0;
		}
		return new BallPairs(new BallPoint(x1, y1, ux_, uy_), new BallPoint(x2, y2, vx_, vy_));

	}
	/**
	 * 
	 * @param interval
	 * @return false 無處理
	 * @throws InterruptedException 
	 * 				
	 */
	public boolean detect() 
	{
		if (balls.size() < 2)
			return false;

		for (int i = 0; i < balls.size() - 1; i++)
		{
			for (int j = i + 1; j < balls.size(); j++)
			{
				double distance = Math.sqrt((balls.get(i).x - balls.get(j).x) * (balls.get(i).x - balls.get(j).x)
						+ (balls.get(i).y - balls.get(j).y) * (balls.get(i).y - balls.get(j).y));
				double d = BallDemo.d;

				if (distance <= d * 1.1)
				{
					if (distance >d*1.001)
					{
						
						return true;
					}
					
					
					if (distance <= d*1.001 && distance >= d * 0.9)
					{
						//System.out.println("碰撞前 " + i + "：" + balls.get(i).Vx + ", " + balls.get(i).Vy + "。\t" + j + "："
								//+ balls.get(j).Vx + ", " + balls.get(j).Vy);

						// 速度都不為0
						BallPairs b = collide(balls.get(i), balls.get(j));

						balls.get(i).Vx = b.b1.ux;
						balls.get(i).Vy = b.b1.uy;
						balls.get(j).Vx = b.b2.ux;
						balls.get(j).Vy = b.b2.uy;
						//System.out.println("碰撞后 " + i + "：" + balls.get(i).Vx + ", " + balls.get(i).Vy + "。\t" + j + "："
								//+ balls.get(j).Vx + ", " + balls.get(j).Vy);
					}
				}
			}

		}
		//Thread.sleep(interval);
		return false;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (BallDemo b : balls)
		{
			g2.setColor(b.color);
			g2.fill(b.getSharp());
		}
		// detect();

	}

	public Dimension getPreferredSize()
	{
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}

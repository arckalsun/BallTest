package BallDemoTest;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.*;

public class BallDemo 
{
	public double x = 0;
	public double y = 0;
	// �ɫ
	public Color color;
	Random random = new Random();
	
	
	// ֱ��
	public static double d = 100;
	// �ٶ�
	public double Vx = 5;
	public double Vy = 3;
	// ���ټ��ٶ�
	public double ax = 0.001;
	public double ay = 0.001;


	

	public BallDemo()
	{
		this.color = new Color(random.nextInt(254), random.nextInt(254), random.nextInt(254));
		
	}

	public void move(Rectangle2D bounds)
	{
		
				// �ƶ�
				x += Vx ;
				y += Vy ;
				// ����
				if (Vx > 0)
					Vx -= ax ;
				else
					Vx += ax ;

				if (Vy > 0)
					Vy -= ax ;
				else
					Vy += ax ;
				// ����Ƿ�ײǽ
				wall(bounds);
			if ( Math.abs(Vx)  < 0.0001 && Math.abs(Vy) < 0.0001 )
			{
				Vx = 0;
				Vy = 0;
			}
			
		
	}


	public void wall(Rectangle2D bounds)
	{
		if (x-d/2 < bounds.getMinX())
		{
			x = bounds.getMinX()+d/2;
			Vx = -Vx;
		}
		if (x + d/2  >= bounds.getMaxX())
		{
			x = bounds.getMaxX() - d/2 ;
			Vx = -Vx;
		}
		if (y -d/2< bounds.getMinY())
		{
			y = bounds.getMinY() +d/2;
			Vy = -Vy;
		}
		if (y + d /2 >= bounds.getMaxY())
		{
			y = bounds.getMaxY() - d/2 ;
			Vy = -Vy;
		}
	}

	public Ellipse2D getSharp()
	{
		return new Ellipse2D.Double(x-d/2, y-d/2, d, d);
	}

}

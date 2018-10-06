import java.awt.Graphics;
import java.util.ArrayList;

public class Simulation
{
	int pixels[][] = new int[640][480];
	ArrayList<Rock> rocks = new ArrayList<Rock>();
	public void simulate(Graphics gr, boolean  up, boolean down, boolean left, boolean right, boolean pleft, boolean pright)
	{
		for(Rock temp : rocks)
		{
			if(temp.isActive == false)
			{
				temp.velocity = temp.velocity -1; //accelerates rock falling down
				if(temp.y > 480)
				{
					rocks.remove(temp);
				}
			}
		}
	}
	public void createRock(boolean side)//0 is left 1 is right
	{
		for(Rock temp : rocks)
		{
			if(temp.side == side)
			{
				if(temp.isActive)
				{
					temp.isActive = false;
				}
			}
		}
		int x = side? 420: 240;
		Rock newRock = new Rock(x,0,side);
		rocks.add(newRock);
	}
}

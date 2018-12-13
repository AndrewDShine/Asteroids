
public class Ship extends SpaceObject
	{
	
		private final double ROTATION_SPEED = 0.05;
		private boolean isAcc = false;
		private int isRot = 0;
		private double velAngle = 0;
		
	public Ship(double angle, int numPoints, int [] xCord, int []yCord)
	{
		super(angle, numPoints, xCord, yCord);
		pos = new Vector(0,0);
		pos.setX(xCord[0] - 25);
		pos.setY(yCord[0]);
		vel = new Vector(0,0);
		acc = new Vector(0,0);
	}

	
	public boolean isAcc()
		{
			return isAcc;
		}
	public void setAcc(boolean isAcc)
		{
			this.isAcc = isAcc;
		}
	public int getIsRot()
		{
			return isRot;
		}
	public void setIsRot(int isRot)
		{
			this.isRot = isRot;
		}
	public void tick()
	{
		if(isRot > 0)
			{
				angle += ROTATION_SPEED;
			}
		else if(isRot < 0)
			{
				angle -= ROTATION_SPEED;
			}
		if(!isAcc)
			{
				if(speed > 0)
					{
						speed -= (speed / 45);
					}
			}
		
		vel = new Vector(speed, velAngle);
		pos.setX(pos.getX() + vel.getX());
		pos.setY(pos.getY() + vel.getY());
		
		if(pos.getX() < 0 || pos.getX() > 913 || pos.getY() < 0 || pos.getY() > 813)
			{
				if(pos.getX() < 0)
					{
						pos.setX(913);
					}
				else if(pos.getX() > 913)
					{
						pos.setX(0);
					}
				if(pos.getY() < 0)
					{
						pos.setY(813);
					}
				else if(pos.getY() > 813)
					{
						pos.setY(0);
					}
			}
		
		updatePoints();
	}
		
	}

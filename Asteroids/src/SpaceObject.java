
public abstract class SpaceObject 
	{

		protected Vector pos;
		protected Vector vel;
		protected Vector acc;

		protected int[] xCord;
		protected int[] yCord;
		protected int numPoints;
		protected double speed = 0;

		protected double angle;
		
		public SpaceObject(double angle, int numPoints, int[]xCord, int[]yCord)
		{
			this.angle = angle;	
			this.numPoints = numPoints;
			this.xCord = xCord;
			this.yCord = yCord;
		}
		
		public double getSpeed()
			{
				return speed;
			}
		public void setSpeed(double speed)
			{
				this.speed = speed;
			}
		public int[] getxCord()
			{
				return xCord;
			}
		public void setxCord(int[] xCord)
			{
				this.xCord = xCord;
			}
		public int[] getyCord()
			{
				return yCord;
			}
		public void setyCord(int[] yCord)
			{
				this.yCord = yCord;
			}
		public int getNumPoints()
			{
				return numPoints;
			}
		public void setNumPoints(int numPoints)
			{
				this.numPoints = numPoints;
			}
		public Vector getPos()
			{
				return pos;
			}
		public void setPos(Vector pos)
			{
				this.pos = pos;
			}
		public Vector getVel()
			{
				return vel;
			}
		public void setVel(Vector vel)
			{
				this.vel = vel;
			}
		public Vector getAcc()
			{
				return acc;
			}
		public void setAcc(Vector acc)
			{
				this.acc = acc;
			}
		public double getAngle()
			{
				return angle;
			}
		public void setAngle(double angle)
			{
				this.angle = angle;
				vel.setO(angle);
				updatePoints();
			}
		public void tick()
		{
			Vector v = new Vector(speed, angle);
			pos.setX(pos.getX() + v.getX());
			pos.setY(pos.getY() + v.getY());
			
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
		protected abstract void updatePoints();
		
		
		
	}

package smallfolk;




public class Hero {
	Instance callInstance = new Instance();
	int hy, hx = 400;
	double modifier = 1;
	int energy = 2000;
	int MAX_ENERGY = 2000;
	int DEPLETION_RATE = 15;
	int health = 150;
	int MAX_HEALTH = 150;
	int HERO_X, HERO_Y = 0;
	String direction = "D";
	int ANIM_STAGE = 0;
	boolean useenergy = false;
	int oldhx, oldhy = 0;
	
	String crew[] = new String[4];
	String inventory[] = new String[128];

	
	
	Hero (Instance theInstance){
		callInstance = theInstance;
	}
	String energyid = ("data/ui/energy/full.png");
	
	
	public void SetValues()
	{
		crew[0] = ("Shlomo");
		crew[1] = ("None");
		crew[2] = ("None");
		crew[3] = ("None");
		
		for (int j = 0; j < 128; j++)
			inventory[j] = ("None");
			
	}
	
	public void WalkLeft()
	{
		hx -= 2*modifier;
		if (ValidMove() == false)
			hx += 2*modifier;
		
	}
	public void WalkRight()
	{
		hx += 2*modifier;
		if (ValidMove() == false)
			hx -= 2*modifier;
	
	}
	public void WalkUp()
	{
		hy -= 2*modifier;
		if (ValidMove() == false)
			hy += 2*modifier;
	}
	public void WalkDown()
	{
		hy += 2*modifier;
		if (ValidMove() == false)
			hy -= 2*modifier;
		direction = "D";
	}
	public void UpdateSquare()
	{
		for (int a = 0; a < callInstance.roomlength; a++)
		{
			for (int b = 0; b < callInstance.roomwidth; b++)
			{
				if (hx > b*32)
				{
					if (hy > a*32)
					{
						HERO_X = b;
						HERO_Y = a;
					}
				}
			}
			
		}
	}
	public boolean ValidMove()
	{
		boolean move = true;
		useenergy = true;
		UpdateSquare();
		if (callInstance.mapmiddle[HERO_Y][HERO_X] == '1' || callInstance.mapmiddle[HERO_Y][HERO_X] == 'b' || 
			callInstance.mapmiddle[HERO_Y][HERO_X] == 'a' || callInstance.mapmiddle[HERO_Y][HERO_X] == '2' ||
			callInstance.mapmiddle[HERO_Y][HERO_X] == '3' || callInstance.mapmiddle[HERO_Y][HERO_X] == '*' ||
			callInstance.mapmiddle[HERO_Y][HERO_X] == '+' || callInstance.mapmiddle[HERO_Y][HERO_X] == 'R' ||
			callInstance.mapmiddle[HERO_Y][HERO_X] == 'S' || callInstance.mapmiddle[HERO_Y][HERO_X] == 'T' ||
			callInstance.mapmiddle[HERO_Y][HERO_X] == 'U' || callInstance.mapmiddle[HERO_Y][HERO_X] == 'V' ||
			callInstance.mapmiddle[HERO_Y][HERO_X] == 'W' || callInstance.mapmiddle[HERO_Y][HERO_X] == 'X' ||
			callInstance.mapmiddle[HERO_Y][HERO_X] == 'Y' || callInstance.mapmiddle[HERO_Y][HERO_X] == 'Z' ||
			callInstance.mapnpc[HERO_Y][HERO_X]    == '1' || callInstance.mapnpc[HERO_Y][HERO_X]    == '2' ) 
		{
			useenergy = false;
			return false;
		}
		
			
			
		return move;
	}
	public void Sprint()
	{
		if (energy >= DEPLETION_RATE && useenergy == true && (oldhx != hx || oldhy != hy))
		{
			energy-=DEPLETION_RATE;
			modifier=1.5;
		}
		else
		{
			modifier = 1;
		}
	}
	public void UpdateStats()
	{
		if (energy < MAX_ENERGY)
		{
			energy+=2;
		}
		if (health < MAX_HEALTH)
		{
			
		}
	}
	
	//UPDATE FILES
	public void UpdateFirst()
	{
		oldhx = hx;
		oldhy = hy;
	}
	
	public void UpdateModel()
	{
		
	}
	
	public void UpdateEnergyBar()
	{
		if (energy > MAX_ENERGY*(0.99))
		{
			energyid = ("data/ui/energy/full.png");
		}
		else if (energy > MAX_ENERGY*(0.95))
		{
			energyid = ("data/ui/energy/95.png");
		}
		else if (energy > MAX_ENERGY*(0.90))
		{
			energyid = ("data/ui/energy/90.png");
		}
		else if (energy > MAX_ENERGY*(0.85))
		{
			energyid = ("data/ui/energy/85.png");
		}
		else if (energy > MAX_ENERGY*(0.80))
		{
			energyid = ("data/ui/energy/80.png");
		}
		else if (energy > MAX_ENERGY*(0.75))
		{
			energyid = ("data/ui/energy/75.png");
		}
		else if (energy > MAX_ENERGY*(0.70))
		{
			energyid = ("data/ui/energy/70.png");
		}
		else if (energy > MAX_ENERGY*(0.65))
		{
			energyid = ("data/ui/energy/65.png");
		}
		else if (energy > MAX_ENERGY*(0.60))
		{
			energyid = ("data/ui/energy/60.png");
		}
		else if (energy > MAX_ENERGY*(0.55))
		{
			energyid = ("data/ui/energy/55.png");
		}
		else if (energy > MAX_ENERGY*(0.50))
		{
			energyid = ("data/ui/energy/50.png");
		}
		else if (energy > MAX_ENERGY*(0.45))
		{
			energyid = ("data/ui/energy/45.png");
		}
		else if (energy > MAX_ENERGY*(0.40))
		{
			energyid = ("data/ui/energy/40.png");
		}
		else if (energy > MAX_ENERGY*(0.35))
		{
			energyid = ("data/ui/energy/35.png");
		}
		else if (energy > MAX_ENERGY*(0.30))
		{
			energyid = ("data/ui/energy/30.png");
		}
		else if (energy > MAX_ENERGY*(0.25))
		{
			energyid = ("data/ui/energy/25.png");
		}
		else if (energy > MAX_ENERGY*(0.20))
		{
			energyid = ("data/ui/energy/20.png");
		}
		else if (energy > MAX_ENERGY*(0.15))
		{
			energyid = ("data/ui/energy/15.png");
		}
		else if (energy > MAX_ENERGY*(0.10))
		{
			energyid = ("data/ui/energy/10.png");
		}
		else if (energy > MAX_ENERGY*(0.05))
		{
			energyid = ("data/ui/energy/5.png");
		}
		else
		{
			energyid = ("data/ui/energy/empty.png");
		}
	}
}

package smallfolk;

public class Particle {
	
	int grassx[][] = new int[64][64];
	int grassy[][] = new int[64][64];
	int sway = 0, swig = 0;
	
	public void SetGrass()
	{
		for (int a = 0; a > 4; a++)
		{
			for (int b = 0; b > 4; b++)
			{
				grassx[a][b] = (a*2);
				grassy[a][b] = (b*2);
			}
		}
	}
	public void Sway()
	{
		
	}
}
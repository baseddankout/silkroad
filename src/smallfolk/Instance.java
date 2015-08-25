package smallfolk;

public class Instance
{
	LoadMap callLoadMap = new LoadMap();
	
	String location = ("Start");
	char map[][] = new char[128][128];
	char mapmiddle[][] = new char[128][128];
	char maptop[][] = new char[128][128];
	char mapnpc[][] = new char[128][128];
	int roomlength = 32;
	int roomwidth = 32;
	
	public void LoadMap()
	{
		if (location == "Start")
		{
			for (int i = 0; i < 32; i++)
			{
				for (int m = 0; m < 32; m++)
				{
					map[i][m] = callLoadMap.testmap.charAt(i*32+m);
					mapmiddle[i][m] = callLoadMap.testmapm.charAt(i*32+m);
					maptop[i][m] = callLoadMap.testmapt.charAt(i*32+m);
					
					mapnpc[i][m] = callLoadMap.testmapNPC.charAt(i*32+m);
				}
			}
		}
	}
	
	public void ClearMap()	
	{
		for (int i = 0; i < 128; i++)
		{
			for (int m = 0; m < 128; m++)
			{
				map[i][m] = 0;
			}
		}
	}
	
}

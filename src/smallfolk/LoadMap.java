package smallfolk;
import java.io.*;

import org.newdawn.slick.Image;

public class LoadMap {
	//  TEST MAP -------------------------------------------- TILE
	String testmap = ("11111111111111111111111111111111"//1
			+         "11111111111111111111111111111111"//2
			+		  "11111111111111111111111111111111"//3
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"//5
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"//10
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"//15
			+		  "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"//20
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"//25
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111"//30
			+         "11111111111111111111111111111111"
			+         "11111111111111111111111111111111");//32
	//  TEST MAP ------------------------------------------------- MIDDLE
	String testmapm = ("0000srrrrzrrrrrrrrrrrrrrrrrrt000"//1
			+         "0000p0000p001000000000000000p000"//2
			+		  "0000p0000p000010000RST000000p000"//3
			+         "0000pRST0p000000100UVW000000p000"
			+         "0000pU*W0p002110000XYZ000000p000"//5
			+         "0000pX+Z3}rrrrrrrrrzrrrrrrrru000"
			+         "0000qrrrr{000010000p000000000000"
			+         "000000000p000000200p000000000000"
			+         "000000000p002000200p000000000000"
			+         "000000000p0000300sru000000000000"//10
			+         "000000030qrrrrrrru00000000000000"
			+         "00000000000000000000000000000000"
			+         "bbibbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
			+         "00000000003000000000000000000000"
			+         "00000000000000000000000000000000"//15
			+		  "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"//20
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"//25
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"//30
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000");//32
	//  TEST MAP ------------------------------------------------- TOP
	String testmapt = ("00000000000000000000000000000000"//1
			+         "00000000000000000000000000000000"//2
			+		  "00000000000000000000000000000000"//3
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"//5
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"//10
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"//15
			+		  "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"//20
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"//25
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"//30
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000");//32
	
	String testmapNPC = ("00000000000000000031300000000000"//1
			+         "00000000000000000003000000000000"//2
			+		  "00000000000000400000000000000000"//3
			+         "00000000000004240000000000000000"
			+         "00000000000000400000000000000000"//5
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"//10
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"//15
			+		  "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"//20
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"//25
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000"//30
			+         "00000000000000000000000000000000"
			+         "00000000000000000000000000000000");//32
	
	
	
	
	public String IdTile(char t)
	{
		String path = ("data/tiles/blank.png");
		if (t == '0')//Dark black blank
		{
			path =("data/tiles/blank.png");
		}
		if (t == '1')//Basic grass
		{
			path =("data/tiles/grass.png");
		}
		
		return path;
	}
}

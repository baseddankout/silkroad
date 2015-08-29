package smallfolk;

public class Menu {
	String list[] = new String[64];
	int listx[] = new int[64];
	int listy[] = new int[64];
	String type = ("In Game");
	boolean isopen = false;
	int spot = 0, page = 0, sposx = 0, sposy = 0, position = 0;
	

public void UpdateMenu(String Giveme)
{
	type = Giveme;
	if (type == ("In Game"))
	{
		listx[0] = 699;
		listy[0] = 8;
		listx[1] = 699;
		listy[1] = 147;
		listx[2] = 699;
		listy[2] = 287;
		listx[3] = 699;
		listy[3] = 429;
		
		
		list[0] = "Crew";
		list[1] = "Items";
		list[2] = "Map";
		list[3] = "Exit";

				
	}
	if (type == ("Item"))
	{
		listx[0] = 15;
		listy[0] = 0;
		listx[1] = 240;
		listy[1] = 0;
		listx[2] = 460;
		listy[2] = 0;
		listx[3] = 720;
		listy[3] = 0;
		listx[4] = 12;
		listy[4] = 113;
		listx[5] = 233;
		listy[5] = 113;
		listx[6] = 460;
		listy[6] = 112;
		listx[7] = 683;
		listy[7] = 112;
		listx[8] = 12;
		listy[8] = 290;
		listx[9] = 232;
		listy[9] = 282;
		listx[10] = 460;
		listy[10] = 283;
		listx[11] = 685;
		listy[11] = 280;
		
		
		list[0] = "Left";
		list[1] = "";
		list[2] = "Exit";
		list[3] = "Right";
	}
}

public void UseMenu()
{
	if (isopen == true)
		isopen = false;
	else
	{
		isopen = true;
		position = 0;
	}
			
	UpdatePosition();
}	

public void UpdatePosition()
{
	if (position == 0)
	{
		sposx = listx[0];
		sposy = listy[0];
	}
	if (position == 1)
	{
		sposx = listx[1];
		sposy = listy[1];
	}
	if (position == 2)
	{
		sposx = listx[2];
		sposy = listy[2];
	}
	if (position == 3)
	{
		sposx = listx[3];
		sposy = listy[3];
	}
	if (position == 4)
	{
		sposx = listx[4];
		sposy = listy[4];
	}
	if (position == 5)
	{
		sposx = listx[5];
		sposy = listy[5];
	}
	if (position == 6)
	{
		sposx = listx[6];
		sposy = listy[6];
	}
	if (position == 7)
	{
		sposx = listx[7];
		sposy = listy[7];
	}
	if (position == 8)
	{
		sposx = listx[8];
		sposy = listy[8];
	}
	if (position == 9)
	{
		sposx = listx[9];
		sposy = listy[9];
	}
	if (position == 10)
	{
		sposx = listx[10];
		sposy = listy[10];
	}
	if (position == 11)
	{
		sposx = listx[11];
		sposy = listy[11];
	}
	spot = (position + page*24)-4;
}

public void SelectLeft()
{
	if (type == ("Item"))
	{
	if (position == 1)
	{
		position = 0;
	}
	if (position == 2)
	{
		position = 1;
	}	
	if (position == 3)
	{
		position = 2;
	}
	}
	if (position == 5)
	{
		position = 4;
	}
	if (position == 6)
	{
		position = 5;
	}	
	if (position == 7)
	{
		position = 6;
	}
	if (position == 9)
	{
		position = 8;
	}
	if (position == 10)
	{
		position = 9;
	}	
	if (position == 11)
	{
		position = 10;
	}
}

public void SelectRight()
{
	if (type == ("Item"))
	{
	if (position == 2)
	{
		position = 3;
	}
	if (position == 1)
	{
		position = 2;
	}	
	if (position == 0)
	{
		position = 1;
	}
	if (position == 6)
	{
		position = 7;
	}
	if (position == 5)
	{
		position = 6;
	}	
	if (position == 4)
	{
		position = 5;
	}
	if (position == 10)
	{
		position = 11;
	}
	if (position == 9)
	{
		position = 10;
	}	
	if (position == 8)
	{
		position = 9;
	}
	}
}
public void SelectUp()
{
	if (type == ("In Game"))
	{
	if (position == 1)
	{
		position = 0;
	}
	if (position == 2)
	{
		position = 1;
	}	
	if (position == 3)
	{
		position = 2;
	}
	}
	
	
	if (type == ("Item"))
	{
	if (position == 4)
	{
		position = 0;
	}
	if (position == 5)
	{
		position = 1;
	}	
	if (position == 6)
	{
		position = 2;
	}
	if (position == 7)
	{
		position = 3;
	}
	if (position == 8)
	{
		position = 4;
	}
	if (position == 9)
	{
		position = 5;
	}	
	if (position == 10)
	{
		position = 6;
	}
	if (position == 11)
	{
		position = 7;
	}
	}
}

public void SelectDown()
{
	if (type == ("In Game"))
	{
	if (position == 2)
	{
		position = 3;
	}
	if (position == 1)
	{
		position = 2;
	}	
	if (position == 0)
	{
		position = 1;
	}
	}
	
	if (type == ("Item"))
	{
	if (position == 7)
	{
		position = 11;
	}
	if (position == 6)
	{
		position = 10;
	}	
	if (position == 5)
	{
		position = 9;
	}
	if (position == 4)
	{
		position = 8;
	}
	if (position == 3)
	{
		position = 7;
	}
	if (position == 2)
	{
		position = 6;
	}	
	if (position == 1)
	{
		position = 5;
	}
	if (position == 0)
	{
		position = 4;
	}
	}
}

}

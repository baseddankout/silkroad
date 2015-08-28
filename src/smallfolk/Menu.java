package smallfolk;

public class Menu {
	String list[] = new String[64];
	int listx[] = new int[64];
	int listy[] = new int[64];
	String type = ("In Game");
	boolean isopen = false;
	int sposx, sposy, position = 0;
	

public void UpdateMenu()
{
	
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
}

public void SelectUp()
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

public void SelectDown()
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

}

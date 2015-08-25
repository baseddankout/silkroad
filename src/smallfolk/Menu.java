package smallfolk;

public class Menu {
	String list[] = new String[64];
	int listx[] = new int[64];
	String type = ("In Game");
	boolean isopen = false;

public void UpdateMenu()
{
	
	if (type == ("In Game"))
	{
		listx[0] = 640;
		listx[1] = 640;
		listx[2] = 640;
		listx[3] = 640;
		listx[4] = 640;
		listx[5] = 640;
		list[0] = "Resume";
		list[1] = "Character";
		list[2] = "Inventory";
		list[3] = "Crafting";
		list[4] = "Save";
		list[5] = "Debug";
				
	}
}

public void UseMenu()
{
	if (isopen == true)
		isopen = false;
	else
		isopen = true;
			
}	

}

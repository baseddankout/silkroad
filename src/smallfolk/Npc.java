package smallfolk;

public class Npc {
	Instance callInstance = new Instance();
	Hero callHero = new Hero(callInstance);
	String textid = ("data/text/navyseal.png");
	boolean talk = false;
	boolean inRange = true;
	boolean talking = false;
	Npc (Hero theHero, Instance theInstance){
		callHero = theHero;
		callInstance = theInstance;
	}
	public void callText()	{
		if (callInstance.mapnpc[callHero.HERO_Y][callHero.HERO_X+1] == '1')
		{
			renderText(1);
		}
		else if (callInstance.mapnpc[callHero.HERO_Y+1][callHero.HERO_X] == '1')
		{
			renderText(1);
		}
		else if (callInstance.mapnpc[callHero.HERO_Y][callHero.HERO_X] == '1')
		{
			renderText(1);
		}
		else if (callInstance.mapnpc[callHero.HERO_Y][callHero.HERO_X] == '1')
		{	
			renderText(1);
		}
		else{
			talking = false;
			inRange = false;
		}
			
	}
	public void renderText(int i)	{
		if (i == 1)
		{
			textid = ("data/text/navyseal.png");
		}
		inRange = true;
	}
	
	public void toggleText()	{
		if (inRange == true && talk == false)	
		{
			talking = true;
			talk = true;
		}
		else if (talk == true)
		{
			talking = false;
			talk = false;
		}
	}
}


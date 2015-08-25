package smallfolk;


 
import org.newdawn.slick.*;


public class SmallfolkGame extends BasicGame
{
	Instance callInstance = new Instance();
	LoadMap callLoadMap = new LoadMap();
	Hero callHero = new Hero(callInstance);
	Button callButton = new Button();
	Menu callMenu = new Menu();
	Npc callNpc = new Npc(callHero, callInstance);
	int globalticks = 0;
	static int height = 600;
	static int width = 900;
	static boolean fullscreen = false;
	static boolean showFPS = true;
	static String title = "Smallfolk";
	static int fpslimit = 60;
	
	Image uia, uid, uiw, uis, uiq, uispace, uileftshift, textleftshift, textspace, uie, texte, energybar, hero, menuplate, text;
	Image tiles[] = new Image[128];
	Image middle[] = new Image[128];
	Image top[] = new Image[128];
	Image npc[] = new Image[128];
	
    public SmallfolkGame()
    {
        super("Smallfolk");
    }
 
    public static void main(String[] arguments)
    {
        try
        {
            AppGameContainer app = new AppGameContainer(new SmallfolkGame());
    		app.setDisplayMode(width, height, fullscreen);
    		app.setSmoothDeltas(true);
    		app.setTargetFrameRate(fpslimit);
    		app.setShowFPS(showFPS);
            app.setDisplayMode(width, height, false);
            app.start();
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }
 
    public void menuInput(GameContainer container, Input input, int delta) throws SlickException{
    	if (input.isKeyPressed(Input.KEY_W))
    	{
    		
    	}
    	if (input.isKeyPressed(Input.KEY_S))
    	{
    		
    	}
    	if (input.isKeyPressed(Input.KEY_A))
    	{
    		
    	}
    	if(input.isKeyPressed(Input.KEY_D))
    	{
    		
    	}
    	if (input.isKeyPressed(Input.KEY_SPACE))
    	{
    		callMenu.UseMenu();
    	}
    	if (input.isKeyPressed(Input.KEY_E))
    	{
    		
    	}
    }
    
    public void gameInput(GameContainer container, Input input, int delta) throws SlickException{
    	if (input.isKeyDown(Input.KEY_W))
    	{
    		callButton.wpressed = true;
    		callHero.WalkUp();
    	}
    	else
    		callButton.wpressed = false;
    	
    	if (input.isKeyDown(Input.KEY_A))
    	{
    		callButton.apressed = true;
    		callHero.WalkLeft();
    	}
    	else
    		callButton.apressed = false;
    	
    	if (input.isKeyDown(Input.KEY_S))
    	{
    		callButton.spressed = true;
    		callHero.WalkDown();
    	}
    	else
    		callButton.spressed = false;
    	
    	if (input.isKeyDown(Input.KEY_D))
    	{
    		callButton.dpressed = true;
    		callHero.WalkRight();
    	}
    	else
    		callButton.dpressed = false;
    	
    	if (input.isKeyDown(Input.KEY_LSHIFT))
    	{
    		callButton.leftshiftpressed = true;
    		callHero.Sprint();
    	}
    	else
    	{
    		callButton.leftshiftpressed = false;
    		callHero.modifier = 1;
    	}
    	
    	if (input.isKeyPressed(Input.KEY_SPACE))
    	{
    		callButton.spacepressed = true;
    		callMenu.UpdateMenu();
    		callMenu.UseMenu();
    	}
    	else if (input.isKeyDown(Input.KEY_SPACE))
    	{
    		callButton.spacepressed = true;
    	}
    	else
    		callButton.spacepressed = false;
    	

    	if (input.isKeyDown(Input.KEY_E))
    	{
    		callButton.epressed = true;
    		if (input.isKeyPressed(Input.KEY_E))
    		{
    			callNpc.toggleText();
    		}
    	}
    	else
    		callButton.epressed = false;
    	
    	if (input.isKeyDown(Input.KEY_Q))
    	{
    		callButton.qpressed = true;
    	}
    	else
    		callButton.qpressed = false;
    }
    
    
    @Override
    public void init(GameContainer container) throws SlickException
    {	
    	uia = new Image(callButton.a);
    	uid = new Image(callButton.d);
    	uiw = new Image(callButton.w);
    	uis = new Image(callButton.s);
    	uiq = new Image(callButton.q);
    	uispace = new Image(callButton.space);
    	uileftshift = new Image(callButton.leftshift);
    	textleftshift = new Image(callButton.overlayleftshift);
    	textspace = new Image(callButton.overlayspace);
    	uie = new Image(callButton.e);
    	texte = new Image(callButton.overlaye);
    	
    	energybar = new Image("data/ui/energy/full.png");
    	hero = new Image("data/sprites/hero/downi.png");
    	menuplate = new Image("data/ui/menu/menu.png");
    	text = new Image("data/text/navyseal.png");
    	
    	for (int a = 0; a < 128; a++)
    	{
    		tiles[a] = new Image("data/tiles/dark.png");
    		middle[a] = new Image("data/tiles/blank.png");
    		top[a] = new Image("data/tiles/blank.png");
    		npc[a] = new Image("data/tiles/blank.png");
    	}
    	tiles[49] = new Image("data/tiles/grass.png");       //UNICODE 1 = GRASS
    	
    	
    	middle[49] = new Image("data/tiles/pebbles.png");    //UNICODE 1 = PEBBLES
    	middle[50] = new Image("data/tiles/rock.png");       //UNICODE 2 = ROCK
    	middle[51] = new Image("data/tiles/uglystump.png");  //UNICODE 3 = STUMP
    	middle[112] = new Image("data/tiles/path1.png");     //UNICODE p = PATH 1 V
    	middle[113] = new Image("data/tiles/path2.png");     //UNICODE q = PATH D->R
    	middle[114] = new Image("data/tiles/path3.png");     //UNICODE r = PATH 2 H
    	middle[115] = new Image("data/tiles/path4.png");     //UNICODE s = PATH U->R
    	middle[116] = new Image("data/tiles/path5.png");     //UNICODE t = PATH L->D
    	middle[117] = new Image("data/tiles/path6.png");     //UNICODE u = PATH L->U
    	middle[118] = new Image("data/tiles/path7.png");     //UNICODE v = DEADEND U
    	middle[119] = new Image("data/tiles/path8.png");     //UNICODE w = DEADEND R
    	middle[120] = new Image("data/tiles/path9.png");     //UNICODE x = DEADEND L
    	middle[121] = new Image("data/tiles/path10.png");    //UNICODE y = DEADEND D
    	middle[122] = new Image("data/tiles/path11.png");    //UNICODE z = PATH -v-
    	middle[124] = new Image("data/tiles/path12.png");    //UNICODE | = PATH -^-
    	middle[123] = new Image("data/tiles/path13.png");    //UNICODE { = PATH <|
    	middle[125] = new Image("data/tiles/path14.png");    //UNICODE } = PATH |>
 
    	middle[97] = new Image("data/tiles/water1.png");     //UNICODE a = WATER V
    	middle[98] = new Image("data/tiles/water2.png");     //UNICODE b = WATER H
    	middle[105] = new Image("data/tiles/bridge1.png");   //UNICODE i = BRIDGE V
    	
    	middle[42] = new Image("data/tiles/wooddoortop.png");   //UNICODE * = DOOR TOP
    	middle[43] = new Image("data/tiles/wooddoorbottom.png");//UNICODE + = DOOR BOT
    	middle[82] = new Image("data/tiles/wall1.png");         //UNICODE R = Wall 1
    	middle[83] = new Image("data/tiles/wall2.png");         //UNICODE S = Wall 2
    	middle[84] = new Image("data/tiles/wall3.png");         //UNICODE T = Wall 3
    	middle[85] = new Image("data/tiles/wall4.png");         //UNICODE U = Wall 4
    	middle[86] = new Image("data/tiles/wall5.png");         //UNICODE V = Wall 5
    	middle[87] = new Image("data/tiles/wall6.png");         //UNICODE W = Wall 6
    	middle[88] = new Image("data/tiles/wall7.png");         //UNICODE X = Wall 7
    	middle[89] = new Image("data/tiles/wall8.png");         //UNICODE Y = Wall 8
    	middle[90] = new Image("data/tiles/wall9.png");         //UNICODE Z = Wall 9
    	
    	npc[49] = new Image("data/npc/dank.png");
    	
    	callMenu.UpdateMenu();
    	
    }
 
    
    
    @Override
    public void update(GameContainer container, int delta) throws SlickException
    {
    	//Prioritize
    	callHero.UpdateFirst();
    	
    	//Input
    	Input input = container.getInput();
    	if (callMenu.isopen == false)
    		gameInput(container, input, delta);
    	else
    		menuInput(container, input, delta);
    	//Update 
    	callInstance.LoadMap();
    	callButton.UpdateOverlay();
    	callNpc.callText();
    	
    	
    		//Buttons
    	if (uia.equals(callButton.a))	{} else {
    		uia = new Image (callButton.a);
    	}
    	if (uiw.equals(callButton.w))	{} else {
    		uiw = new Image (callButton.w);
    	}
    	if (uis.equals(callButton.s))	{} else {
    		uis = new Image (callButton.s);
    	}
    	if (uid.equals(callButton.d))	{} else {
    		uid = new Image (callButton.d);
    	}
    	if (uiq.equals(callButton.q))	{} else	{
    		uiq = new Image(callButton.q);
    	}
    	if (uispace.equals(callButton.space))	{} else {
    		uispace = new Image (callButton.space);
    	}
    	if (uileftshift.equals(callButton.leftshift))	{} else {
    		uileftshift = new Image (callButton.leftshift);
    	}
    	if (uie.equals(callButton.e))	{} else {
    		uie = new Image (callButton.e);
    	}
    	if (texte.equals(callButton.overlaye))	{} else {
    		texte = new Image (callButton.overlaye);
    	}
    	//Reset Values
    	
    	callHero.UpdateStats();
    	callHero.UpdateEnergyBar();
    	if (callHero.energy != callHero.MAX_ENERGY)
    		energybar = new Image(callHero.energyid);
    	
    	
    	//Animato!
    	if (globalticks == 40)
    	{
    		middle[97] = new Image("data/tiles/water3.png");
    		middle[98] = new Image("data/tiles/water4.png"); 
    		globalticks++;
    	}
    	else if (globalticks == 80)
    	{
    		middle[97] = new Image("data/tiles/water5.png");
    		middle[98] = new Image("data/tiles/water6.png"); 
    		globalticks++;
    	}
    	else if (globalticks == 120)
    	{
    		middle[97] = new Image("data/tiles/water3.png");
    		middle[98] = new Image("data/tiles/water4.png"); 
    		globalticks++;
    	}
    	else if (globalticks == 160)
    	{
    		middle[97] = new Image("data/tiles/water1.png");
    		middle[98] = new Image("data/tiles/water2.png");
    		globalticks = 0;
    	}
    	else
    	{
    		globalticks++;
    	}
    }
 
    public void render(GameContainer container, Graphics g) throws SlickException
    {
    	int camx = callHero.hx-480;
    	int camy = callHero.hy-320;
    	if (callInstance.location == ("Start"))	
    	{
    		for (int a = 0; a < 32; a++)
    		{
    			for (int b = 0; b < 32; b++)
    			{
    				char tile = callInstance.map[b][a];
    				int v = (int) tile;
    				tiles[v].draw(a*32-camx,b*32-camy);
    				
    				tile = callInstance.mapmiddle[b][a];
    				v = (int) tile;
    				middle[v].draw(a*32-camx,b*32-camy);
    				
    				tile = callInstance.maptop[b][a];
    				v = (int) tile;
    				top[v].draw(a*32-camx,b*32-camy);
    		
    				tile = callInstance.mapnpc[b][a];
    				v = (int) tile;
    				npc[v].draw(a*32-camx,b*32-camy);
    			}
    		}
    		hero.draw(480-24,320-32, 1.0f);
    		energybar.draw(760,530);
    		
    		uis.draw(150,560);
    		uiw.draw(100,515);
    		uia.draw(80,560);
    		uid.draw(220,560);
    		uiq.draw(30,515);
    		uispace.draw(290, 560);
    		if (callMenu.isopen == false)
    			textspace.draw(338, 560);
    		uileftshift.draw(5, 560);
    		if (callHero.energy >= callHero.MAX_ENERGY*.95)
    			textleftshift.draw(22,564);
    		uie.draw(170,515);
    		
    		if (callMenu.isopen == true)
    		{
    			if (callMenu.type == ("In Game"))
    			{
    				menuplate.draw(600,80, 1.5f);
    				for (int x = 0; x < 6; x++)
    				{
    					g.drawString(callMenu.list[x], callMenu.listx[x], 110+(32*x));
    					//textspace.draw( callMenu.listx[x], 100+(32*x));
    				}
    			}
    		}
        	if (callNpc.talking == true)
        	{
        		text.draw(400,300);
        	}
    	}
    }
}
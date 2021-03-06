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
	Particle callParticle = new Particle();
	int globalticks = 0;
	static int height = 600;
	static int width = 900;
	static boolean fullscreen = false;
	static boolean showFPS = true;
	static String title = "Smallfolk";
	static int fpslimit = 60;
	
	Image uia, uid, uiw, uis, uiq, uispace, uileftshift, textleftshift, textspace, uie, texte, energybar, hero, menuplate, text, menuselect, crewbg, loadscreen, itemui, itemar, itemal, itemselect;
	Image ricon[] = new Image[4];
	Image tiles[] = new Image[128];
	Image middle[] = new Image[128];
	Image top[] = new Image[128];
	Image npc[] = new Image[128];
	Image grass[] = new Image[64];
	
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
    		callMenu.SelectUp();
    		callMenu.UpdatePosition();
    	}
    	if (input.isKeyPressed(Input.KEY_S))
    	{
    		callMenu.SelectDown();
    		callMenu.UpdatePosition();
    	}
    	if (input.isKeyPressed(Input.KEY_A))
    	{
    		callMenu.SelectLeft();
    		callMenu.UpdatePosition();
    	}
    	if(input.isKeyPressed(Input.KEY_D))
    	{
    		callMenu.SelectRight();
    		callMenu.UpdatePosition();
    	}
    	if (input.isKeyPressed(Input.KEY_SPACE))
    	{
    		if (callMenu.type == ("In Game"))	{
    			if (callMenu.position == 3)
        			callMenu.UseMenu();
        		if (callMenu.position == 1)
        		{
        			callMenu.UpdateMenu("Item");
    				callMenu.position = 1;
    				callMenu.UpdatePosition();
        		}
    		}
    		else if (callMenu.type == ("Item"))
    		{
    			if (callMenu.position == 2)
    			{
    				callMenu.UpdateMenu("In Game");
    				callMenu.position = 1;
    				callMenu.UpdatePosition();
    			}
    		}
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
    		String Giveme = ("In Game");
    		callMenu.UpdateMenu(Giveme);
    		callMenu.UseMenu();
    	}
    	else if (input.isKeyDown(Input.KEY_SPACE))
    	{
    		callButton.spacepressed = true;
    	}
    	else
    		callButton.spacepressed = false;
    	

    	if (input.isKeyPressed(Input.KEY_E))
    	{
    		callButton.epressed = true;
    		callNpc.toggleText();
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
    	loadscreen = new Image("data/ui/title/title.png");
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
    	itemui = new Image("data/ui/menu/itemui.png");
    	itemselect = new Image("data/ui/menu/itemselect.png");
    	itemal = new Image("data/ui/menu/larrown.png");
    	itemar = new Image("data/ui/menu/rarrown.png");
    	
    	energybar = new Image("data/ui/energy/full.png");
    	hero = new Image("data/sprites/hero/downi.png");
    	menuplate = new Image("data/ui/menu/loadout.png");
    	text = new Image("data/text/navyseal.png");
    	menuselect = new Image("data/ui/menu/loadoutselect.png");
    	crewbg = new Image("data/ui/menu/crewbg.png");
    	ricon[0] = new Image("data/ui/menu/hebrewicon.png");
    	
    	
    	for (int a = 0; a < 128; a++)
    	{
    		tiles[a] = new Image("data/tiles/dark.png");
    		middle[a] = new Image("data/tiles/blank.png");
    		top[a] = new Image("data/tiles/blank.png");
    		npc[a] = new Image("data/tiles/blank.png");
    	}
    	tiles[49] = new Image("data/tiles/grass.png");       //UNICODE 1 = GRASS
    	tiles[50] = new Image("data/tiles/grass.png");       //UNICODE 2 = TALL GRASS
    	
    	
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
    	
    	top[97] = new Image("data/tiles/roof1.png");            // a = Roof 1
    	top[98] = new Image("data/tiles/roof2.png");            // b = Roof 2
    	top[99] = new Image("data/tiles/roof3.png");            // c = Roof 3
    	top[100] = new Image("data/tiles/roof4.png");            // d = Roof 4
    	top[101] = new Image("data/tiles/roof5.png");            // e = Roof 5
    	top[102] = new Image("data/tiles/roof6.png");            // f = Roof 6
    	top[103] = new Image("data/tiles/roof7.png");            // g = Roof 7
    	top[104] = new Image("data/tiles/roof8.png");            // h = Roof 8
    	top[105] = new Image("data/tiles/roof9.png");            // i = Roof 9
    	top[106] = new Image("data/tiles/roof10.png");            // j = Roof 10
    	top[107] = new Image("data/tiles/roof11.png");            // k = Roof 11
    	top[108] = new Image("data/tiles/roof12.png");            // l = Roof 12
    	top[109] = new Image("data/tiles/roof13.png");            // m = Roof 13
    	top[110] = new Image("data/tiles/roof14.png");            // n = Roof 14
    	top[111] = new Image("data/tiles/roof15.png");            // o = Roof 15
    	top[112] = new Image("data/tiles/roof16.png");            // p = Roof 16
    	top[113] = new Image("data/tiles/roof17.png");            // q = Roof 17
    	top[114] = new Image("data/tiles/roof18.png");            // r = Roof 18
    	top[115] = new Image("data/tiles/roof19.png");            // s = Roof 19
    	top[116] = new Image("data/tiles/roof20.png");            // t = Roof 20
    	top[117] = new Image("data/tiles/roof21.png");            // u = Roof 21
    	top[118] = new Image("data/tiles/roof22.png");            // v = Roof 22
    	top[119] = new Image("data/tiles/roof23.png");            // w = Roof 23
    	top[120] = new Image("data/tiles/roof24.png");            // x = Roof 24
    	top[121] = new Image("data/tiles/roof25.png");            // y = Roof 25
    	top[122] = new Image("data/tiles/roof26.png");            // z = Roof 26
    	top[123] = new Image("data/tiles/roof27.png");            // { = Roof 27
    	
    	
    	npc[49] = new Image("data/npc/dank.png"); //1
    	npc[50] = new Image("data/npc/ron.png"); //2
    	
    	
    	/*ohhh god the roof    its like
    	 *        1 2 3
    	 *      4 5 6 7 8
    	 *    9 10 11 12 13
    	 *   14 15 16 17 18  
    	 *   19 20 21 22 23
    	 *   24 25    26 27
    	*/
    	callHero.SetValues();
    	String Giveme = ("In Game");
    	callMenu.UpdateMenu(Giveme);
    	callParticle.SetGrass();
    	for (int i = 0; i < 64; i++)
    	{
    		grass[i] = new Image("data/particle/grass.png");
    	}
    	
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
    	if (text.equals(callNpc.textid))	{} else{
    		text = new Image (callNpc.textid);
    	}
    	//Reset Values
    	
    	callHero.UpdateStats();
    	callHero.UpdateEnergyBar();
    	if (callHero.energy != callHero.MAX_ENERGY)
    		energybar = new Image(callHero.energyid);
    	
    	if (callMenu.type == ("Item"))
    	{
    		if (callMenu.position <= 3)
    		{
    	    	itemselect = new Image("data/ui/menu/topitem.png");
    		}
    		else
    			itemselect = new Image("data/ui/menu/itemselect.png");
    	}
    	
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
    	if (callInstance.startuptime > 0)
    	{
    		callInstance.startuptime--;
    		callInstance.alpha--;
    		loadscreen.draw(0,0);
    		loadscreen.setAlpha(callInstance.alpha/100);
    	}
    	else	{
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
    				
    		
    				tile = callInstance.mapnpc[b][a];
    				v = (int) tile;
    				npc[v].draw(a*32-camx,b*32-camy);
    			}
    		}
    		hero.draw(480-24,320-32, 1.0f);
    		
    		//Draw above hero
    		for (int a = 0; a < 32; a++)
    		{
    			for (int b = 0; b < 32; b++)
    			{
    				char tile = callInstance.map[b][a];
    				int v = (int) tile;
    				tile = callInstance.maptop[b][a];
    				v = (int) tile;
    				top[v].draw(a*32-camx,b*32-camy);
    			}
    		}
    		
    		energybar.draw(760,530);
    		
    		for (int a = 0; a < 32; a++)
    		{
    			for (int b = 0; b < 32; b++)
    			{
    				if (callInstance.map[b][a] == ('2'))
    				{
    					for (int i = 0; i < 4; i++)
    					{    	
    						for (int r = 0; r < 4; r++)
    						{
    							grass[a].draw(a*32-camx+(callParticle.grassx[a][b]+i*4), b*32-camy+(callParticle.grassy[a][b]+r*4));
    						}
    						
    					}
    				}
    			}	
    		}
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
    				menuplate.draw(0,0);
    				menuselect.draw(callMenu.sposx, callMenu.sposy);
    				for (int h = 0; h < 4; h++)
    				{
        				if (callHero.crew[h] == ("Shlomo"))
        				{
        					crewbg.draw(25,150+(143*h));
        					ricon[0].draw(458,193+(143*h));
        					g.drawString("Shlomo",86,160);
        				}
    				}

    			}
    			else if (callMenu.type == ("Item"))
    			{
    				itemui.draw(0,0);
    				itemal.draw(0,0);
    				itemar.draw(0,0);
    				itemselect.draw(callMenu.sposx, callMenu.sposy);
    				if (callMenu.spot > 0)
    				{
        				if (callHero.inventory[callMenu.spot] == ("None"))
        				{
        					g.drawString("Nothing: There is absolutely nothing in this spot. What are you even looking at?",50,530);
        				}
    				}

    			}
    		}
        	if (callNpc.talking == true)
        	{
        		text.draw(420,440);
        	}
    	}
    	
    	}//loadscreen shitter
    }
}
package smallfolk;

public class Button {
	String a = "data/ui/button/a/greya.png";
	String d = "data/ui/button/d/greyd.png";
	String w = "data/ui/button/w/greyw.png";
	String s = "data/ui/button/s/greys.png";
	String q = "data/ui/button/q/greyq.png";
	String space = "data/ui/button/space/greyspace.png";
	String leftshift = "data/ui/button/leftshift/greyleftshift.png";
	String overlayleftshift = "data/ui/button/leftshift/sprint.png";
	String overlayspace = "data/ui/button/menu.png";
	String e = "data/ui/button/e/greye.png";
	String overlaye = "data/blank.png";
	boolean keypressed, apressed, dpressed, wpressed, spressed, spacepressed, leftshiftpressed, epressed, qpressed = false;

	
	public void UpdateOverlay()
	{
		//WASD Overlay
		if (apressed == true)
		{
			a = "data/ui/button/a/a.png";
		}
		else
			a = "data/ui/button/a/greya.png";
		//D
		if (dpressed == true)
		{
			d = "data/ui/button/d/d.png";
		}
		else
			d = "data/ui/button/d/greyd.png";
		//W
		if (wpressed == true)
		{
			w = "data/ui/button/w/w.png";
		}
		else
			w = "data/ui/button/w/greyw.png";
		//S
		if (spressed == true)
		{
			s = "data/ui/button/s/s.png";
		}
		else
			s = "data/ui/button/s/greys.png";
		//LEFT SHIFT
		if (qpressed == true)
		{
			q = "data/ui/button/q/q.png";
		}
		else
			q = "data/ui/button/q/greyq.png";
		if (leftshiftpressed == true)
		{
			leftshift = "data/ui/button/leftshift/leftshift.png";
		}
		else
			leftshift = "data/ui/button/leftshift/greyleftshift.png";
		//SPACE
		if (spacepressed == true)
		{
			space = "data/ui/button/space/space.png";
		}
		else
			space = "data/ui/button/space/greyspace.png";
		if (epressed == true)
		{
			e = "data/ui/button/e/e.png";
		}
		else
			e = "data/ui/button/e/greye.png";
	}
}

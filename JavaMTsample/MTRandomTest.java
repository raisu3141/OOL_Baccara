import net.goui.util.MTRandom;

public class MTRandomTest
{
	public static void main(String args[])
	{
		long seed = Long.parseLong(args[0]);
		double dValue = 0.0;
 
		MTRandom rnd = new MTRandom(seed);
 
		for(int i=0; i<100; i++)
		{
			dValue = rnd.nextDouble();
			System.out.printf("%1.8f\n", dValue);
		}
	}
}

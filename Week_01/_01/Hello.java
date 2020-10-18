public class Hello
{
	static int add(int a, int b)
	{
		return a+b;
	}
	
	public static void main(String[] args)
	{
		int a = 1;
		int b = 9;
		int c = a+b;
		
		float f1 = 0.1f;
		float f2 = 11;
		float f3 = f1 * f2;
		
		int sum = 0;
		for(int i = 0; i < 10; i++)
		{
			sum += i;
		}
		
		long l1 = 111;
		long l2 = 2;
		long l3 = l1 / l2;
		
		add(15,16);
	}
}
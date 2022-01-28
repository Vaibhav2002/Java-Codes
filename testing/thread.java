package testing;

public class thread extends Thread{
	public void run()
	{
		System.out.println("Hello");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception ignored) { }
		System.out.println("Hi");
	}
	public static void main(String[] args)
	{
		Thread t1=new Thread(new thread());
		Thread t2=new Thread(new thread());
		t1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException ignored) {	}
		t2.start();
	}
}

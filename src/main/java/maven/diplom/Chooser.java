package maven.diplom;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Chooser implements Runnable {

	static volatile int count;
	private String name;
	private Random rnd;
	private Button[] btn;
	ImageView iv;
	Semaphore sem;
	boolean flag = true;
	Thread thr;
	Chooser(){}
	Chooser(String name, Button[] btn, Semaphore sem)
	{
		this.name = name;
		this.btn = btn;
		this.sem = sem;
		thr = new Thread(this);
		thr.start();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ImageView getHorse() 
	{
		
		return iv;
		
	}
	
	public boolean getAlive() 
	{
		return thr.currentThread().isAlive();
	}
	
	@Override
	public void run() {
		try {
			
			sem.acquire();
			TimeUnit.SECONDS.sleep(3);
			for(int i = 0; i < btn.length;i++) 
			{
				if(!btn[i].isDisabled()) 
				{
					iv = (ImageView) btn[i].getGraphic();
					btn[i].setDisable(true);
					break;
				}
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		sem.release();
		flag = false;
		
		
		
		
		
	}

}

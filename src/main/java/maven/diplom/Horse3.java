package maven.diplom;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;


import javafx.concurrent.Task;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

public class Horse3 extends Task {
	private ImageView selectedImage ;
	 Finish finish;
	private int random;
	private int x=0;
	private Random rnd = new Random();
	private int speed;
	private Screen screen;
	private Rectangle2D bounds;
	private String name;
	private ImageView winner;
	static boolean stop = true;
	
	
	
	
	Horse3(){}
	Horse3(String name,ImageView selectedImage, Screen screen, Finish finish, ImageView winner)
	{
		this.name = name;
		this.selectedImage = selectedImage;
		this.screen = screen;
		this.finish = finish;
		this.winner = winner;
		
		
	}
	
	public void setImage(ImageView iv) 
	{
		winner.setImage(iv.getImage());
	}
	public Image getImage() 
	{
		return winner.getImage();
	}
	
	@Override
	protected Object call() throws Exception {
		boolean b = true;
		bounds = screen.getBounds();
		random = rnd.nextInt(2) + 1;
		while(b) 
		{
			if(random == 1) 
			{
				if(bounds.getWidth() > x) 
				{
					speed = rnd.nextInt(100);
					try {
						
						x+=5;
						System.out.println("Speed " + speed);
						selectedImage.setTranslateX(x);
						TimeUnit.MILLISECONDS.sleep(speed);
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else 
				{
					break;
				}
			}else
				if(bounds.getWidth() > x) 
				{
					speed = rnd.nextInt(100);
					try {
						x+=7;
						System.out.println("Speed " + speed);
						selectedImage.setTranslateX(x);
						TimeUnit.MILLISECONDS.sleep(speed);
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else 
				{
					break;
				}
			
			
		}
		
		if(finish.flag) 
		{
			finish.flag = false;
			stop = false;
			System.out.println(name + " is winner");
			winner.setImage(selectedImage.getImage());
		}else
			System.out.println(name + " is looser");
		
		
		
		
		return null;
	}

}

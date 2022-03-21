import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;



class level1 {
	static boolean tak = true;
	static int bsize = 50;
	static int bl = 20;
	static int x=1;
	static int y=550;
	
}
class level2{
	static boolean tak=false;
	static boolean ustawienia=false;
	static int firstPlatformX= 1;
	static int firstPlatformY= 150;
	static int firstPlatformQuantity= 18;
	static int secondPlatformX= 50;
	static int secondPlatformY= 300;
	static int secondPlatformQuantity= 18;
	static int thirdPlatformX= 1;
	static int thirdPlatformY= 550;
	static int thirdPlatformQuantity= 20;
	static int bsize = 50;
}

class objects{
	
	static int netherSize = 50;
	
}

class windowSize{
	
	static int width=1000;
	static int height=600;
}

class player{
	static int x=0;
	static int y=495;
	static int size=50;
	static int v=1;
	static int power=1;
	static int hp=100;
	static int exp=0;
	static int lvl=1;
	static int lvlup=0;
	static int wtimer;
	static int wrange=0;
	static boolean wtak= true;
	static boolean wdol=false;
	static int wslow =0;
	static boolean stop = false;
	static int hptimer;
	static boolean end =false;
	static boolean sStop=false;
}
class m1{
	
	static int x=700;
	static int y=450;
	static int size=100;
	static int v=5;
	static int hp=100;
	static boolean tak= true;
}

class fire{
	static int[] liczba= new int[10];
	static int[] x = new int[10];
	static int[] y= new int[10];
	static int[] range= new int[10];
	static int size=20;
	static int v=1;
	static int timer=0;
	static int l;
	static int r=400;
}

class swi{
	static boolean tak= true;
}
	
	class meeJFrame extends JFrame implements KeyListener{

//		ma ma = new ma();
		public meeJFrame(String string) {
			
			
			addKeyListener(this);
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			char c = e.getKeyChar();
			
			if(c=='w'&&player.wtak==true) {
				if(player.y>5)
				player.wtak=false;
			}
			if(c=='s') {
				if(level1.tak==true) {
					if(player.y+player.size<=level1.y-5&&player.x<=level1.bsize*level1.x*level1.bl)
					
					player.y+=player.v;
				}
				if(level2.tak==true&&player.sStop==false) {
					player.y+=player.v;
				}
//				if(player.y<550)
				
			
			}
			if(c=='a') {
				if(player.x>5)
				player.x-=player.v;
			}
			if(c=='d') {
				if(player.x<=945&&player.stop==false)
					player.x+=player.v;
					
			}
			
			if(c=='e'&&fire.timer==0) {
				System.out.println("fireball");
				fire.liczba[fire.l]=1;
				fire.x[fire.l]=player.x+player.size;
				fire.y[fire.l]=player.y+player.size/2;
				if(fire.l==9) {
					fire.l=0;
					
				}
				else
					fire.l++;
				fire.timer=200;
			}
			
			repaint();
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	public class DungeonGame extends JPanel{
			
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(windowSize.width, windowSize.height);
			}
	
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				
			
			
			try {
				Image nether = ImageIO.read(new File("C:\\Users\\Kris\\Desktop\\Obrazki\\blackb.png"));
				Image bg1 = ImageIO.read(new File("C:\\Users\\Kris\\Desktop\\Obrazki\\background1.jpg"));
				Image mage = ImageIO.read(new File("C:\\Users\\Kris\\Desktop\\Obrazki\\mage211.png"));
				Image wsad = ImageIO.read(new File("C:\\Users\\Kris\\Desktop\\Obrazki\\wsad1.png"));
				Image e = ImageIO.read(new File("C:\\Users\\Kris\\Desktop\\Obrazki\\e.png"));
				Image mon1 = ImageIO.read(new File("C:\\Users\\Kris\\Desktop\\Obrazki\\monster11.png"));
				Image fb = ImageIO.read(new File("C:\\Users\\Kris\\Desktop\\Obrazki\\fb111.png"));
				Image lvlupp = ImageIO.read(new File("C:\\Users\\Kris\\Desktop\\Obrazki\\lvlup.jpg"));
				Image sw = ImageIO.read(new File("C:\\Users\\Kris\\Desktop\\Obrazki\\switch11.png"));
				Image exit = ImageIO.read(new File("C:\\Users\\Kris\\Desktop\\Obrazki\\exit1.png"));
				Image go = ImageIO.read(new File("C:\\Users\\Kris\\Desktop\\Obrazki\\gameover.png"));
				Image bg2 = ImageIO.read(new File("C:\\Users\\Kris\\Desktop\\Obrazki\\bg222.png"));
				Image lift = ImageIO.read(new File("C:\\Users\\Kris\\Desktop\\Obrazki\\platform11.png"));
				
				if(level1.tak==true&&player.end==false) {
					g.drawImage(bg1,0,0,getSize().width,getSize().height,null);
					g.drawImage(wsad,200,400,150,100,null);
					g.drawImage(e,500,400,50,50,null);
					g.drawImage(mage,player.x,player.y,player.size,player.size,null);
					g.setColor(Color.BLACK);
					g.fillRect(0, 0, 80, 80);
					g.setColor(Color.WHITE);
					g.drawString("LVL: "+Integer.toString(player.lvl), 20, 20);
					g.drawString("EXP: "+Integer.toString(player.exp), 20, 40);
					g.drawString("HP: "+Integer.toString(player.hp), 20, 60);
					
					if(m1.tak==true) {
						g.drawImage(mon1,m1.x,m1.y,m1.size,m1.size,null);
					}
					
					
					g.drawImage(exit,950,500,50,50,null);
					
					
					for(int i=0;i<level1.bl;i++) {
						g.drawImage(nether,i*level1.bsize,550,level1.bsize,level1.bsize,null);
						
					}
					
					for(int i=0;i<fire.liczba.length-1;i++) {
						if(fire.liczba[i]==1) {
							g.drawImage(fb,fire.x[i],fire.y[i],fire.size,fire.size,null);
						}
					}
					
					if(player.lvlup>0) {
						g.drawImage(lvlupp,450,300,100,100,null);
					}
					
					
					
				}
				if(player.end==true) {
					g.setColor(Color.white);
					g.fillRect(0, 0, 1000, 600);
					g.drawImage(go,450,300,100,100,null);
					
				}
				
				if(level2.tak==true&&player.end==false) {
					g.drawImage(bg2,0,0,getSize().width,getSize().height,null);
					g.setColor(Color.BLACK);
					g.fillRect(0, 0, 80, 80);
					g.setColor(Color.white);
					g.drawString("LVL: "+Integer.toString(player.lvl), 20, 20); 
					g.drawString("EXP: "+Integer.toString(player.exp), 20, 40);
					g.drawString("HP: "+Integer.toString(player.hp), 20, 60);
					g.drawString("X: "+Integer.toString(player.x), 20, 80);
					g.drawString("Y: "+Integer.toString(player.y), 20, 100);
					g.drawImage(mage,player.x,player.y,player.size,player.size,null);
					
					
					//Platformy Level2
					for(int i=0;i<18;i++) {
						g.drawImage(nether,i*level2.bsize,level2.firstPlatformY,level1.bsize,level1.bsize,null);
					}
					for(int i=0;i<18;i++) {
						g.drawImage(nether,i*level2.bsize+level2.secondPlatformX,level2.secondPlatformY,level1.bsize,level1.bsize,null);
					}
					for(int i=0;i<20;i++) {
						g.drawImage(nether,i*level2.bsize,level2.thirdPlatformY,level1.bsize,level1.bsize,null);
					}
					//lift
					g.drawImage(lift,900,level2.firstPlatformY,level1.bsize,20,null);
					g.drawImage(lift,950,level2.firstPlatformY,level1.bsize,20,null);
					
				}
				
			}
			
			catch (Exception e) { 
			}		
	}
			
			
			
			public void animacja() {
				
				
				while (true) {
					// fireball
					for(int i=0;i<fire.liczba.length-1;i++) {
						if(fire.liczba[i]==1) {
//							System.out.println(fire.liczba[i]+"fire l i " + i +"-i");
//							System.out.println(fire.x[i]+"x");
//							System.out.println(fire.y[i]+"y");
							fire.x[i]+=fire.v;
							fire.range[i]+=fire.v;
							if(fire.range[i]>=fire.r) {
								fire.liczba[i]=0;
								fire.x[i]=0;
								fire.y[i]=0;
								fire.range[i]=0;
							}
							if(fire.y[i]+fire.size>=m1.y&&fire.y[i]<=m1.y+m1.size&&fire.x[i]>=m1.x&&fire.x[i]<=m1.x+m1.size&&m1.tak==true) {
								m1.hp=m1.hp-20*player.power;
								fire.liczba[i]=0;
								fire.x[i]=0;
								fire.y[i]=0;
								fire.range[i]=0;
								if(m1.hp<=0) {
									m1.tak=false;
									player.exp+=100;
									if(player.exp==100) {
										player.lvl++;
										player.lvlup=500;
										player.power=2;
									}
								}
								
							}
						}
					}
					
					//w
					if(player.wtak==false&&player.wdol==false) {
						player.wslow++;
						if(player.wslow==10) {
							player.y--;
							player.wrange++;
							player.wslow=0;
						}
						if(player.wrange>=50) {
							player.wdol=true;
							player.wslow=0;
						}
					}
//					System.out.println(player.wrange+"player wrange");
					if(player.wtak==false&&player.wdol==true) {
						player.wslow++;
						if(player.wslow==10) {
						player.y++;
						player.wrange--;
						player.wslow=0;
						}
						if(player.wrange<=0) {
							player.wdol=false;
							player.wtak=true;
							player.wslow=0;
						}
					}
					
					//dmg od mobow
					if(level1.tak==true) {
						if(m1.tak==true) {
							if(player.x+player.size>=m1.x) {
								player.stop=true;
							}
							if(player.x+player.size>=m1.x&&player.hptimer==0) {
								player.hp-=10;
								player.hptimer=200;
								if(player.hp==0) {
									player.end=true;
								}
							}
							
						}
						if(player.x+player.size<=m1.x) {
							player.stop=false;
						}
					}
					
					//level2
					if(player.x>=940) {
						level2.tak=true;
						level1.tak=false;
					}
					
					if(player.hptimer>0) {
						player.hptimer--;
					}
					if(fire.timer>0) 
						fire.timer--;
					if(player.lvlup>0)
						player.lvlup--;
					if(player.wtimer>0) {
						player.wtimer--;
					}
					
					if(level2.tak==true&&level2.ustawienia==false) {
						ustawieniaLvl2();
						level2.ustawienia=true;
					}
					
					if(level2.tak==true) {
						nonTransitivePlatform1();
					}
					
					
					try {
						Thread.sleep(1); 
					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
						e.printStackTrace();
						}
					
					repaint();
					
				}
				
			}
			
			public void ustawieniaLvl2() {
				
				player.x=800;
				player.y=100;
				
				return;
				
			}
			
			public void nonTransitivePlatform1() {
				
				if(player.x<=level2.firstPlatformX*level2.bsize*level2.firstPlatformQuantity&&player.y+player.size<=level2.firstPlatformY||
						player.x<=level2.firstPlatformX*level2.bsize*level2.firstPlatformQuantity&&player.y<=level2.firstPlatformY+level2.bsize||
						player.x<=level2.firstPlatformX*level2.bsize*level2.firstPlatformQuantity&&player.y+player.size>=level2.firstPlatformY&&player.y<=level2.firstPlatformY+level2.bsize)
					player.sStop=true;
				else
					player.sStop=false;
				return;
				
			}
			
			
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DungeonGame du = new DungeonGame();
		meeJFrame window = new meeJFrame("Dung");
		window.setDefaultCloseOperation(meeJFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.add(du);
		window.pack();
		du.animacja();

	}

}


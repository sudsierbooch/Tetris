import java.awt.Point;
import java.util.ArrayList;

public class Shape {
	private int shapeColor;
	private Point one;
	private Point two;
	private Point three;
	private Point four;
	private String direction; 
	private String name; 

	public Shape(String s){
		if(s == "long"){
			shapeColor = 1;
			name = "long";
			direction = "Start";
			one = new Point(0,4);
			two = new Point(0,5);
			three = new Point(0,6);
			four = new Point(0,7);
		}
		if(s =="normL"){
			 shapeColor = 2;
			 name = "normL";
			 direction = "Start";
			 one = new Point(1,4);
			 two = new Point(0,4);
			 three = new Point(0,5);
			 four = new Point(0,6);
			// one = new Point(0,2);
			// two = new Point(0,1);
			// three = new Point(0,0);
			// four = new Point(0,3);
		}
		if(s =="backL"){
			shapeColor = 3; 
			name = "backL";
			direction = "Start";
			 one = new Point(1,6);
			 two = new Point(0,4);
			 three = new Point(0,5);
			 four = new Point(0,6);
			//one = new Point(0,8);
			//two = new Point(0,7);
		   // three = new Point(1,8);
			//four = new Point(1,9);
		}
		if(s =="tee"){
			 shapeColor = 4; 
			 name = "tee";
			 direction = "Start";
			 one = new Point(0,5);
			 two = new Point(1,4);
			 three = new Point(1,5);
			 four = new Point(1,6);
		}
		
		if(s =="box"){
			 shapeColor = 5;
			 name = "box";
			 direction = "Start";
			 one = new Point(0,4);
			 two = new Point(1,4);
			 three = new Point(0,5);
			 four = new Point(1,5);
		}
		if(s =="zee"){
			 shapeColor = 6;
			 name = "zee";
			 direction = "Start";
			 one = new Point(1,4);
			 two = new Point(1,5);
			 three = new Point(0,5);
			 four = new Point(0,6);
		}
		if(s =="backZee"){
			 shapeColor = 7;
			 direction = "Start";
			 name = "backZee";
			 one = new Point(0,4);
			 two = new Point(0,5);
			 three = new Point(1,5);
			 four = new Point(1,6);
		}
	}
	
	public int getColor(){
		return this.shapeColor;
	}
	public Point getOne(){
		return  this.one;
	}
	public Point getTwo(){
		return  this.two;
	}
	public Point getThree(){
		return  this.three;
	}
	public Point getFour(){
		return  this.four;
	}
	public String getDirection(){
		return  this.direction;
	}
	public String getName(){
		return  this.name;
	}
	
	public void setDirection(String s){
		this.direction = s;
	}
	//// list goes x1,y1,x2,y2,x3,y3,x4,y4
	public void updateShape(int[] curPos){
		this.getOne().setLocation(curPos[0]+1, curPos[1]); 
		this.getTwo().setLocation(curPos[2]+1, curPos[3]); 
		this.getThree().setLocation(curPos[4]+1, curPos[5]); 
		this.getFour().setLocation(curPos[6]+1, curPos[7]);
	}
	
	public void moveLeft(int[] curPos){
		this.getOne().setLocation(curPos[0], curPos[1]-1); 
		this.getTwo().setLocation(curPos[2], curPos[3]-1); 
		this.getThree().setLocation(curPos[4], curPos[5]-1); 
		this.getFour().setLocation(curPos[6], curPos[7]-1);
	}
	
	public void moveRight(int[] curPos){
		this.getOne().setLocation(curPos[0], curPos[1]+1); 
		this.getTwo().setLocation(curPos[2], curPos[3]+1); 
		this.getThree().setLocation(curPos[4], curPos[5]+1); 
		this.getFour().setLocation(curPos[6], curPos[7]+1);
	}
	
	public void moveDown(int[] curPos){
		this.getOne().setLocation(curPos[0]+1, curPos[1]); 
		this.getTwo().setLocation(curPos[2]+1, curPos[3]); 
		this.getThree().setLocation(curPos[4]+1, curPos[5]); 
		this.getFour().setLocation(curPos[6]+1, curPos[7]);
	}
	
	
	public boolean rotateCheck(boolean [][] bb, int[] ar){
		if(this.name=="long"){
			if(this.direction =="Start"){
				if(bb[ar[2]-1][ar[3]] || bb[ar[2]+1][ar[3]] || bb[ar[2]+2][ar[3]]){
					System.out.println("Can't rotate");
					return false;
				}else{
					System.out.println("Able to rotate");
					return true;
				}
			}
			if(this.direction == "one"){
				if(bb[ar[2]][ar[3]-1] || bb[ar[2]][ar[3]+1] || bb[ar[2]][ar[3]+2]){
					System.out.println("Can't rotate");
					return false;
				}else{
					System.out.println("Able to rotate");
					return true;
				}
			
			}
		}
		if(this.name=="normL"){
			if(this.direction =="Start"){
				if(bb[ar[2]-1][ar[3]] || bb[ar[4]-1][ar[5]] || bb[ar[4]+1][ar[5]]){
					System.out.println("Can't rotate");
					return false;
				}else{
					System.out.println("Able to rotate");
					return true;
				}
			}
			if(this.direction == "one"){
				if(bb[ar[4]][ar[5]+1] || bb[ar[6]][ar[7+1]] || bb[ar[6]][ar[7]-1]){
					System.out.println("Can't rotate");
					return false;
				}else{
					System.out.println("Able to rotate");
					return true;
				}
			}
			if(this.direction == "two"){
				if(bb[ar[4]-1][ar[5]] || bb[ar[4]-2][ar[5]]){
					System.out.println("Can't rotate");
					return false;
				}else{
					System.out.println("Able to rotate");
					return true;
				}
			}
			if(this.direction == "three"){
				if(bb[ar[4]][ar[5]+1] || bb[ar[4]][ar[5]+2]){
					System.out.println("Can't rotate");
					return false;
				}else{
					System.out.println("Able to rotate");
					return true;
				}
			}
		
		
		
		}
		if(this.name=="backL"){
			if(this.direction =="Start"){
				if(bb[ar[0]][ar[1]-1] || bb[ar[6]-1][ar[7]]){
					System.out.println("Can't rotate");
					return false;
				}else{
					System.out.println("Able to rotate");
					return true;
				}
			}
			if(this.direction =="one"){
				if(bb[ar[0]-1][ar[1]] || bb[ar[6]][ar[7]+1]){
					System.out.println("Can't rotate");
					return false;
				}else{
					System.out.println("Able to rotate");
					return true;
				}
			}
			if(this.direction =="two"){
				if(bb[ar[2]-2][ar[3]] || bb[ar[2]][ar[3]-1] || bb[ar[4]-1][ar[5]] || bb[ar[4]-2][ar[5]+1]){
					System.out.println("Can't rotate");
					return false;
				}else{
					System.out.println("Able to rotate");
					return true;
				}
			}
			if(this.direction =="three"){
				if(bb[ar[2]][ar[3]+1] || bb[ar[4]][ar[5]-1] || bb[ar[4]][ar[5]+1]){
					System.out.println("Can't rotate");
					return false;
				}else{
					System.out.println("Able to rotate");
					return true;
				}
			}
		}
		if(this.name=="tee"){
			if(this.direction =="Start"){
				if(bb[ar[4]+1][ar[5]]){
					System.out.println("Can't rotate");
					return false;
				}else{
					System.out.println("Able to rotate");
					return true;
				}
			}
			if(this.direction =="one"){
				if(bb[ar[4]][ar[5]-1]){
					System.out.println("Can't rotate");
					return false;
				}else{
					System.out.println("Able to rotate");
					return true;
				}
			}
			if(this.direction =="two"){
				if(bb[ar[4]-1][ar[5]]){
					System.out.println("Can't rotate");
					return false;
				}else{
					System.out.println("Able to rotate");
					return true;
				}
			}
			if(this.direction =="three"){
				if(bb[ar[4]][ar[5]+1]){
					System.out.println("Can't rotate");
					return false;
				}else{
					System.out.println("Able to rotate");
					return true;
				}
			}
		}
		if(this.name=="zee"){
			if(this.direction =="Start"){
				if(bb[ar[2]][ar[3]+1] || bb[ar[2]+1][ar[3]+1]){
					System.out.println("Can't rotate");
					return false;
				}else{
					System.out.println("Able to rotate");
					return true;
				}
			}
			if(this.direction =="one"){
				if(bb[ar[2]][ar[3]-1] || bb[ar[2]-1][ar[3]+1] || bb[ar[2]-1][ar[3]]){
					System.out.println("Can't rotate");
					return false;
				}else{
					System.out.println("Able to rotate");
					return true;
				}
			}
		
		}
		if(this.name=="backZee"){
			if(this.direction =="Start"){
				if(bb[ar[0]-1][ar[7]] || bb[ar[2]][ar[3]+1] || bb[ar[4]-1][ar[5]] || bb[ar[6]][ar[7]-1]){
						System.out.println("Can't rotate");
						return false;
					}else{
						System.out.println("Able to rotate");
						return true;
					}
				}
			
			if(this.direction =="one"){
				if(bb[ar[4]][ar[5]-1] || bb[ar[6]][ar[7]+1]){
					System.out.println("Can't rotate");
						return false;
					}else{
						System.out.println("Able to rotate");
						return true;
					}
				
				}
			}
			
		return false;
	
	}
}
import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;






public class Grid {
	// Array of current piece position
	private int[] curPos; 
	//2D array of int to dictate what color the boxes are
	private int [][] intBoard;
	//2D array of bools to tell is a position is locked/free
	private boolean [][] boolBoard;
	//Current shape
	private Shape curShape;
	private JButton [][] buttonBoard;
	private Thread t = new Thread();
	
	
	
	private class MKeyListener implements KeyEventDispatcher {
		

		@Override
		public boolean dispatchKeyEvent(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (e.getID() == KeyEvent.KEY_PRESSED) {
	              if(keyCode == 40 ){
					System.out.println("Down");
				
					if(!dropCheck()){
						System.out.println("pushing");
						moveDownPiece(curShape);
						recolor();
					}
	              }
	              if(keyCode == 39 ){
						System.out.println("Right");
						if(rightCheck()){
							moveRight(curShape);
						}
		           }
	              if(keyCode == 37 ){
						System.out.println("Left");
						if(leftCheck()){
							moveLeft(curShape);
						}
		           }
	              
	              if (Character.isSpaceChar(e.getKeyChar())) {
	                  System.out.println("space");
	                  if(curShape.rotateCheck(boolBoard, curPos)){
							rotate(curShape);
						}
	              }
	           // } else if (e.getID() == KeyEvent.KEY_RELEASED) {
	           //     System.out.println("2test2");
	          //  } else if (e.getID() == KeyEvent.KEY_TYPED) {
	           //     System.out.println("3test3");
	            }
	            return false;
	        }
	}
	
	
	
	
	
	
	
	
	
	
	//Constructor
	public Grid(GUI g){
		curPos = new int[10];
		intBoard = new int[20][10];
		boolBoard = new boolean[20][10];
		buttonBoard = new JButton[20][10];
		setUpButtons(g);
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MKeyListener());
	}
	
	public int[][] getIntBoard(){
		return intBoard;
	
	}
	public JButton[][] getButtonBoard(){
		return buttonBoard;
	
	}
	public void setUpButtons(GUI g){
		for(int i=0; i<20; i++){
			for(int t=0; t<10; t++){
				JButton b = new JButton();
				g.getPanel().add(b);
				b.setBackground(Color.ORANGE);
				buttonBoard[i][t] = b;			
			}	
		}
	}
	
	public void recolor(){
		for(int i=0; i<20; i++){
			for(int t=0;t<10; t++){
				if(getIntBoard()[i][t]==0){
					getButtonBoard()[i][t].setBackground(Color.DARK_GRAY);
				}
				if(getIntBoard()[i][t]==1){
					getButtonBoard()[i][t].setBackground(Color.CYAN);
				}
				if(getIntBoard()[i][t]==2){
					getButtonBoard()[i][t].setBackground(Color.MAGENTA);
				}
				if(getIntBoard()[i][t]==3){
					getButtonBoard()[i][t].setBackground(Color.BLUE);
				}
				if(getIntBoard()[i][t]==4){
					getButtonBoard()[i][t].setBackground(Color.PINK);
				}
				if(getIntBoard()[i][t]==5){
					getButtonBoard()[i][t].setBackground(Color.yellow);
				}
				if(getIntBoard()[i][t]==6){
					getButtonBoard()[i][t].setBackground(Color.RED);
				}
				if(getIntBoard()[i][t]==7){
					getButtonBoard()[i][t].setBackground(Color.GREEN);
				}
			}
		}
	}
	//////////////////////////////////////////////////////////////////////////
	//// Testing functionality of normal fall with multiple shapes
	//////////////////////////////////////////////////////////////////////////
	public void test(){
		newPiece(randInt(0,7));
		//Shape curShape = new Shape("long");
		normalFall(curShape);
		
		//curShape = new Shape("backL");
		newPiece(randInt(0,7));
		normalFall(curShape);
		newPiece(randInt(0,7));
		normalFall(curShape);
		newPiece(randInt(0,7));
		normalFall(curShape);
		newPiece(randInt(0,7));
		normalFall(curShape);
		newPiece(randInt(0,7));
		normalFall(curShape);
		newPiece(randInt(0,7));
		normalFall(curShape);
		newPiece(1);
		normalFall(curShape);
		newPiece(randInt(0,7));
		normalFall(curShape);
		newPiece(randInt(0,7));
		normalFall(curShape);
		newPiece(randInt(0,7));
		normalFall(curShape);
		newPiece(randInt(0,7));
		normalFall(curShape);
		newPiece(randInt(0,7));
		normalFall(curShape);
		newPiece(randInt(0,7));
		normalFall(curShape);
	//	newPiece(randInt(0,7));
	//	normalFall(curShape);
	//	newPiece(randInt(0,7));
	//	normalFall(curShape);
	//	newPiece(randInt(0,7));
	//	normalFall(curShape);
		//curShape = new Shape("normL");
		//newPiece(randInt(0,7));
	//	normalFall(curShape);
		//curShape = new Shape("zee");
	//	newPiece(randInt(0,7));
	//	normalFall(curShape);
	/*intBoard[10][6]=1;
			intBoard[10][7]=1;
			intBoard[10][5]=1;
			intBoard[10][4]=1;
			intBoard[10][3]=1;
			intBoard[10][2]=1;
			intBoard[10][1]=1;
			intBoard[10][0]=1;
			intBoard[10][8]=1;
			intBoard[10][9]=1;
			boolBoard[10][0]=true;
		boolBoard[10][1]=true;
		boolBoard[10][2]=true;
		boolBoard[10][3]=true;
		boolBoard[10][4]=true;
		boolBoard[10][5]=true;
		boolBoard[10][6]=true;
		boolBoard[10][7]=true;
		boolBoard[10][8]=true;
		boolBoard[10][9]=true;*/
	    intBoard[17][0]=1;
		intBoard[17][1]=1;
		intBoard[17][2]=1;
		intBoard[17][3]=1;
		intBoard[17][4]=1;
		intBoard[17][7]=1;
		intBoard[17][8]=1;
		intBoard[17][9]=1;
		//intBoard[16][1]=1;
		//intBoard[16][2]=1;
		//	boolBoard[16][1]=true;
	//	boolBoard[16][2]=true;
		boolBoard[17][0]=true;
		boolBoard[17][1]=true;
		boolBoard[17][2]=true;
		boolBoard[17][3]=true;
		boolBoard[17][4]=true;
		boolBoard[17][7]=true;
		boolBoard[17][8]=true;
		boolBoard[17][9]=true;
		//printGrid();
		
		
		
		adjustBoard();
		//printGrid();
		//adjustBoard();
				
		
		//printGrid();
		
	}
	
	//////////////////////////////////////////////////////////////////////////
	// Update the array of current positions
	//////////////////////////////////////////////////////////////////////////
	public void update(Shape s){
		curPos[0] = (int)s.getOne().getX();
		//System.out.println(curPos[0]);
		curPos[1]=(int) s.getOne().getY();
		//System.out.println(curPos[1]);
		curPos[2] = (int) s.getTwo().getX();
		//System.out.println(curPos[2]);
		curPos[3]= (int) s.getTwo().getY();
		//System.out.println(curPos[3]);
		curPos[4] = (int) s.getThree().getX();
		//System.out.println(curPos[4]);
		curPos[5]= (int) s.getThree().getY();
		//System.out.println(curPos[5]);
		curPos[6]= (int) s.getFour().getX();
		//System.out.println(curPos[6]);
		curPos[7]= (int) s.getFour().getY();
		//System.out.println(curPos[7]);
		//return curPos;
	}
	
	//Shifts all pieces down one row
	public void moveDown(int row){
		System.out.println("Moving down!");
		for(int t=row;t>0;--t){
			for(int i=0;i<10;i++){
			intBoard[t][i]=0;	
			intBoard[t][i]=intBoard[t-1][i];
			intBoard[t-1][i]=0;
			
			}
		}
			
	}
	
	//Check bool board after the move down if a locked space
	// is filled keep true else if space now free set to false
	public void updateBool(){
		for(int i=0; i<20;i++){
			for(int t=0;t<10;t++){
				if(intBoard[i][t]>0){
				boolBoard[i][t]=true;
				}else{
					boolBoard[i][t]=false;
				}
			}
		}
	}
		
	
	//returns  the row which is solid and to be cleared
	public int checkBoard(){
		for(int i=19;i>-1;--i){
			if(checkRow(boolBoard[i])){
				return i;
			}
		}
		return -1;
	}
	
	
	//Preforms the check for full rows, if the row is full move down
	// and update the boolBoard
	public boolean adjustBoard(){
		int q = checkBoard();
		System.out.println("checkBoard value = "+q);
		if(q>-1){
			moveDown(q);
			updateBool();
			recolor();
			return true;
		}
		return false;
	}
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////
	//// Check space below if its greater than 20 or locked, if it is dont move piece mark the 
	//// positions as locked.
	//// If its less than 20 and the spaces below aren't locked set current board colors to normal, 
	//// and update the shapes points, update the list array to the new points, set new board colors
	//// to the Shapes color
	////////////////////////////////////////////////////////////////////////////////////////////
	public void normalFall(Shape s) {
		//Update where the current shape is located
		update(s);
		adjustBoard();
		//While were not at the end of the grid...
		while(bottomCheck()){
			//update the piece position in array
			update(s);
			//If the next spots in bool board are true(locked)... break and lock current position
			if(dropCheck())
			{
				System.out.println("Space not free");
				break;
			
			}else{
					System.out.println("Space is free");
					
					//Space is on the grid and not locked set old spaces to 0
					intBoard[curPos[0]][curPos[1]] = 0;
					intBoard[curPos[2]][curPos[3]] = 0;
					intBoard[curPos[4]][curPos[5]] = 0;
					intBoard[curPos[6]][curPos[7]] = 0;
					
					//Update shape Points
					s.updateShape(curPos);
					
					//update where shape is in curPos
					update(s);
					
					
					
					
					
					//set new spaces to shape color
					intBoard[curPos[0]][curPos[1]] = s.getColor();
					intBoard[curPos[2]][curPos[3]] = s.getColor();
					intBoard[curPos[4]][curPos[5]] = s.getColor();
					intBoard[curPos[6]][curPos[7]] = s.getColor();
					//System.out.println(s.rotate(boolBoard, curPos));
					
					recolor();
					printGrid();
					//Here is where we'll wait
					try {
					t.sleep(500);
					//Check for key press
					}catch (Exception e) {
						   System.out.println(e);
					}
				}
			}
		
		//Lock the spaces down by updating boolBoard to true
		
		boolBoard[curPos[0]][curPos[1]] = true;
		boolBoard[curPos[2]][curPos[3]] = true;
		boolBoard[curPos[4]][curPos[5]] = true;
		boolBoard[curPos[6]][curPos[7]] = true;
		adjustBoard();
		//print out the new grid
		printGrid();
						
	}

	////////////////////////////////////////////////////////////////////////////////////
	////Prints boolBoard
	/////////////////////////////////////////////////////////////////////////////////////
	public  void printRow(boolean[] row) {
        for (boolean i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
	
	////////////////////////////////////////////////////////////////////////////////////
	////Prints intBoard
	/////////////////////////////////////////////////////////////////////////////////////
	public  void printRow(int[] row) {
		for (int i : row) {
			System.out.print(i);
			System.out.print("\t");
		}
		System.out.println();
	}
	
	/////////////////////////////////////////////////////////////////
	//Checks the row if it is true all the way across
	/////////////////////////////////////////////////////////////////
	public boolean checkRow(boolean[] row){
		int k = 0;
		for (boolean i : row) {
          //  System.out.print(i);
           // System.out.print("\t");
            if(i==true){
            	k=k+1;
            
            }
            if(k==10){
            	return true;
            }
		}
		return false;
		
		
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////////////
	//// Prints the grid, showing status of the board
	//// Both boolBoard and intBoard
	//////////////////////////////////////////////////////////////////////////////////
	public void printGrid(){
		for(boolean[] row : boolBoard) {
            printRow(row);
        }
		for(int[] row : intBoard) {
            printRow(row);
        }
	}
	
	/////////////////////////////////////////////////////////////////
	//Generate randInt for next piece
	/////////////////////////////////////////////////////////////////
	public  int randInt(int min, int max) {

	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public void newPiece(int random){
		if(random==1){
			curShape = new Shape("long");
		}
		if(random==2){
			curShape = new Shape("normL");
		}
		if(random==3){
			curShape = new Shape("backL");
		}
		if(random==4){
			curShape = new Shape("tee");
		}
		if(random==5){
			curShape = new Shape("box");
		}
		if(random==6){
			curShape = new Shape("zee");
		}
		if(random==7){
			curShape = new Shape("backZee");
		}
	}
	
	public boolean bottomCheck(){
		return curPos[0]+1<20 && curPos[2]+1<20 && curPos[4]+1<20 && curPos[6]+1<20;
	}
	
	public boolean dropCheck(){
		
			
		
		return boolBoard[curPos[0]+1][curPos[1]] || boolBoard[curPos[2]+1][curPos[3]]
				|| boolBoard[curPos[4]+1][curPos[5]] || boolBoard[curPos[6]+1][curPos[7]];
		}
		
		
	
	public boolean leftCheck(){
		if(curPos[1]==0||curPos[3]==0||curPos[5]==0||curPos[7]==0){
			System.out.println("Piece already as far left as can be");
			return false;
		}
		if(!boolBoard[curPos[0]][curPos[1]-1]  && !boolBoard[curPos[2]][curPos[3]-1] 
				&& !boolBoard[curPos[4]][curPos[5]-1] && !boolBoard[curPos[6]][curPos[7]-1] ){
			return true;
		}
		return false;
	}
	
	public boolean rightCheck(){
		if(curPos[1]==9||curPos[3]==9||curPos[5]==9||curPos[7]==9){
			System.out.println("Piece already as far right as can be");
			return false;
		}
		if(!boolBoard[curPos[0]][curPos[1]+1]  && !boolBoard[curPos[2]][curPos[3]+1] 
				&& !boolBoard[curPos[4]][curPos[5]+1] && !boolBoard[curPos[6]][curPos[7]+1] ){
			return true;
		}
		return false;
	}
	
	public void moveLeft(Shape s){
		
		intBoard[curPos[0]][curPos[1]] = 0;
		intBoard[curPos[2]][curPos[3]] = 0;
		intBoard[curPos[4]][curPos[5]] = 0;
		intBoard[curPos[6]][curPos[7]] = 0;
		s.moveLeft(curPos);
		update(s);
		
	}
	
	public void moveRight(Shape s){
		intBoard[curPos[0]][curPos[1]] = 0;
		intBoard[curPos[2]][curPos[3]] = 0;
		intBoard[curPos[4]][curPos[5]] = 0;
		intBoard[curPos[6]][curPos[7]] = 0;
		s.moveRight(curPos);
		update(s);
		
	}
	
	public void moveDownPiece(Shape s){
		if((!boolBoard[curPos[0]+1][curPos[1]]&&!boolBoard[curPos[2]+1][curPos[3]]&&!boolBoard[curPos[4]+1][curPos[5]]&&!boolBoard[curPos[6]+1][curPos[7]])&&!bottomCheck()){
			intBoard[curPos[0]][curPos[1]] = 0;
			intBoard[curPos[2]][curPos[3]] = 0;
			intBoard[curPos[4]][curPos[5]] = 0;
			intBoard[curPos[6]][curPos[7]] = 0;
			s.moveDown(curPos);
			update(s);
		}
	}
	
	public void rotate(Shape s){
		if(s.getName()=="long"){
			if(s.getDirection() =="Start"){
				System.out.println("fak");
				intBoard[curPos[0]][curPos[1]]=0;
				intBoard[curPos[2]][curPos[3]]=0;
				intBoard[curPos[4]][curPos[5]]=0;
				intBoard[curPos[6]][curPos[7]]=0;
				s.getOne().setLocation(curPos[2]-1, curPos[3]); 
				s.getTwo().setLocation(curPos[2], curPos[3]); 
				s.getThree().setLocation(curPos[2]+1, curPos[3]); 
				s.getFour().setLocation(curPos[2]+2, curPos[3]);
				update(s);
				intBoard[curPos[0]][curPos[1]] = s.getColor();
				intBoard[curPos[2]][curPos[3]] = s.getColor();
				intBoard[curPos[4]][curPos[5]] = s.getColor();
				intBoard[curPos[6]][curPos[7]] = s.getColor();
				s.setDirection("one");
				}else{
					System.out.println(s.getDirection());
					System.out.println("you");
					intBoard[curPos[0]][curPos[1]]=0;
					intBoard[curPos[2]][curPos[3]]=0;
					intBoard[curPos[4]][curPos[5]]=0;
					intBoard[curPos[6]][curPos[7]]=0;
					s.getOne().setLocation(curPos[2], curPos[3]-1); 
					s.getTwo().setLocation(curPos[2], curPos[3]); 
					s.getThree().setLocation(curPos[2], curPos[3]+1); 
					s.getFour().setLocation(curPos[2], curPos[3]+2);
					update(s);
					intBoard[curPos[0]][curPos[1]] = s.getColor();
					intBoard[curPos[2]][curPos[3]] = s.getColor();
					intBoard[curPos[4]][curPos[5]] = s.getColor();
					intBoard[curPos[6]][curPos[7]] = s.getColor();
					s.setDirection("Start");
					
				}
			}
			/*if(this.direction == "one"){
				if(bb[ar[2]][ar[3]-1] || bb[ar[2]][ar[3]+1] || bb[ar[2]][ar[3]+2]){
					System.out.println("Can't rotate");
					
				}else{
					System.out.println("Able to rotate");
							
			}
		}
		if(this.name=="normL"){
			if(this.direction =="Start"){
				if(bb[ar[2]-1][ar[3]] || bb[ar[4]-1][ar[5]] || bb[ar[4]+1][ar[5]]){
					System.out.println("Can't rotate");
					
				}else{
					System.out.println("Able to rotate");
					
				}
			}
			if(this.direction == "one"){
				if(bb[ar[4]][ar[5]+1] || bb[ar[6]][ar[7+1]] || bb[ar[6]][ar[7]-1]){
					System.out.println("Can't rotate");
					
				}else{
					System.out.println("Able to rotate");
					
				}
			}
			if(this.direction == "two"){
				if(bb[ar[4]-1][ar[5]] || bb[ar[4]-2][ar[5]]){
					System.out.println("Can't rotate");
					
				}else{
					System.out.println("Able to rotate");
					
				}
			}
			if(this.direction == "three"){
				if(bb[ar[4]][ar[5]+1] || bb[ar[4]][ar[5]+2]){
					System.out.println("Can't rotate");
					
				}else{
					System.out.println("Able to rotate");
					
				}
			}
		
		
		
		}
		if(this.name=="backL"){
			if(this.direction =="Start"){
				if(bb[ar[0]][ar[1]-1] || bb[ar[6]-1][ar[7]]){
					System.out.println("Can't rotate");
					
				}else{
					System.out.println("Able to rotate");
					
				}
			}
			if(this.direction =="one"){
				if(bb[ar[0]-1][ar[1]] || bb[ar[6]][ar[7]+1]){
					System.out.println("Can't rotate");
					
				}else{
					System.out.println("Able to rotate");
					
				}
			}
			if(this.direction =="two"){
				if(bb[ar[2]-2][ar[3]] || bb[ar[2]][ar[3]-1] || bb[ar[4]-1][ar[5]] || bb[ar[4]-2][ar[5]+1]){
					System.out.println("Can't rotate");
					
				}else{
					System.out.println("Able to rotate");
					
				}
			}
			if(this.direction =="three"){
				if(bb[ar[2]][ar[3]+1] || bb[ar[4]][ar[5]-1] || bb[ar[4]][ar[5]+1]){
					System.out.println("Can't rotate");
					
				}else{
					System.out.println("Able to rotate");
					
				}
			}
		}
		if(this.name=="tee"){
			if(this.direction =="Start"){
				if(bb[ar[4]+1][ar[5]]){
					System.out.println("Can't rotate");
					
				}else{
					System.out.println("Able to rotate");
					
				}
			}
			if(this.direction =="one"){
				if(bb[ar[4]][ar[5]-1]){
					System.out.println("Can't rotate");
					
				}else{
					System.out.println("Able to rotate");
					
				}
			}
			if(this.direction =="two"){
				if(bb[ar[4]-1][ar[5]]){
					System.out.println("Can't rotate");
					
				}else{
					System.out.println("Able to rotate");
					
				}
			}
			if(this.direction =="three"){
				if(bb[ar[4]][ar[5]+1]){
					System.out.println("Can't rotate");
					
				}else{
					System.out.println("Able to rotate");
					
				}
			}
		}
		if(this.name=="zee"){
			if(this.direction =="Start"){
				if(bb[ar[2]][ar[3]+1] || bb[ar[2]+1][ar[3]+1]){
					System.out.println("Can't rotate");
					
				}else{
					System.out.println("Able to rotate");
					
				}
			}
			if(this.direction =="one"){
				if(bb[ar[2]][ar[3]-1] || bb[ar[2]-1][ar[3]+1] || bb[ar[2]-1][ar[3]]){
					System.out.println("Can't rotate");
					
				}else{
					System.out.println("Able to rotate");
					
				}
			}
		
		}
		if(this.name=="backZee"){
			if(this.direction =="Start"){
				if(bb[ar[0]-1][ar[7]] || bb[ar[2]][ar[3]+1] || bb[ar[4]-1][ar[5]] || bb[ar[6]][ar[7]-1]){
						System.out.println("Can't rotate");
						
					}else{
						System.out.println("Able to rotate");
						
					}
				}
			
			if(this.direction =="one"){
				if(bb[ar[4]][ar[5]-1] || bb[ar[6]][ar[7]+1]){
					System.out.println("Can't rotate");
						
					}else{
						System.out.println("Able to rotate");
						
					}
				
				}
			}
			
		
	
	}*/
	
	
	} 

}

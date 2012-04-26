import java.util.ArrayList;


public class Sector {
	
	private byte[][] y0 = {{1,0,0,0,1},
				   {1,0,0,0,1},
				   {1,0,0,0,1},
				   {1,0,0,0,1},
				   {1,1,1,1,1}};
	
	private byte[][] y1 = {{1,0,0,0,1},
			       {1,0,0,0,1},
			       {1,0,0,0,1},
			       {1,0,0,0,1},
			       {1,1,1,1,1}};
	
	private byte[][] y2 = {{1,1,1,1,1},
			       {1,1,1,1,1},
			       {1,1,1,1,1},
			       {1,1,1,1,1},
			       {1,1,1,1,1}};
	
	ArrayList<Block> top;
	ArrayList<Block> middle;
	ArrayList<Block> bottom;
	
	/**
	 * initializes the ArrayLists
	 */
	public Sector(){
		top = new ArrayList<Block>();
		middle = new ArrayList<Block>();
		bottom = new ArrayList<Block>();
		initBlocks();
	}
	
	/**
	 * Fills the arrayLists of blocks based on the integer maps
	 */
	public void initBlocks(){
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				if(y0[i][j] == 1){
					bottom.add(new Block(i,0,j,1));
				}
				if(y1[i][j] == 1){
					middle.add(new Block(i,1,j,1));
				}
				if(y2[i][j] == 1){
					top.add(new Block(i,2,j,1));
				}
			}
		}
	}

	/**
	 * renders all of the blocks in the sector
	 */
	public void render(){
		for(int i=0; i<bottom.size(); i++){
			bottom.get(i).renderObject();
		}
		for(int i=0; i<middle.size(); i++){
			middle.get(i).renderObject();
		}
		for(int i=0; i<top.size(); i++){
			top.get(i).renderObject();
		}
	}
	
	/**
	 * @return the top
	 */
	public ArrayList<Block> getTop() {
		return top;
	}

	/**
	 * @return the middle
	 */
	public ArrayList<Block> getMiddle() {
		return middle;
	}

	/**
	 * @return the bottom
	 */
	public ArrayList<Block> getBottom() {
		return bottom;
	}
}

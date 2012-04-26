
/**
 * Represents the player in the 3D world
 * Also handles player movement
 * @author Joe Frangoudes
 *
 */
public class Player {
	
	private boolean forward;
	private boolean backward;
	private boolean right;
	private boolean left;
	
	//direction vector
	private float lx;
	private float lz;
	
	private float camAngle;
	
	//player position
	private float x;
	private float y;
	private float z;
	
	//used to revert the players location id necessary
	private float tempx;
	private float tempz;
	
	//how quickly the player can turn 
	//Usually the value 0.001f works fine for this
	private float sensitivity;
	
	//how quickly the player moves forward and backward 
	//a value between 0.01f and 0.001f is suggested
	private float speed;
	
	/**
	 * Constructs a player with all necessary attributes
	 * @param x
	 * @param y
	 * @param z
	 * @param sensitivity
	 * @param speed
	 */
	public Player(float x, float y, float z,  float sensitivity, float speed){
		this.y = y;
		this.z =z;
		this.x = x;
		this.sensitivity = sensitivity;
		this.speed = speed;
		camAngle=0;
	}
	
	/**
	 * Moves the player in the appropriate direction and calculates the
	 * players direction vector based on the movement flags
	 */
	public void move(){
		
		if(left || right){
			if(right){
				camAngle+= sensitivity;
			}
			if(left){
				camAngle-= sensitivity;
			}
			lx = (float)Math.sin(camAngle);
			lz = -(float)Math.cos(camAngle);
		}
		if(forward){
			tempx = x;
			tempz = z;
			x = x+lx*speed;
			z = z+lz*speed;
		}
		if(backward){
			tempx = x;
			tempz = z;
			x = x-lx*speed;
			z = z-lz*speed;
		}
	}
	
	public void revert(){
		x = tempx;
		z = tempz;
	}

	/**
	 * @return the forward
	 */
	public boolean isForward() {
		return forward;
	}

	/**
	 * @param forward the forward to set
	 */
	public void setForward(boolean forward) {
		this.forward = forward;
	}

	/**
	 * @return the backward
	 */
	public boolean isBackward() {
		return backward;
	}

	/**
	 * @param backward the backward to set
	 */
	public void setBackward(boolean backward) {
		this.backward = backward;
	}

	/**
	 * @return the right
	 */
	public boolean isRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(boolean right) {
		this.right = right;
	}

	/**
	 * @return the left
	 */
	public boolean isLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(boolean left) {
		this.left = left;
	}

	/**
	 * @return the lx
	 */
	public float getLx() {
		return lx;
	}

	/**
	 * @param lx the lx to set
	 */
	public void setLx(float lx) {
		this.lx = lx;
	}

	/**
	 * @return the lz
	 */
	public float getLz() {
		return lz;
	}

	/**
	 * @param lz the lz to set
	 */
	public void setLz(float lz) {
		this.lz = lz;
	}

	/**
	 * @return the camAngle
	 */
	public float getCamAngle() {
		return camAngle;
	}

	/**
	 * @param camAngle the camAngle to set
	 */
	public void setCamAngle(float camAngle) {
		this.camAngle = camAngle;
	}

	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return the z
	 */
	public float getZ() {
		return z;
	}

	/**
	 * @param z the z to set
	 */
	public void setZ(float z) {
		this.z = z;
	}

	/**
	 * @return the sensitivity
	 */
	public float getSensitivity() {
		return sensitivity;
	}

	/**
	 * @param sensitivity the sensitivity to set
	 */
	public void setSensitivity(float sensitivity) {
		this.sensitivity = sensitivity;
	}

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	

}

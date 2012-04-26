
/**
 * 2D bounding box representation on the x,z plane
 * @author Joe Frangoudes
 *
 */
public class BBox2D {
	private float x;
	private float z;
	private float width;
	private float depth;
	
	/**
	 * Constructs a Bounding Box on the x,z plane
	 * @param x
	 * @param z
	 * @param width
	 * @param depth
	 */
	public BBox2D(float x, float z, float width, float depth){
		this.x = x;
		this.z = z;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * checks to see if whether the point supplied is inside the Bounding Box
	 * If the point is inside, this function returns true, else returns false
	 * @param xPos
	 * @param zPos
	 * @return
	 */
	public boolean isInside(float xPos, float zPos){
		if(xPos >=x && xPos <=x+width && zPos >=z && zPos <=z+depth){
			return true;
		}else{
			return false;
		}
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
	 * @return the width
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * @return the depth
	 */
	public float getDepth() {
		return depth;
	}

	/**
	 * @param depth the depth to set
	 */
	public void setDepth(float depth) {
		this.depth = depth;
	}
	
	
}

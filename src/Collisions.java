import org.lwjgl.opengl.GL11;


public class Collisions {
	
	/**
	 * 
	 * @param p
	 * @param b
	 * @param range
	 * @return
	 */
	public static boolean rayBox(Player p, Block b, float range){
		float px, pz, py;
		boolean collision;
		
		py = p.getY();
		if(p.isForward()){
			px = p.getX()+p.getLx()*range;
			pz = p.getZ()+p.getLz()*range;
		}else{
			px = p.getX()-p.getLx()*range;
			pz = p.getZ()-p.getLz()*range;
		}
		
		
		/*if(px >= b.getxPos() && px <= b.getxPos()+b.getWidth() && 
		   pz >= b.getzPos() && pz <= b.getzPos()+b.getDepth() &&
		   py >= b.getyPos() && py <=b.getyPos()+b.getHeight()){
			collision = true;
		}else{
			collision = false;
		}*/
		
		collision =  !(
						(px < b.getxPos() || px > (b.getxPos() + b.getWidth()) )
					  ||
					    (pz < b.getzPos() || pz > (b.getzPos() + b.getDepth()) )
					 );
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor3f(1, 1, 1);
		GL11.glBegin(GL11.GL_LINES);
		GL11.glVertex3f(px, 0, pz);
		GL11.glVertex3f(p.getX(), 0, p.getZ());
		GL11.glEnd();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		return collision;
	}
}


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Window win = new Window(600, 400);
		ImageBank.texInit();
		win.render();
	}
}
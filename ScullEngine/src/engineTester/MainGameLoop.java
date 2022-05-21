package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop {
	
	public static void main(String [] args) {
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		
		float[] vertices = {
				-0.5f,-0.5f,0f,		//vertex 1
				0.5f, -0.5f, 0f,	//vertex 2
				0.5f, 0.5f, 0f,		//vertex 3
				-0.5f, 0.5f, 0f		//vertex 4
				
		};
		
		int[] indices = {
				0,1,2,
				0,2,3
				
		};
		
		RawModel model = loader.loadToVAO(vertices, indices);
		
		while(!Display.isCloseRequested()) {
			renderer.prepare();
			
			renderer.render(model);
			DisplayManager.updateDisplay();
		}
		
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
	
	

}

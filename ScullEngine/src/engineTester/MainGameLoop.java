package engineTester;

import org.lwjgl.opengl.Display;

import models.RawModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;
import shaders.StaticShader;

public class MainGameLoop {
	
	public static void main(String [] args) {
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader();
		
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
			shader.start();
			
			renderer.render(model);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
	
	

}

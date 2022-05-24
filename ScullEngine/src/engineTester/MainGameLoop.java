package engineTester;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import entities.Entity;
import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

public class MainGameLoop {
	
	public static void main(String [] args) {
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		
		StaticShader shader = new StaticShader();
		
		Renderer renderer = new Renderer(shader);
		
		float[] vertices = {
				-0.5f,0.5f,0f,		//vertex 1
				-0.5f, -0.5f, 0f,	//vertex 2
				0.5f, -0.5f, 0f,		//vertex 3
				0.5f, 0.5f, 0f		//vertex 4
				
		};
		
		float[] textureCoords = {
				0,0,
				0,1,
				1,1,
				1,0
		};
		
		int[] indices = {
				0,1,3,
				3,1,2
				
		};
		
		
		
		RawModel model = loader.loadToVAO(vertices, textureCoords, indices);
		
		TexturedModel staticModel = new TexturedModel(model,new ModelTexture(loader.loadTexture("bird")));
		
		Entity entity = new Entity(staticModel, new Vector3f(0,0,-1),0,0,0,1);
		
		while(!Display.isCloseRequested()) {
			entity.increasePosition(0, 0, -0.1f);
			
			renderer.prepare();
			shader.start();
			
			renderer.render(entity,shader);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
	
	

}

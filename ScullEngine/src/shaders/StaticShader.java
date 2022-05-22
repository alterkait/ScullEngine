package shaders;

public class StaticShader extends ShaderProgram{
	
	private static final String VERTEX_FILE = "/ScullEngine/src/shaders/vertexShader.txt";
	private static final String FRAGMENT_FILE = "/ScullEngine/src/shaders/fragmentShader.txt";

	public StaticShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}
	
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
	}
}

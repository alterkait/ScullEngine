package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
	
	private Vector3f position = new Vector3f(0,0,0);
	
	private float pitch;
	private float yaw;
	private float roll;
	
	public Camera() {
		
	}
	
	public void move() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			position.z -= 1.5f;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			position.z += 1.5f;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			position.x -= 1.5f;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			position.x += 1.55f;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) |Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			position.y += 1.55f;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
			position.y -= 1.55f;
		}
	}

	public Vector3f getPosition() {
		return position;
	}

	public float getPitch() {
		return pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public float getRoll() {
		return roll;
	}
	
	

}

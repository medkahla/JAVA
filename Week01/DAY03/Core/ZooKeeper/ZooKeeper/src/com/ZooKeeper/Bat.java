import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Bat extends Mammal {
	
	public Bat() {
		super(300);
	}
	
	public void fly(){
		this.setEnergyLevel(this.getEnergyLevel()-50);
	}
	
	public void eatHumans(){
		this.setEnergyLevel(this.getEnergyLevel()+25);
	} 
	
	public void attackTown() {
		this.setEnergyLevel(this.getEnergyLevel()-100);
		String filepath = "battle.wav";
		PlayMusic(filepath);
		JOptionPane.showMessageDialog(null, "Stop Playing");
	}
	
	public static void PlayMusic(String location) {
		try {
			File musicPath = new File(location);
			if (musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				
			}
			else {
				System.out.println("Can't find the file!");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}

}

package net.codejava.sound;
import javax.sound.sampled.*;

import java.io.File;
import java.nio.file.Path;
public class Audio{
	public static void main(String []args) {
		 Path path = Path.of("C:\\Pokemon Bleu Rouge Jaune Musique  - Combat Vs Dresseur Pokémon.wav");
		    System.out.println(path);

     File battlemsc = new File("C:\\Pokemon Bleu Rouge Jaune Musique  - Combat Vs Dresseur Pokémon.wav");
     PlaySound(battlemsc);
	}
	static void PlaySound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
		}catch(Exception e) {
			
		}
	}
}
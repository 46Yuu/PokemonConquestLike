public class Test {

	public static void main (String [] args ) throws Exception, Exception, Exception {
		try
		{
			Audio.filePath = "Pokemon Bleu Rouge Jaune Musique  - Combat Vs Dresseur Pokémon.wav";
			Audio audioPlayer =
							new Audio();
			
			audioPlayer.play();
			
			while (true)
			{
		
			}
			
		} 
		
		catch (Exception ex)
		{
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		
		}
	}
}
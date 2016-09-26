package objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

public class World extends Observable{
	
	private ArrayList<GameCharacter> characters;
	
	public World()
	{
		characters = new ArrayList<>();
	}
	
	public void loadCharacters() throws IOException
	{
		FileReader log = new FileReader("info/CharacterList.txt");
		BufferedReader input = new BufferedReader(log);
		String line;
		
		while((line = input.readLine()) != null)
		{
			GameCharacter temp = new GameCharacter(line);
			while(!(line = input.readLine()).equals("===="))
			{
				String[] stats = line.split(":");
				temp.setStat(stats[0], stats[1]);
			}
			
			while(!(line = input.readLine()).equals("===="))
			{
				String[] info = line.split(":");
				temp.setInfo(info[0], info[1]);
			}
			
			line = input.readLine();			
			temp.setBio(line);
			temp.setHealth(100);
			
			//this is to read the last dividing line between characters
			line = input.readLine();
			
			characters.add(temp);
		}
		
		log.close();
	}
	
	public GameCharacter getCharacter(String name)
	{
		for(GameCharacter people : characters)
		{
			if(people.getName().equals(name))
			{
				return people;
			}
		}
		return null;
	}
	
	public ArrayList<GameCharacter> getCharacters()
	{
		return characters;
	}
}

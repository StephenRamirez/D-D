package objects;

import java.util.Hashtable;

/*
 * This class represents the D&D character
 * It has a name, bio, and an infinite amount of stats and info
 */
public class Character {
	
	private String name, bio;
	private int health;
	private Hashtable<String, String> stats; //this represents infinite amount of stats
	private Hashtable<String, String> info; //this represents infinite amount of info
	
	public Character(String name)
	{
		this.name = name;
		this.health = 0;
		stats = new Hashtable<String, String>();
		info = new Hashtable<String, String>();
	}
	
	public void setHealth(int health)
	{
		this.health += health; //this can affect the health positively or negatively
	}
	
	public boolean isDead()
	{
		return health <= 0; //if the health is less than or equal to 0 the character is dead
	}
	
	private void setHash(Hashtable<String, String> hash, String term, String def)
	{
		if(hash.contains(term)) //if the term exists remove it
		{
			hash.remove(term);
			hash.put(term, def); //then add the new definition
		}
		else
		{
			hash.put(term, def);
		}
	}
	
	public void setStat(String term, String def)
	{
		this.setHash(stats, term, def);
	}
	
	public void setInfo(String term, String def)
	{
		this.setHash(info, term, def);
	}
	
	public void setBio(String bio)
	{
		this.bio = bio;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getBio()
	{
		return bio;
	}
	
	public Hashtable<String, String> getStats()
	{
		return stats;
	}
	
	public Hashtable<String, String> getInfo()
	{
		return info;
	}
}

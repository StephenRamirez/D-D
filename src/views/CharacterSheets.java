package views;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JPanel;

public class CharacterSheets extends JPanel
{
	private ArrayList<Character> characters;
	private Hashtable<String, String> stats;
	private Hashtable<String, String> info;
	
	public CharacterSheets()
	{
		characters = new ArrayList<>();
		
		this.setUpPage();
	}
	
	private void setUpPage()
	{
		
		
		this.setUpStats();
		this.setUpInfo();
	}
	
	private void setUpStats()
	{
		
	}
	
	private void setUpInfo()
	{
		
	}
}
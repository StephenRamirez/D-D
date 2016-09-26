package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import objects.GameCharacter;
import objects.World;

public class CharacterSheets extends JPanel implements Observer
{
	private JComboBox<String> characterOptions;
	private World game;
	private GameCharacter currentScope;
	private Hashtable<String, String> pageStats;
	private Hashtable<String, String> pageInfo;
	
	public CharacterSheets(World game)
	{
		this.game = game;
		this.setUpPage();
	}
	
	private void setCharacter(String person)
	{
		currentScope = game.getCharacter(person);
		pageStats = currentScope.getStats();
		pageInfo = currentScope.getInfo();
	}
	
	private void setUpPage()
	{
		this.setUpStats();
		this.setUpInfo();
		this.setUpComboMenu();
	}
	
	private void setUpStats()
	{
		JPanel statPanel = new JPanel();
		statPanel.setLayout(new GridLayout(0,2));
		statPanel.setSize(500, this.getHeight());
		statPanel.setLocation(1000, 0);
		
		Set<String> list = pageStats.keySet();
		for(String keys : list)
		{
			statPanel.add(new JLabel(keys +":"));
			statPanel.add(new JLabel(pageStats.get(keys)));
		}
		
		this.add(statPanel);
	}
	
	private void setUpInfo()
	{
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(0,2));
		infoPanel.setSize(500, this.getHeight());
		infoPanel.setLocation(0, 0);
		
		Set<String> list = pageInfo.keySet();
		for(String keys : list)
		{
			infoPanel.add(new JLabel(keys +":"));
			infoPanel.add(new JLabel(pageInfo.get(keys)));
		}
		
		this.add(infoPanel);
	}
	
	private void setUpComboMenu()
	{
		characterOptions = new JComboBox<String>();
		for(GameCharacter item : game.getCharacters())
		{
			characterOptions.addItem(item.getName());
		}
		
		JComboListener boxAction = new JComboListener();
		characterOptions.addActionListener(boxAction);
		
		characterOptions.setLocation(1000, 0);
		characterOptions.setSize(200,20);
		this.add(characterOptions);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	private class JComboListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
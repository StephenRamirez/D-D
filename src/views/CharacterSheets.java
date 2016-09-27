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
		this.setCharacter(null);
	}
	
	private void setCharacter(String person)
	{
		if(person == null)
			currentScope = game.getCharacters().get(0);
		else
			currentScope = game.getCharacter(person);
		
		pageStats = currentScope.getStats();
		pageInfo = currentScope.getInfo();
		
		this.setUpPage();
	}
	
	private void setUpPage()
	{
		this.setUpData(1000, 0, pageStats);
		this.setUpData(0, 0, pageInfo);
		//this.setUpStats();
		//this.setUpInfo();
		this.setUpComboMenu();
	}
	
	private void setUpData(int x, int y, Hashtable<String, String> data)
	{
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new GridLayout(0,2));
		dataPanel.setSize(500, this.getHeight());
		dataPanel.setLocation(1000, 0);
		
		Set<String> list = data.keySet();
		for(String keys : list)
		{
			dataPanel.add(new JLabel(keys +":"));
			dataPanel.add(new JLabel(data.get(keys)));
		}
		
		this.add(dataPanel);
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
			JComboBox selected = (JComboBox)e.getSource();
			String text = (String)selected.getSelectedItem();
			removeAll();
			setCharacter(text);
			repaint();
			validate();
		}
		
	}
}
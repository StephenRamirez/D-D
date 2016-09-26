package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DDGui extends JFrame{
	
	private JPanel currentView;
	
	//here is where you would declare your JPanel classes
	
	//private CharacterSheets characterSheets();
	
	public static void main(String[] args)
	{
		DDGui application = new DDGui();
		application.setExtendedState(JFrame.MAXIMIZED_BOTH);
		application.setVisible(true);
	}
	
	public DDGui()
	{
		this.setTitle("This is the D&D title!");
		this.setUpMenu();

		/*
		characterSheets = new CharacterSheets();
		
		this.setView(characterSheets);
		*/
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setUpMenu()
	{
		JMenu menu = new JMenu("Options");
		
		JMenuItem characterTab = new JMenuItem("Character Sheets");
		menu.add(characterTab);
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		menuBar.add(menu);
		
		MenuListener menuListener = new MenuListener();
		characterTab.addActionListener(menuListener);
	}
	
	private void setView(JPanel view)
	{
		if(currentView != null)
			this.remove(currentView);
		currentView = view;
		this.add(currentView);
		currentView.repaint();
		this.validate();
	}
	
	private class MenuListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent obj) {
			//this method will deal with the JMenuItems
			JMenuItem clicked = (JMenuItem) obj.getSource();
			String text = clicked.getText();
			
			if(text.equals("Character Sheets"))
			{
				System.out.println("Menu is set up correctly!");
			}
		}
		
	}
}

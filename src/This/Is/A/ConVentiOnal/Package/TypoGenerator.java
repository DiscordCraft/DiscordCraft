package This.Is.A.ConVentiOnal.Package;

// old project when i was learning programming, thought it'd fit discord

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.SystemColor;

public class TypoGenerator {
	private JFrame frmTypoSimulator;
	private String result = "";
	private JTextField textField;
	private static char[][] keyboard = {{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'}, {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'}, {'z', 'x', 'c', 'v', 'b', 'n', 'm'}};
	private JTextField textField_1;
	private JTextField textField_2;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TypoGenerator window = new TypoGenerator();
					window.frmTypoSimulator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public TypoGenerator() {
		initialize();
	}
	private void initialize() {
		frmTypoSimulator = new JFrame();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		frmTypoSimulator.setResizable(false);
		frmTypoSimulator.setIconImage(Toolkit.getDefaultToolkit().getImage(TypoGenerator.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		frmTypoSimulator.setTitle("Typo Simulator");
		frmTypoSimulator.getContentPane().setBackground(new Color(240, 230, 140));
		frmTypoSimulator.getContentPane().setLayout(null);
		JLabel lblEnterYourSentence = new JLabel("Paragraph");
		lblEnterYourSentence.setBounds(10, 99, 163, 14);
		frmTypoSimulator.getContentPane().add(lblEnterYourSentence);
		JLabel lblTypoAmount = new JLabel("Typo amount");
		lblTypoAmount.setBounds(301, 29, 68, 20);
		frmTypoSimulator.getContentPane().add(lblTypoAmount);
		JLabel lblNewLabel = new JLabel("Result: " + result);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(10, 152, 37, 108);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Duplicate non-letters");
		rdbtnNewRadioButton.setEnabled(false);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBackground(new Color(240, 230, 140));
		rdbtnNewRadioButton.setBounds(301, 181, 141, 23);
		frmTypoSimulator.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnSwitchCharacter = new JRadioButton("Switch character");
		rdbtnSwitchCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnNewRadioButton.setEnabled(rdbtnSwitchCharacter.isSelected());
			}
		});
		rdbtnSwitchCharacter.setBackground(new Color(240, 230, 140));
		rdbtnSwitchCharacter.setBounds(301, 155, 141, 23);
		frmTypoSimulator.getContentPane().add(rdbtnSwitchCharacter);
		
		JRadioButton rdbtnPutCharacterClose = new JRadioButton("Close on keyboard");
		rdbtnPutCharacterClose.setBackground(new Color(240, 230, 140));
		rdbtnPutCharacterClose.setBounds(301, 207, 141, 23);
		frmTypoSimulator.getContentPane().add(rdbtnPutCharacterClose);
		frmTypoSimulator.setBackground(Color.WHITE);
		frmTypoSimulator.setBounds(100, 100, 450, 300);
		frmTypoSimulator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 255, 240));
		textField_1.setText("1");
		textField_1.setBounds(301, 11, 133, 20);
		frmTypoSimulator.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(255, 255, 240));
		textPane.setBounds(10, 11, 281, 88);
		frmTypoSimulator.getContentPane().add(textPane);
	    textPane.setBorder(BorderFactory.createLineBorder(SystemColor.activeCaptionBorder));
	    
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBorder(BorderFactory.createLineBorder(SystemColor.activeCaptionBorder));
		textPane_1.setBackground(new Color(255, 255, 240));
		textPane_1.setBounds(10, 172, 281, 88);
		frmTypoSimulator.getContentPane().add(textPane_1);
		
		frmTypoSimulator.getContentPane().add(lblNewLabel);
		JButton btnTypoUp = new JButton("Typo up");
		btnTypoUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] s = textPane.getText().toCharArray();
				if (rdbtnSwitchCharacter.isSelected()){
					for (long i = 0; i < Long.parseLong(textField_1.getText()); i++){
						int j = new Random().nextInt(s.length - 1);
						int k = new Random().nextInt((int) Long.parseLong(textField.getText()) + 1);
						char c1 = s[j];
						char c2;
						if (j + k > s.length){
							s[j + k] = c1;
							c2 = s[j + k];
							s[j] = c2;
						}else if (j - k > 0){
							s[j - k] = c1;
							c2 = s[j - k];
							s[j] = c2;
						}else{
							s[j] = c1;
						}
					}
				}
				if (rdbtnPutCharacterClose.isSelected()){
					for (long i = 0; i < Long.parseLong(textField_1.getText()); i++){
						int j = new Random().nextInt(s.length - 1);
						int k = new Random().nextInt((int) Long.parseLong(textField_2.getText()) + 1);
						char c1 = s[j];
						char c2 = c1; 
						if (rdbtnNewRadioButton.isSelected()){
							c2 = getCloseLetter(c1, k).toCharArray()[0];
						}else{
							if (getIndexOnRow(c1) != null){
								c2 = getCloseLetter(c1, k).toCharArray()[0];
							}else{
								c2 = c1;
							}
						}
						s[j] = c2;
					}
				}
				result = String.valueOf(s);
				textPane_1.setText(result);
			}
		});
		btnTypoUp.setBounds(345, 237, 89, 23);
		frmTypoSimulator.getContentPane().add(btnTypoUp);
		
		textField = new JTextField();
		textField.setText("2");
		textField.setBackground(new Color(255, 255, 240));
		textField.setBounds(301, 64, 133, 20);
		frmTypoSimulator.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblTypoCloseness = new JLabel("Typo closeness (in text)");
		lblTypoCloseness.setVerticalAlignment(SwingConstants.TOP);
		lblTypoCloseness.setBounds(301, 85, 133, 14);
		frmTypoSimulator.getContentPane().add(lblTypoCloseness);
		
		textField_2 = new JTextField();
		textField_2.setText("2");
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(255, 255, 240));
		textField_2.setBounds(301, 112, 133, 20);
		frmTypoSimulator.getContentPane().add(textField_2);
		
		JLabel lblTypoClosenesson = new JLabel("Typo closeness (keyboard)");
		lblTypoClosenesson.setVerticalAlignment(SwingConstants.TOP);
		lblTypoClosenesson.setBounds(301, 134, 133, 14);
		frmTypoSimulator.getContentPane().add(lblTypoClosenesson);
	}
	
	@SuppressWarnings("unused")
	private static boolean inRow(char c, int r){
		for (char cl : keyboard[r]){
			if (cl == c){
				return true;
			}else{
				continue;
			}
		}
		return false;
	}
	
	private static int getRow(char c){
		for (int i = 0; i < keyboard.length; i++){
			for (char ct : keyboard[i]){
				if (ct == c){
					return i;
				}else{
					continue;
				}
			}
		}
		return 0;
	}
	
	private static int[] getIndexOnRow(char c){
		for (int i = 0; i < keyboard[getRow(c)].length; i++){
			if (c == keyboard[getRow(c)][i]){
				return new int[]{getRow(c), i};
			}else{
				continue;
			}
		}
		return null;
	}
	
	private static String getCloseLetter(char pc, int random){
		int closeness = random;
		char lowPc = String.valueOf(pc).toLowerCase().toCharArray()[0];
		boolean isUppercase = String.valueOf(pc).toUpperCase() == String.valueOf(pc);
		String c = String.valueOf(pc);
		if (getIndexOnRow(lowPc) == null){
			return String.valueOf(pc);
		}
		if (!((getIndexOnRow(lowPc)[1] + closeness) > keyboard[getRow(lowPc)].length - 1)){
			c = (isUppercase) ? String.valueOf(keyboard[getIndexOnRow(lowPc)[0]][getIndexOnRow(lowPc)[1] + closeness]).toUpperCase() : String.valueOf(keyboard[getIndexOnRow(lowPc)[0]][getIndexOnRow(lowPc)[1] + closeness]);
		}else if (!((getIndexOnRow(lowPc)[1] - closeness) > keyboard[getRow(lowPc)].length)){
			c = (isUppercase) ? String.valueOf(keyboard[getIndexOnRow(lowPc)[0]][getIndexOnRow(lowPc)[1] - closeness]).toUpperCase() : String.valueOf(keyboard[getIndexOnRow(lowPc)[0]][getIndexOnRow(lowPc)[1] - closeness]);
		}else{
			c = String.valueOf(pc);
		}
		return c;
	}
}
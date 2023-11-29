package sudoku;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;


/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
   private static final long serialVersionUID = 1L;  // to prevent serial warning
   private static SudokuMain instance;


	// private variables
   GameBoardPanel board = new GameBoardPanel();
   JButton btnIniciarJogo= new JButton("Iniciar Jogo");
   JLabel lblEscolhaONvel = new JLabel("Selecione o nível: ");;
   JComboBox comboBox = new JComboBox();
   JLabel lblNewLabel = new JLabel("SUDOKU");
   JButton btnPausar = new JButton("Pausar");
   JButton btnReiniciar = new JButton("Reiniciar");

   // Constructor
   private SudokuMain() {

      Container cp = getContentPane();
      setLocationRelativeTo(null);
      getContentPane().setLayout(null);
      cp.setBackground(new Color(176, 224, 230));
      
      //Botao start game
      btnIniciarJogo.setBounds(158, 357, 117, 25);
      getContentPane().add(btnIniciarJogo);

      //ComboBox
      comboBox.setBounds(115, 304, 191, 22);
      getContentPane().add(comboBox);
      comboBox.addItem("Fácil");
      comboBox.addItem("Médio");
      comboBox.addItem("Difícil");
      
      
      lblEscolhaONvel.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
      lblEscolhaONvel.setBounds(158, 275, 117, 15);
      getContentPane().add(lblEscolhaONvel);
      

 
      board.setBounds(0, 39, 435, 462);

      cp.add(board);     
      board.setVisible(false);
      	
   
	  setBounds(100, 100, 435, 537);
	  Cronometro.getInstance().setBounds(365, 12, 70, 15);
	  cp.add(Cronometro.getInstance());
	  Cronometro.getInstance().setVisible(false);

      // Add a button to the south to re-start the game via board.newGame()
      // ......

      // Initialize the game board to start the game
      

      //pack();     // Pack the UI components, instead of using setSize()
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // to handle window-closing
      setTitle("Sudoku");
      setVisible(true);
      btnIniciarJogo.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0) {
				
        		if (comboBox.getSelectedItem().equals("Fácil")) 
        			board.newGame(Level.facil);
        		if (comboBox.getSelectedItem().equals("Médio")) 
        			board.newGame(Level.medio);
        		if (comboBox.getSelectedItem().equals("Difícil")) 
        			board.newGame(Level.dificil);
        		
        		cp.setBackground(Color.LIGHT_GRAY);
        		Cronometro.getInstance().startTimer();
        		startGame(true);
        	}		
        });
      
 
	  lblNewLabel.setForeground(new Color(255, 255, 255));
	  lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 60));
	  lblNewLabel.setBounds(115, 76, 191, 155);

      getContentPane().add(lblNewLabel);
      
      
      btnPausar.setBounds(145, 10, 117, 25);
      getContentPane().add(btnPausar);
      btnPausar.setVisible(false);
      btnReiniciar.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		StopGame(true);
      		cp.setBackground(new Color(176, 224, 230));
      		
      	}
      });
      
   
      btnReiniciar.setBounds(10, 10, 117, 25);
      getContentPane().add(btnReiniciar);
      btnReiniciar.setVisible(false);

      setLocationRelativeTo(null);
   }
   
   
   public static SudokuMain getInstance() {
	   if(instance == null)
		   instance = new SudokuMain();
	   return instance;
   }
   
   public void startGame(boolean bool) {
	   	Cronometro.getInstance().setVisible(bool);
		board.setVisible(bool);
		btnIniciarJogo.setVisible(!bool);
		lblEscolhaONvel.setVisible(!bool);
		comboBox.setVisible(!bool);
		lblNewLabel.setVisible(!bool);
		btnPausar.setVisible(bool);
		btnReiniciar.setVisible(bool);
	}
  public void StopGame(boolean bool) {
	  Cronometro.getInstance().setVisible(!bool);
		board.setVisible(!bool);
		btnIniciarJogo.setVisible(bool);
		lblEscolhaONvel.setVisible(bool);
		comboBox.setVisible(bool);
		lblNewLabel.setVisible(bool);
		btnPausar.setVisible(!bool);
		btnReiniciar.setVisible(!bool);
  }
   

/** The entry main() entry method */
   public static void main(String[] args) {
      // [TODO 1] Check "Swing program template" on how to run
      //  the constructor of "SudokuMain" [ok]
	   
	   EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SudokuMain frame = getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
   }
}

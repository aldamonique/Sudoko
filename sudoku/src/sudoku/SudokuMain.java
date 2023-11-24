package sudoku;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SudokuMain extends JFrame {
		private static final long serialVersionUID = 1L;  // to prevent serial warning

	   // private variables
	   GameBoardPanel board = new GameBoardPanel();
	   JButton btnNewGame = new JButton("New Game");

	   // Constructor
	   public SudokuMain() {
	      Container cp = getContentPane();
	      cp.setLayout(new BorderLayout());

	      cp.add(board, BorderLayout.CENTER);

	      // Add a button to the south to re-start the game via board.newGame()
	      // ......
	      JButton restartButton = new JButton("Restart");
	      
	      // Initialize the game board to start the game
	      restartButton.addActionListener((ActionListener) new ActionListener() {
	    	    @Override
	    	    public void actionPerformed(ActionEvent e) {
	    	        board.newGame();  //método newGame() para quando o botão for clicado
	    	    }
	    	});
	      cp.add(restartButton, BorderLayout.SOUTH);

	     board.newGame(); //classe original

	      pack();     // Pack the UI components, instead of using setSize()
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // to handle window-closing
	      setTitle("Sudoku");
	      setVisible(true);
	   }

	   /** The entry main() entry method */
	   public static void main(String[] args) {
	      // [TODO 1] Check "Swing program template" on how to run
	      //  the constructor of "SudokuMain"
	      // .........
		   SudokuMain sudokuApp = new SudokuMain();
		      
		      // Configurar o encerramento da aplicação ao fechar a janela
		      sudokuApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      
		      // Tornar a janela visível
		      sudokuApp.setVisible(true);
	   }

}

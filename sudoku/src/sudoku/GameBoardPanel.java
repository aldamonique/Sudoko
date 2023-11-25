package sudoku;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class GameBoardPanel extends JPanel{
	 private static final long serialVersionUID = 1L;  // to prevent serial warning

	   // Define named constants for UI sizes
	   public static final int CELL_SIZE = 60;   // Cell width/height in pixels
	   public static final int BOARD_WIDTH  = CELL_SIZE * SudokuConstants.GRID_SIZE;
	   public static final int BOARD_HEIGHT = CELL_SIZE * SudokuConstants.GRID_SIZE;
	                                             // Board width/height in pixels

	   // Define properties
	   /** The game board composes of 9x9 Cells (customized JTextFields) */
	   private Cell[][] cells = new Cell[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
	   /** It also contains a Puzzle with array numbers and isGiven */
	   private Puzzle puzzle = new Puzzle();

	   /** Constructor */
	   public GameBoardPanel() {
	      super.setLayout(new GridLayout(SudokuConstants.GRID_SIZE, SudokuConstants.GRID_SIZE));  // JPanel

	      // Allocate the 2D array of Cell, and added into JPanel.
	      //t: Aloca o array 2D de Cell e adiciona no JPanel.
	      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
	         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
	            cells[row][col] = new Cell(row, col);
	            super.add(cells[row][col]);   // JPanel
	         }
	      }

	      // [TODO 3] Allocate a common listener as the ActionEvent listener for all the
	      //  Cells (JTextFields)
	      // .........
	      //t: Aloque um ouvinte comum como ouvinte ActionEvent para todos os
	    //Células (JTextFields)

	      // [TODO 4] Adds this common listener to all editable cells
	      // .........
	      // t: // [TODO 4] Adiciona este ouvinte comum a todas as células editáveis
	      super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
	   }

	   /**
	    * Generate a new puzzle; and reset the gameboard of cells based on the puzzle.
	    * You can call this method to start a new game.
	    */
	   //t: /** Gere um novo quebra-cabeça; e redefina o tabuleiro de células com base no quebra-cabeça.Você pode chamar este método para iniciar um novo jogo.
	  
	   public void newGame() {
	      // Generate a new puzzle
	      puzzle.newPuzzle(2);
	      // Initialize all the 9x9 cells, based on the puzzle.
	      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
	         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
	            cells[row][col].newGame(puzzle.numbers[row][col], puzzle.isGiven[row][col]);
	         }
	      }
	   }

	   /**
	    * Return true if the puzzle is solved
	    * i.e., none of the cell have status of TO_GUESS or WRONG_GUESS
	    */
	   //Retorne verdadeiro se o quebra-cabeça for resolvido ou seja, nenhuma célula tem status TO_GUESS ou WRONG_GUESS
	   public boolean isSolved() {
	      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
	         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
	            if (cells[row][col].status == CellStatus.TO_GUESS || cells[row][col].status == CellStatus.WRONG_GUESS) {
	               return false;
	            }
	         }
	      }
	      return true;
	   }

	   // [TODO 2] Define a Listener Inner Class for all the editable Cells
	   // .........
	   //t: // [TODO 2] Definir uma classe interna de ouvinte para todas as células editáveis
	// .........
}

package environment;

import lifeform.LifeForm;

public class Environment {

  private Cell[][] cells;

  /**
   * Creates new Environment
   * 
   * @param rows
   *          The number of rows
   * @param cols
   *          The number of columns
   */
  public Environment(int rows, int cols) {
    cells = new Cell[rows][cols];

    for (int r = 0; r < cells.length; r++) {
      for (int c = 0; c < cells[0].length; c++) {
        cells[r][c] = new Cell();
      }
    }
  }

  public LifeForm getLifeForm(int row, int col) {
    return cells[row][col].getLifeForm();
  }

  public boolean addLifeForm(LifeForm entity, int row, int col) {
    return cells[row][col].addLifeForm(entity);
  }

  public void removeLifeForm(int row, int col) {
    cells[row][col] = new Cell();
  }


  public double getDistance​(int row1, int col1, int row2, int col2) {
    return 5 * (Math.hypot(Math.abs(row2-row1), Math.abs(col2-col1)));
  }
  
  public double getDistance​(LifeForm lifeform1, LifeForm lifeform2) {
    //return 5 * (Math.hypot(Math.abs(row2-row1), Math.abs(col2-col1)));
  }
  
  public int getNumCols() {
    return cells[0].length;
  }
  
  public int getNumRows() {
    return cells.length;
  }
  
  static Environment getEnvironment(int rows, int cols)
  {
    return null;
    
  }
}

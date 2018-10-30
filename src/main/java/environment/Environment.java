package environment;

import exceptions.EnvironmentException;
import lifeform.LifeForm;
import weapon.Weapon;


public class Environment {

  private Cell[][] cells;
  static Environment environment;
  
  /**
   * Creates new Environment
   * 
   * @param rows
   *          The number of rows
   * @param cols
   *          The number of columns
   */
  private Environment(int rows, int cols) {
    cells = new Cell[rows][cols];

    for (int r = 0; r < cells.length; r++) {
      for (int c = 0; c < cells[0].length; c++) {
        cells[r][c] = new Cell();
      }
    }
  }

  public boolean addLifeForm(LifeForm entity, int row, int col) {
    entity.setLocation(row, col);
    return cells[row][col].addLifeForm(entity);
  }
  
  ////////&****************************
  public boolean addWeapon(Weapon weapon, int row, int col) {
    return cells[row][col].addWeapon(weapon);
  }
  
  public void clearBoard() {
    for (int r = 0; r < cells.length; r++) {
      for (int c = 0; c < cells[0].length; c++) {
        environment.removeLifeForm(r,c);
        environment.removeWeapon(cells[r][c].getWeapon1(), r, c);
        environment.removeWeapon(cells[r][c].getWeapon2(), r, c);   
      }
     }
  }
  
  public double getDistance​(int row1, int col1, int row2, int col2) throws EnvironmentException {
    return 5 * (Math.hypot(Math.abs(row2-row1), Math.abs(col2-col1)));
  }
  
  
  public double getDistance​(LifeForm lifeform1, LifeForm lifeform2) throws EnvironmentException {
    return 5 * (Math.hypot(Math.abs(lifeform1.getRow()-lifeform2.getRow()), Math.abs(lifeform1.getCol()-lifeform2.getCol())));
  }
  
  ///////**************************
  public static Environment getEnvironment(int rows, int cols)
  {
    if (environment == null) {
      environment = new Environment(rows,cols);
    } 
    return environment;
  }
  
  public LifeForm getLifeForm(int row, int col) {
    return cells[row][col].getLifeForm();
  }
  

  public int getNumCols() {
    return cells[0].length;
  }
  

  public int getNumRows() {
    return cells.length;
  }
  
  
  public Weapon[] getWeapons(int row, int col) {
    Weapon[] weapons = new Weapon[2];
    
    weapons[0] = cells[row][col].getWeapon1();
    weapons[1] = cells[row][col].getWeapon2(); 
    return weapons;
  }
  
  
  public void removeLifeForm(int row, int col) {
    cells[row][col] = new Cell();
  }  
  
  public Weapon removeWeapon(Weapon weapon, int row, int col) {
     if (row > getNumRows() || col > getNumCols() || row < 0 || col < 0) {
       return null;
      } return cells[row][col].removeWeapon(weapon);
     
  }

    
}

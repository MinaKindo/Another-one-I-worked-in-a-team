package environment;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import exceptions.EnvironmentException;
import lifeform.LifeForm;
import weapon.Weapon;

public class Environment implements EnvironmentSubject {

  private Cell[][] cells;
  static Environment environment;
  List<EnvironmentObserver> obs = new ArrayList<>();

  /**
   * Creates new Environment
   * 
   * @param rows The number of rows
   * @param cols The number of columns
   */
  private Environment(int rows, int cols) {
    cells = new Cell[rows][cols];

    for (int r = 0; r < cells.length; r++) {
      for (int c = 0; c < cells[0].length; c++) {
        cells[r][c] = new Cell();
      }
    }
  }

  @Override
  public void addObserver(EnvironmentObserver o) {
    obs.add(o);
  }

  @Override
  public void notifyObservers(Point[] locs) {
    obs.forEach(o -> o.updateCells(locs));
  }

  /**
   * @author lh9509 Moves LifeForm -- takes into account max bounds & other
   *         LifeForms
   * 
   * @param entity
   */
  public void move(LifeForm entity) {

    int speed = entity.getCurrentSpeed();
    String direction = entity.getCurrentDirection();
    int previousRow = entity.getRow();
    int previousCol = entity.getCol();

    if (direction.equals("North")) {
      while (entity.getRow() - speed < 0) {
        speed -= 1;
      }
      while (cells[entity.getRow() - speed][entity.getCol()].getLifeForm() != null) {
        speed -= 1;
      }
      if (speed >= 1) {
        environment.removeLifeForm(previousRow, previousCol);
        environment.addLifeForm(entity, entity.getRow() - speed, entity.getCol());
      }
    } else if (direction.equals("West")) {
      while (entity.getCol() - speed < 0) {
        speed -= 1;
      }
      while (cells[entity.getRow()][entity.getCol() - speed].getLifeForm() != null) {
        speed -= 1;
      }

      if (speed >= 1) {
        environment.removeLifeForm(previousRow, previousCol);
        environment.addLifeForm(entity, entity.getRow(), entity.getCol() - speed);
      }
    } else if (direction.equals("South")) {
      while (entity.getRow() + speed >= environment.getNumRows()) {
        speed -= 1;
      }
      while (cells[entity.getRow() + speed][entity.getCol()].getLifeForm() != null) {
        speed -= 1;
      }

      if (speed >= 1) {
        environment.removeLifeForm(previousRow, previousCol);
        environment.addLifeForm(entity, entity.getRow() + speed, entity.getCol());
      }
    } else if (direction.equals("East")) {
      while (entity.getCol() + speed >= environment.getNumCols()) {
        speed -= 1;
      }
      while (cells[entity.getRow()][entity.getCol() + speed].getLifeForm() != null) {
        speed -= 1;
      }

      if (speed >= 1) {
        environment.removeLifeForm(previousRow, previousCol);
        environment.addLifeForm(entity, entity.getRow(), entity.getCol() + speed);
      }
    }
  }

  public boolean addLifeForm(LifeForm entity, int row, int col) {
    entity.setLocation(row, col);
    return cells[row][col].addLifeForm(entity);
  }

  //////// &****************************
  public boolean addWeapon(Weapon weapon, int row, int col) {
    return cells[row][col].addWeapon(weapon);
  }

  /**
   * removes all LifeForms and Weapons from the Environment useful for tests and
   * game resets
   */
  public void clearBoard() {
    for (int r = 0; r < cells.length; r++) {
      for (int c = 0; c < cells[0].length; c++) {
        environment.removeLifeForm(r, c);
        environment.removeWeapon(cells[r][c].getWeapon1(), r, c);
        environment.removeWeapon(cells[r][c].getWeapon2(), r, c);
      }
    }
  }

  public double getDistance(int row1, int col1, int row2, int col2) throws EnvironmentException {
    return 5 * (Math.hypot(Math.abs(row2 - row1), Math.abs(col2 - col1)));
  }

  public double getDistance(LifeForm lifeform1, LifeForm lifeform2) throws EnvironmentException {
    return 5 * (Math.hypot(Math.abs(lifeform1.getRow() - lifeform2.getRow()),
        Math.abs(lifeform1.getCol() - lifeform2.getCol())));
  }

  /////// **************************
  /**
   * @return the Singleton instance of the Environment
   */
  public static Environment getEnvironment(int rows, int cols) {
    if (environment == null) {
      environment = new Environment(rows, cols);
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

  /**
   * @return an array containing up to two weapons
   */
  public Weapon[] getWeapons(int row, int col) {
    Weapon[] weapons = new Weapon[2];

    weapons[0] = cells[row][col].getWeapon1();
    weapons[1] = cells[row][col].getWeapon2();
    return weapons;
  }

  public void removeLifeForm(int row, int col) {
    cells[row][col] = new Cell();
  }

  /**
   * @return the Weapon removed from the Cell. Returns null of the cell was off
   *         the grid
   */
  public Weapon removeWeapon(Weapon weapon, int row, int col) {
    if (row > getNumRows() || col > getNumCols() || row < 0 || col < 0) {
      return null;
    }
    return cells[row][col].removeWeapon(weapon);

  }

}

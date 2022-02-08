public class Player {

private String name;

private int unplacedArmies;

Player() {

count++;

System.out.print("Enter player " + count + " 's name: ");

name = World.keyword.nextLine();

}

private static int count = 0;

public String getName() {

return name;

}

public void setName(String name) {

this.name = name;

}

public int getUnplacedArmies() {

return unplacedArmies;

}

public void setUnplacedArmies(int unplacedArmies) {

this.unplacedArmies = unplacedArmies;

}

public static int getCount() {

return count;

}

public void placeArmies(int numOfArmies) {

this.setUnplacedArmies(this.getUnplacedArmies() - numOfArmies);

}

}

Territory.java

public class Territory {

private int row;

private int column;

private String owner;

private int armies;

public Territory(int row, int col) {

this.row = row;

this.column = col;

}

public int getRow() {

return row;

}

public void setRow(int row) {

this.row = row;

}

public int getColumn() {

return column;

}

public void setColumn(int column) {

this.column = column;

}

public String getOwner() {

return owner;

}

public void setOwner(String owner) {

this.owner = owner;

}

public int getArmies() {

return armies;

}

public void setArmies(int armies) {

this.armies = armies;

}

public void placeArmies(Player player, int numOfArmies) {

this.setOwner(player.getName());

this.setArmies(this.getArmies() + numOfArmies);

}

public String toString() {

return "["+row+","+column+"]"+owner+"("+armies+")";

}

}

World.java

public class World {

private Territory territory1;

private Territory territory2;

private Territory territory3;

private Territory territory4;

private Player player1;

private Player player2;

public static final Scanner keyword = new Scanner(System.in);

public World() {

player1 = new Player();

player2 = new Player();

territory1 = new Territory(0, 0);

territory2 = new Territory(1, 0);

territory3 = new Territory(0, 1);

territory4 = new Territory(1, 1);

}

public String toString() {

return territory1+" "+territory2+" "+territory3+" "+territory4;

}

public void placeArmies(Player player, Territory territory) {

System.out.print("How many armies would you like to place on "+territory+"? ");

int numOfArmies = keyword.nextInt();

player.placeArmies(numOfArmies);

territory.placeArmies(player, numOfArmies);

}

public Player getPlayer1() {

return player1;

}

public Player getPlayer2() {

return player2;

}

public Territory getTerritory1() {

return territory1;

}

public Territory getTerritory2() {

return territory2;

}

public Territory getTerritory3() {

return territory3;

}

public Territory getTerritory4() {

return territory4;

}

}

Main.java

public class Main {

public static void main(String[] args) {

World world = new World();

System.out.println(world);

world.placeArmies(world.getPlayer1(), world.getTerritory2());

System.out.println(world);

world.placeArmies(world.getPlayer2(), world.getTerritory4());

System.out.println(world);

}

}
//Name: Tejesh Anand
//DS D block
//Tiles Lab
import java.util.*;
import java.awt.*;
public class TileManager {
    private ArrayList<Tile> tiles = new ArrayList<Tile>();
    //Default Constructor
    public TileManager() {

    }
    //Adds a tile
    public void addTile(Tile rect) {
        tiles.add(rect);
    }
    //Draws all tiles on screen
    public void drawAll(Graphics g) {
        for (int i = tiles.size() - 1; i >= 0; i--) {
            tiles.get(i).draw(g);
        }
    }
    //Returns true if a given point (x,y) is in Tile t
    private boolean isInTile(Tile t, int x, int y) {
        //pseudocode: if(x lies between tile's smallest and largest x)
        if(x <= t.getX() + t.getWidth() && x >= t.getX()) { 
            if(y <= t.getY() + t.getHeight() && y >= t.getY()) { 
                return true;
            }
        }
        return false;
    }
    //Lowers the topmost tile at point (x,y) to the bottom of the list if applicable
    public void lower(int x, int y) {
        for (int i = 0; i < tiles.size(); i++) {
            if (isInTile(tiles.get(i), x, y)) {
                tiles.add(tiles.get(i));
                tiles.remove(i);
                return;
            }
        }
    }
    //Raises the topmost tile at point (x,y) to the top of the list if applicable

    public void raise(int x, int y) {
        for (int i = 0; i < tiles.size(); i++) {
            if (isInTile(tiles.get(i), x, y)) {
                tiles.add(0, tiles.get(i));
                tiles.remove(i + 1);
                return;
            }
        }
    }
    //Deletes the topmost tile at point (x,y) if applicable 
    public void delete(int x, int y) {
        for (int i = 0; i < tiles.size(); i++) {
            if (isInTile(tiles.get(i), x, y)) {
                tiles.remove(i);
                return;
            }
        }
    }
    //Deletes all tiles overlapping point (x,y) if applicable
    public void deleteAll(int x, int y) {
        for (int i = 0; i < tiles.size(); i++) {
            if (isInTile(tiles.get(i), x, y)) {
                tiles.remove(i);
                
            }
        }
    }
    //Randomizes tile location and order, placing all new locations within the given width and height bounds
    public void shuffle(int width, int height) {
        Collections.shuffle(tiles);
        for (int i = 0; i < tiles.size(); i++) {
            //sets Tile x and y to a randomized int on the bounds [0, max] where max is largest value
            //for the tile to remain within supplied bounds
            tiles.get(i).setX((int)((width + 1 - tiles.get(i).getWidth()) * (Math.random())));
            tiles.get(i).setY((int)((height + 1 - tiles.get(i).getHeight()) * (Math.random())));
        }
    }
}

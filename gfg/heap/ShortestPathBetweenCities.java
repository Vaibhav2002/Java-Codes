package gfg.heap;

public class ShortestPathBetweenCities {

    int getLevel(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }

    boolean inLeftSide(int n, int level) {
        int levelSize = (int) Math.pow(2, level);
        return n < (levelSize + levelSize / 2);
    }

    int shortestPath(int x, int y) {
        int levelX = getLevel(x);
        int levelY = getLevel(y);
        if(levelX == levelY) return Math.abs(x-y);
        if(inLeftSide(x, levelX) != inLeftSide(y, levelY))
            return levelX+levelY;
        else return Math.abs(levelX-levelY);
    }
}

import java.util.HashSet;
import java.util.Map;

/**
 * Created by pratyush on 26/5/16.
 *
 *  Formula:  if a queen placed at a[row][col]
 *  Then following places are blocked
 *  1. (SameRow)Rest of the cells for that row
 *  2. (SameColumn)Rest of the cells for than column
 *  3. (LeftDiagonal)Rest of the cells with R-C = (row-col)
 *  4. (RightDiagonal)Rest of cells with R + C = row+col
 *
 *
 *
 *
 */
public class NQueenProblem {

    public static void main(String[] args) {

        int n = 4;
        int result[][] = new int[n][n];
        Map<Position,HashSet<Position>>




    }


}

class Position{
    int x ,y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        if (y != position.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
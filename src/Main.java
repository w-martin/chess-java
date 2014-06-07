import com.chess.model.Position;
import com.chess.standard.StandardBoard;
import com.chess.standard.StandardPosition;
import com.chess.standard.pieces.Bishop;
import com.chess.standard.pieces.Queen;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
//        Position p2 = StandardPosition.positionFromCoord("E5");
//        System.out.println(String.format("%d %s", p2.hashCode(), p2.toString()));



        StandardBoard b = new StandardBoard();
        b.addPieceToPosition(StandardPosition.positionFromCoord("F4"), new Bishop(0));
        b.addPieceToPosition(StandardPosition.positionFromCoord("G1"), new Bishop(1));
        b.addPieceToPosition(StandardPosition.positionFromCoord("D1"), new Bishop(1));
        b.addPieceToPosition(StandardPosition.positionFromCoord("E2"), new Bishop(1));
        Set<Position> positions = new Queen(0).computePossibleMoves(StandardPosition.positionFromCoord("F1"), b);
//        Collections.sort(new ArrayList<Position>(positions.));
        for (Position p : positions) {
//            System.out.println(p.toString());
            System.out.println(String.format("%d %s", p.hashCode(), p.toString()));
        }
    }
}

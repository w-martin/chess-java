import com.chess.engine.Scorer;
import com.chess.standard.StandardScorer;

/**
 * Basic {@link com.chess.engine.Engine}
 */
public class BasicEngine extends NegamaxEngine {

    public BasicEngine() {
        super(1, new StandardScorer());
    }
}

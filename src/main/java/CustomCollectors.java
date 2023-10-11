import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollectors {
    public static Collector<String, StringJoiner, String> concatenating() {
        return Collector.of(
                () -> new StringJoiner(", "),
                StringJoiner::add,
                StringJoiner::merge,
                StringJoiner::toString
        );
    }
}

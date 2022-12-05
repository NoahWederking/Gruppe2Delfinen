import java.util.Comparator;

public class SortSwimmersByTime implements Comparator<Member> {
    @Override
    public int compare(Member o1, Member o2) {
        return Double.compare(o1.getBestTime(),o2.getBestTime());
    }
}

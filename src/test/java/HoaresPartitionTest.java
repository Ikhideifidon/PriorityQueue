import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.Arrays;

import static java.lang.System.out;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HoaresPartitionTest {


    @Test
    void partition() {
        int[] array = {6, 4, 1, 7, 4, 7, 3, 6, 5};
        out.println(HoaresPartition.findKthLargest(array, 9));
    }
}
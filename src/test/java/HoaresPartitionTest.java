import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static java.lang.System.out;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HoaresPartitionTest {


    @Test
    void partition() {
        int[] array = {6, 4, 1, 7, 4, 7, 3, 6, 5};
        HoaresPartition.partition(array);
        out.println(Arrays.toString(array));
    }
}
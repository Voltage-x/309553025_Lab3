import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class lab3Test {

    static Stream<Arguments> stingIntAndListProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 4, 7}, new int[]{1, 4, 5, 7}),
                Arguments.of(new int[]{1, -5, 4, -7}, new int[]{-7, -5, 1, 4}),
                Arguments.of(new int[]{5, 8, 4, 2}, new int[]{2, 4, 5, 8}),
                Arguments.of(new int[]{-3, 0, -9, 65}, new int[]{-9, -3, 0, 65})
        );
    }

    @ParameterizedTest
    @MethodSource("stingIntAndListProvider")
    public void PriorityQueueTesting(int[] random_array, int[] correct_array) {
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int[] result = new int[random_array.length];

        //TODO random_array add to PriorityQueue
        for (int ele : random_array) {
            test.offer(ele);
        }

        //TODO GET PriorityQueue RESULT
        for (int i = 0; i < random_array.length; i++) {
            result[i] = test.poll();
        }

        Assertions.assertArrayEquals(result, correct_array);
    }

    @Test
    public void illegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(-1);
        });
        assertEquals("java.lang.IllegalArgumentException", exception.toString());
    }

    @Test
    public void nullPointerException() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
            priorityQueue.offer(null);
        });
        assertEquals("java.lang.NullPointerException", exception.toString());
    }

    @Test
    public void illegalArgumentException2() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(0);
            priorityQueue.poll();
        });
        assertEquals("java.lang.IllegalArgumentException", exception.toString());
    }
}
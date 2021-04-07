
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import java.util.PriorityQueue;


public class PriorityQueueTest {
    static Stream<Arguments> stringIntAndListProvider(){
        //  return stream
        return Stream.of(
                arguments(new int[]{3,8,4,2},new int[] {3,2,6,3}),
                arguments(new int[]{4,5,3,1},new int[] {1,2,3,4}),
                arguments(new int[]{7,4,7,5},new int[] {1,5,6,9}),
                arguments(new int[]{9,0,3,6},new int[] {0,3,6,7}),
                arguments(new int[]{4,2,9,6},new int[] {1,4,5,1})
        );
    }

    @ParameterizedTest(name="#{index} -Test with Argument={0},{1}")
    @MethodSource("stringIntAndListProvider")
    public void PriorityQueue_RunTest(int [] random_array,int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int [] result = new int[random_array.length];
        for (int i =0 ; i<random_array.length;i++){
            test.add(random_array[i]);
        }
        for(int i =0 ; i< random_array.length;i++){
            result[i] = test.poll();

        }
        
        assertArrayEquals(correct_array,result);
    }

    @Test
    public void OfferTest(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            new PriorityQueue().offer(null);
        });
    }

    @Test
    public void InitialCapacityTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(-1, null);
        });
    }

    @Test
    public void ForEachRemainingTest(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            new PriorityQueue().forEach(null);
        });
    }
}

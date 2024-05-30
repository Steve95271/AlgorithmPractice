package TestClasses;

import DataStructure.DynamicArray.DynamicArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDynamicArray {
    @Test
    public void test1() {
        DynamicArray dynamicArray = new DynamicArray();

        for (int i = 1; i <= 9; i++) {
            dynamicArray.addLast(i);
        }

        Assertions.assertIterableEquals(List.of(1,2,3,4,5,6,7,8,9), dynamicArray);

    }
}

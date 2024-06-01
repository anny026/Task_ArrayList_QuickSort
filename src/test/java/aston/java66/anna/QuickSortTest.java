package aston.java66.anna;

import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;


class QuickSortTest {

    Dog dog1;
    Dog dog2;
    Dog dog3;

    @BeforeEach
    void prepareDate() {
        dog1 = new Dog("Gerda", 5, "shepherd");
        dog2 = new Dog("Lola", 4, "collie");
        dog3 = new Dog("Nelli", 2, "husky");
    }

    @Test
    @DisplayName("Test QuickSort with Comparable")
    void givenArrayList_whenQuickSortWithComparable_thenArrayListSorted() {
        //given
        MyArrayList<Dog> dogs = new MyArrayList<>();
        dogs.add(dog1);
        dogs.add(dog3);
        dogs.add(dog2);
        // when
        QuickSort.quickSortWithComparable(dogs);
        // then
        Assert.assertEquals(dog2, dogs.get(1));
    }

    @Test
    @DisplayName("Test QuickSort with Comparator")
    void quickSortWithComparator() {
        //given
        MyArrayList<Dog> dogs = new MyArrayList<>();
        dogs.add(dog1);
        dogs.add(dog3);
        dogs.add(dog2);
        // when
        QuickSort.quickSortWithComparator(dogs, Comparator.comparing(Dog::getBreed));
        // then
        Assert.assertEquals(dog2, dogs.get(0));
    }
}
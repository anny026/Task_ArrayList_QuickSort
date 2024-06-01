package aston.java66.anna;

import junit.framework.Assert;
import org.junit.jupiter.api.*;

import java.util.List;

class MyArrayListTest {
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
    @DisplayName("Test get size of ArrayList")
    void givenArrayList_whenGetSize_thenSize() {
        //given
        List<Dog> dogs = new MyArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        // when
        int sizeMyArrayList = dogs.size();
        // then
        Assert.assertEquals(3, sizeMyArrayList);
    }

    @Test
    @DisplayName("Test add element to Arraylist by index")
    void givenArrayList_whenAdd_thenElementAdded() {
        //given
        List<Dog> dogs = new MyArrayList<>();
        // when
        dogs.add(0, dog1);
        // then
        Assert.assertEquals(dog1, dogs.get(0));
    }

    @Test
    @DisplayName("Test add element for unexpected index")
    void givenArrayList_whenAddByWrongIndex_thenIndexExpectedIndexOutOfBoundsException() {
        //given
        List<Dog> dogs = new MyArrayList<>();
        dogs.add(0, dog1);
        // when
        // then
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            dogs.add(3, dog2);
        });
    }

    @Test
    @DisplayName("Test add element to ArrayList")
    void givenArrayList_whenAddWithoutIndex_thenElementAddedToNextIndex() {
        //given
        List<Dog> dogs = new MyArrayList<>();
        // when
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        // then
        Assert.assertEquals(dog3, dogs.get(2));
    }

    @Test
    @DisplayName("Test get element by index")
    void givenArrayListAndArray_whenAddArray_thenCreateNewArrayList() {
        //given
        List<Dog> dogs1 = new MyArrayList<>();
        Dog[] dogs2 = new Dog[]{dog2, dog3};
        // when
        dogs1.add(dog1);
        ((MyArrayList<Dog>) dogs1).addArray(dogs2);
        // then
        Assert.assertEquals(dog3, dogs1.get(2));
    }

    @Test
    @DisplayName("Test get element by index")
    void givenArrayList_whenGet_thenElementGot() {
        //given
        List<Dog> dogs = new MyArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        // when
        Dog dog4 = dogs.get(2);
        // then
        Assert.assertEquals(dog3, dog4);
    }

    @Test
    @DisplayName("Test get element by index")
    void givenArrayList_whenGet_thenIndexOutOfBoundsException() {
        //given
        List<Dog> dogs = new MyArrayList<>();
        dogs.add(dog1);
        // when
        // then
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            dogs.get(3);
        });
    }

    @Test
    @DisplayName("Test set element by index")
    void givenArrayList_whenSet_thenElementChanged() {
        //given
        List<Dog> dogs = new MyArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        // when
        dogs.set(0, dog3);
        // then
        Assert.assertEquals(dog3, dogs.get(0));
    }

    @Test
    @DisplayName("Test set element by index out of bound array ")
    void givenArrayList_whenSet_thenIndexOutOfBoundsException() {
        //given
        List<Dog> dogs = new MyArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        // when
        // then
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            dogs.set(2, dog3);
        });
    }

    @Test
    @DisplayName("Test remove element by index")
    void givenArrayList_whenRemove_thenElementRemoved() {
        //given
        List<Dog> dogs = new MyArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        // when
        dogs.remove(0);
        // then
        Assert.assertEquals(dog2, dogs.get(0));
        Assert.assertEquals(1, dogs.size());
    }

    @Test
    @DisplayName("Test remove element by index")
    void givenArrayList_whenRemoveLastElement_thenArrayListIsClean() {
        //given
        List<Dog> dogs = new MyArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        // when
        dogs.remove(0);
        dogs.remove(0);
        // then
        Assert.assertEquals(0, dogs.size());
    }

    @Test
    @DisplayName("Test get element by index")
    void givenArrayList_whenRemove_thenIndexExpectedIndexOutOfBoundsException() {
        //given
        List<Dog> dogs = new MyArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        // when
        // then
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            dogs.remove(2);
        });
    }

    @Test
    @DisplayName("Test clean ArrayList")
    void givenArrayList_whenClear_thenArrayListIsEmpty() {
        //given
        List<Dog> dogs = new MyArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        // when
        dogs.clear();
        // then
        Assert.assertEquals(0, dogs.size());
    }
}
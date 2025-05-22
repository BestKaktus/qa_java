package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    Feline felineMock;

    @Test
    public void createLionTestWithException() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Something", felineMock), "Используйте допустимые значения пола животного - самец или самка");
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void getKittenLionTest() throws Exception{
        Lion lion = new Lion("Самец", felineMock);
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        assertEquals(lion.getKittens(), felineMock.getKittens());
    }

    @Test
    public void getFoodLionTest() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(lion.getFood(), felineMock.getFood("Хищник"));
    }

}

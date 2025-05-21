package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SomeTests {

    @Mock
    Feline felineMock;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(felineMock);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Spy
    Feline felineSpy = new Feline();

    @Test
    public void getKittensTestWithParam() {
        felineSpy.getKittens(6);
        assertEquals(6, felineSpy.getKittens(6));
    }

    @Test
    public void getKittensTestNoParams() {
        felineSpy.getKittens();
        Mockito.verify(felineSpy).getKittens(1);
        assertEquals(1, felineSpy.getKittens());
    }

    @Test
    public void eatMeatTestWithException() throws Exception {
        Mockito.when(felineMock.getFood("Something")).thenThrow(Exception.class);
        assertThrows(Exception.class, () -> felineMock.getFood("Something"));
    }

    @Test
    public void eatMeatTest() throws Exception{
        felineSpy.eatMeat();
        Mockito.verify(felineSpy).eatMeat();
    }

    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(felineMock);
        cat.getFood();
        Mockito.verify(felineMock).eatMeat();
    }

    @Test
    public void doesHaveManeTest() {
        Lion lion = new Lion(felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void createLionTestWithException() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Something"), "Используйте допустимые значения пола животного - самец или самка");
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void getKittenLionTest() {
        Lion lion = new Lion(felineMock);
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        assertEquals(lion.getKittens(), felineMock.getKittens());
    }

    @Test
    public void getFoodLionTest() throws Exception {
        Lion lion = new Lion(felineMock);
        assertEquals(lion.getFood(), felineMock.getFood("Хищник"));
    }

}

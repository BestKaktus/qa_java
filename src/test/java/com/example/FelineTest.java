package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FelineTest {

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Spy
    Feline felineSpy = new Feline();

    @Test
    public void getKittensTestWithParam() {
        Feline feline = new Feline();
        assertEquals(6, feline.getKittens(6));
    }

    @Test
    public void getKittensTestNoParams() {
        felineSpy.getKittens();
        assertEquals(1, felineSpy.getKittens());
    }

    @Test
    public void eatMeatTestWithException() throws Exception {
        Feline feline = new Feline();
        assertThrows(Exception.class, () -> feline.getFood("Something"));
    }

    @Test
    public void eatMeatTest() throws Exception{
        felineSpy.eatMeat();
        Mockito.verify(felineSpy).eatMeat();
    }

}

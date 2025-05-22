package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FelineTest {

    @Mock
    Feline felineMock;

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Spy
    Feline felineSpy = new Feline();

    @Test
    public void getKittensTestWithParam() {
        Mockito.when(felineMock.getKittens(6)).thenReturn(6);
        assertEquals(6, felineMock.getKittens(6));
    }

    @Test
    public void getKittensTestNoParams() {
        felineSpy.getKittens();
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

}

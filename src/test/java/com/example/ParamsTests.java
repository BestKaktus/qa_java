package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@ExtendWith(MockitoExtension.class)
public class ParamsTests {

    @ParameterizedTest
    @MethodSource("lionSex")
    public void createLionTest(String sex, boolean result) throws Exception {
        Lion lion = new Lion(sex);
        assertEquals(result, lion.doesHaveMane());
    }

    public static Stream<Arguments> lionSex() {
        return Stream.of(
                arguments("Самец", true),
                arguments("Самка", false)
        );
    }
}

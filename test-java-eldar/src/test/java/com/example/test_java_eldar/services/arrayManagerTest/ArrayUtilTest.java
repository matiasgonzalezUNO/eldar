package com.example.test_java_eldar.services.arrayManagerTest;

import com.example.test_java_eldar.services.arrayManager.ArrayUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test")
public class ArrayUtilTest {

    @Autowired
    private ArrayUtil arrayUtil;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testConvertArrayWithValidInput() {
        String[] input = {"Hello", "World"};
        String result = arrayUtil.convertArray(input);
        assertEquals("hello world", result);
    }

    @Test
    public void testConvertArrayWithInvalidLength() {
        String[] input = {"Hello", "World", "ExtraElement"};
        assertThrows(IllegalArgumentException.class, () -> arrayUtil.convertArray(input));
    }

    @Test
    public void testConvertArrayWithInvalidCharacter() {
        String[] input = {"Hello", "W@rld"};
        assertThrows(IllegalArgumentException.class, () -> arrayUtil.convertArray(input));
    }

}

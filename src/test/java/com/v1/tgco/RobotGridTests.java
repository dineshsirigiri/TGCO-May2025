package com.v1.tgco;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RobotGridTests {

    private RobotGrid robotGrid;

    @BeforeEach
    void setup() {
        robotGrid = new RobotGrid();
    }

    @Test
    public void testIsSafe() {
        assertTrue( robotGrid.isSafe( 1,2 ) );
        assertTrue( robotGrid.isSafe( 12,12 ) );
        assertFalse( robotGrid.isSafe( 999,999 ) );
    }

    @Test
    public void testTotalSafeSquares() {
        assertAll(
            () -> assertTrue(robotGrid.totalSafeSquares() > 1),
            () -> assertTrue(robotGrid.totalSafeSquares() < 9999*9999)
        );

    }

    @Test
    public void testShortestSafeJourney() {
        // TODO: Add test logic and assertions for shortestSafeJourney function
        Assertions.fail("Not implemented yet");
    }


    // TODO: Add more tests to ensure comprehensive test coverage
}

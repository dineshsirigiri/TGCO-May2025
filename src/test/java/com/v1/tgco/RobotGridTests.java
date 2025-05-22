package com.v1.tgco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RobotGridTests {

    private RobotGrid robotGrid;

    @BeforeEach
    void setup() {
        robotGrid = new RobotGrid();
    }

    @Test
    public void routeIsSafe() {
        assertTrue( robotGrid.isSafe( 1,2 ) );
        assertTrue( robotGrid.isSafe( 12,12 ) );
    }

    @Test
    public void routeIsNotSafe() {
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
    public void validShortestSafeJourney() {
        assertEquals( 4, robotGrid.shortestSafeJourney( 0,0,2,2 ) );
    }

    @Test
    public void unsafeShortestSafeJourney() {
        assertEquals( -1, robotGrid.shortestSafeJourney( 0,0,9999,9999 ) );
    }

    @Test
    public void invalidShortestSafeJourney() {
        assertEquals( -1, robotGrid.shortestSafeJourney( 0,0,333,279 ) );
    }
}

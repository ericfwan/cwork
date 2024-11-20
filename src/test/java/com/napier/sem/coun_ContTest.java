package com.napier.sem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CounContTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private Statement mockStatement;

    @Mock
    private ResultSet mockResultSet;

    private coun_Cont counCont;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
        counCont = new coun_Cont();

        // Redirect System.out to capture the print statements
        System.setOut(new PrintStream(outputStreamCaptor));

        // Mock the connection setup
        when(mockConnection.createStatement()).thenReturn(mockStatement);
    }

    @Test
    void testRun_withValidData() throws SQLException {
        // Mock the query result
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);  // Simulate one result

        when(mockResultSet.getString("Name")).thenReturn("India");
        when(mockResultSet.getString("Continent")).thenReturn("Asia");
        when(mockResultSet.getInt("Population")).thenReturn(1013662000);

        // Call the method you are testing
        counCont.run("Asia");

        // Capture and verify the printed output
        String expectedOutput = "Countries in Asia:\nContinent: Asia, Name: India, Population: 1013662000\n\n\n\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());

        // Verify interactions with the mocked objects
        verify(mockStatement, times(1)).executeQuery(anyString());
        verify(mockResultSet, times(1)).next();
    }

    @Test
    void testRun_noResults() throws SQLException {
        // Mock the query result with no data
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);  // No rows in the result set

        // Call the method you are testing
        counCont.run("Antarctica");

        // Capture and verify the printed output
        String expectedOutput = "Countries in Antarctica:\n\n\n\n";  // No countries printed
        assertEquals(expectedOutput, outputStreamCaptor.toString());

        // Verify interactions with the mocked objects
        verify(mockStatement, times(1)).executeQuery(anyString());
        verify(mockResultSet, times(1)).next();
    }

    @Test
    void testRun_databaseError() throws SQLException {
        // Simulate a SQLException being thrown
        when(mockConnection.createStatement()).thenThrow(new SQLException("Database error"));

        // Call the method and assert it throws a runtime exception
        assertThrows(RuntimeException.class, () -> {
            counCont.run("Europe");
        });
    }

}

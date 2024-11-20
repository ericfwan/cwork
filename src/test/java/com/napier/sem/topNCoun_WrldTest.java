package com.napier.sem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.sql.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TopNCounWrldTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private Statement mockStatement;

    @Mock
    private ResultSet mockResultSet;

    private topNCoun_Wrld topNCounWrld;

    private App app;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
        topNCounWrld = new topNCoun_Wrld();

        // Mock the connection setup
        when(mockConnection.createStatement()).thenReturn(mockStatement);
    }

    @Test
    void testRun_withValidData() throws SQLException {
        // Mock the query result
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);  // Simulate one result

        when(mockResultSet.getString("Name")).thenReturn("Country1");
        when(mockResultSet.getInt("Population")).thenReturn(1000000);

        // Call the method you are testing
        topNCounWrld.run(app,1);

        // Verify interactions with the mocked objects
        verify(mockStatement, times(1)).executeQuery(anyString());  // Ensure the query was executed once
        verify(mockResultSet, times(1)).next();  // Ensure we moved through the ResultSet
    }

    @Test
    void testRun_noResults() throws SQLException {
        // Mock the query result with no data
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);  // No rows in the result set

        // Call the method you are testing
        topNCounWrld.run(app,1);

        // Verify the query execution
        verify(mockStatement, times(1)).executeQuery(anyString());
        verify(mockResultSet, times(1)).next();  // Verify no rows were found
    }

    @Test
    void testRun_databaseError() throws SQLException {
        // Simulate a SQLException being thrown
        when(mockConnection.createStatement()).thenThrow(new SQLException("Database error"));

        // Call the method and assert it throws a runtime exception
        assertThrows(RuntimeException.class, () -> {
            topNCounWrld.run(app,1);
        });
    }

}

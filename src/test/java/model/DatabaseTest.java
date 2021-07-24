package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    Database db;
    private Object SQLException;

    @BeforeEach
    void setUp() throws SQLException {
        db = new Database();
    }

    private void assertThrows(Object sqlException) {
    }

    @Test
    public void creoNuevoUsuario(){
        int res_esperado = db.testNumberOfAccounts()+1;
        db.newAccount("Mati","Lambda");
        assertEquals(res_esperado,db.testNumberOfAccounts());
    }
    @Test
    public void newUserDelete(){
        int res_esperado = db.testNumberOfAccounts()-1;
        db.deleteAccount("Mati");
        assertEquals(res_esperado, db.testNumberOfAccounts());
    }
    @Test
    public void deleteNonExistanceUser(){
        db.deleteAccount("Mati");
        assertThrows(SQLException);
    }

}
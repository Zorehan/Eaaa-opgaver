package DAL;

import BE.Bog;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BogDAO {

    private DatabaseConnector databaseConnector;

    public BogDAO(){
        databaseConnector = new DatabaseConnector();
    }

    public List<Bog> getAllBooks()
    {
        ArrayList<Bog> allBooks = new ArrayList<>();

        try(Connection conn = databaseConnector.getConnection();
        Statement stmt = conn.createStatement())
        {
            String sql = "SELECT * FROM dbo.Bog;";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                int id = rs.getInt("id");
                String titel = rs.getString("titel");
                String udgivelseAar = rs.getString("udgivelseAar");
                int forfatterID = rs.getInt("forfatterID");

                Bog bog = new Bog(id, titel, udgivelseAar, forfatterID);
                allBooks.add(bog);
            }
            return allBooks;
        } catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}

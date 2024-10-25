package DAL;

import BE.Forfatter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ForfatterDAO {

    private DatabaseConnector databaseConnector;

    public ForfatterDAO() {
        databaseConnector = new DatabaseConnector();
    }

    public List<Forfatter> getAllForfatters()
    {
        ArrayList<Forfatter> allForfatters = new ArrayList<>();

        try(Connection conn = databaseConnector.getConnection();
        Statement stmt = conn.createStatement())
        {
            String sql = "SELECT * FROM dbo.Forfatter;";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                int id = rs.getInt("id");
                String navn = rs.getString("navn");
                String foedselsaar = rs.getString("foedselsaar");
                String doedlAar = rs.getString("doedIAar");
                String land = rs.getString("land");

                Forfatter forfatter = new Forfatter(id,navn,foedselsaar,doedlAar,land);
                allForfatters.add(forfatter);
            }
            return allForfatters;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

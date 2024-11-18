import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class KontoDAO {

    private static DatabaseConnector databaseConnector;
    public static Connection conn;

    static {
        databaseConnector = new DatabaseConnector();
        conn = databaseConnector.getConnection();
    }

    public KontoDAO(){
        databaseConnector = new DatabaseConnector();
        conn = databaseConnector.getConnection();
    }

    public static void main(String[] args) throws SQLException {
        wireMoney();
    }

    public static void wireMoney() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Tast 1 for at sende penge, tast 2 for at trække penge fra konto: ");
            String wireOrWithdraw = scanner.nextLine();

            System.out.print("Enter regNr: ");
            String regNr = scanner.nextLine();

            System.out.print("Enter ktoNr: ");
            String ktoNr = scanner.nextLine();

            System.out.print("Enter amount to wire: ");
            double amount = scanner.nextDouble();

            String selectQuery = "SELECT saldo FROM Konto WHERE regNr = ? AND ktoNr = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
            selectStmt.setString(1, regNr);
            selectStmt.setString(2, ktoNr);

            ResultSet rs = selectStmt.executeQuery();
            if (rs.next()) {
                double currentSaldo = rs.getDouble("saldo");
                double newSaldo = currentSaldo;

                if (wireOrWithdraw.equals("1")) {
                    newSaldo = currentSaldo + amount;
                } else if (wireOrWithdraw.equals("2")) {
                    newSaldo = currentSaldo - amount;
                } else {
                    System.out.println("Ugyldigt valg. Tast 1 for at sende penge eller 2 for at trække penge.");
                    return;
                }

                String updateQuery = "UPDATE Konto SET saldo = ? WHERE regNr = ? AND ktoNr = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                updateStmt.setDouble(1, newSaldo);
                updateStmt.setString(2, regNr);
                updateStmt.setString(3, ktoNr);

                int rowsUpdated = updateStmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Penge sendt WOOOHOOO! Ny saldo: " + newSaldo);
                } else {
                    System.out.println("Det virkede ikke unlucky");
                }
                updateStmt.close();
            } else {
                System.out.println("Du yasyede kontooplysningerne forkert");
            }

            selectStmt.close();
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

}


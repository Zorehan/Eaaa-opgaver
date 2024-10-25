import DAL.BogDAO;
import DAL.ForfatterDAO;

public class Main {
    private static ForfatterDAO forfatterDAO  = new ForfatterDAO();
    private static BogDAO bogDAO = new BogDAO();
    public Main()
    {
    }

    public static void main(String[] args)
    {
        System.out.println(forfatterDAO.getAllForfatters().toString() );
        System.out.println(bogDAO.getAllBooks().toString());
    }
}

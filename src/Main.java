import model.ConnectionPool;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = ConnectionPool.getInstance().getConnection();

        if (conn == null) {
            System.out.println("Connection ERROR!");
        } else {
            System.out.println("Connection Successfully");

            boolean success = ConnectionPool.getInstance().closeConnection(conn);

            if (success) {
                System.out.println("Connection closed");
            }
        }
    }
}
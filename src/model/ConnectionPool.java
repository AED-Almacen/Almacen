package model;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionPool {

    private final BasicDataSource basicDataSource;
    private static ConnectionPool dataSource;

        private ConnectionPool() {
            this.basicDataSource = new BasicDataSource();
            this.basicDataSource.setDriverClassName("org.postgresql.Driver");
            this.basicDataSource.setUsername("postgres");
            this.basicDataSource.setPassword("daw1234");
            this.basicDataSource.setUrl("jdbc:postgresql://localhost:5432/almacen");
        }

        public static ConnectionPool getInstance() {
            return dataSource == null ? dataSource = new ConnectionPool() : dataSource;
        }

        public Connection getConnection () {
            Connection connect = null;

            try {
                connect = this.basicDataSource.getConnection();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            return connect;
        }

        public void closeConnection(Connection connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
}

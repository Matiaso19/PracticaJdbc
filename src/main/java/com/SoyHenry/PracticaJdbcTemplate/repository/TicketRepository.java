package com.SoyHenry.PracticaJdbcTemplate.repository;

import com.SoyHenry.PracticaJdbcTemplate.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TicketRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createTable(){
        String createTableSql = "CREATE TABLE Ticket (id LONG PRIMARY KEY AUTO_INCREMENT NOT NULL,description VARCHAR(50) NOT NULL,status VARCHAR(50) NOT NULL";
        jdbcTemplate.execute(createTableSql);
    }

    public Ticket insertTicket(Ticket ticket){
        String insertTicketSql = "INSERT INTO Ticket (description, status) VALUES(?,?)";
        jdbcTemplate.update(insertTicketSql, ticket.getDescription(), ticket.getStatus());
        return ticket;
    }

    public List<Ticket> getAllTickets(){
        String sql = "SELECT * FROM Ticket";
        return jdbcTemplate.query(sql, new TicketRowMapper());
    }

    private static final class TicketRowMapper implements RowMapper<Ticket> {

        @Override
        public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
            Ticket ticket = new Ticket();
            ticket.setId(rs.getLong("id"));
            ticket.setDescription(rs.getString("description"));
            ticket.setStatus(rs.getString("status"));
            return ticket;
        }
    }
}

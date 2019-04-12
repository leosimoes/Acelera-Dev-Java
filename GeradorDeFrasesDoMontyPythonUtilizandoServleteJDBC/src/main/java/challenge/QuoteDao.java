package challenge;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuoteDao {

    private Connection conexao;

    public QuoteDao() {
        try {
            this.conexao = ConnectionFactory.createConnection();
        } catch (SQLException e) {
            Logger.getLogger(QuoteDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Quote getQuote() throws SQLException {
        try {
            String sql = "SELECT actor, detail AS quote FROM scripts ORDER BY RANDOM() LIMIT 1";
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            Quote quote = new Quote();
            quote.setActor(rs.getString("actor"));
            quote.setQuote(rs.getString("quote"));
            return quote;
        } finally {
            this.close();
        }
    }

    public Quote getQuoteByActor(String actor) throws SQLException {
        try {
            String sql = "SELECT actor, detail AS quote FROM scripts WHERE actor LIKE ? ORDER BY RANDOM() LIMIT 1";
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, "%" + actor + "%");
            ResultSet rs = stmt.executeQuery();
            Quote quote = new Quote();
            quote.setActor(rs.getString("actor"));
            quote.setQuote(rs.getString("quote"));
            return quote;
        } finally {
            this.close();
        }
    }

    public void close() {
        if (this.conexao != null) {
            try {
                this.conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuoteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

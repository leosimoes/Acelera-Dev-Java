package challenge;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet(value = "v1/quote/*")
public class QuoteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Quote quote;
            QuoteDao quoteDao = new QuoteDao();
            String pathInfo = req.getPathInfo();
            if (pathInfo == null || pathInfo.equals("/")) {
                quote = quoteDao.getQuote();

            } else {
                String actor = pathInfo.split("/")[1];
                quote = quoteDao.getQuoteByActor(actor);
            }
            //A conexão já é fechada em getQuote e getQuoteByActor
            //quoteDao.close();
            resp.getWriter().print(new Gson().toJson(quote));
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}

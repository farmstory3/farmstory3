package common;

import java.io.IOException;

import controller.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("*.do")
public class FrontController extends HttpServlet{
	private HandlerMapping handlerMapping;
	
	@Override
    public void init() throws ServletException {
        handlerMapping = new HandlerMapping();
    }
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("front Controller 입장");
		
		String method = req.getMethod();
		String uri = req.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));
        System.out.println("uri : " + uri);
        System.out.println("path : " + path);
		Controller controller = handlerMapping.getController(path);
		
		if (controller == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
		
		switch (method) {
	     case "GET":
	         controller.handleGet(req, resp);
	         break;
	     case "POST":
	         controller.handlePost(req, resp);
	         break;
	     case "PUT":
	         controller.handlePut(req, resp);
	         break;
	     case "DELETE":
	         controller.handleDelete(req, resp);
	         break;
	     default:
	         resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	         break;
		}
		
    }
	
}

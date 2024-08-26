package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    void handlePut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    void handleDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}

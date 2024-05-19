package com.example;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "SortedArray", value = "/sortArray")
public class SortedArray extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String input = request.getParameter("numbers");
        String[] numbersArray = input.split(",");
        int[] numbers = Arrays.stream(numbersArray).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(numbers);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Sorted array:</h2>");
        out.println("<p>" + Arrays.toString(numbers) + "</p>");
        out.println("</body></html>");
    }
}


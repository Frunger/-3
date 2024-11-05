package cn.edu.gench.javaee.fengjingxuan2220680.servlet;

import cn.edu.gench.javaee.fengjingxuan2220680.pojo.Airport;
import cn.edu.gench.javaee.fengjingxuan2220680.pojo.Flight;
import cn.edu.gench.javaee.fengjingxuan2220680.service.AirportService;
import cn.edu.gench.javaee.fengjingxuan2220680.service.FlightService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/queryFlights")
public class QueryServlet extends HttpServlet {

    private final FlightService flightService = new FlightService();
    private final AirportService airportService = new AirportService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departureAirportCode = request.getParameter("departureAirport");
        String arrivalAirportCode = request.getParameter("arrivalAirport");

        Map<String, String> conditions = new HashMap<>();
        conditions.put("departureAirportCode", departureAirportCode != null && !departureAirportCode.isEmpty() ? departureAirportCode : null);
        conditions.put("arrivalAirportCode", arrivalAirportCode != null && !arrivalAirportCode.isEmpty() ? arrivalAirportCode : null);

        List<Flight> flights = flightService.queryFlights(conditions);
        List<Airport> airports = airportService.getAllAirports(); // 获取所有机场信息

        // 添加调试日志
        System.out.println("Airports: " + airports);
        System.out.println("Flights: " + flights);

        // 确保 airports 不为 null
        if (airports == null) {
            airports = Collections.emptyList();
        }

        request.setAttribute("flights", flights);
        request.setAttribute("airports", airports);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

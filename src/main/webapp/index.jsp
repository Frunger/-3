<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.gench.javaee.fengjingxuan2220680.pojo.Airport" %>
<%@ page import="cn.edu.gench.javaee.fengjingxuan2220680.pojo.Flight" %>
<html>
<head>
    <title>航班查询</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            color: #333;
            margin: 20px;
        }
        h1 {
            text-align: center;
            color: #4CAF50;
        }
        form {
            margin-bottom: 20px;
            display: flex;
            justify-content: center;
            gap: 15px;
        }
        select, input[type="submit"] {
            padding: 5px;
            font-size: 16px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            background-color: #fff;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        .no-data {
            text-align: center;
            padding: 20px;
            color: #888;
        }
    </style>
</head>
<body>
<h1>航班查询</h1>
<form action="queryFlights" method="get">
    <label>起飞机场:</label>
    <label>
        <select name="departureAirport">
            <option value="">请选择</option>
            <%
                List<Airport> airports = (List<Airport>) request.getAttribute("airports");
                if (airports != null && !airports.isEmpty()) { // 空检查，确保 airports 不为 null
                    for (Airport airport : airports) {
            %>
            <option value="<%= airport.getAirportCode() %>"><%= airport.getAirportName() %> - <%= airport.getCity() %></option>
            <%
                }
            } else {
            %>
            <option value="">没有机场数据</option>
            <%
                }
            %>
        </select>
    </label>

    <label>降落机场:</label>
    <label>
        <select name="arrivalAirport">
            <option value="">请选择</option>
            <%
                if (airports != null && !airports.isEmpty()) { // 空检查
                    for (Airport airport : airports) {
            %>
            <option value="<%= airport.getAirportCode() %>"><%= airport.getAirportName() %> - <%= airport.getCity() %></option>
            <%
                }
            } else {
            %>
            <option value="">没有机场数据</option>
            <%
                }
            %>
        </select>
    </label>

    <input type="submit" value="查询"/>
</form>

<table>
    <tr>
        <th>航班编号</th>
        <th>起飞机场</th>
        <th>起飞城市</th>
        <th>降落机场</th>
        <th>降落城市</th>
        <th>航行时间</th>
        <th>票价(元)</th>
    </tr>
    <%
        List<Flight> flights = (List<Flight>) request.getAttribute("flights");
        if (flights != null && !flights.isEmpty()) {
            for (Flight flight : flights) {
    %>
    <tr>
        <td><%= flight.getFlightNumber() %></td>
        <td><%= flight.getDepartureAirport().getAirportName() %></td>
        <td><%= flight.getDepartureAirport().getCity() %></td>
        <td><%= flight.getArrivalAirport().getAirportName() %></td>
        <td><%= flight.getArrivalAirport().getCity() %></td>
        <td><%= flight.getFlightDuration() %></td>
        <td><%= flight.getTicketPrice() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="7" class="no-data">没有航班数据</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>

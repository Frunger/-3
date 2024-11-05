package cn.edu.gench.javaee.fengjingxuan2220680.mapper;

import cn.edu.gench.javaee.fengjingxuan2220680.pojo.Flight;
import java.util.List;
import java.util.Map;

public interface FlightMapper {
    List<Flight> queryFlightsByConditions(Map<String, String> conditions);
}

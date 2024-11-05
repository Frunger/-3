package cn.edu.gench.javaee.fengjingxuan2220680.service;

import cn.edu.gench.javaee.fengjingxuan2220680.mapper.FlightMapper;
import cn.edu.gench.javaee.fengjingxuan2220680.pojo.Flight;
import cn.edu.gench.javaee.fengjingxuan2220680.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class FlightService {
    public List<Flight> queryFlights(Map<String, String> conditions) {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            FlightMapper mapper = session.getMapper(FlightMapper.class);
            return mapper.queryFlightsByConditions(conditions);
        }
    }
}

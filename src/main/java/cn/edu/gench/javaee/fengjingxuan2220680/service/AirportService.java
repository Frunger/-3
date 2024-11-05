package cn.edu.gench.javaee.fengjingxuan2220680.service;

import cn.edu.gench.javaee.fengjingxuan2220680.mapper.AirportMapper;
import cn.edu.gench.javaee.fengjingxuan2220680.pojo.Airport;
import cn.edu.gench.javaee.fengjingxuan2220680.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AirportService {

    /**
     * 获取所有机场信息
     * @return 包含所有机场信息的列表
     */
    public List<Airport> getAllAirports() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            AirportMapper mapper = session.getMapper(AirportMapper.class);
            return mapper.getAllAirports();
        }
    }
}

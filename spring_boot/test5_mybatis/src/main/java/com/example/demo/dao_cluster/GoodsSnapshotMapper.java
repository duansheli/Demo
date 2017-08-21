package com.example.demo.dao_cluster;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain_cluster.GoodsSnapshot;

@Mapper
public interface GoodsSnapshotMapper {
    @Insert("INSERT INTO `goods_snapshot` (`order_id`, `name`, `price`) VALUES ( #{orderId}, #{name}, #{price})" )
    int insert(GoodsSnapshot record);

    @Select("select gs.order_id as orderId , gs.name name, gs.price price from goods_snapshot gs where gs.order_id = #{orderId}")
    List<GoodsSnapshot> selectByOrderId(@Param("orderId")Integer orderId);
}
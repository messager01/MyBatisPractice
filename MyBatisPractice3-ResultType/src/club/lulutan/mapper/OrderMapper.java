package club.lulutan.mapper;

import club.lulutan.domain.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    // 查询所有订单
    List<Order> getAllOrders();

    // 查询一个订单   实验分步查询
    Order getOrder(Integer id);

    // 添加提个订单
    void insertOrder(Order order);

    // 根据cust_id 查订单
    List<Order> getOrderWithId(Integer id);

    ///  更新关系

    void updateCust_id(@Param("orderId") Integer orderId, @Param("custId") Integer custId);


    // 打破关系
    void  updateRelation(Integer cust_id);
}

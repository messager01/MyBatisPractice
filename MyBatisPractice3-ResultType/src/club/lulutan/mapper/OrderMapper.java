package club.lulutan.mapper;

import club.lulutan.domain.Order;

import java.util.List;

public interface OrderMapper {

    // 查询所有订单
    List<Order> getAllOrders();

    // 查询一个订单   实验分步查询
    Order getOrder(Integer id);
}

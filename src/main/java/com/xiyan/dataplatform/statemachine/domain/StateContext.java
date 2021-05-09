package com.xiyan.dataplatform.statemachine.domain;

import com.xiyan.dataplatform.statemachine.server.OrderStateEvent;

/**
 * @author Ruimin Wu
 * @date 2021-05-09 13:07
 **/
public class StateContext<C> {
    /**
     * 订单操作事件
     */
    private OrderStateEvent orderStateEvent;
    /**
     * 状态机需要的订单基本信息
     */
    private FsmOrder fsmOrder;
    /**
     * 业务可定义的上下文泛型对象
     */
    private C context;

    public StateContext(OrderStateEvent orderStateEvent, FsmOrder fsmOrder) {
        this.orderStateEvent = orderStateEvent;
        this.fsmOrder = fsmOrder;
    }
}

package com.xiyan.dataplatform.statemachine.imlp;

import com.xiyan.dataplatform.statemachine.anno.OrderProcessor;
import com.xiyan.dataplatform.statemachine.domain.OrderEventEnum;
import com.xiyan.dataplatform.statemachine.domain.OrderStateEnum;
import com.xiyan.dataplatform.statemachine.domain.ServiceResult;

/**
 * @author Ruimin Wu
 * @date 2021-05-09 13:44
 **/
@OrderProcessor(state = OrderStateEnum.INIT, event = OrderEventEnum.CREATE, bizCode = "BUSINESS")
public class OrderCreatedProcessor extends AbstractStateProcessor<String, CreateOrderContext> {

    @Override
    public String getNextState(StateContext<CreateOrderContext> context) {
        // if (context.getOrderStateEvent().getEventType().equals("xxx")) {
        //     return OrderStateEnum.INIT;
        //  }
        return OrderStateEnum.NEW;
    }
    @Override
    public ServiceResult<String> save(String nextState, StateContext<CreateOrderContext> context) throws Exception {
        OrderInfo orderInfo = context.getContext().getOrderInfo();
        // 更新状态
        orderInfo.setOrderState(nextState);
        // 持久化
//        this.updateOrderInfo(orderInfo);
        log.info("save BUSINESS order success, userId:{}, orderId:{}", orderInfo.getUserId(), orderInfo.getOrderId());
        return new ServiceResult<>(orderInfo.getOrderId(), "business下单成功");
    }
}


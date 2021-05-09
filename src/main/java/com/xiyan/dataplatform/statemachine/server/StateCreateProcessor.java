package com.xiyan.dataplatform.statemachine.server;

/**
 * @author Ruimin Wu
 * @date 2021-05-09 13:10
 **/

import com.xiyan.dataplatform.statemachine.anno.OrderProcessor;
import com.xiyan.dataplatform.statemachine.domain.ServiceResult;
import com.xiyan.dataplatform.statemachine.domain.StateContext;

/**
 * 创建订单状态对应的状态处理器
 * @author wrmu
 */
@OrderProcessor(state = "INIT", event = "", bizCode = {"CHEAP", "POPULAR"}, sceneId = "H5")
public class StateCreateProcessor implements StateProcessor {
    @Override
    public ServiceResult action(StateContext stateContext) throws Exception {
        return null;
    }
}


package com.xiyan.dataplatform.statemachine.server;

/**
 * @author Ruimin Wu
 * @date 2021-05-09 13:09
 **/

import com.xiyan.dataplatform.statemachine.domain.ServiceResult;
import com.xiyan.dataplatform.statemachine.domain.StateContext;

/**
 * 状态机处理器接口
 */
public interface StateProcessor<T, C> {
    /**
     * 执行状态迁移的入口
     */
    ServiceResult<T> action(StateContext<C> stateContext) throws Exception;
}
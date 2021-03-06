package com.xiyan.dataplatform.statemachine.server;

/**
 * @author Ruimin Wu
 * @date 2021-05-09 13:11
 **/

import com.xiyan.dataplatform.statemachine.domain.ServiceResult;
import com.xiyan.dataplatform.statemachine.domain.StateContext;
import org.springframework.stereotype.Component;

/**
 * 状态机处理器模板类
 */
@Component
public abstract class AbstractStateProcessor<T, C> implements StateProcessor<T, C>, StateActionStep<T, C> {

    @Override
    public final ServiceResult<T> action(StateContext<C> context) throws Exception {
        ServiceResult<T> result = null;
        try {
            // 数据准备
            this.prepare(context);
            // 串行校验器
            result = this.check(context);
            if (!result.isSuccess()) {
                return result;
            }
            // getNextState不能在prepare前，因为有的nextState是根据prepare中的数据转换而来
            String nextState = this.getNextState(context);
            // 业务逻辑
            result = this.action(nextState, context);
            if (!result.isSuccess()) {
                return result;
            }
            // 持久化
            result = this.save(nextState, context);
            if (!result.isSuccess()) {
                return result;
            }
            // after
            this.after(context);
            return result;
        } catch (Exception e) {
            throw e;
        }
    }
}

package com.github.program_in_chinese.junit4_in_chinese;

import static com.github.program_in_chinese.junit4_in_chinese.断言类.*;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Azige
 */
@RunWith(运行器.class)
public class 运行器测试类{

    @测试
    public void 基本(){
        相等(2, 1 + 1);
    }

    @测试(期望异常 = IllegalStateException.class)
    public void 期望异常的情况(){
        throw new IllegalStateException();
    }

    @测试
    @Test(expected = IllegalStateException.class)
    public void 混用的情况(){
        // 什么也不做，如果只有 @Test 的情况下应当测试失败
    }
}

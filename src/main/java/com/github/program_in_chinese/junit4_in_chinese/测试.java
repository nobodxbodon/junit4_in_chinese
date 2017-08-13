/*
 * Copyright (C) 2017 Azige
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.program_in_chinese.junit4_in_chinese;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.Test.None;

/**
 * {@link org.junit.Test} 的中文等价替换。
 *
 * @author Azige
 */
// TODO: 翻译 org.junit.Test 的参考文档？
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface 测试{

    Class<? extends Throwable> 期望异常() default None.class;

    long 超时() default 0L;
}

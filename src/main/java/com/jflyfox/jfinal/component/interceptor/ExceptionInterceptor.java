/**
 * Copyright 2015-2025 FLY的狐狸(email:jflyfox@sina.com qq:369191470).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.jflyfox.jfinal.component.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.log.Log;
import com.jflyfox.util.Config;

/**
 * 设置用户session公共属性
 * 
 * 2014年8月9日 下午11:18:02 flyfox 330627517@qq.com
 */
public class ExceptionInterceptor implements Interceptor {

	private final static Log log = Log.getLog(ExceptionInterceptor.class);

	public void intercept(Invocation ai) {

		try {
			ai.invoke();
		} catch (Exception e) {
			log.error("异常：", e);
			Controller controller = ai.getController();
			controller.setAttr("error", e.toString());
			controller.render(Config.getStr("PAGES.500"));
		}

	}
}

/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.saml.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.saml.model.SPSessionClp;
import com.liferay.portal.saml.model.SSOSessionClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "saml-web";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(SPSessionClp.class.getName())) {
			SPSessionClp oldCplModel = (SPSessionClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.liferay.portal.saml.model.impl.SPSessionImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setSpSessionId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getSpSessionId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getCompanyId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getUserId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value3 = oldCplModel.getCreateDate();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setSsoSessionId",
							new Class[] { Long.TYPE });

					Long value4 = new Long(oldCplModel.getSsoSessionId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setIssuer",
							new Class[] { String.class });

					String value5 = oldCplModel.getIssuer();

					method5.invoke(newModel, value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(SSOSessionClp.class.getName())) {
			SSOSessionClp oldCplModel = (SSOSessionClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.liferay.portal.saml.model.impl.SSOSessionImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setSsoSessionId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getSsoSessionId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getCompanyId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getUserId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value3 = oldCplModel.getCreateDate();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setLastActiveDate",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getLastActiveDate();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setKey",
							new Class[] { String.class });

					String value5 = oldCplModel.getKey();

					method5.invoke(newModel, value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.liferay.portal.saml.model.impl.SPSessionImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					SPSessionClp newModel = new SPSessionClp();

					Method method0 = oldModelClass.getMethod("getSpSessionId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setSpSessionId(value0);

					Method method1 = oldModelClass.getMethod("getCompanyId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value1);

					Method method2 = oldModelClass.getMethod("getUserId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setUserId(value2);

					Method method3 = oldModelClass.getMethod("getCreateDate");

					Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

					newModel.setCreateDate(value3);

					Method method4 = oldModelClass.getMethod("getSsoSessionId");

					Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

					newModel.setSsoSessionId(value4);

					Method method5 = oldModelClass.getMethod("getIssuer");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setIssuer(value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.portal.saml.model.impl.SSOSessionImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					SSOSessionClp newModel = new SSOSessionClp();

					Method method0 = oldModelClass.getMethod("getSsoSessionId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setSsoSessionId(value0);

					Method method1 = oldModelClass.getMethod("getCompanyId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value1);

					Method method2 = oldModelClass.getMethod("getUserId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setUserId(value2);

					Method method3 = oldModelClass.getMethod("getCreateDate");

					Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

					newModel.setCreateDate(value3);

					Method method4 = oldModelClass.getMethod(
							"getLastActiveDate");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setLastActiveDate(value4);

					Method method5 = oldModelClass.getMethod("getKey");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setKey(value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}
package com.kimyunjae.util.common;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

public class BeanPropertySetter {
	public static void setProps(HttpServletRequest req, Object bean) {
		Method[] methods = bean.getClass().getDeclaredMethods();
		for (Method m : methods) {
			Class<?>[] params = m.getParameterTypes();
			try {
				if (m.getName().startsWith("set") && params.length == 1) {
					String paramName = m.getName().substring(3, 4).toLowerCase() + m.getName().substring(4);
					String paramValue = req.getParameter(paramName);
					if (req != null && paramValue != null) {
						Object targetParam = paramValue;
						if (params[0] == Integer.class || params[0] == int.class) {
							targetParam = Integer.parseInt(paramValue);
						} else if (params[0] == Double.class || params[0] == double.class) {
							targetParam = Double.parseDouble(paramValue);
						} else if (params[0] == Boolean.class || params[0] == boolean.class) {
							targetParam = paramValue.equals("0") ? false : true;
						}
						m.invoke(bean, targetParam);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void setProps(HttpServletRequest req, List<Object> bean) {
		for(int i = 0 ; i < bean.size(); i ++) {
			Method[] methods = bean.get(i).getClass().getDeclaredMethods();
			for (Method m : methods) {
				Class<?>[] params = m.getParameterTypes();
				try {
					if (m.getName().startsWith("set") && params.length == 1) {
						String paramName = m.getName().substring(3, 4).toLowerCase() + m.getName().substring(4);
						String paramValue = req.getParameter(paramName);
						if (req != null && paramValue != null) {
							Object targetParam = paramValue;
							if (params[0] == Integer.class || params[0] == int.class) {
								targetParam = Integer.parseInt(paramValue);
							} else if (params[0] == Double.class || params[0] == double.class) {
								targetParam = Double.parseDouble(paramValue);
							} else if (params[0] == Boolean.class || params[0] == boolean.class) {
								targetParam = paramValue.equals("0") ? false : true;
							}
							m.invoke(bean.get(i), targetParam);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void setProps(MultipartRequest req, Object bean) {
		Method[] methods = bean.getClass().getDeclaredMethods();
		for (Method m : methods) {
			Class<?>[] params = m.getParameterTypes();
			try {
				if(m.getName().startsWith("set") && params.length == 1) {
					String paramName = m.getName().substring(3,4).toLowerCase() + m.getName().substring(4);
					String paramValue = req.getParameter(paramName);
					if(req != null && paramValue != null) {
						Object targetParam = paramValue;
						
						if(params[0] == Integer.class && params[0] == int.class) {
							targetParam = Integer.parseInt(paramValue);
						} else if(params[0] == Double.class && params[0] == double.class) {
							targetParam = Double.parseDouble(paramValue);
						} else if(params[0] == Boolean.class && params[0] == boolean.class) {
							targetParam = paramValue.equals("0") ? false : true;
						} 
						m.invoke(bean, targetParam);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

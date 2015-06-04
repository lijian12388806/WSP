package com.liveneo.plat.web.context;

import sun.awt.AppContext;

public class AppContextHolder {

	private static final InheritableThreadLocal<AppContext> holder = new InheritableThreadLocal<AppContext>() {

		@Override
		protected AppContext initialValue() {
			return null;
		}

	};

	public static AppContext getContext() {
		return holder.get();
	}

	public static void setContext(AppContext context) {
		holder.set(context);
	}
	
}

package com.example.login.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Login implements EntryPoint {

	@Override
	public void onModuleLoad() {
		AppController appViewer = new AppController();
		appViewer.go(RootPanel.get());
	}

}

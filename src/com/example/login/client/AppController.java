package com.example.login.client;

import com.example.login.client.presenter.LoginPresenter;
import com.example.login.client.presenter.SuccessPresenter;
import com.example.login.client.view.LoginView;
import com.example.login.client.view.SuccessView;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements ValueChangeHandler<String> {
	private HasWidgets container;
	
	public AppController(){
		History.addValueChangeHandler(this);
	}
	
	public void go(final HasWidgets container) {
		this.container = container;
		if("".equals(History.getToken())) {
			History.newItem("login"); // default page to go
		} else {
			History.fireCurrentHistoryState();
		}
	}
	
	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();
		
		if(token != null) {
			if(token.equals("login")) {
				LoginView view = new LoginView();
				LoginPresenter presenter = new LoginPresenter(view);
				presenter.go(container);
			} else if (token.contains("success")) {
				String username = token.split(":")[1];
				SuccessView view = new SuccessView();
				SuccessPresenter presenter = new SuccessPresenter(view);
				presenter.init(username);
				presenter.go(container);
			}
		}
	}
}

package com.example.login.client.presenter;

import com.example.login.client.view.LoginView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

public class LoginPresenter {
	public interface View {
		TextBox getUsernameTxt();
		PasswordTextBox getPasswordTxt();
		Button getLoginBtn();
	}
	
	LoginView view;
	
	public LoginPresenter(LoginView view) {
		this.view = view;
		bind();
	}
	
	private void bind() {
		view.getLoginBtn().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boolean flg = true;
				if(view.getUsernameTxt().getText().trim().length() <= 0) {
					flg = false;
					view.getUsernameTxt().setStyleName("error");
				}
				if(view.getPasswordTxt().getText().trim().length() <= 0) {
					flg = false;
					view.getPasswordTxt().setStyleName("error");
				}
				if(flg) {
					History.newItem("success:"+view.getUsernameTxt().getText().trim());
				}
			}
		});
		
		view.getUsernameTxt().addFocusHandler(new FocusHandler() {
			public void onFocus(FocusEvent event) {
				view.getUsernameTxt().removeStyleName("error");
			}
		});
		view.getPasswordTxt().addFocusHandler(new FocusHandler() {
			public void onFocus(FocusEvent event) {
				view.getPasswordTxt().removeStyleName("error");
			}
		});
	}
	
	public void go(final HasWidgets container) {
		container.clear();
		container.add(view.asWidget());
	}
}

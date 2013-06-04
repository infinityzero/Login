package com.example.login.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.example.login.client.presenter.LoginPresenter;

public class LoginView extends Composite implements LoginPresenter.View {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, LoginView> {
	}
	
	@UiField TextBox txtUsername;
	@UiField PasswordTextBox txtPassword;
	@UiField Button btnLogin;

	public LoginView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public TextBox getUsernameTxt() {
		return txtUsername;
	}

	@Override
	public PasswordTextBox getPasswordTxt() {
		return txtPassword;
	}

	@Override
	public Button getLoginBtn() {
		return btnLogin;
	}

}

package com.example.login.client.view;

import com.google.gwt.core.client.GWT;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.example.login.client.presenter.SuccessPresenter;

public class SuccessView extends Composite implements SuccessPresenter.View {

	private static SuccessViewUiBinder uiBinder = GWT
			.create(SuccessViewUiBinder.class);

	interface SuccessViewUiBinder extends UiBinder<Widget, SuccessView> {
	}

	@UiField
	Label lblUsername;

	public SuccessView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public Label getUsernameLbl() {
		return lblUsername;
	}

}

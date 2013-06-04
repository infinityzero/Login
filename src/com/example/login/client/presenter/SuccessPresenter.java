package com.example.login.client.presenter;

import com.example.login.client.view.SuccessView;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;

public class SuccessPresenter {
	// interface for control from .ui.xml
	public interface View {
		Label getUsernameLbl();
	}

	private SuccessView view;

	public SuccessPresenter(SuccessView view) {
		this.view = view;
	}

	public void init(String username) {
		view.getUsernameLbl().setText(username);
	}

	public void go(final HasWidgets container) {
		container.clear();
		container.add(view.asWidget());
	}
}

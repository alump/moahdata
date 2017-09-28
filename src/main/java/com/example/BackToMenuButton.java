package com.example;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;

public class BackToMenuButton extends Button {

    public BackToMenuButton() {
        setIcon(VaadinIcons.MENU);
        addClickListener(this::clicked);
    }

    private void clicked(ClickEvent event) {
        getUI().getNavigator().navigateTo(MainView.NAME);
    }
}

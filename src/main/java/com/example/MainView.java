package com.example;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class MainView extends VerticalLayout implements View {

    public final static String NAME = "";

    public MainView() {
        setWidth(100, Unit.PERCENTAGE);
        setSpacing(true);
        setMargin(true);

        Button grid = new Button("Grid", e -> getUI().getNavigator().navigateTo(GridView.NAME));
        Button sheet = new Button("Spreadsheet", e -> getUI().getNavigator().navigateTo(SheetView.NAME));

        addComponents(grid, sheet);
    }
}

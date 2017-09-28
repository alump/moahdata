package com.example;

import com.example.data.DataGenerator;
import com.example.data.DataObject;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class GridView extends VerticalLayout implements View {

    public final static String NAME = "grid";

    private Grid<DataObject> grid;

    public GridView() {
        setWidth(100, Unit.PERCENTAGE);
        setSpacing(true);
        setMargin(true);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        BackToMenuButton menu = new BackToMenuButton();
        Button medium = new Button("100k", VaadinIcons.FOLDER_OPEN);
        medium.addClickListener(e -> grid.setDataProvider(createProvider(100000)));
        Button large = new Button("500k", VaadinIcons.FOLDER_OPEN);
        large.addClickListener(e -> grid.setDataProvider(createProvider(500000)));
        buttons.addComponents(menu, medium, large);

        grid = new Grid();
        grid.setColumnReorderingAllowed(true);
        grid.setWidth(100, Unit.PERCENTAGE);
        grid.setHeightByRows(10);
        grid.addColumn(DataObject::getIndex).setCaption("Row").setHidable(true);
        grid.addColumn(DataObject::getName).setCaption("Name").setHidable(true);
        grid.addColumn(DataObject::getCity).setCaption("City").setHidable(true);
        grid.addColumn(DataObject::getPhone).setCaption("Phone").setHidable(true);

        addComponents(buttons, grid);
    }

    private static ListDataProvider<DataObject> createProvider(int size) {
        List<DataObject> data = new ArrayList<>(size);
        DataGenerator.generate(size, data::add);
        ListDataProvider<DataObject> provider = new ListDataProvider<>(data);
        return provider;
    }
}

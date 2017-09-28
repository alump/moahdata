package com.example;

import com.vaadin.addon.spreadsheet.Spreadsheet;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

import java.io.IOException;

public class SheetView extends VerticalLayout implements View {

    public final static String NAME = "sheet";

    private Spreadsheet sheet;

    public SheetView() {
        setWidth(100, Unit.PERCENTAGE);
        setSpacing(true);
        setMargin(true);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);

        BackToMenuButton menu = new BackToMenuButton();
        Button tiny = new Button("100", VaadinIcons.FOLDER_OPEN);
        tiny.addClickListener(e -> loadFile("tiny.xlsx"));
        Button small = new Button("10k", VaadinIcons.FOLDER_OPEN);
        small.addClickListener(e -> loadFile("small.xlsx"));
        Button medium = new Button("100k", VaadinIcons.FOLDER_OPEN);
        medium.addClickListener(e -> loadFile("medium.xlsx"));
        Button large = new Button("500k", VaadinIcons.FOLDER_OPEN);
        large.addClickListener(e -> loadFile("big.xlsx"));
        buttons.addComponents(menu, tiny, small, medium, large);

        sheet = new Spreadsheet();
        sheet.setWidth(100, Unit.PERCENTAGE);

        addComponents(buttons, sheet);
    }

    private void loadFile(String fileName) {
        try {
            sheet.read(getClass().getClassLoader().getResourceAsStream(fileName));
        } catch(IOException e) {
            e.printStackTrace();
            Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
        }
    }
}

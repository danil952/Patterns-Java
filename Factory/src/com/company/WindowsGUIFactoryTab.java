package com.company;


public class WindowsGUIFactoryTab implements GUIFactory { //реализуем фабрику определенного типа
    public WindowsGUIFactoryTab() {
        System.out.println("Creating gui factory for Windows Tab");
    }

    @Override
    public Element showElement(GUIElements type) {
        if (type == GUIElements.BUTTON) {
            return new WindowsButtonTab();
        } else if (type == GUIElements.SELECT) {
            return new WindowsSelectTab();
        } else return null;
    }
}

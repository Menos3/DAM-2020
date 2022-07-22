package org.psg.m15.controls.integertextfield;

import javafx.scene.control.TextField;

public class IntegerTextField extends TextField {

    public IntegerTextField() {
        super();
        //
        this.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                this.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }
}
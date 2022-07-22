package org.psg.m15.app.classes;

import org.psg.m15.app.enums.Modes;
import org.psg.m15.app.interfaces.IInicia;

public abstract class DefaultDBControllerModes extends DefaultDBController implements IInicia {

    private Modes mode;

    public Modes getMode() { return mode; }

    public void setMode(Modes mode) { this.mode = mode; }
}

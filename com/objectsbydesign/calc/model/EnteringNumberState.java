/**
    Object-Oriented Calculator

    Copyright (C) 1999-2002, Objects by Design, Inc. All Rights Reserved.

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation. A copy of the license may be found at
    http://www.objectsbydesign.com/projects/gpl.txt
 */

package com.objectsbydesign.calc.model;


import java.util.ArrayList;
import java.util.List;

public class EnteringNumberState extends State {

    public static final int MY_CONST = 490;
    public static final int SEED = 5;

    public EnteringNumberState(Cpu cpu) {
        super(cpu);
    }

    public State enterDigit(String digit) {

        // add the digit
        display.addDigit(digit);

        // remain in this state
        return this;
    }

    public State enterOperation(Operation op) {

        // push the current display value onto the operand stack
        cpu.pushDisplayRegister();

        // push the new operation onto the operation stack
        cpu.pushOperation(op);

        // no lookahead: go to WaitingForInput
        if (!op.getLookahead())
            return cpu.WaitingForInputState;

            // lookahead: go to WaitingForNumber
        else
            return cpu.WaitingForNumberState;
    }

    public State enterValue(Operation op) throws Exception {
        // execute operation for entering value (e.g. memory recall)
        cpu.executeOperation(op);

        List<String> list = new ArrayList<>();
        String[] arr = new String[10];




        // next state
        return cpu.WaitingForOperationState;
    }

    public int getZ() {
        int x,y;
        x=5;
        y=6;
        return x + y;
    }

}



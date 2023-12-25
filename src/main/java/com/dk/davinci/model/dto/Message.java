package com.dk.davinci.model.dto;

import com.dk.davinci.model.Command;
import org.springframework.stereotype.Component;

public class Message<T> {
    private Command command;
    private T data;

    public Message(Command command, T data) {
        this.command = command;
        this.data = data;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

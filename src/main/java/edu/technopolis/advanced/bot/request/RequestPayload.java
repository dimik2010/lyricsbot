package edu.technopolis.advanced.bot.request;

import java.io.Serializable;

public interface RequestPayload extends Serializable {

    String toString();


    class EmptyPayload implements RequestPayload {
        private EmptyPayload() {

        }

    }
}

package edu.technopolis.advanced.bot.response;

public class SubscribeResponse extends Response {
    boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

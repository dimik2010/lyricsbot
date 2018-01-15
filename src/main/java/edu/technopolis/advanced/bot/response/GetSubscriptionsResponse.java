package edu.technopolis.advanced.bot.response;

import java.util.List;

public class GetSubscriptionsResponse extends Response {
    private List<Subscription> subscriptions;

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}

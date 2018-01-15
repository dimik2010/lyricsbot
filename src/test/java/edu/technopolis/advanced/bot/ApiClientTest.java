package edu.technopolis.advanced.bot;

import java.io.IOException;

import edu.technopolis.advanced.bot.request.*;
import edu.technopolis.advanced.bot.response.LyricsResponse;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.technopolis.advanced.bot.incoming.request.Message;
import edu.technopolis.advanced.bot.response.GetSubscriptionsResponse;
import edu.technopolis.advanced.bot.response.SendMessageResponse;
import edu.technopolis.advanced.bot.response.SubscribeResponse;
import junit.framework.TestCase;

public class ApiClientTest {
    private static ApiClient client;

    @BeforeClass
    public static void createClient() throws IOException {
        client = new ApiClient("https", "api.ok.ru",
                "access_token=tkn1EWSeqziuAuKC9eyAugzpvNPJTkWuLLf8dOBAox8M8qVq0rjiM152BFbpyntgGZhLq1:CBAPONCMEBABABABA");
    }

    @Test
    public void testSubscriptions() throws Exception {
        GetSubscriptionsResponse subscriptions = client.get(new GetSubscriptionsRequest("/graph/me/subscriptions"), GetSubscriptionsResponse.class);
        subscriptions.getSubscriptions().forEach(subscription -> System.out.println(subscription.getUrl()));
        TestCase.assertNotNull(subscriptions);
    }

    @Test
    public void testSubscribe() throws Exception {
        SubscribeRequest req = new SubscribeRequest("/graph/me/subscribe");
        SubscribePayload payload = new SubscribePayload();
        payload.setUrl("https://bot.jtechnopolis.pw/onmessage");
        req.setPayload(payload);
        SubscribeResponse status = client.post(req, SubscribeResponse.class);
        TestCase.assertNotNull(status);
    }

    @Test
    public void testPostMessage() throws Exception {
        SendMessageRequest req = new SendMessageRequest("/graph/me/messages", "chat:C3e7a6b21f900");
        Message message = new Message();
        message.setText("text");
        SendMessagePayload payload = new SendMessagePayload(new SendRecipient("user:541569460261"), message);
        req.setPayload(payload);
        SendMessageResponse status = client.post(req, SendMessageResponse.class);
        TestCase.assertNotNull(status);
    }

    @Test
    public void testLyricsClient() throws IOException {
        LyricsApiClient lyricsApiClient = new LyricsApiClient("https", "musixmatchcom-musixmatch.p.mashape.com", null);
        String lyricsQuery = String.format("/wsr/1.1/matcher.lyrics.get?q_artist=%s&q_track=%s", "michael+jackson", "bad");
        LyricsResponse lyricsResponse = lyricsApiClient.get(new LyricsRequest(lyricsQuery));
        Assert.assertNotNull(lyricsResponse.getLyricsBody());
        Assert.assertNotNull(lyricsResponse.getLyricsLang());
    }

    @AfterClass
    public static void closeClient() throws IOException {
        client.close();
    }
}

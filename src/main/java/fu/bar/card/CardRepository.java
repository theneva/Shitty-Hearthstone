package fu.bar.card;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CardRepository
{
    public CardRepository() throws Exception
    {
        final HttpResponse<JsonNode> response = Unirest.get("https://irythia-hs.p.mashape.com/cards")
                .header("X-Mashape-Key", "wKWpmL6JcymshAxYRhq8dV8b7U9Cp1Ph4IGjsnPcwbeLuyCz6t")
                .asJson();

        final String cardsAsJson = response.getBody().toString();

        final JsonArray jsonElements = new Gson().fromJson(cardsAsJson, JsonArray.class);

        System.out.println(jsonCardArrayToCards(jsonElements));
    }

    final List<Card> jsonCardArrayToCards(final JsonArray cardArray) {

        final List<Card> cards = new ArrayList<>();

        for (JsonElement cardElement : cardArray)
        {
            cards.add(jsonCardElementToCard(cardElement));
        }

        return cards;
    }

    private Card jsonCardElementToCard(final JsonElement cardElement) {
        final JsonObject cardObject = (JsonObject) cardElement;

        final String name = unquote(cardObject.get("name"));
        final String text = unquote(cardObject.get("description"));
        final int cost = unquoteInt(cardObject.get("cost"));

        return new Card(name, text, cost);
    }

    private String unquote(final JsonElement jsonStringElement) {
        return unquote(jsonStringElement.toString());
    }

    private String unquote(final String text) {
        String strippedText = StringUtils.remove(text, "\"");
        strippedText = strippedText.replaceAll("<(.*?)>", "");
        return StringUtils.remove(strippedText, "'");

    }

    private int unquoteInt(final JsonElement integerAsText) {

        if ("null".equals(integerAsText.toString())) {
            return -1;
        }

        return Integer.valueOf(unquote(integerAsText));
    }
}

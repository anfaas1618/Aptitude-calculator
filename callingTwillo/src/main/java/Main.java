// Install the Java helper library from twilio.com/docs/libraries/java
import java.net.URI;
import java.net.URISyntaxException;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import spark.Spark;

class MakePhoneCall {
    // Get your Account SID and Auth Token from https://twilio.com/console
    // To set up environment variables, see http://twil.io/secure
    public static final String ACCOUNT_SID = "AC870492cd3e4bfa2f193786f1f0f9dca9";
    public static final String AUTH_TOKEN = "924d9ea9d55405e455c67d25c55896e8";

    public static void main(String[] args) throws URISyntaxException {
        Spark.port(80);
        Spark.get("/call", (request, response) -> {
            // your callback code
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            String from = "+19035686949";
            String to = "+917974471702";

            Call call = Call.creator(new PhoneNumber(to), new PhoneNumber(from),
                    new URI("https://demo.twilio.com/welcome/voice/")).create();

            System.out.println(call.getSid());
            return null;
        });
    }
}
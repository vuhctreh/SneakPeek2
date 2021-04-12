package com.victor.sneakpeek2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SelectedCardActivity extends AppCompatActivity {
    // Declare variables
    ImageView image;
    Toolbar toolbar;
    TextView skuBox, priceBox, retailBox, dateBox;
    String size;
    String endpoint;

    Map<String, Map<String, String>> endpointCollection = new HashMap<String, Map<String, String>>();

    Map<String, String> aj1_unc = new HashMap<String, String>();
    Map<String, String> dunk_city_market = new HashMap<String, String>();
    Map<String, String> sb_supreme_dunk_blue = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_card);

        /**
         * Populates endpointCollection on creation.
         */
        populate();

        /**
         * Assign elements in view to their respective variables
         * */
        image = findViewById(R.id.image);
        priceBox = findViewById(R.id.price);
        skuBox = findViewById(R.id.skuField);
        retailBox = findViewById(R.id.retailField);
        dateBox = findViewById(R.id.dateField);

        /**
         * Gets intent in order to access extras
         * */
        Intent intent = getIntent();

        /**
         * If extras are not null, sets the text and images in the view as well as the action bar.
         * */
        if (intent.getExtras() != null) {
            Model model = (Model) intent.getSerializableExtra("data");
            size = (String) intent.getSerializableExtra("size");

            skuBox.setText(model.getDesc());
            image.setImageResource(model.getImage());
            retailBox.setText(model.getRetail());
            dateBox.setText(model.getDate());

            /**
             * sets toolbar title
             * */
            toolbar = findViewById(R.id.toolbar);
            toolbar.setTitle(model.getTitle());
            /**
             * sets toolbar as an actionbar
             * */
            setSupportActionBar(toolbar);
            /**
             * enable back button on toolbar
             * */
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            /**
             * fetches endpoint for given size and sku (size is a SharedPreference)
             */
            endpoint = endpointCollection.get(model.getDesc()).get(size);
        }

        /**
         * Instantiate retrofit builder for json parsing
         * */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://stockx.com/api/products/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        /**
         *  Create instance of StockXApi.Class via retrofit
         * */
        StockXApi stockXApi = retrofit.create(StockXApi.class);

        /**
        * Generate get request, pass endpoint dynamically into URL. Uses getProductInfo
        * method from StockXApi
        */
        Call<ProductInfo> call = stockXApi
                .getProductInfo("https://stockx.com/api/products/" + endpoint +
                        "/activity?state=480&currency=GBP&limit=2&page=1&sort=createdAt&order=DESC&country=FR");

        /**
         * Retrofit method to queue the request in a separate thread.
         * */
        call.enqueue(new Callback<ProductInfo>() {
            @Override
            public void onResponse(Call<ProductInfo> call, Response<ProductInfo> response) {
                /**
                 * Handle response. If error, show error message and return.
                 */
                if (!response.isSuccessful()) {
                    skuBox.setText("Error: " + response.code());
                    return;
                }
                /**
                 * Sets the text in priceBox using response
                 * */
                priceBox.setText("£" + response.body().getProductActivity().get(0).getLocalAmount());
            }

            @Override
            public void onFailure(Call<ProductInfo> call, Throwable throwable) {
                /**
                 * If error sending request, shows and logs error message.
                 * Tag "Bruh" is used to ease debugging.
                 * */
                priceBox.setText("Error getting price. Please check your connection.");
                Log.d("Bruh", "Attempted fetch failed. " + throwable.toString());
            }
        });
    }

    /**
     * Populates a map of each shoe and puts the maps into endpointCollection.
     */
    public void populate() {
        aj1_unc.put("7", "62ff5d23-bde3-4693-9028-5de527e331c4");
        aj1_unc.put("7.5", "400dd33b-c166-4145-bbdf-439b13909bec");
        aj1_unc.put("8", "c64d400b-ea81-4643-8a4b-be08af1c6a52");
        aj1_unc.put("8.5", "2d146ff6-561e-414e-9cee-bfe0005eadae");
        aj1_unc.put("9", "bf9cc80c-1fd7-4ae8-bbe8-c62d89a3afce");
        aj1_unc.put("9.5", "f70c29a7-22a5-4615-bc0e-2707f662c468");
        aj1_unc.put("10", "69e307aa-663a-4ee2-99f8-39fa66138a51");
        aj1_unc.put("10.5", "a71544f2-a2f8-4f3e-a38c-8a9022784697");
        aj1_unc.put("11", "c7bb98ac-0b06-453a-b8cc-d8fec5f017b0");
        aj1_unc.put("11.5", "b81ffda3-e311-4085-b337-903793a56731");
        aj1_unc.put("12", "51bbab13-c439-429b-813c-57952486036c");

        dunk_city_market.put("7", "8eb55afa-2109-4348-a965-f1a05e0054eb");
        dunk_city_market.put("7.5", "faa004b5-89ef-47ff-a1f5-248ffdef4fe4");
        dunk_city_market.put("8", "e8472dde-200a-465b-966f-622c84b5f0e0");
        dunk_city_market.put("8.5", "6e2a3452-fb8e-4fc1-922b-e8e0783d8e2f");
        dunk_city_market.put("9", "68a2aa0a-9c86-49c2-a5bd-2ad5d5bf8325");
        dunk_city_market.put("9.5", "614b0a58-ca86-4246-836f-60c8ee149cba");
        dunk_city_market.put("10", "74b1ced8-3906-47e7-b359-42b611b48740");
        dunk_city_market.put("10.5", "ddcf161a-a26e-4467-a492-1ea1eef5890f");
        dunk_city_market.put("11", "cc3e89d9-7d3e-442c-8b81-f79332d63fbc");
        dunk_city_market.put("11.5", "cb1d94ab-0a24-4ee7-9db2-41b365ac986a");
        dunk_city_market.put("12", "fd7804e2-bda6-4a12-9961-201b3b9d3022");

        sb_supreme_dunk_blue.put("7", "c26f40c0-3cd1-49a1-9ec6-4bfb1bb78021");
        sb_supreme_dunk_blue.put("7.5", "6ee7612a-6815-4387-b170-4d82aadb481f");
        sb_supreme_dunk_blue.put("8", "e93ec00a-c18b-431f-8104-ee72ae8847b4");
        sb_supreme_dunk_blue.put("8.5", "fbdb7080-1457-4f7b-a637-1a842ecbff73");
        sb_supreme_dunk_blue.put("9", "13aedc99-e403-441b-b716-076d7cf372b1");
        sb_supreme_dunk_blue.put("9.5", "edfb0520-c5bf-474a-b4f1-0db9ec274497");
        sb_supreme_dunk_blue.put("10", "43f9dc2c-78ad-405b-93c9-0084a3e37c32");
        sb_supreme_dunk_blue.put("10.5", "5dac598a-8dee-4688-9bd5-8e58e4ae0ab6");
        sb_supreme_dunk_blue.put("11", "2ad214c1-631e-4f40-b09d-28ec663bccd7");
        sb_supreme_dunk_blue.put("11.5", "ded80704-541b-4b79-8bcf-da5deefd4ce6");
        sb_supreme_dunk_blue.put("12", "4182c71c-2086-4700-8e8d-4781ee943951");

        endpointCollection.put("555088-134", aj1_unc);
        endpointCollection.put("DA6125-900", dunk_city_market);
        endpointCollection.put("DH3228-100", sb_supreme_dunk_blue);
    }
}
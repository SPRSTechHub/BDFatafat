package live.bdfatafat.android.API;

import live.bdfatafat.android.model.add_money.AddMoneyResponse;
import live.bdfatafat.android.model.addmoney_online.AddMoneyOnlineResponse;
import live.bdfatafat.android.model.betPlacement.BetPlacementResponse;
import live.bdfatafat.android.model.forgotPassword.ForgotPasswordResponse;
import live.bdfatafat.android.model.game_category.GameCategoryResponse;
import live.bdfatafat.android.model.game_list.GameListResponse;
import live.bdfatafat.android.model.login_response.LoginResponse;
import live.bdfatafat.android.model.market_ratio.MarketRatioResponse;
import live.bdfatafat.android.model.offer.OfferResponse;
import live.bdfatafat.android.model.profile.ProfileResponse;
import live.bdfatafat.android.model.register_response.RegisterResponse;
import live.bdfatafat.android.model.result.ResultResponse;
import live.bdfatafat.android.model.transaction_history.TransactionHistoryResponse;
import live.bdfatafat.android.model.win_history.WinHistoryResponse;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {
    @POST("api/")
    @Multipart
    Call<AddMoneyResponse> addBank(@Part("action") String str, @Part("mobile") String str2, @Part("userid") String str3, @Part("bankName") String str4, @Part("bankAccNo") String str5, @Part("ifscBank") String str6);

    @POST("api/")
    @Multipart
    Call<AddMoneyResponse> addWithdraw(@Part("action") String str, @Part("mobile") String str2, @Part("amount") String str3, @Part("upi") String str4, @Part("date") String str5, @Part("time") String str6);

    @POST("api/")
    @Multipart
    Call<AddMoneyResponse> addMoney(
            @Part("action") String str,
            @Part("mobile") String str2,
            @Part("amount") String str3,
            @Part("trtype") String str4,
            @Part("balance") String str5,
            @Part("trdetails") String str6,
            @Part("trno") String str7
    );

    @POST("api/")
    @Multipart
    Call<AddMoneyResponse> addUpiId(@Part("action") String str, @Part("mobile") String str2, @Part("userid") String str3, @Part("bankUpi") String str4);

    @POST("api/")
    @Multipart
    Call<ForgotPasswordResponse> forgotPassword(@Part("mobile") String str, @Part("action") String str2);

    @POST("api/")
    @Multipart
    Call<GameCategoryResponse> getGameCategory(@Part("action") String str, @Part("day") String str2);

    @POST("api/")
    @Multipart
    Call<GameListResponse> getGameList(@Part("action") String str, @Part("day") String str2, @Part("cat_id") String str3);

    @POST("api/")
    @Multipart
    Call<MarketRatioResponse> getMarketRatio(@Part("action") String str, @Part("mobile") String str2, @Part("cat_id") String str3);

    @POST("api/")
    @Multipart
    Call<OfferResponse> getOffer(@Part("action") String str, @Part("mobile") String str2);

    @POST("api/")
    @Multipart
    Call<AddMoneyOnlineResponse> addMoneyOnline(@Part("action") String str, @Part("mobile") String str2, @Part("amount") String str3, @Part("trtype") String str4, @Part("pmgateway") String str5);

    @POST("api/")
    @Multipart
    Call<TransactionHistoryResponse> getTransactionHistory(@Part("action") String str, @Part("mobile") String str2, @Part("sortBy") String str3, @Part("sortTo") String str4, @Part("lstart") String str5, @Part("lend") String str6);

    @POST("api/")
    @Multipart
    Call<WinHistoryResponse> getWinHistory(@Part("action") String str,
                                           @Part("mobile") String str2,
                                           @Part("catId") String str3,
                                           @Part("sortBy") String str4,
                                           @Part("sortTo") String str5,
                                           @Part("lstart") String str6,
                                           @Part("lend") String str7,
                                           @Part("searchKey") String str8);


    @POST("api/")
    @Multipart
    Call<LoginResponse> login(@Part("mobile") String str, @Part("password") String str2, @Part("action") String str3);

    @POST("api/")
    @Multipart
    Call<ResultResponse> getWinResult(@Part("mobile") String str, @Part("action") String str3);


    @POST("api/")
    @Multipart
    Call<ProfileResponse> getUserDetails(@Part("mobile") String str, @Part("action") String str3);

    @POST("api/")
    @Multipart
    Call<BetPlacementResponse> placeBet(@Part("action") String str, @Part("matchId") String str2, @Part("betType") String str3, @Part("betVal") String str4, @Part("betAmnt") String str5, @Part("mobile") String str6, @Part("date") String str7, @Part("time") String str8);

    @POST("api/")
    @Multipart
    Call<BetPlacementResponse> placeBetJodi(@Part("action") String str, @Part("matchId1") String str2, @Part("matchId2") String str3, @Part("mobile") String str4, @Part("betVal1") String str5, @Part("betVal2") String str6, @Part("betType") String str7, @Part("betAmnt") String str8, @Part("date") String str9, @Part("time") String str10, @Part("day") String str11);

    @POST("api/")
    @Multipart
    Call<RegisterResponse> signUp(@Part("action") String str, @Part("mobile") String str2, @Part("password") String str3, @Part("fullname") String str4);
}

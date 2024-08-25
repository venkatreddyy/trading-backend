package com.venkat.service;

import com.venkat.model.CoinDTO;
import com.venkat.response.ApiResponse;

public interface ChatBotService {
    ApiResponse getCoinDetails(String coinName);

    CoinDTO getCoinByName(String coinName);

    String simpleChat(String prompt);
}

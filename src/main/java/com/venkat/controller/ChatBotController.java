package com.venkat.controller;

import com.venkat.model.CoinDTO;
import com.venkat.request.PromptBody;
import com.venkat.response.ApiResponse;
import com.venkat.service.ChatBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/chat")
public class ChatBotController {

    @Autowired
    private ChatBotService chatBotService;

    @GetMapping("/coin/{coinName}")
    public ResponseEntity<CoinDTO> getCoinDetails(@PathVariable String coinName){

        CoinDTO coinDTO=chatBotService.getCoinByName(coinName);
        return new ResponseEntity<>(coinDTO, HttpStatus.OK);
    }

    @PostMapping("/bot")
    public ResponseEntity<String> simpleChat(@RequestBody PromptBody promptBody){

        String res = chatBotService.simpleChat(promptBody.getPrompt());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    @PostMapping("/bot/coin")
    public ResponseEntity<ApiResponse> getCoinRealtimeTime(@RequestBody PromptBody promptBody){

        ApiResponse res = chatBotService.getCoinDetails(promptBody.getPrompt());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}

package com.nyu.oa.twitter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */

//https://leetcode.com/discuss/interview-question/378237/Twitter-or-OA-2019-or-Authentication-Tokens
public class AuthenticationToken {
    public static int numberOfTokens(int expiryLimit, List<List<Integer>> commands) {
        // Write your code here
        if (commands == null || commands.isEmpty()) {
            return 0;
        }
        Map<Integer, Integer> tokenIdToTokenExpiry = new HashMap<>();
        for (List<Integer> token : commands) {
            if (token.size() != 3) {
                return 0;
            }
            Integer tokenCommand = token.get(0);
            Integer tokenId = token.get(1);
            Integer tokenTime = token.get(2);

            if (tokenCommand == 0) {
                tokenIdToTokenExpiry.put(tokenId, tokenTime + expiryLimit);
            } else {
                if (tokenIdToTokenExpiry.containsKey(tokenId)) {
                    if (tokenTime <= tokenIdToTokenExpiry.get(tokenId)) {
                        tokenIdToTokenExpiry.put(tokenId, tokenTime + expiryLimit);
                    } else {
                        tokenIdToTokenExpiry.remove(tokenId);
                    }
                }
            }
        }
        Integer lastTime = commands.get(commands.size() - 1).get(2);
        return (int) tokenIdToTokenExpiry.values().stream().filter(tokenTime -> tokenTime >= lastTime).count();
    }
}

package org.yuvika.service.impl;

import org.springframework.stereotype.Service;
import org.yuvika.dto.BfhlRequest;
import org.yuvika.dto.BfhlResponse;
import org.yuvika.service.BfhlService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    @Override
    public BfhlResponse process(BfhlRequest request) {

        List<String> odd = new ArrayList<>();
        List<String> even = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> special = new ArrayList<>();

        long sum = 0;

        StringBuilder allAlphabets = new StringBuilder();

        for (String item : request.getData()) {

            if (item.matches("\\d+")) {

                int num = Integer.parseInt(item);

                sum += num;

                if (num % 2 == 0)
                    even.add(item);
                else
                    odd.add(item);

            } else if (item.matches("[a-zA-Z]+")) {

                alphabets.add(item.toUpperCase());

                allAlphabets.append(item);

            } else {

                special.add(item);
            }
        }

        BfhlResponse response = new BfhlResponse();

        response.setIs_success(true);

        response.setUser_id("yuvika_24062026");
        response.setEmail("yuvika1831@gmail.com");
        response.setRoll_number("2310992568");

        response.setOdd_numbers(odd);
        response.setEven_numbers(even);
        response.setAlphabets(alphabets);
        response.setSpecial_characters(special);

        response.setSum(String.valueOf(sum));

        response.setConcat_string(
                alternateCaps(
                        allAlphabets.toString()
                )
        );

        return response;
    }

    private String alternateCaps(String str) {

        String reversed =
                new StringBuilder(str)
                        .reverse()
                        .toString();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < reversed.length(); i++) {

            if (i % 2 == 0)
                result.append(
                        Character.toUpperCase(
                                reversed.charAt(i)
                        )
                );
            else
                result.append(
                        Character.toLowerCase(
                                reversed.charAt(i)
                        )
                );
        }

        return result.toString();
    }
}
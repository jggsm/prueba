package com.pruebatecnica.prueba1.service.impl;

import com.pruebatecnica.prueba1.constants.ApplicationConstants;
import com.pruebatecnica.prueba1.service.AlliterationService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * The type Alliteration service.
 */
@Component
public class AlliterationServiceImpl implements AlliterationService {

    /**
     * Calculate alliteration percentange.
     *
     * @param requestTest the request test
     * @return the string
     */
    @Override
    public String calculateAlliterationPercentange(String requestTest) {

        List<String> wordList = new ArrayList<>(List.of(requestTest.split(ApplicationConstants.PATTERN_ONLY_LETTERS)));
        //We remove any possible empty value in the list created by characters like (,{, [
        wordList.removeIf(String::isEmpty);


        HashMap<String, Integer> lettersMatrix = new HashMap<>();
        int maxValue = 0;
        String maxLetter = "";

        for (String word : wordList) {
            //Extraemos la primera letra de la palabra
            String letter = word.substring(0, 1);
            if (Pattern.matches(ApplicationConstants.PATTERN_CONSONANT, letter)) {
                String lowerCaseLetter = letter.toLowerCase();
                if (lettersMatrix.containsKey(lowerCaseLetter)) {
                    Integer currentValue = lettersMatrix.get(lowerCaseLetter);
                    lettersMatrix.put(lowerCaseLetter, currentValue + 1);
                    if (maxValue < currentValue + 1) {
                        maxValue = currentValue + 1;
                        maxLetter = lowerCaseLetter;
                    }
                } else {
                    lettersMatrix.put(lowerCaseLetter, 1);
                }
            }
        }

        if (maxLetter.isBlank()) {
            return "There is no Alliteration in the requested text.";
        }

        Integer percentage = (maxValue * 100) / wordList.size();

        return "The letter \"" + maxLetter + "\" has a " + percentage + "% of Alliteration.";
    }
}

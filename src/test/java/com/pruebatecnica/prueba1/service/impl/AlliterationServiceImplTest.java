package com.pruebatecnica.prueba1.service.impl;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AlliterationServiceImplTest {

    @InjectMocks
    private AlliterationServiceImpl service;


    @Test
    public void exerciseTest1() {
        String test ="Mike made mellow music with his new microphone.";

        Assertions.assertEquals("The letter \"m\" has a 50% of Alliteration.", service.calculateAlliterationPercentange(test));
    }

    @Test
    public void exerciseTest2() {
        String test ="Yarvis yanked his ankle at yoga, and Yolanda yelled out in surprise.";

        Assertions.assertEquals("The letter \"y\" has a 25% of Alliteration.", service.calculateAlliterationPercentange(test));
    }


    @Test
    public void punctuationMarksTest() {
        String test ="(Yarvis |yanked 'his ankle at {yoga, and \"Yolanda `yelled out in (surprise.";

        Assertions.assertEquals("The letter \"y\" has a 25% of Alliteration.", service.calculateAlliterationPercentange(test));
    }


    @Test
    public void extremePunctuationMarksTest() {
        String test ="(%553536563''¡'223424'14*++´+´1+4+aeiou[][}{][{`+`+´´¨¨Ç¨*^*ç`__--;::;;<<>>=)(/&%$·\"ºº";

        Assertions.assertEquals("There is no Alliteration in the requested text.", service.calculateAlliterationPercentange(test));
    }

}
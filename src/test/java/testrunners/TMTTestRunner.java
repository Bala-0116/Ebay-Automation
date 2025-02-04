package testrunners;

import com.intuit.karate.junit5.Karate;


public class TMTTestRunner {

    @Karate.Test
    Karate testUsers() {
        return Karate.run("classpath:Feature/api.feature").tags("@primary").relativeTo(getClass());
    }

}


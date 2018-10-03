package pages;

import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by kapil.kumar1 on 02/10/18.
 */

public class TestDriverProfileFragement {


    public  TestDriverProfileFragement(){
        onView(withId(R.id.textViewDriverName)).check(matches(isDisplayed()));

    }


    public void testCallButtonDisplayed(){

        onView(withId(R.id.fab)).check(matches(isDisplayed()));

    }


    public void clickonDriverCallButton(){
        onView(withId(R.id.fab)).perform(click());

    }

}

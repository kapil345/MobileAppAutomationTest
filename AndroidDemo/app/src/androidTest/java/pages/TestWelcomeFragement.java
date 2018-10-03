package pages;

import android.app.Activity;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.activities.MainActivity;

import Util.MyTaxiConstants;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created by kapil.kumar1 on 02/10/18.
 */

public class TestWelcomeFragement {

    public  TestWelcomeFragement(ActivityTestRule activityTestRule){
        activityTestRule.launchActivity( new Intent(InstrumentationRegistry.getContext(),MainActivity.class));
        onView(withId(R.id.textSearch)).check(matches(isDisplayed()));
    }

    public void searchDriverName() {

        onView(withId(R.id.textSearch)).perform(typeText(MyTaxiConstants.SEARCH_TEXT));

    }

    public void validateSearchedResults(Activity mActivity){
        onView(withText(MyTaxiConstants.DRIVER_NAME))
                .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                .check(matches(isDisplayed()));

    }

    public void clickOnSecondDisplayedNameFromList(Activity mActivity){
        onView(withText(MyTaxiConstants.DRIVER_NAME))
                .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                .perform(click());

    }

}

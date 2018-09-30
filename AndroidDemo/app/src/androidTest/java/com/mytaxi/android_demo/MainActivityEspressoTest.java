package com.mytaxi.android_demo;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.mytaxi.android_demo.activities.AuthenticationActivity;
import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.models.Driver;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.not;

/**
 * Created by kapil.kumar1 on 28/09/18.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {



    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    private MainActivity mActivity = null;
    @Before
    public void setActivity() {
        mActivity = activityActivityTestRule.getActivity();
    }

    @Test
    public void searchDriverTest(){

        onView(isRoot()).perform(waitFor(5000));
        onView(withId(R.id.textSearch)).perform(typeText("sa"));
        onView(isRoot()).perform(waitFor(2000));
        //ViewInteraction textView = onView(allOf(withId(android.R.id.text1), isDisplayed()));
     //   onData(hasToString(startsWith("sa"))).inAdapterView(withId(android.R.id.text1)).atPosition(2).perform(click());
        //onData(allOf(is(instanceOf(String.class)), is("Sarah Scott"))).perform(click());



        //  onView(withId(R.id.textSearch)).perform(ViewActions.click());
      //  onData(allOf(is(instanceOf(String.class)), is("sa"))).perform(click());
       // onView(withId(R.id.textSearch)).check(matches(withText("nn")));

        //onData(allOf(is(instanceOf(String.class)), is("Sarah Scott"))).perform(click());
        //onData(equalTo("Sarah Scott")).inRoot(RootMatchers.withDecorView(not(is(activityActivityTestRule.getActivity().getWindow().getDecorView())))).perform(click());
    //    onData(instanceOf(Driver.class)).atPosition(0).perform(click());

        onView(withText("Sara Christensen"))
                .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
        onView(withText("Sarah Scott"))
                .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
        onView(withText("Sarah Scott"))
                .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                .perform(click());

      //  onView(withId(R.id.textSearch))
        //        .check(matches(withText("sa")));

      //  onData(anything()).inAdapterView(withId(android.R.id.text1)).atPosition(2).perform(click());

        onView(isRoot()).perform(waitFor(10000));


       // onData(CoreMatchers.allOf(instanceOf(String.class)),ma )
        System.out.print("waiting here");


    }


    public static ViewAction waitFor(final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "Wait for " + millis + " milliseconds.";
            }

            @Override
            public void perform(UiController uiController, final View view) {
                uiController.loopMainThreadForAtLeast(millis);
            }
        };
    }

}

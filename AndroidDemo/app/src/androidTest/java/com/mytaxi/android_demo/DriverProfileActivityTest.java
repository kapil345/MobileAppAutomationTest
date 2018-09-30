package com.mytaxi.android_demo;

import android.support.test.rule.ActivityTestRule;

import com.mytaxi.android_demo.activities.AuthenticationActivity;
import com.mytaxi.android_demo.activities.DriverProfileActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by kapil.kumar1 on 29/09/18.
 */

public class DriverProfileActivityTest {



    @Rule
    public ActivityTestRule<DriverProfileActivity> activityActivityTestRule = new ActivityTestRule<>(DriverProfileActivity.class);
    @Test
    public void loginSucessTest(){

        onView(withId(R.drawable.ic_phone)).perform(click());

    }
}

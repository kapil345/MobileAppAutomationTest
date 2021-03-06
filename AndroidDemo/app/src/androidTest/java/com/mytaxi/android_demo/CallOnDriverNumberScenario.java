package com.mytaxi.android_demo;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.view.WindowManager;

import com.mytaxi.android_demo.activities.AuthenticationActivity;
import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import Util.LoggerUtils;
import Util.MyTaxiConstants;
import pages.TestDriverProfileFragement;
import pages.TestLoginFragement;
import pages.TestWelcomeFragement;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;

/**
 * Created by kapil.kumar1 on 28/09/18.
 */

public class CallOnDriverNumberScenario {

    private MainActivity mActivity = null;


    @Rule
    public ActivityTestRule<AuthenticationActivity> activityActivityTestRule = new ActivityTestRule<>(AuthenticationActivity.class, false, false);


    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule1 = new ActivityTestRule<>(MainActivity.class, false, false);


    @Test
    public void execute() throws InterruptedException {

        activityActivityTestRule.launchActivity(new Intent(InstrumentationRegistry.getContext(), AuthenticationActivity.class));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getInstrumentation().getUiAutomation().executeShellCommand(
                    "pm grant " + activityActivityTestRule.getActivity().getPackageName()
                            + " android.permission.ACCESS_FINE_LOCATION");
        }
        LoggerUtils.info("Verify login screen");
        TestLoginFragement testLoginFragement = new TestLoginFragement();
        testLoginFragement.clickonLoginButton();
        Thread.sleep(500);
        LoggerUtils.info("Verifying Welcome Screen");
        TestWelcomeFragement testWelcomeFragement = new TestWelcomeFragement(activityActivityTestRule1);
        Thread.sleep(10000);
        MainActivity mActivity = activityActivityTestRule1.getActivity();
        testWelcomeFragement.searchDriverName();
        Thread.sleep(2000);
     //   closeSoftKeyboard();
     //   Thread.sleep(2000);
        testWelcomeFragement.validateSearchedResults(mActivity);
        testWelcomeFragement.clickOnSecondDisplayedNameFromList(mActivity);
        Thread.sleep(2000);
        LoggerUtils.info("Verifying Driver Profile screen");
        TestDriverProfileFragement testDriverProfileFragement = new TestDriverProfileFragement();
        testDriverProfileFragement.testCallButtonDisplayed();
        testDriverProfileFragement.clickonDriverCallButton();
    }


}



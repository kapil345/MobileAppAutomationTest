package com.mytaxi.android_demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.content.IntentSender;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.renderscript.RenderScript;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import static android.support.test.espresso.Espresso.onView;

import com.google.android.gms.location.places.ui.PlacePicker;
import com.mytaxi.android_demo.activities.AuthenticatedActivity;
import com.mytaxi.android_demo.activities.AuthenticationActivity;
import com.mytaxi.android_demo.activities.MainActivity;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.

        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.mytaxi.android_demo", appContext.getPackageName());

    }
    private MainActivity mActivity = null;
    @Before
    public void setActivity() {
        mActivity = activityActivityTestRule1.getActivity();
    }

    @Rule
    public ActivityTestRule<AuthenticationActivity> activityActivityTestRule = new ActivityTestRule<>(AuthenticationActivity.class);


    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule1 = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void A_loginSucessTest() throws InterruptedException {


        onView(withId(R.id.edt_username)).perform(typeText("crazydog335"));
        onView(withId(R.id.edt_password)).perform(typeText("venture"));
        onView(withId(R.id.btn_login)).perform(click());

        activityActivityTestRule1.launchActivity( new Intent(InstrumentationRegistry.getContext(),MainActivity.class));

        onView(withId(R.id.textSearch)).check(matches(isDisplayed()));
        Thread.sleep(10000);

        onView(withId(R.id.textSearch)).perform(typeText("sa"));

        onView(withText("Sarah Scott"))
                .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
        onView(withText("Sarah Scott"))
                .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                .perform(click());

        Thread.sleep(2000);
        onView(withId(R.id.textViewDriverName)).check(matches(isDisplayed()));
        onView(withId(R.id.fab)).check(matches(isDisplayed()));
        onView(withId(R.id.fab)).perform(click());

    }








}

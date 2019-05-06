package es.ulpgc.miguel.fortguide.introduction;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.miguel.fortguide.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class WeaponTestEspresso {

  @Rule
  public ActivityTestRule<IntroductionActivity> mActivityTestRule = new ActivityTestRule<>(IntroductionActivity.class);

  @Test
  public void weaponTestEspresso() {
    ViewInteraction appCompatButton = onView(
        allOf(withId(R.id.buttonContinue), withText("CONTINUAR"),
            childAtPosition(
                childAtPosition(
                    withId(android.R.id.content),
                    0),
                1),
            isDisplayed()));
    appCompatButton.perform(click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction linearLayout = onView(
        allOf(withId(R.id.weaponLayout),
            childAtPosition(
                childAtPosition(
                    withClassName(is("android.widget.ScrollView")),
                    0),
                4)));
    linearLayout.perform(scrollTo(), click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction appCompatButton2 = onView(
        allOf(withId(R.id.commonRarityButton), withText("Common"),
            childAtPosition(
                childAtPosition(
                    withClassName(is("android.widget.HorizontalScrollView")),
                    0),
                0)));
    appCompatButton2.perform(scrollTo(), click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction appCompatButton3 = onView(
        allOf(withId(R.id.uncommonRarityButton), withText("Uncommon"),
            childAtPosition(
                childAtPosition(
                    withClassName(is("android.widget.HorizontalScrollView")),
                    0),
                1)));
    appCompatButton3.perform(scrollTo(), click());

    ViewInteraction appCompatButton4 = onView(
        allOf(withId(R.id.rareRarityButton), withText("Rare"),
            childAtPosition(
                childAtPosition(
                    withClassName(is("android.widget.HorizontalScrollView")),
                    0),
                2)));
    appCompatButton4.perform(scrollTo(), click());

    ViewInteraction appCompatButton5 = onView(
        allOf(withId(R.id.epicRarityButton), withText("Epic"),
            childAtPosition(
                childAtPosition(
                    withClassName(is("android.widget.HorizontalScrollView")),
                    0),
                3)));
    appCompatButton5.perform(scrollTo(), click());

    ViewInteraction appCompatButton6 = onView(
        allOf(withId(R.id.legendaryRarityButton), withText("Legendary"),
            childAtPosition(
                childAtPosition(
                    withClassName(is("android.widget.HorizontalScrollView")),
                    0),
                4)));
    appCompatButton6.perform(scrollTo(), click());

    ViewInteraction appCompatButton7 = onView(
        allOf(withId(R.id.bananaButton),
            childAtPosition(
                childAtPosition(
                    withClassName(is("android.support.constraint.ConstraintLayout")),
                    1),
                0),
            isDisplayed()));
    appCompatButton7.perform(click());
  }

  private static Matcher<View> childAtPosition(
      final Matcher<View> parentMatcher, final int position) {

    return new TypeSafeMatcher<View>() {
      @Override
      public void describeTo(Description description) {
        description.appendText("Child at position " + position + " in parent ");
        parentMatcher.describeTo(description);
      }

      @Override
      public boolean matchesSafely(View view) {
        ViewParent parent = view.getParent();
        return parent instanceof ViewGroup && parentMatcher.matches(parent)
            && view.equals(((ViewGroup) parent).getChildAt(position));
      }
    };
  }
}

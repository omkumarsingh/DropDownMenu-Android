
package se.kjellstrand.dropdowndemo;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityOfItem2 extends Activity {

    /** Layout holding the droddown view */
    private LinearLayout mDropdownFoldOutMenu;
    private final int[] imgs = {R.drawable.icon_tab_bar_my_profile, R.drawable.icon_tab_bar_deals,
    							R.drawable.icon_tab_bar_ibid, R.drawable.icon_tab_bar_live};

    /** Textview holding the title of the droddown */
    private TextView mDropdownTitle;
    private byte sel = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_2);

        mDropdownFoldOutMenu = ((LinearLayout) findViewById(R.id.dropdown_foldout_menu));
        mDropdownTitle = ((TextView) findViewById(R.id.dropdown_textview));

        final TextView dropDownTextView = (TextView) findViewById(R.id.dropdown_textview);
        final TextView alt0 = (TextView) findViewById(R.id.dropdown_alt0);
        final TextView alt1 = (TextView) findViewById(R.id.dropdown_alt1);
        alt1.setCompoundDrawablesWithIntrinsicBounds(imgs[1], 0,
                R.drawable.icn_dropdown_checked, 0);
        final TextView alt2 = (TextView) findViewById(R.id.dropdown_alt2);
        final TextView alt3 = (TextView) findViewById(R.id.dropdown_alt3);

        dropDownTextView.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mDropdownFoldOutMenu.getVisibility() == View.GONE) {
                            openDropdown();
                        } else {
                            closeDropdown();
                        }
                    }
                });

        alt0.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dropDownTextView.setText(R.string.alt0);
                        sel = 0;
                        closeDropdown();
                        alt0.setCompoundDrawablesWithIntrinsicBounds(imgs[0], 0,
                                R.drawable.icn_dropdown_checked, 0);
                        alt1.setCompoundDrawablesWithIntrinsicBounds(imgs[1], 0, 0, 0);
                        alt2.setCompoundDrawablesWithIntrinsicBounds(imgs[2], 0, 0, 0);
                        alt3.setCompoundDrawablesWithIntrinsicBounds(imgs[3], 0, 0, 0);
                        
                        Intent intent = new Intent(ActivityOfItem2.this, MainActivity.class);
                        startActivity(intent);
                    }
                });

        alt1.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dropDownTextView.setText(R.string.alt1);
                        sel = 1;
                        closeDropdown();
                        alt0.setCompoundDrawablesWithIntrinsicBounds(imgs[0], 0, 0, 0);
                        alt1.setCompoundDrawablesWithIntrinsicBounds(imgs[1], 0,
                                R.drawable.icn_dropdown_checked, 0);
                        alt2.setCompoundDrawablesWithIntrinsicBounds(imgs[2], 0, 0, 0);
                        alt3.setCompoundDrawablesWithIntrinsicBounds(imgs[3], 0, 0, 0);
                    }
                });

        alt2.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dropDownTextView.setText(R.string.alt2);
                        sel = 2;
                        closeDropdown();
                        alt0.setCompoundDrawablesWithIntrinsicBounds(imgs[0], 0, 0, 0);
                        alt1.setCompoundDrawablesWithIntrinsicBounds(imgs[1], 0, 0, 0);
                        alt2.setCompoundDrawablesWithIntrinsicBounds(imgs[2], 0,
                                R.drawable.icn_dropdown_checked, 0);
                        alt3.setCompoundDrawablesWithIntrinsicBounds(imgs[3], 0, 0, 0);

                        Intent intent = new Intent(ActivityOfItem2.this, ActivityOfItem3.class);
                        startActivity(intent);
                    }
                });
        
        alt3.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dropDownTextView.setText(R.string.alt3);
                        sel = 3;
                        closeDropdown();
                        alt0.setCompoundDrawablesWithIntrinsicBounds(imgs[0], 0, 0, 0);
                        alt1.setCompoundDrawablesWithIntrinsicBounds(imgs[1], 0, 0, 0);
                        alt2.setCompoundDrawablesWithIntrinsicBounds(imgs[2], 0, 0, 0);
                        alt3.setCompoundDrawablesWithIntrinsicBounds(imgs[3], 0, R.drawable.icn_dropdown_checked, 0);

                        Intent intent = new Intent(ActivityOfItem2.this, ActivityOfItem3.class);
                        startActivity(intent);
                    }
                });
    }

    /**
     * Animates in the dropdown list
     */
    private void openDropdown() {
        if (mDropdownFoldOutMenu.getVisibility() != View.VISIBLE) {
            ScaleAnimation anim = new ScaleAnimation(1, 1, 0, 1);
            anim.setDuration(getResources().getInteger(R.integer.dropdown_amination_time));
            mDropdownFoldOutMenu.startAnimation(anim);
            if (sel == 0) {
            	mDropdownTitle.setCompoundDrawablesWithIntrinsicBounds(imgs[0], 0,
                        R.drawable.icn_dropdown_close, 0);
            } else if (sel == 1) {
            	mDropdownTitle.setCompoundDrawablesWithIntrinsicBounds(imgs[1], 0,
                        R.drawable.icn_dropdown_close, 0);
            } else if (sel == 2) {
            	mDropdownTitle.setCompoundDrawablesWithIntrinsicBounds(imgs[2], 0,
                        R.drawable.icn_dropdown_close, 0);
            } else if (sel == 3) {
            	mDropdownTitle.setCompoundDrawablesWithIntrinsicBounds(imgs[3], 0,
                        R.drawable.icn_dropdown_close, 0);
            }
            mDropdownFoldOutMenu.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Animates out the dropdown list
     */
    private void closeDropdown() {
        if (mDropdownFoldOutMenu.getVisibility() == View.VISIBLE) {
            ScaleAnimation anim = new ScaleAnimation(1, 1, 1, 0);
            anim.setDuration(getResources().getInteger(R.integer.dropdown_amination_time));
            anim.setAnimationListener(new AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mDropdownFoldOutMenu.setVisibility(View.GONE);
                }
            });
            
            if (sel == 0) {
            	mDropdownTitle.setCompoundDrawablesWithIntrinsicBounds(imgs[0], 0,
                        R.drawable.icn_dropdown_open, 0);
            } else if (sel == 1) {
            	mDropdownTitle.setCompoundDrawablesWithIntrinsicBounds(imgs[1], 0,
                        R.drawable.icn_dropdown_open, 0);
            } else if (sel == 2) {
            	mDropdownTitle.setCompoundDrawablesWithIntrinsicBounds(imgs[2], 0,
                        R.drawable.icn_dropdown_open, 0);
            } else if (sel == 3) {
            	mDropdownTitle.setCompoundDrawablesWithIntrinsicBounds(imgs[3], 0,
                        R.drawable.icn_dropdown_open, 0);
            }
            
            
            mDropdownFoldOutMenu.startAnimation(anim);
        }
    }
}

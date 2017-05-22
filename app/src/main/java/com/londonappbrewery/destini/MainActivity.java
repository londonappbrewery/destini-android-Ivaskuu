package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    TextView mStoryText;
    Button mButtonTop;
    Button mButtonBottom;

    int mStoryIndex = 0;
    int[] mStoryBank =
    {
        R.string.T1_Story,
        R.string.T2_Story,
        R.string.T3_Story,
        R.string.T4_End,
        R.string.T5_End,
        R.string.T6_End
    };

    int[] mButtonTopBank =
    {
        R.string.T1_Ans1,
        R.string.T2_Ans1,
        R.string.T3_Ans1
    };

    int[] mButtonBottomBank =
    {
        R.string.T1_Ans2,
        R.string.T2_Ans2,
        R.string.T3_Ans2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStoryText = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);

        mButtonTop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                UpdateQuestion(true);
            }
        });

        mButtonBottom.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                UpdateQuestion(false);
            }
        });
    }

    private void UpdateQuestion(boolean answer)
    {
        if(answer)
        {
            switch (mStoryIndex)
            {
                case 0: // Goto T3
                case 1:
                    mStoryText.setText(mStoryBank[2]);
                    mButtonTop.setText(mButtonTopBank[2]);
                    mButtonBottom.setText(mButtonBottomBank[2]);
                    mStoryIndex = 2;
                    break;
                case 2: // Goto T6_End
                    mStoryText.setText(mStoryBank[5]);
                    DisableButtons();
                    break;
            }
        }
        else
        {
            switch (mStoryIndex)
            {
                case 0: // Goto T2
                    mStoryText.setText(mStoryBank[1]);
                    mButtonTop.setText(mButtonTopBank[1]);
                    mButtonBottom.setText(mButtonBottomBank[1]);

                    mStoryIndex = 1;
                    break;
                case 1: // T4_End
                    mStoryText.setText(mStoryBank[3]);
                    DisableButtons();
                    break;
                case 2: // T5_End
                    mStoryText.setText(mStoryBank[4]);
                    DisableButtons();
                    break;
            }
        }
    }

    private void DisableButtons()
    {
        mButtonTop.setVisibility(View.GONE);
        mButtonBottom.setVisibility(View.GONE);

        Toast.makeText(getApplicationContext(), "You have finished the game. To replay the story, rotate your phone.", Toast.LENGTH_LONG).show();
    }
}

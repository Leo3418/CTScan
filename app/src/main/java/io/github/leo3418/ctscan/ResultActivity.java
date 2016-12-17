package io.github.leo3418.ctscan;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Automatically generated by Android Studio
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        // Create a tool bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Add a "Back" button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get the previous activity
        Intent intent = getIntent();
        // Retrieve data from previous activity
        int[] voxel = intent.getIntArrayExtra(MainActivity.VOXEL);
        // Define a new object from "CTscan" class
        CTscan input = new CTscan();
        // Specify the instance variable of the object
        input.setVoxel(voxel);
        // Specify TextView objects in GUI which will display output
        TextView horizontal0 = (TextView) findViewById(R.id.horizontal0);
        TextView horizontal1 = (TextView) findViewById(R.id.horizontal1);
        TextView horizontal2 = (TextView) findViewById(R.id.horizontal2);
        TextView horizontal3 = (TextView) findViewById(R.id.horizontal3);

        TextView topleft_bottomright0 = (TextView) findViewById(R.id.topleft_bottomright0);
        TextView topleft_bottomright1 = (TextView) findViewById(R.id.topleft_bottomright1);
        TextView topleft_bottomright2 = (TextView) findViewById(R.id.topleft_bottomright2);
        TextView topleft_bottomright3 = (TextView) findViewById(R.id.topleft_bottomright3);

        TextView vertical0 = (TextView) findViewById(R.id.vertical0);
        TextView vertical1 = (TextView) findViewById(R.id.vertical1);
        TextView vertical2 = (TextView) findViewById(R.id.vertical2);
        TextView vertical3 = (TextView) findViewById(R.id.vertical3);

        TextView topright_bottomleft0 = (TextView) findViewById(R.id.topright_bottomleft0);
        TextView topright_bottomleft1 = (TextView) findViewById(R.id.topright_bottomleft1);
        TextView topright_bottomleft2 = (TextView) findViewById(R.id.topright_bottomleft2);
        TextView topright_bottomleft3 = (TextView) findViewById(R.id.topright_bottomleft3);

        TextView overall0 = (TextView) findViewById(R.id.overall0);
        TextView overall1 = (TextView) findViewById(R.id.overall1);
        TextView overall2 = (TextView) findViewById(R.id.overall2);
        TextView overall3 = (TextView) findViewById(R.id.overall3);

        TextView background0 = (TextView) findViewById(R.id.background0);
        TextView background1 = (TextView) findViewById(R.id.background1);
        TextView background2 = (TextView) findViewById(R.id.background2);
        TextView background3 = (TextView) findViewById(R.id.background3);

        TextView result0 = (TextView) findViewById(R.id.result0);
        TextView result1 = (TextView) findViewById(R.id.result1);
        TextView result2 = (TextView) findViewById(R.id.result2);
        TextView result3 = (TextView) findViewById(R.id.result3);

        // Get outputs from the "CTscan" class and apply them to TextView objects above
        horizontal0.setText(String.valueOf(input.getHorizontal()[0]));
        horizontal1.setText(String.valueOf(input.getHorizontal()[1]));
        horizontal2.setText(String.valueOf(input.getHorizontal()[2]));
        horizontal3.setText(String.valueOf(input.getHorizontal()[3]));

        topleft_bottomright0.setText(String.valueOf(input.getTopleft_Bottomright()[0]));
        topleft_bottomright1.setText(String.valueOf(input.getTopleft_Bottomright()[1]));
        topleft_bottomright2.setText(String.valueOf(input.getTopleft_Bottomright()[2]));
        topleft_bottomright3.setText(String.valueOf(input.getTopleft_Bottomright()[3]));

        vertical0.setText(String.valueOf(input.getVertical()[0]));
        vertical1.setText(String.valueOf(input.getVertical()[1]));
        vertical2.setText(String.valueOf(input.getVertical()[2]));
        vertical3.setText(String.valueOf(input.getVertical()[3]));

        topright_bottomleft0.setText(String.valueOf(input.getTopright_Bottomleft()[0]));
        topright_bottomleft1.setText(String.valueOf(input.getTopright_Bottomleft()[1]));
        topright_bottomleft2.setText(String.valueOf(input.getTopright_Bottomleft()[2]));
        topright_bottomleft3.setText(String.valueOf(input.getTopright_Bottomleft()[3]));

        overall0.setText(String.valueOf(input.getOverall()[0]));
        overall1.setText(String.valueOf(input.getOverall()[1]));
        overall2.setText(String.valueOf(input.getOverall()[2]));
        overall3.setText(String.valueOf(input.getOverall()[3]));

        background0.setText(String.valueOf(input.getBackground()[0]));
        background1.setText(String.valueOf(input.getBackground()[1]));
        background2.setText(String.valueOf(input.getBackground()[2]));
        background3.setText(String.valueOf(input.getBackground()[3]));

        result0.setText(String.valueOf(input.getResult()[0]));
        result1.setText(String.valueOf(input.getResult()[1]));
        result2.setText(String.valueOf(input.getResult()[2]));
        result3.setText(String.valueOf(input.getResult()[3]));
    }

    // Create a menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    // This method is called when user clicks items in menu
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            // When the user clicks "About"
            case R.id.about:
                // Construct a dialog box
                AlertDialog.Builder about = new AlertDialog.Builder(this);
                // Construct "Go to GitHub" button
                about.setNeutralButton(R.string.goto_GitHub, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        // Visit GitHub
                        dialog.dismiss();
                        String url = "https://github.com/Leo3418/CTScan";
                        Intent view_GPL = new Intent(Intent.ACTION_VIEW);
                        view_GPL.setData(Uri.parse(url));
                        startActivity(view_GPL);
                    }
                });
                // Construct an "OK" button
                about.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        // When the user clicks the "OK" button, the dialog disappears
                        dialog.dismiss();
                    }
                });
                // Define the title of the dialog box
                about.setTitle(R.string.about);
                // Define the message of the dialog box
                about.setMessage(R.string.about_message);
                // Display "About" box
                about.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

class CTscan{
    private int[] voxel;

    void setVoxel(int[] input){
        voxel = input;
    }

    int[] getHorizontal(){
        int[] output = new int[4];
        output[0] = voxel[0] + voxel[1];
        output[1] = voxel[0] + voxel[1];
        output[2] = voxel[2] + voxel[3];
        output[3] = voxel[2] + voxel[3];
        return output;
    }

    int[] getTopleft_Bottomright(){
        int[] output = new int[4];
        output[0] = voxel[0] + voxel[3];
        output[1] = voxel[1];
        output[2] = voxel[2];
        output[3] = voxel[0] + voxel[3];
        return output;
    }

    int[] getVertical(){
        int[] output = new int[4];
        output[0] = voxel[0] + voxel[2];
        output[1] = voxel[1] + voxel[3];
        output[2] = voxel[0] + voxel[2];
        output[3] = voxel[1] + voxel[3];
        return output;
    }

    int[] getTopright_Bottomleft(){
        int[] output = new int[4];
        output[0] = voxel[0];
        output[1] = voxel[1] + voxel[2];
        output[2] = voxel[1] + voxel[2];
        output[3] = voxel[3];
        return output;
    }

    int[] getOverall(){
        int[] output = new int[4];
        for(int i = 0; i < 4; i++) output[i] = getHorizontal()[i] + getTopleft_Bottomright()[i] + getVertical()[i] + getTopright_Bottomleft()[i];
        return output;
    }

    int[] getBackground(){
        int[] output = new int[4];
        int background = getOverall()[0] - 3 * voxel[0];
        for(int i = 0; i < 4; i++) output[i] = background;
        return output;
    }
    
    int[] getResult(){
        int[] output = new int[4];
        for(int i = 0; i < 4; i++) output[i] = (getOverall()[i] - getBackground()[i]) / 3;
        return output;
    }
}
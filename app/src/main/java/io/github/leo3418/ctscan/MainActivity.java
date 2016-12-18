package io.github.leo3418.ctscan;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Define variable which stores the data that is being used in other activities
    public final static String VOXEL = "io.github.leo3418.ctscan.VOXEL";

    // Automatically generated by Android Studio
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define "Analyze" button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                analyze();
            }
        });
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
                        Intent goto_GitHub = new Intent(Intent.ACTION_VIEW);
                        goto_GitHub.setData(Uri.parse(url));
                        startActivity(goto_GitHub);
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

    // This method is called when user clicks "Analyze" button
    private void analyze(){
        // Define the next activity
        Intent intent = new Intent(this, ResultActivity.class);

        // Read data from user's input in GUI
        EditText raw_voxel0 = (EditText) findViewById(R.id.voxel0);
        EditText raw_voxel1 = (EditText) findViewById(R.id.voxel1);
        EditText raw_voxel2 = (EditText) findViewById(R.id.voxel2);
        EditText raw_voxel3 = (EditText) findViewById(R.id.voxel3);

        // Stop proceeding if there is any unentered value
        for(int i = 0; i < 4; i++){
            if(raw_voxel0.getText().toString().equals("") || raw_voxel1.getText().toString().equals("")
            || raw_voxel2.getText().toString().equals("") || raw_voxel3.getText().toString().equals("")){
                Toast.makeText(MainActivity.this, R.string.no_input_warning,  Toast.LENGTH_LONG).show();
                return;
            }
        }

        // Store input data to array "voxel"
        int[] voxel = new int[4];
        voxel[0] = Integer.parseInt(raw_voxel0.getText().toString());
        voxel[1] = Integer.parseInt(raw_voxel1.getText().toString());
        voxel[2] = Integer.parseInt(raw_voxel2.getText().toString());
        voxel[3] = Integer.parseInt(raw_voxel3.getText().toString());

        // Carry forward the array "voxel" to the next activity
        intent.putExtra(VOXEL, voxel);
        // Start the next activity
        startActivity(intent);
    }
}

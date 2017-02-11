package com.example.jake.activityrecognition;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
<<<<<<< HEAD
import android.widget.ImageView;
=======
>>>>>>> origin/master
import android.widget.Toast;

import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

import java.util.List;

/**
 * Created by Jake on 2/6/2017.
 */

public class ActivityRecognizedService extends IntentService{
    private int currentAct = 2;

    public ActivityRecognizedService() {
        super("com.example.jake.activityrecognition.ActivityRecognizedService");
    }

    public ActivityRecognizedService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(ActivityRecognitionResult.hasResult(intent)) {
            ActivityRecognitionResult result = ActivityRecognitionResult.extractResult(intent);
            handleDetectedActivities( result.getProbableActivities() );
        }
    }
    /**
     *
     * IMPORTANT
     * We need to make sure we aren't toasting every time this updates, only when
     * the activity changes.
     *
     * Probably we will need to store current activity, then in this update method
     * check to see if we are detecting a new activity or not.
     */
    private void handleDetectedActivities(List<DetectedActivity> probableActivities) {
        for( DetectedActivity activity : probableActivities ) {
            switch( activity.getType() ) {
                case DetectedActivity.IN_VEHICLE: {
                    Log.e( "ActivityRecogition", "In Vehicle: " + activity.getConfidence() );
                    if( activity.getConfidence() >= 75 ) {
<<<<<<< HEAD
                        if(currentAct != 0){
                            currentAct = 0;
                            //change to in vehicle and do things
                            //Add sqlite insert
                            //toast
                            Context context = getApplicationContext();
                            CharSequence vehicle_text = "Are you driving?";
                            Toast vehicle_toast = Toast.makeText(context, vehicle_text, Toast.LENGTH_SHORT);
                            vehicle_toast.show();
                            //change image
                            MainActivity.imgView.setImageResource(R.drawable.in_vehicle);
                            MainActivity.txtView.setText("You are in a vehicle.");
                            //update map with current location
                        }

=======
                        //Add sqlite insert
                        //toast
                        Context context = getApplicationContext();
                        CharSequence vehicle_text = "Are you driving?";
                        Toast vehicle_toast = Toast.makeText(context, vehicle_text, Toast.LENGTH_SHORT);
                        vehicle_toast.show();
                        //change image
                        //update map with current location
>>>>>>> origin/master
                    }
                    break;
                }
                case DetectedActivity.RUNNING: {
                    Log.e( "ActivityRecogition", "Running: " + activity.getConfidence() );
                    if( activity.getConfidence() >= 75 ) {
<<<<<<< HEAD
                        if(currentAct != 1){
                            currentAct = 1;
                            //Add sqlite insert
                            //toast
                            Context context = getApplicationContext();
                            CharSequence running_text = "Are you running?";
                            Toast running_toast = Toast.makeText(context, running_text, Toast.LENGTH_SHORT);
                            running_toast.show();
                            //change image
                            MainActivity.imgView.setImageResource(R.drawable.running);
                            MainActivity.txtView.setText("You are running.");
                            //update map with current location
                        }
=======
                        //Add sqlite insert
                        //toast
                        Context context = getApplicationContext();
                        CharSequence running_text = "Are you running?";
                        Toast running_toast = Toast.makeText(context, running_text, Toast.LENGTH_SHORT);
                        running_toast.show();
                        //change image
                        //update map with current location
>>>>>>> origin/master
                    }
                    break;
                }
                case DetectedActivity.STILL: {
                    Log.e( "ActivityRecogition", "Still: " + activity.getConfidence() );
                    if( activity.getConfidence() >= 75 ) {
<<<<<<< HEAD
                        if(currentAct != 2){
                            currentAct = 2;
                            //Add sqlite insert
                            //toast
                            Context context = getApplicationContext();
                            CharSequence still_text = "Are you still?";
                            Toast still_toast = Toast.makeText(context, still_text, Toast.LENGTH_SHORT);
                            still_toast.show();
                            //change image
                            MainActivity.imgView.setImageResource(R.drawable.still);
                            MainActivity.txtView.setText("You are still.");
                            //update map with current location
                        }

=======
                        //Add sqlite insert
                        //toast
                        Context context = getApplicationContext();
                        CharSequence still_text = "Are you still?";
                        Toast still_toast = Toast.makeText(context, still_text, Toast.LENGTH_SHORT);
                        still_toast.show();
                        //change image
                        //update map with current location
>>>>>>> origin/master
                    }
                    break;
                }
                case DetectedActivity.WALKING: {
                    Log.e( "ActivityRecogition", "Walking: " + activity.getConfidence() );
                    if( activity.getConfidence() >= 75 ) {
<<<<<<< HEAD
                        if(currentAct != 3){
                            currentAct = 3;
                            //Add sqlite insert
                            //toast
                            Context context = getApplicationContext();
                            CharSequence walking_text = "Are you walking?";
                            Toast walking_toast = Toast.makeText(context, walking_text, Toast.LENGTH_SHORT);
                            walking_toast.show();
                            //change image
                            MainActivity.imgView.setImageResource(R.drawable.walking);
                            MainActivity.txtView.setText("You are walking.");
                            //update map with current location
                        }

=======
                        //Add sqlite insert
                        //toast
                        Context context = getApplicationContext();
                        CharSequence walking_text = "Are you walking?";
                        Toast walking_toast = Toast.makeText(context, walking_text, Toast.LENGTH_SHORT);
                        walking_toast.show();
                        //change image
                        //update map with current location
>>>>>>> origin/master
                    }
                    break;
                }
                case DetectedActivity.UNKNOWN: {
                    Log.e( "ActivityRecogition", "Unknown: " + activity.getConfidence() );
                    break;
                }
                default:{
                    Log.e("ActivityRecognition", "unneccesary");
                    break;
                }
            }
        }
    }
}

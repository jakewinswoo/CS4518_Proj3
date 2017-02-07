package com.example.jake.activityrecognition;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

import java.util.List;

/**
 * Created by Jake on 2/6/2017.
 */

public class ActivityRecognizedService extends IntentService{
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
                        //Add sqlite insert
                        //toast
                        //change image
                        //update map with current location
                    }
                    break;
                }
                case DetectedActivity.RUNNING: {
                    Log.e( "ActivityRecogition", "Running: " + activity.getConfidence() );
                    if( activity.getConfidence() >= 75 ) {
                        //Add sqlite insert
                        //toast
                        //change image
                        //update map with current location
                    }
                    break;
                }
                case DetectedActivity.STILL: {
                    Log.e( "ActivityRecogition", "Still: " + activity.getConfidence() );
                    if( activity.getConfidence() >= 75 ) {
                        //Add sqlite insert
                        //toast
                        //change image
                        //update map with current location
                    }
                    break;
                }
                case DetectedActivity.WALKING: {
                    Log.e( "ActivityRecogition", "Walking: " + activity.getConfidence() );
                    if( activity.getConfidence() >= 75 ) {
                        //Add sqlite insert
                        //toast
                        //change image
                        //update map with current location
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

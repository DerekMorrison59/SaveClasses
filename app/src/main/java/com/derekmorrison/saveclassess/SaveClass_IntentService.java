package com.derekmorrison.saveclassess;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.google.gson.Gson;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * Things to consider
 * - may need a class version number if classes change over time
 */
public class SaveClass_IntentService extends IntentService {
    // actions
    private static final String ACTION_SAVE_CLASS = "com.derekmorrison.saveclassess.action.SAVE_CLASS";

    // parameters
    private static final String EXTRA_JSON_STRING = "com.derekmorrison.saveclassess.extra.JSON_STRING";
    private static final String EXTRA_CLASS_ID = "com.derekmorrison.saveclassess.extra.CLASS_ID";

    // class IDs will make it easier to restore the JSON to an class instance
    private static final int CLASS_ID_COMMENT = 1;
    private static final int CLASS_ID_ANNOTATION = 2;

    public SaveClass_IntentService() {
        super("SaveClass_IntentService");
    }

    /**
     * Starts this service to perform action SAVE_CLASS with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // handles converting the 'Comment' class to JSON and starting the send service
    public static void saveCommentToRemote(Context context, Comment comment) {
        Intent intent = new Intent(context, SaveClass_IntentService.class);
        intent.setAction(ACTION_SAVE_CLASS);

        // convert Comment class to JSON
        // todo try - catch because gson may not work
        Gson gson = new Gson();
        String jsonString = gson.toJson(comment);

        intent.putExtra(EXTRA_JSON_STRING, jsonString);
        intent.putExtra(EXTRA_CLASS_ID, CLASS_ID_COMMENT);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action SAVE_CLASS with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     *
     * handles converting the 'Annotation' class to JSON and starting the send service
     */
    // TODO: Customize helper method
    public static void saveAnnotationToRemote(Context context, Annotation annotation) {
        Intent intent = new Intent(context, SaveClass_IntentService.class);
        intent.setAction(ACTION_SAVE_CLASS);

        // convert Annotation class to JSON
        Gson gson = new Gson();
        String jsonString = gson.toJson(annotation);

        intent.putExtra(EXTRA_JSON_STRING, jsonString);
        intent.putExtra(EXTRA_CLASS_ID, CLASS_ID_ANNOTATION);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_SAVE_CLASS.equals(action)) {
                final String jsonString = intent.getStringExtra(EXTRA_JSON_STRING);
                final int class_id = intent.getIntExtra(EXTRA_CLASS_ID, 0);  // zero indicates error
                handleActionSaveClassToRemote(jsonString, class_id);
            }
        }
    }

    /**
     * Send the JSON representation of the class and the class ID to the remote data store
     *
     * the assumption here is that the class ID and JSON string are stored together for later
     * retrieval
     */
    private void handleActionSaveClassToRemote(String jsonString, int classId) {

        // check the classId

        // check for internet permissions

        // check for internet connection

        // create the JSON containing the class string and the class id

        // send to the remote server
    }
}

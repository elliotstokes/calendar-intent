package com.megaphone.cordova.calendar;

import android.content.Context;
import android.content.Intent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.PluginResult;

public class CalendarIntent extends CordovaPlugin {

	public static final String ACTION_CREATE_EVENT = "createEvent";


	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

		if (action.equals(ACTION_CREATE_EVENT)) {

			Intent intent = new Intent(Intent.ACTION_EDIT);
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra("title", "Some title");
			intent.putExtra("description", "Some description");
			//intent.putExtra("beginTime", eventStartInMillis);
			//intent.putExtra("endTime", eventEndInMillis);
			((CordovaActivity)this.cordova.getActivity()).startActivity(intent);
			callbackContext.success(action);
		}

		
		return true;
	}

}
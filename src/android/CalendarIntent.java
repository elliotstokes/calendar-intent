package com.megaphone.cordova.calendar;

import android.content.Context;
import android.content.ContentUris;
import android.content.Intent;

import java.util.Calendar;
import android.provider.CalendarContract;
import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;

public class CalendarIntent extends CordovaPlugin {

	private static final String ACTION_CREATE_EVENT = "createEvent";
	private static final String ACTION_SHOW_CALENDAR = "showCalendar";
	
	private Calendar _calendar;

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
	  super.initialize(cordova, webView);
	  this._calendar = Calendar.getInstance();
	}

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

		if (action.equals(ACTION_CREATE_EVENT)) {

			if (args.length() != 1) {
            	callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.INVALID_ACTION));
                return false;
            }

            JSONObject options = args.optJSONObject(0);
            String title = options.optString("title");
            String description = options.optString("description");
            String location = options.optString("location");
            long beginTime = options.optLong("beginTime", this._calendar.getTimeInMillis());
            long endTime = options.optLong("endTime",this._calendar.getTimeInMillis());

			Intent intent = new Intent(Intent.ACTION_EDIT);
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra("title", title);
			intent.putExtra("description", description);
			intent.putExtra("beginTime", beginTime);
			intent.putExtra("eventLocation", location);
			intent.putExtra("endTime", endTime);
			
			((CordovaActivity)this.cordova.getActivity()).startActivity(intent);
			callbackContext.success(action);
		}

		if (action.equals(ACTION_SHOW_CALENDAR)) {
			JSONObject options = args.optJSONObject(0);
			long time = options.optLong("time", this._calendar.getTimeInMillis());
			Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();   
 			builder.appendPath("time");
 			ContentUris.appendId(builder, time);
 			Intent intent = new Intent(Intent.ACTION_VIEW)
     		.setData(builder.build());
     		((CordovaActivity)this.cordova.getActivity()).startActivity(intent);
   			callbackContext.success(action);
		}

		
		return true;
	}

}
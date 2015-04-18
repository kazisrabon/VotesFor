package com.example.iit.dhakathon;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Shohag on 17-Apr-15.
 */
public class JsonParse extends AsyncTask<Void, Void, Void> {
    private static final String TAG_ID = "id";
    private static final String TAG_IMAGE = "image";
    private static final String TAG_CITY = "city";
    private static final String TAG_TYPE = "type";
    private static final String TAG_WARD = "type";
    private static final String TAG_NAME = "name";
    private static final String TAG_DATE_OF_BIRTH = "date_of_birth";
    private static final String TAG_PRESENT_ADDRESS = "present_address";
    private static final String TAG_PERMANENT_ADDRESS = "permanent_address";
    private static final String TAG_PROFESSION = "fld_4a_my_business_profession_desc";
    private static final String TAG_EDUCATION_QUALIFICATION = "fld_1_max_educational_qualifications";

    Context context;
    CandidateDataObject candidateDataObject;

    // jsonArrays JSONArray
    JSONArray jsonArrays = null;
    String url;
    AsyncResponce asyncResponce;
    private ProgressDialog progressDialog;
    ArrayList<CandidateDataObject> listOfCandidateDataObjects;


    public JsonParse(Context context, AsyncResponce asyncResponce, String url) {
        this.context = context;
        this.asyncResponce = asyncResponce;
        this.url = url;

    }

    @Override
    protected void onPreExecute() {
        listOfCandidateDataObjects = new ArrayList<>();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Please wait");
        progressDialog.setCancelable(false);
        progressDialog.show();
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        // Creating service handler class instance
        ServiceHandler sh = new ServiceHandler();

        // Making a request to url and getting response
        String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

        jsonStr = getRealJsonString(jsonStr);
        Log.d("Response:XXXXXXXXXX", jsonStr);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                //JSONObject jsonObj = new JSONObject(jsonStr);


                // Getting JSON Array node

                jsonArrays = jsonObj.getJSONArray("contacts");

                // looping through All Candidates
                for (int i = 0; i < jsonArrays.length(); i++) {
                    candidateDataObject = new CandidateDataObject();
                    JSONObject c = jsonArrays.getJSONObject(i);

                    if (!c.isNull(TAG_ID))
                        candidateDataObject.setId(c.getString(TAG_ID));
                    if (!c.isNull(TAG_IMAGE))
                        candidateDataObject.setImage_link(c.getString(TAG_IMAGE));
                    if (!c.isNull(TAG_CITY))
                        candidateDataObject.setCity(c.getString(TAG_CITY));
                    if (!c.isNull(TAG_TYPE))
                        candidateDataObject.setType(c.getString(TAG_TYPE));
                    if (!c.isNull(TAG_WARD))
                        candidateDataObject.setWard(c.getString(TAG_WARD));
                    if (!c.isNull(TAG_NAME))
                        candidateDataObject.setName(c.getString(TAG_NAME));
                    if (!c.isNull(TAG_DATE_OF_BIRTH))
                        candidateDataObject.setDate_of_birth(c.getString(TAG_DATE_OF_BIRTH));
                    if (!c.isNull(TAG_PERMANENT_ADDRESS))
                        candidateDataObject.setPermanent_address(c.getString(TAG_PERMANENT_ADDRESS));
                    if (!c.isNull(TAG_PRESENT_ADDRESS))
                        candidateDataObject.setPresent_address(c.getString(TAG_PRESENT_ADDRESS));
                    if (!c.isNull(TAG_EDUCATION_QUALIFICATION))
                        candidateDataObject.setEducation_qualification(c.getString(TAG_EDUCATION_QUALIFICATION));
                    if (!c.isNull(TAG_PROFESSION))
                        candidateDataObject.setProfession(c.getString(TAG_PROFESSION));

                    listOfCandidateDataObjects.add(candidateDataObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Log.e("ServiceHandler", "Couldn't get any data from the url");
        }
        return null;
    }

    private String getRealJsonString(String jsonStr) {
        String result = jsonStr;
        result = result.replace("true", "\"true\"");
        result = result.replace("false", "\"false\"");
        result = "{contacts:" + result + "}";
        return result;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        asyncResponce.processFinish(listOfCandidateDataObjects);
        progressDialog.dismiss();
        super.onPostExecute(aVoid);
    }
}

package com.rallerenp.recodeblog.exceptions;

import com.rallerenp.recodeblog.util.JSONObjectable;
import org.json.JSONObject;

public class RecodeServiceException extends Exception implements JSONObjectable
{

    public RecodeServiceException(String message)
    {
        super(message);
    }

    @Override
    public JSONObject toJSON()
    {
        JSONObject json = new JSONObject();

        json.put("error", this.getMessage());

        return json;
    }
}
